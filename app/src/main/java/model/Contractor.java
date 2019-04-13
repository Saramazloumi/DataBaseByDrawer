package model;

import java.io.Serializable;

public class Contractor extends Employee implements Serializable {

    private String cStartDate;
    private String endDate;
    private int cSalary;
    private int nhPerWeek;

    public Contractor(String id, String name, String job, String cStartDate, String endDate, int cSalary, int nhPerWeek) {
        super(id, name, job);
        this.cStartDate = cStartDate;
        this.endDate = endDate;
        this.cSalary = cSalary;
        this.nhPerWeek = nhPerWeek;
    }

    public String getcStartDate() {
        return cStartDate;
    }

    public void setcStartDate(String cStartDate) {
        this.cStartDate = cStartDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getcSalary() {
        return cSalary;
    }

    public void setcSalary(int cSalary) {
        this.cSalary = cSalary;
    }

    public int getNhPerWeek() {
        return nhPerWeek;
    }

    public void setNhPerWeek(int nhPerWeek) {
        this.nhPerWeek = nhPerWeek;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getJob() {
        return this.job;
    }
}
