package com.hr190023.salih_selim_sekerci_final.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190023.salih_selim_sekerci_final.R;

public class VersionViewHolder extends RecyclerView.ViewHolder {

    public TextView txtVersion, txtName;
    public ImageView version_img;
    public CardView card_view;

    public VersionViewHolder(@NonNull View itemView) {
        super(itemView);
//Önyüzdeki ilgili itemleri arka yüze alıyoruz
        card_view = itemView.findViewById(R.id.cvVersion);
        txtVersion = itemView.findViewById(R.id.txtVersion);
        txtName = itemView.findViewById(R.id.txtName);
        version_img = itemView.findViewById(R.id.version_img);

    }

}