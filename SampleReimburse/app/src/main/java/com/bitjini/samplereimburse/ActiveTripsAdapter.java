package com.bitjini.samplereimburse;

/**
 * Created by bitjini on 27/2/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by bitjini on 28/10/16.
 */

public class ActiveTripsAdapter extends RecyclerView.Adapter<ActiveTripsAdapter.ViewHolder> {

    Context context;
    ArrayList<String> arrayOfServiceList=new ArrayList<>();

    public ActiveTripsAdapter(Context context, ArrayList<String> arrayOfServiceList) {
        this.context=context;
        this.arrayOfServiceList=arrayOfServiceList;
    }

    @Override
    public ActiveTripsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.active_trip_list_items,parent,false);

//        ViewHolder viewHolder1 = new ViewHolder(view1);
        // work here if you need to control height of your items
        // keep in mind that parent is RecyclerView in this case
        int height = parent.getMeasuredHeight() / 4;
        view1.setMinimumHeight(height);
        return  new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(ActiveTripsAdapter.ViewHolder holder, int position) {
        holder.txtdestination.setText(arrayOfServiceList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayOfServiceList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtdestination,txtDate,txtCategory,txtDays,txtCost;
        ImageView callBtn;
        public ViewHolder(View view) {
            super(view);

            txtdestination = (TextView)view.findViewById(R.id.destination);
            txtDate = (TextView)view.findViewById(R.id.date);
            txtCategory = (TextView)view.findViewById(R.id.numberOfDays);
            txtDays = (TextView)view.findViewById(R.id.category);
            txtCost = (TextView)view.findViewById(R.id.totalCost);





        }
    }
}

