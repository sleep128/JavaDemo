package com.sleep.thread.threadPool;

import java.util.List;
import java.util.concurrent.Callable;

public class DealThreadCallable implements Callable<Integer> {
    private List<Patient> patientList;

    public DealThreadCallable(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public Integer call() {
        try {
            Thread.sleep(1000);
            for (Patient patient : patientList) {
                patient.setThreadname(Thread.currentThread().getName());
                patient.setPrice(patient.getAge() + 1);
                System.out.println(patient);
//                if(patient.getId()==5||patient.getId()==8){
//                    throw new RuntimeException("cuowu");
//                }
            }
        } catch (InterruptedException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return patientList.size();
    }
}
