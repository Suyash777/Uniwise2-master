package com.example.uniwise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.SubjectsViewHolder> {


    private String[] data;
    private String[] course;
    public SubjectsAdapter(String[] data,String[] course)
    {
        this.data=data;
        this.course=course;
    }
    @NonNull
    @Override
    public SubjectsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_layout,parent,false);
        return new SubjectsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectsViewHolder holder, int position) {
        String title=data[position];
        String Ccode=course[position];
        holder.txtCode.setText(Ccode);
        holder.txtTitle.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class SubjectsViewHolder extends RecyclerView.ViewHolder{
        TextView txtCode;
        TextView txtTitle;
        public SubjectsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCode=itemView.findViewById(R.id.courseCode);
            txtTitle=itemView.findViewById(R.id.javaSub);
        }
    }
}
