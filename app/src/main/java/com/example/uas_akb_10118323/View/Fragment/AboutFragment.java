//10 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.View.Fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uas_akb_10118323.Presenter.Implement.UserImplement;
import com.example.uas_akb_10118323.Presenter.Listener.OnGetDataListener;
import com.example.uas_akb_10118323.R;
import com.google.firebase.database.DataSnapshot;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutFragment extends Fragment {

    private ImageButton btnWhatsapp, btnInstagram, btnCall;
    private TextView tvNama, tvEmail, tvNama2, tvKelas, tvNim, tvCampus, tvEmail2, tvPhone, tvInstagram;
    private LinearLayout llResult;
    private CardView cvLoading;
    private CircleImageView ivProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        init(root);
        return root;
    }

    private void init(View root) {
        btnWhatsapp = root.findViewById(R.id.btnWhatsapp);
        btnInstagram = root.findViewById(R.id.btnInstagram);
        btnCall = root.findViewById(R.id.btnCall);
        tvNama = root.findViewById(R.id.tvNama);
        tvEmail = root.findViewById(R.id.tvEmail);
        tvNama2 = root.findViewById(R.id.tvNama2);
        tvKelas = root.findViewById(R.id.tvKelas);
        tvNim = root.findViewById(R.id.tvNim);
        tvCampus = root.findViewById(R.id.tvCampus);
        tvEmail2 = root.findViewById(R.id.tvEmail2);
        tvPhone = root.findViewById(R.id.tvPhone);
        tvInstagram = root.findViewById(R.id.tvInstagram);
        llResult = root.findViewById(R.id.llResult);
        cvLoading = root.findViewById(R.id.cvLoading);
        ivProfile = root.findViewById(R.id.ivProfile);

        llResult.setVisibility(View.GONE);
        cvLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStart() {
        super.onStart();
        UserImplement user = new UserImplement();
        user.read(new OnGetDataListener() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                tvNim.setText(String.valueOf(dataSnapshot.child("nim").getValue()));
                tvPhone.setText(String.valueOf(dataSnapshot.child("phone").getValue()));
                tvCampus.setText(String.valueOf(dataSnapshot.child("campus").getValue()));
                tvNama.setText(String.valueOf(dataSnapshot.child("name").getValue()));
                tvNama2.setText(String.valueOf(dataSnapshot.child("name").getValue()));
                tvInstagram.setText(String.valueOf(dataSnapshot.child("instagram").getValue()));
                tvKelas.setText(String.valueOf(dataSnapshot.child("class").getValue()));
                tvEmail.setText(String.valueOf(dataSnapshot.child("email").getValue()));
                tvEmail2.setText(String.valueOf(dataSnapshot.child("email").getValue()));
                Picasso
                        .get()
                        .load(String.valueOf(dataSnapshot.child("profilepic").getValue()))
                        .placeholder(R.drawable.ic_outline_account_circle_24)
                        .error(R.drawable.ic_outline_account_circle_24)
                        .into(ivProfile, new com.squareup.picasso.Callback() {
                            @Override
                            public void onSuccess() {
                                llResult.setVisibility(View.VISIBLE);
                                cvLoading.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError(Exception e) {
                                Toast.makeText(getContext(), "Error downloading image!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.whatsapp.com/send?phone=+62 85974594099";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri url = Uri.parse("http://www.instagram.com/_u/riffaap");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, url);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/xxx")));
                }
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+6285974594099";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });
    }
}