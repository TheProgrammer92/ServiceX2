package com.theprogrammer.servicex.outils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.theprogrammer.servicex.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

        Context context;
        List<service_item> mData;


        public Adapter(Context nContext, List<service_item> mData) {


            this.mData = mData;
            this.context = nContext;
        }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater  = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.card_item,viewGroup,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.myViewHolder myViewHolder, int i) {


            myViewHolder.background_img.setImageResource(mData.get(i).getBackground());
            myViewHolder.profile_photo.setImageResource(mData.get(i).getProfile_photo());
            myViewHolder.txt_info.setText(mData.get(i).getInfo_service());
            myViewHolder.txt_title.setText(mData.get(i).getName_service());
    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {


            ImageView profile_photo , background_img;
            TextView txt_title,txt_info;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            profile_photo = itemView.findViewById(R.id.profile_service);
            background_img = itemView.findViewById(R.id.card_background);
           txt_title = itemView.findViewById(R.id.card_title);

           txt_info = itemView.findViewById(R.id.txt_info);

        }
    }
}
