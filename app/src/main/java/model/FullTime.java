package model;

import java.io.Serializable;

public class FullTime extends Employee implements Serializable {
    private String FstartDate;
    private double Fsalary;

    public FullTime(String id, String name, String job, String FstartDate, double Fsalary) {
        super(id, name, job);
        this.FstartDate = FstartDate;
        this.Fsalary = Fsalary;
    }

    public String getFStartDate() {
        return FstartDate;
    }

    public void setFStartDate(String FstartDate) {
        this.FstartDate = FstartDate;
    }

    public double getFSalary() {
        return Fsalary;
    }

    public void setFSalary(double Fsalary) {
        this.Fsalary = Fsalary;
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
