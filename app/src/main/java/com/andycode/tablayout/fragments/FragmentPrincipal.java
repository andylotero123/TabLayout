package com.andycode.tablayout.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andycode.tablayout.R;
import com.andycode.tablayout.adapter.AdapterViewPager;
import com.google.android.material.tabs.TabLayout;

public class FragmentPrincipal extends Fragment {

    TabLayout tabLayoutFragments;
    ViewPager2 viewPager2;
    AdapterViewPager adapterViewPager;

    public FragmentPrincipal() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayoutFragments = view.findViewById(R.id.idTabLayouFragment);
        viewPager2 = view.findViewById(R.id.viewPagerFragment);

        viewPager2.setAdapter(new AdapterViewPager(getActivity()));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                tabLayoutFragments.selectTab(tabLayoutFragments.getTabAt(position));
            }
        });
    }
}