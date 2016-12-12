package com.mycompany.model;


public class ButtonInfo {
    
    private String value;

    public ButtonInfo() {
    }

    public ButtonInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ButtonInfo{" + "value=" + value + '}';
    }
    
    
    
    
}
