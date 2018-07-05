package com.barclays.pojo;

import java.io.Serializable;


public class Customer implements Serializable {

    public String name;
    public Integer rowAssigned;
    public Integer sectionAssigned;
    public String comments;
    public int seatingNeeded;

    public Customer(String name, int seatingNeeded) {
        this.name = name;
        this.seatingNeeded = seatingNeeded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRowAssigned() {
        return rowAssigned;
    }

    public void setRowAssigned(Integer rowAssigned) {
        this.rowAssigned = rowAssigned;
    }

    public Integer getSectionAssigned() {
        return sectionAssigned;
    }

    public void setSectionAssigned(Integer sectionAssigned) {
        this.sectionAssigned = sectionAssigned;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getSeatingNeeded() {
        return seatingNeeded;
    }

    public void setSeatingNeeded(int seatingNeeded) {
        this.seatingNeeded = seatingNeeded;
    }

}
