package com.example.recyclerviewnested;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterParent extends RecyclerView.Adapter<AdapterParent.ViewHolder> {

    private Context context;
    private ArrayList<ModelParent> arrayListParent;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    public static int parentPosition = -1;

    public AdapterParent(MainActivity context, ArrayList<ModelParent> arrayListParent) {
        this.context = context;
        this.arrayListParent = arrayListParent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_parent, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelParent modelParent = arrayListParent.get(position);
        ArrayList<ModelChild> arrayListChild = modelParent.getArrayListChild();

        holder.textView.setText(modelParent.getParent());

        //Child Recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.recyclerViewChild.getContext(),
                LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setInitialPrefetchItemCount(arrayListChild.size());

        AdapterChild adapterChild = new AdapterChild(context, arrayListParent, arrayListChild);

        holder.recyclerViewChild.setLayoutManager(linearLayoutManager);
        holder.recyclerViewChild.setAdapter(adapterChild);
        holder.recyclerViewChild.setRecycledViewPool(viewPool);

        if (modelParent.isChildVisible()) {
            holder.recyclerViewChild.setVisibility(View.VISIBLE);
        } else {
            holder.recyclerViewChild.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return arrayListParent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView recyclerViewChild;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textView = itemView.findViewById(R.id.textViewParent);
            this.recyclerViewChild = itemView.findViewById(R.id.recyclerviewChild);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    parentPosition = getAdapterPosition();
                    Toast.makeText(context, String.valueOf(arrayListParent.get(getAdapterPosition()).getParent()),
                            Toast.LENGTH_SHORT).show();

                    ModelParent modelParent = arrayListParent.get(getAdapterPosition());
                    if (modelParent.isChildVisible()) {
                        modelParent.setChildVisible(false);
                    } else {
                        modelParent.setChildVisible(true);
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }
}
