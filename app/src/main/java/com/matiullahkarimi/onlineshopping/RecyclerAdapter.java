package com.matiullahkarimi.onlineshopping;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Matiullah Karimi on 10/12/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Product> mData;
    private LayoutInflater mInflator;

    public RecyclerAdapter(Context context, List<Product> data){
        this.mData = data;
        this.mInflator = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflator.inflate(R.layout.item_list, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Product currentObject = mData.get(position);
        holder.setData(currentObject, position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, price;
        ImageView image;
        int position;
        Product current;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.pName);
            image = (ImageView) itemView.findViewById(R.id.pImage);
            price = (TextView) itemView.findViewById(R.id.pPrice);
        }

        public void setData(Product current, int position) {
            this.name.setText(current.getName());
            this.image.setImageResource(current.getImage());
            this.price.setText(current.getPrice());
            this.position = position;
            this.current = current;
        }
    }
}
