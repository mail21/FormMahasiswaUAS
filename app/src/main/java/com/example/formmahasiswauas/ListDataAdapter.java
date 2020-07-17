package com.example.formmahasiswauas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ViewHolder> {

    ArrayList<ModelMahasiswa> mhs;
    Context context;

    public ListDataAdapter(ArrayList<ModelMahasiswa> mhs, Context context) {
        this.mhs = mhs;
        this.context = context;
    }

    @androidx.annotation.NonNull
    @Override
    public ViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_data_design,parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull final ViewHolder holder, final int position) {
        holder.tvNama.setText(mhs.get(position).getNama());
        holder.tvNim.setText(mhs.get(position).getNim());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mhs.get(position).getNama(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Deskripsi.class);
                intent.putExtra("id", mhs.get(position).getId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ListDataActivity.fa.finish();
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mhs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNim;
        LinearLayout layout;

        public ViewHolder(@androidx.annotation.NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_list_nama);
            tvNim = itemView.findViewById(R.id.tv_list_nim);
            layout = itemView.findViewById(R.id.linear_list);
        }
    }
}
