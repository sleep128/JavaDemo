package com.sleep.zk;

public class TestZk002 {

    public static void main(String[] args) {
        ZooKeeperDistributedLock zkLock = new ZooKeeperDistributedLock("002");
        zkLock.tryLock();
        zkLock.unlock();
    }
}
