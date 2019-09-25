package com.sleep.thread.threadPool;

import com.google.common.collect.Lists;
import com.google.errorprone.annotations.Var;
import org.junit.Test;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        testRunnable();
//        testCallable();
//        test();
        Patient patient = new Patient(1, 1);
        Patient patient2 = patient;
        patient = null;
        System.out.println(1);
    }

    public static void test() {
        List<Patient> patientData = getPatientData();
        for (int i = 0, j = 0; i < 5; i++, j = j + 1) {
            System.out.println("execute:" + i);
            new Thread(new DealThreadRunable(patientData.subList(j, 1 + j))).start();
        }
    }

    public static void testRunnable() {
        ThreadPoolExecutor threadPoolExecutor = getExecutor();
        List<Patient> patientData = getPatientData();
        for (int i = 0, j = 0; i < 15; i++, j = j + 1) {
            System.out.println("execute:" + i+1);
            threadPoolExecutor.execute(new DealThreadRunable(patientData.subList(j, 1 + j)));
        }
        threadPoolExecutor.shutdown();
    }

    public static void testCallable() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = getExecutor();
        List<Patient> patientData = getPatientData();
        ArrayList<Future> tasks = Lists.newArrayListWithCapacity(20);
        for (int i = 0, j = 0; i < 15; i++, j = j + 1) {
            Future<Integer> submit = executor.submit(new DealThreadCallable(patientData.subList(j, 1 + j)));
            tasks.add(submit);
        }

//        Object o = tasks.get(14).get();
//        System.out.println("-------"+o);
//        for (int i = 0; i < tasks.size(); i++) {
//            try {
//                System.out.println(">>>start--"+i+"<<<");
//                System.out.println(tasks.get(i).isDone());
//                System.out.println(i+":result:"+ tasks.get(i).get());
//                System.out.println(tasks.get(i).isDone());
//                System.out.println(">>>end--"+i+"<<<");
//            } catch (InterruptedException e) {
//                System.out.println("here1");
//            } catch (ExecutionException e) {
//                System.out.println("here2:"+e.getMessage());
//            }
//        }
    }

    private static ThreadPoolExecutor getExecutor() {
        // io密集型，线程池核心大小设置为cpu核数的两倍
        int coreSize = Runtime.getRuntime().availableProcessors() * 2;
        int maximumPoolSize = 100;
        long keepAliveTime = 100;

        ThreadFactory threadFactory = new ThreadFactory() {
            public static final String poolName = "my thread pool-%d";
            public final AtomicInteger count = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                String name = String.format(poolName, count.getAndIncrement());
                return new Thread(r, name);
            }
        };

        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                DealThreadRunable run = (DealThreadRunable) r;
                Patient patient = run.getPatientList().get(0);
                System.out.println("*************reject"+patient.getThreadname()+":"+patient.getId());
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                10,
                keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                threadFactory,
                handler
        );
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        return threadPoolExecutor;
    }

    private static List<Patient> getPatientData() {
        ArrayList<Patient> objects = Lists.newArrayListWithCapacity(30);
        for (int i = 0; i < 15; i++) {
            Patient patient = new Patient(i + 1, i + 2);
            objects.add(patient);
        }
        return objects;
    }
}
