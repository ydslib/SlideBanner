# SlideBanner
可滑动，不能自动滑动，前后项有部分露出，回弹功能

# FragmentStatePagerAdapter的notifyDataSetChanged不刷新
Adapter与ViewPager之间是通过观察者模式来进行数据更新的，

```java
    public void notifyDataSetChanged() {
        synchronized (this) {
            if (mViewPagerObserver != null) {
                mViewPagerObserver.onChanged();
            }
        }
        mObservable.notifyChanged();
    }
```

查看mObservable.notifyChanged()，发现它会通知所有观察者数据更改，如下所示：
```java
    public void notifyChanged() {
        synchronized(mObservers) {
            // since onChanged() is implemented by the app, it could do anything, including
            // removing itself from {@link mObservers} - and that could cause problems if
            // an iterator is used on the ArrayList {@link mObservers}.
            // to avoid such problems, just march thru the list in the reverse order.
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onChanged();
            }
        }
    }
```
继续跟踪，会进入到PagerObserver的onChanged
```java
        @Override
        public void onChanged() {
            dataSetChanged();
        }
```
dataSetChanged内容很多，我们只看下面一段
```java
...
for (int i = 0; i < mItems.size(); i++) {
    ...
    final int newPos = mAdapter.getItemPosition(ii.object);
    if (newPos == PagerAdapter.POSITION_UNCHANGED) {
        continue;
    }
    ...
}
```
可以看到，newPos为continue;PagerAdapter.POSITION_UNCHANGED时，不会继续往下走，直接进入下一个循环了，那么这个newPos的值是啥呢？
可以看看getItemPosition返回值

```java
    public int getItemPosition(@NonNull Object object) {
        return POSITION_UNCHANGED;
    }
```
代码里直接写死了POSITION_UNCHANGED，所以notifyDataSetChanged不会刷新数据，需要重写getItemPosition并设置返回值为POSITION_NONE
