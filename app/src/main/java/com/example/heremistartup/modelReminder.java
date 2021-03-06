package com.example.heremistartup;

public class modelReminder {


    private int med_id;
    private int dose;
    private boolean mon;
    private boolean tue;
    private boolean wed;
    private boolean thu;
    private boolean fri;
    private boolean sat;
    private boolean sun;
    private String notes;
    private boolean active;


    public modelReminder() {
    }

    public modelReminder(int remID, int medID, int dose, boolean mon, boolean tue, boolean wed, boolean thu, boolean fri, boolean sat, boolean sun, String notes, boolean active, String updateTime) {

        this.med_id = medID;
        this.dose = dose;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
        this.notes = notes;
        this.active = active;

    }

    @Override
    public String toString() {
        String mon = (isMon() ? "Mon " : "");
        String tue = (isTue() ? "Tue " : "");
        String wed = (isWed() ? "Wed " : "");
        String thu = (isThu() ? "Thu " : "");
        String fri = (isFri() ? "Fri " : "");
        String sat = (isSat() ? "Sat " : "");
        String sun = (isSun() ? "Sun " : "");
        if (isMon() && isTue() && isWed() && isThu() && isFri() && isSat() && isSun())
            return "Everyday";

        return mon + tue + wed + thu + fri + sat + sun;
    }


    public int getMed_id() {
        return med_id;
    }

    public void setMed_id(int med_id) {
        this.med_id = med_id;
    }


    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public boolean isMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
    }

    public boolean isTue() {
        return tue;
    }

    public void setTue(boolean tue) {
        this.tue = tue;
    }

    public boolean isWed() {
        return wed;
    }

    public void setWed(boolean wed) {
        this.wed = wed;
    }

    public boolean isThu() {
        return thu;
    }

    public void setThu(boolean thu) {
        this.thu = thu;
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
