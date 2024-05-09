package com.wisatarasabali;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MasakanAdapter extends RecyclerView.Adapter<MasakanAdapter.ViewHolderMasakan> {
    private final ArrayList<Masakan> listMasakan;
    private final RVMasakanListener listener;

    public MasakanAdapter(ArrayList<Masakan> listMasakan, RVMasakanListener listener) {
        this.listMasakan = listMasakan;
        this.listener = listener;
    }

    public class ViewHolderMasakan extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtMasakan, txtDeskripsi, txtHarga;
        public ImageView imgviewMasakan;

        public ViewHolderMasakan(@NonNull View itemView) {
            super(itemView);

            txtMasakan = itemView.findViewById(R.id.textMasakan);
            txtDeskripsi = itemView.findViewById(R.id.textDeskripsi);
            txtHarga = itemView.findViewById(R.id.textHarga);
            imgviewMasakan = itemView.findViewById(R.id.imageMasakan);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                listener.onClick(view, position);
            }
        }
    }

    @NonNull
    @Override
    public MasakanAdapter.ViewHolderMasakan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context konteks = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(konteks);
        View itemView = inflater.inflate(R.layout.card_kuliner, parent, false);
        return new ViewHolderMasakan(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MasakanAdapter.ViewHolderMasakan holder, int position) {
        Masakan ambilMasakan = listMasakan.get(position);
        holder.txtMasakan.setText(ambilMasakan.getNamaMasakan());
        holder.txtDeskripsi.setText(ambilMasakan.getDescMasakan());
        holder.txtHarga.setText(ambilMasakan.getHargaMasakan());
        holder.imgviewMasakan.setImageResource(ambilMasakan.getIdPhoto());
    }

    @Override
    public int getItemCount() {
        return listMasakan.size();
    }

    public interface RVMasakanListener {
        void onClick(View view, int position);
    }
}