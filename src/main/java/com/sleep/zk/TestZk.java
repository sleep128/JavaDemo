package com.sleep.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class TestZk {
    public static final String ADDRESS = "192.168.1.8:2181";
    public static final String path = "/";

    public static void main(String[] args) throws IOException {
        ZooKeeperDistributedLock zkLock = new ZooKeeperDistributedLock("001");
        zkLock.tryLock();
        zkLock.unlock();
    }

    private static void test() throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper(ADDRESS, 100, null);
        if (zooKeeper != null) {
            try {

                List<String> children = zooKeeper.getChildren(path, false);
                for (String child : children) {
                    System.out.println(child);
                }

            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
