package com.example.kidsphere.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private CPType cpType;

    private String description;

    private boolean inUse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CPType getCpType() {
        return cpType;
    }

    public void setCpType(CPType cpType) {
        this.cpType = cpType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
