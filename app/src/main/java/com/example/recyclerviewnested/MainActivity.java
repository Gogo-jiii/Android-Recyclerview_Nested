package com.example.recyclerviewnested;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<ModelParent> arrayListParent = new ArrayList<>();
    ArrayList<ArrayList<ModelChild>> arrayListChild = new ArrayList<>();
    ArrayList<ModelChild> arrayListChildA = new ArrayList<>();
    ArrayList<ModelChild> arrayListChildB = new ArrayList<>();
    ArrayList<ModelChild> arrayListChildC = new ArrayList<>();

    String[] arrayParent = new String[]{"a", "b", "c"};
    String[] arrayChildA = new String[]{"a1", "a2", "a3"};
    String[] arrayChildB = new String[]{"b1", "b2", "b3"};
    String[] arrayChildC = new String[]{"c1", "c2", "c3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewParent);

        AdapterParent adapterParent = new AdapterParent(this, getParentData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapterParent);
    }

    private ArrayList<ModelParent> getParentData() {
        arrayListChild = getChildData();

        for (int i = 0; i < arrayParent.length; i++) {

            String parent = arrayParent[i];
            ArrayList<ModelChild> child = arrayListChild.get(i);

            arrayListParent.add(new ModelParent(parent, child, false));
        }

        return arrayListParent;
    }

    private ArrayList<ArrayList<ModelChild>> getChildData() {
        for (int i = 0; i < arrayChildA.length; i++) {
            arrayListChildA.add(new ModelChild(arrayChildA[i]));
        }

        for (int i = 0; i < arrayChildB.length; i++) {
            arrayListChildB.add(new ModelChild(arrayChildB[i]));
        }

        for (int i = 0; i < arrayChildC.length; i++) {
            arrayListChildC.add(new ModelChild(arrayChildC[i]));
        }

        arrayListChild.add(arrayListChildA);
        arrayListChild.add(arrayListChildB);
        arrayListChild.add(arrayListChildC);

        return arrayListChild;
    }
}