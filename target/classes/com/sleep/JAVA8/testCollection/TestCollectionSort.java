package com.sleep.JAVA8.testCollection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollectionSort {

    @Test
    public void method1(){
        List<String> names = Arrays.asList("b","s","c1","c2","a2","a1");
        System.out.println(names);
        Collections.sort(names,(String a,String b) -> {
            return b.compareTo(a);
        });
        System.out.println(names);
    }

    @Test
    public void method2(){
        List<String> names = Arrays.asList("b","s","c1","c2","a2","a1");
        System.out.println(names);
        Collections.sort(names, (String a, String b) -> a.compareTo(b));
        System.out.println(names);
    }

    @Test
    public void method3(){
        List<String> names = Arrays.asList("b","s","c1","c2","a2","a1");
        System.out.println(names);
//        names.sort(String::compareTo);
        names.sort((a,b) -> a.compareTo(b));
        System.out.println(names);
    }
}
