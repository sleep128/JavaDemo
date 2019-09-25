package com.sleep.memory;

import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

import java.util.ArrayList;

public class TestMemory {
    public static void main(String[] args) {
        int i = 155;
        System.out.println(RamUsageEstimator.sizeOf(i));
        long l = 122L;
        System.out.println(RamUsageEstimator.sizeOf(l));

        Tshirt tshirt = new Tshirt();
        System.out.println(RamUsageEstimator.sizeOf(tshirt));
        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(RamUsageEstimator.sizeOf(objects));
        // 40+length*2+padding
        String s1 = "";
        String s2 = "a";
        String s3 = "aa";
        String s4 = "aaaa";
        System.out.println(RamUsageEstimator.sizeOf(s1));
        System.out.println(RamUsageEstimator.sizeOf(s2));
        System.out.println(RamUsageEstimator.sizeOf(s3));
        System.out.println(RamUsageEstimator.sizeOf(s4));
    }

    @Test
    public void TestObject(){
        /**
         * integer+long =40 =12+
         * int+long=24 =12+4+8
         */
        Tshirt tshirt = new Tshirt();
        System.out.println(RamUsageEstimator.sizeOf(tshirt));
    }
}
