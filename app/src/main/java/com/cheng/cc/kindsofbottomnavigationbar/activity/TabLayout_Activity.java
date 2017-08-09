package com.cheng.cc.kindsofbottomnavigationbar.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cheng.cc.kindsofbottomnavigationbar.R;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.FirstFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.FourthFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.SecondFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.ThirdFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabLayout_Activity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    //    5.0控件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        ButterKnife.bind(this);

        ViewPager_Adapter viewPager_Adapter = new ViewPager_Adapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPager_Adapter);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setIcon(R.mipmap.home_selected);
        tabLayout.getTabAt(1).setIcon(R.mipmap.present);
        tabLayout.getTabAt(2).setIcon(R.mipmap.text);
        tabLayout.getTabAt(3).setIcon(R.mipmap.myself);

        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).select();


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.e("data", "---选中----" +tab.getPosition());
                tabLayout.getTabAt(0).setIcon(R.mipmap.home);
                tabLayout.getTabAt(1).setIcon(R.mipmap.present);
                tabLayout.getTabAt(2).setIcon(R.mipmap.text);
                tabLayout.getTabAt(3).setIcon(R.mipmap.myself);
                switch (tab.getPosition()) {
                    case 0:
                        tabLayout.getTabAt(0).setIcon(R.mipmap.home_selected);
                        break;
                    case 1:
                        tabLayout.getTabAt(1).setIcon(R.mipmap.present_selected);
                        break;
                    case 2:
                        tabLayout.getTabAt(2).setIcon(R.mipmap.text_selected);
                        break;
                    case 3:
                        tabLayout.getTabAt(3).setIcon(R.mipmap.myself_selected);
                        break;
                    default:
                        break;
                }


            }

            //tab未选中
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.e("data", "---未选中----" + tab.getPosition());
            }

            //tab重新选中
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.e("data", "---重新选中----" + tab.getPosition());
            }
        });


    }

    public class ViewPager_Adapter extends FragmentStatePagerAdapter {

        private String title[] = {
                "one",
                "two",
                "three",
                "four"
        };

        public ViewPager_Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 1) {
                return new SecondFragment();
            } else if (position == 2) {
                return new ThirdFragment();
            } else if (position == 3) {
                return new FourthFragment();
            }
            return new FirstFragment();
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }


}
