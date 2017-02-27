package com.bitjini.samplereimburse;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

/**
 * Created by bitjini on 27/2/17.
 */

public class ScanAddBill_Activity extends BaseActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    BillingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_or_add_bill);


        initViews();
    }

    private void initViews() {

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        adapter = new BillingAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //set Adapter to view pager
        viewPager.setAdapter(adapter);
        int limit = adapter.getCount();
// Set the number of pages that should be retained to either side of the current page in the view hierarchy in an idle state.
        viewPager.setOffscreenPageLimit(limit);
        //set tablayout with viewpager

        tabLayout.setupWithViewPager(viewPager);
        int page = 0;


        // adding functionality to tab and viewpager to manage each other when a page is changed or when a tab is selected
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0);


    }
}