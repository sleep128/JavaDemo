package com.sleep.JAVA8.testStream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author wb-zy215796
 */
public class TestStudent {

    public static void main(String[] args) {
        List<String> cityList = Arrays.asList("hangzhou", "sahnghai", "wuxi", "suzhou");
        long count = cityList.stream().filter(w -> w.length() > 5).count();
        System.out.println(count);
    }

    @Test
    public void beforeJava8() {
        List<Student> stuList = getStuList();
        long count = 0;
        Iterator<Student> iterator = stuList.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            if (next.getAge() < 20) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void useJava8() {
        List<Student> stuList = getStuList();
        long count = 0;
        count = stuList.stream().filter(student -> {
            return student.getAge() < 20;
        }).count();
        System.out.println(count);
    }

    private List<Student> getStuList() {
        List<Student> studentList = Arrays.asList(new Student[] { new Student("john", 13), new Student("steven", 24),
                                                                  new Student("may", 34), new Student("bob", 18),
                                                                  new Student("six", 19) });
        return studentList;
    }
}
