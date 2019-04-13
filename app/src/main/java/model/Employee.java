package model;

import java.io.Serializable;

public abstract class Employee implements Serializable {

    protected String id;
    protected String name;
    protected String job;

    public Employee(String id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public abstract String getId();
    public abstract String getName();
    public abstract String getJob();

    @Override
    public String toString() {
        return name;
    }
}
