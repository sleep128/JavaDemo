package com.sleep.JAVA8;

import java.util.Arrays;
import java.util.List;

/**
 * @author wb-zy215796
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> cityList = Arrays.asList("hangzhou","sahnghai","wuxi","suzhou");
        long count = cityList.stream().filter(w -> w.length() > 5).count();
        System.out.println(count);
    }
}
