package com.bitjini.samplereimburse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bitjini on 27/2/17.
 */

public class NewTrip_Fragment extends android.support.v4.app.Fragment {
    View newTripView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        setRetainInstance(true);
        newTripView = inflater.inflate(R.layout.new_trip_fragment, container, false);
        return newTripView;

    }
}
