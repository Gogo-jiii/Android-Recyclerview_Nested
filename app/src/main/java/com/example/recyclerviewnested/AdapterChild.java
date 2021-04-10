package com.example.recyclerviewnested;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterChild extends RecyclerView.Adapter<AdapterChild.ViewHolder> {

    private Context context;
    private ArrayList<ModelChild> arrayListChild;
    private ArrayList<ModelParent> arrayListParent;

    public AdapterChild(Context context, ArrayList<ModelParent> arrayListParent, ArrayList<ModelChild> arrayListChild) {
        this.context = context;
        this.arrayListChild = arrayListChild;
        this.arrayListParent = arrayListParent;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_child, parent, false);
        AdapterChild.ViewHolder viewHolder = new AdapterChild.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelChild modelChild = arrayListChild.get(position);
        holder.textViewChild.setText(modelChild.getChild());
    }

    @Override
    public int getItemCount() {
        return arrayListChild.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewChild;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewChild = itemView.findViewById(R.id.textViewChild);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ModelParent modelParent = arrayListParent.get(AdapterParent.parentPosition);
                    ArrayList<ModelChild> arrayListChild = modelParent.getArrayListChild();

                    Toast.makeText(context, "Parent: " + modelParent.getParent() + "\n" +
                                    "Child: " + arrayListChild.get(getAdapterPosition()),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
