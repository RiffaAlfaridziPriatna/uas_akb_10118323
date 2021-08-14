//14 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.Presenter.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas_akb_10118323.Model.WisataModel;
import com.example.uas_akb_10118323.R;
import com.example.uas_akb_10118323.View.Activity.DetailActivity;
import com.example.uas_akb_10118323.View.Activity.DetailDestinasiActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListDestinasiAdapter extends RecyclerView.Adapter<ListDestinasiAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<WisataModel> myModel;
    private Activity activity;

    public ListDestinasiAdapter(Context context, Activity activity, ArrayList<WisataModel> myModel) {
        this.context = context;
        this.myModel = myModel;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ListDestinasiAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_destinasi, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListDestinasiAdapter.MyViewHolder holder, int position) {
        holder.tvJudul.setText(myModel.get(position).getNama());
        holder.tvDesc.setText(myModel.get(position).getDeskripsi());
        holder.tvLokasi.setText(myModel.get(position).getAlamat());
        holder.ratingBar.setRating(Float.parseFloat(myModel.get(position).getRating()));
        Picasso.get().load(myModel.get(position).getGambar()).into(holder.ivGambar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("gambar", myModel.get(position).getGambar());
                intent.putExtra("destinasi", myModel.get(position).getNama());
                intent.putExtra("rating", myModel.get(position).getRating());
                intent.putExtra("lokasi", myModel.get(position).getAlamat());
                intent.putExtra("buka", myModel.get(position).getBuka());
                intent.putExtra("deskripsi", myModel.get(position).getDeskripsi());
                intent.putExtra("longitude", myModel.get(position).getLongitude());
                intent.putExtra("latitude", myModel.get(position).getLatitude());
                context.startActivity(intent);
                activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivGambar;
        private TextView tvJudul, tvDesc, tvLokasi;
        private AppCompatRatingBar ratingBar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGambar = itemView.findViewById(R.id.ivGambar);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvLokasi = itemView.findViewById(R.id.tvLokasi);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
