package com.fadecolor.esport.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.fadecolor.esport.R;
import com.fadecolor.esport.Util.Constant;
import com.fadecolor.esport.domain.Order;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder>  {
    private List<Order> orders;
    private final String[] Time = new String[]{"8:00-9:00","9:00-10:00","10:00-11:00","11:00-12:00","12:00-13:00","13:00-14:00","14:00-15:00","15:00-16:00","16:00-17:00","17:00-18:00","18:00-19:00","19:00-20:00","20:00-21:00","21:00-22:00"};
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日", Locale.CHINA);
    public MyOrderAdapter(List<Order> orders){
        this.orders = orders;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
TextView name,time;
ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Gym_name);
            imageView = itemView.findViewById(R.id.Gym_image);
            time = itemView.findViewById(R.id.time);

        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_gym_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orders.get(position);
        if (order.getImageSrc() != null && !order.getImageSrc().equals("null")) {
            Glide.with(holder.itemView)
                    .load(Constant.GYM_IMG_PATH + order.getImageSrc())
                    .into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.ic_user_default);
        }

        holder.name.setText(order.getName());
        holder.time.setText("有效时间："+dateFormat.format(order.getDate())+" "+Time[order.getPeriod()-1]);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }


}
