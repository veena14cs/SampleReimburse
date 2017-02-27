package com.bitjini.samplereimburse;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by bitjini on 27/2/17.
 */

public class ActiveTrip_Fragment extends android.support.v4.app.Fragment {
    View activeTripView;
    ArrayList<String> arrayOfTripDetails=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        setRetainInstance(true);
        activeTripView = inflater.inflate(R.layout.active_trip_fragment, container, false);
        initViews();
        initListeners();
        showListView();
        return activeTripView;

    }
    private void initViews() {

        recyclerView = (RecyclerView) activeTripView.findViewById(R.id.listOfTrips);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


    }
    private void initListeners() {
    }
    private void showListView() {

        arrayOfTripDetails.add("Delhi");
        arrayOfTripDetails.add("Malwan");

        ActiveTripsAdapter adapter= new ActiveTripsAdapter(getActivity(),arrayOfTripDetails);
        recyclerView.setAdapter(adapter);



        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);


                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }

}
