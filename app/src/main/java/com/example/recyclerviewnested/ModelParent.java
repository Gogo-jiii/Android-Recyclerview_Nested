package com.example.recyclerviewnested;

import java.util.ArrayList;

public class ModelParent {

    private String parent;
    private ArrayList<ModelChild> arrayListChild;
    private boolean isChildVisible;

    public ModelParent(String parent, ArrayList<ModelChild> arrayListChild, boolean isChildVisible) {
        this.parent = parent;
        this.arrayListChild = arrayListChild;
        this.isChildVisible = isChildVisible;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public ArrayList<ModelChild> getArrayListChild() {
        return arrayListChild;
    }

    public void setArrayListChild(ArrayList<ModelChild> arrayListChild) {
        this.arrayListChild = arrayListChild;
    }

    public boolean isChildVisible() {
        return isChildVisible;
    }

    public void setChildVisible(boolean childVisible) {
        isChildVisible = childVisible;
    }

    @Override
    public String toString() {
        return "ModelParent{" +
                "parent='" + parent + '\'' +
                ", children=" + arrayListChild +
                ", isChildVisible=" + isChildVisible +
                '}';
    }
}
