package com.hr190023.salih_selim_sekerci_final.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190023.salih_selim_sekerci_final.Activity.DetailActivity;
import com.hr190023.salih_selim_sekerci_final.Model.AndroidVersion;
import com.hr190023.salih_selim_sekerci_final.R;
import com.hr190023.salih_selim_sekerci_final.Util.GlideUtil;

import java.util.List;

public class VersionAdapter extends RecyclerView.Adapter<VersionViewHolder> {
    List<AndroidVersion> versions;
    Context context;


    public VersionAdapter(List<AndroidVersion> versions, Context context) {
        this.versions = versions;
        this.context = context;
    }

    @NonNull
    @Override
    public VersionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.version_card_view_layout, viewGroup, false);
        return new VersionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionViewHolder viewHolder, final int position) {

        final AndroidVersion version = versions.get(position);
        //Değerleri cardview için ön yüze aktar
        viewHolder.txtName.setText(version.getName());
        viewHolder.txtVersion.setText(version.getVersion());
        GlideUtil.showImageFromUrl(context, version.getImgUrl(), viewHolder.version_img);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("AndroidVersion", versions.get(position)); //tıklanan itemi detay sayfasına gönder
                context.startActivity(intent); // detay sayfasnı aç

            }
        });
    }

    @Override
    public int getItemCount() {
        return versions.size();
    }
}
