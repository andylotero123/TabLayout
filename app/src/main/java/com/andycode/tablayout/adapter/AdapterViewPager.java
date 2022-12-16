package com.andycode.tablayout.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.andycode.tablayout.fragments.Fragment1;
import com.andycode.tablayout.fragments.Fragment2;

public class AdapterViewPager extends FragmentStateAdapter {


    public AdapterViewPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){

            case 0:
                return new Fragment1();

            case 1:
                return new Fragment2();

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
