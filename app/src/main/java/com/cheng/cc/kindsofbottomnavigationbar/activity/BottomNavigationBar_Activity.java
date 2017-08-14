package com.cheng.cc.kindsofbottomnavigationbar.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.cheng.cc.kindsofbottomnavigationbar.R;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.FirstFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.FourthFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.SecondFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomNavigationBar_Activity extends AppCompatActivity {

    @BindView(R.id.navigation_bar)
    BottomNavigationBar navigationBar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private List<Fragment> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavigation_bar);
        ButterKnife.bind(this);

        data.add(new FirstFragment());
        data.add(new SecondFragment());
        data.add(new ThirdFragment());
        data.add(new FourthFragment());

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        navigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        navigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        //设置消息小图标
        TextBadgeItem textBadgeItem = new TextBadgeItem();
        textBadgeItem.setHideOnSelect(false)
                .setText("8")
                .setBackgroundColorResource(R.color.green)
                .setBorderWidth(0);

        View view = LayoutInflater.from(this).inflate(R.layout.fragment_second,null);

        navigationBar
                .setBarBackgroundColor(R.color.white)
                .addItem(new BottomNavigationItem(R.mipmap.home_selected, "one").setActiveColorResource(R.color.colorAccent)
                        .setInactiveIconResource(R.mipmap.home).setInActiveColorResource(R.color.font))
                .addItem(new BottomNavigationItem(R.mipmap.present_selected, "two").setActiveColorResource(R.color.colorAccent)
                        .setInactiveIconResource(R.mipmap.present).setInActiveColorResource(R.color.font)
                        .setBadgeItem(textBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.text_selected, "three").setActiveColorResource(R.color.colorAccent)
                        .setInactiveIconResource(R.mipmap.text).setInActiveColorResource(R.color.font))
                .addItem(new BottomNavigationItem(R.mipmap.myself_selected, "four").setActiveColorResource(R.color.colorAccent)
                        .setInactiveIconResource(R.mipmap.myself).setInActiveColorResource(R.color.font))
                //依次添加item,分别icon和名称
                .setFirstSelectedPosition(0)//设置默认选择item
                .initialise();//初始化



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        navigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });





    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }

        @Override
        public int getCount() {
            return data.size();
        }
    }



}
