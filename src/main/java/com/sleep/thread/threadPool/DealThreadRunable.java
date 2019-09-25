package com.sleep.thread.threadPool;

import java.util.List;

public class DealThreadRunable implements Runnable {
    private List<Patient> patientList;

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public DealThreadRunable(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(3000);
            for (Patient patient : patientList) {
                patient.setThreadname(Thread.currentThread().getName());
                patient.setPrice(patient.getAge() + 1);
                System.out.println(patient);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
