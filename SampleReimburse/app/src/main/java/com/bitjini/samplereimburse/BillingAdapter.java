package com.bitjini.samplereimburse;

/**
 * Created by bitjini on 14/11/16.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by bitjini on 4/11/16.
 */
public class BillingAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    private long baseId = 0;

    public BillingAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new NewTrip_Fragment();
                break;
            case 1:
                frag =new ActiveTrip_Fragment();
                break;

        }
        return frag;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_UNCHANGED;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String title = " ";
        switch (position) {
            case 0:
                title = "New Trip";
                break;
            case 1:
                title = "Active Trip";
                break;

        }
        return title;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
