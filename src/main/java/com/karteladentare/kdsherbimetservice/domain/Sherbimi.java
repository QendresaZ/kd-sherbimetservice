package com.karteladentare.kdsherbimetservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sherbimi {
    @Id
    @GeneratedValue
    private Long id;
    private String emri;
    private String shenime;
    private Double cmimi;

    public Sherbimi(){}

    public Sherbimi(String emri, String shenime, Double cmimi) {
        this.emri = emri;
        this.shenime = shenime;
        this.cmimi = cmimi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getShenime() {
        return shenime;
    }

    public void setShenime(String shenime) {
        this.shenime = shenime;
    }

    public Double getCmimi() {
        return cmimi;
    }

    public void setCmimi(Double cmimi) {
        this.cmimi = cmimi;
    }
}
