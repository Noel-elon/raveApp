package com.example.raveapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecViewHolder>  {

    private Context mContext;
    private List<items> products;
    private onRecyclerClick mOnrecyclerClick;

    public RecyclerAdapter(Context mContext, List<items> products, onRecyclerClick onRecyclerClick) {
        this.mContext = mContext;
        this.products = products;
        this.mOnrecyclerClick = onRecyclerClick;
    }


    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.itemlist, null);
        RecViewHolder holder = new RecViewHolder(view, mOnrecyclerClick);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        items items = products.get(position);
        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(items.getItemImage()));
        holder.textView.setText(items.getItemName());
        holder.textView2.setText(String.valueOf(items.getItemPrice()));



    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class RecViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView, textView2;
        onRecyclerClick onRecyclerClick;


        public RecViewHolder(@NonNull View itemView, onRecyclerClick onRecyclerClick) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            this.onRecyclerClick = onRecyclerClick;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(mContext, "Hey there", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(mContext, PaymentActivity.class);
            mContext.startActivity(intent);


        }

        public items getItem(int position){
            return  products.get(position);

        }





    }



    public interface onRecyclerClick {

        void onItemClick(int position);
    }


}
