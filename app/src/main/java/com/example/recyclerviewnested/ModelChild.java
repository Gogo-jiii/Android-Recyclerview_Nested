package com.example.recyclerviewnested;

public class ModelChild {

    private String child;

    public ModelChild(String child) {
        this.child = child;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "ModelChild{" +
                "child='" + child + '\'' +
                '}';
    }
}
