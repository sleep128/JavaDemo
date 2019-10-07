package com.sleep.zk;

public interface ExtLock  {
    //ExtLock基于zk实现分布式锁
    void  getLock();

    //释放锁
    void unLock();
}
