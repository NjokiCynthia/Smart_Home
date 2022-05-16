package com.example.smart_home;

public class Led {

    private String Id;
    private String Status;
    private int Intensity;
    private boolean isClicked = false;
    private String Label;

    public boolean isClicked() {

        return !isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStatus() {
        return Status;
    }

    public String getLabel() {
        return Label;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public int getIntensity() {
        return Intensity;
    }

    public void setIntensity(int intensity) {
        Intensity = intensity;
    }

    public Led(String id, String status, String label) {
        Id = id;
        Status = status;
        Label = label;
    }

    public Led() {
    }
    
}

