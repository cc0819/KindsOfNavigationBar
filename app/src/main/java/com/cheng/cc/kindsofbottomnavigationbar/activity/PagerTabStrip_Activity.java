package com.cheng.cc.kindsofbottomnavigationbar.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;

import com.cheng.cc.kindsofbottomnavigationbar.R;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.FirstFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.FourthFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.SecondFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PagerTabStrip_Activity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.pagertab)
    PagerTabStrip pagertab;

    private List<String> titles = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagertabstrip);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

        pagertab.setBackgroundColor(Color.BLUE);// 背景颜色
        pagertab.setTextColor(Color.WHITE);// 标题颜色，这里需要带透明度的颜色值
        pagertab.setTabIndicatorColor(Color.YELLOW);// 指示器颜色，这里需要带透明度的颜色值
        pagertab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26);// 字体大小

        fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        fragments.add(new FourthFragment());

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

    @OnClick({R.id.view_pager, R.id.pagertab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.view_pager:

                break;
            case R.id.pagertab:

                break;
        }
    }


    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}
