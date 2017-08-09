package com.cheng.cc.kindsofbottomnavigationbar.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cheng.cc.kindsofbottomnavigationbar.R;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.FirstFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.FourthFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.SecondFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RadioGroup_Activity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.home)
    RadioButton home;
    @BindView(R.id.present)
    RadioButton present;
    @BindView(R.id.text)
    RadioButton text;
    @BindView(R.id.myself)
    RadioButton myself;
    @BindView(R.id.tab)
    RadioGroup tab;

    private List<Fragment> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiogroup);
        ButterKnife.bind(this);
        data.add(new FirstFragment());
        data.add(new SecondFragment());
        data.add(new ThirdFragment());
        data.add(new FourthFragment());

        view_pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        view_pager.setCurrentItem(0);

//        设置默认显示的位置,两种都能设置位置
//        tab.check(R.id.present);
        present.setChecked(true);
        view_pager.setCurrentItem(1, true);

        view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
//                        tab.check(R.id.home);
                        home.setChecked(true);
                        break;
                    case 1:
//                        tab.check(R.id.present);
                        present.setChecked(true);
                        break;
                    case 2:
//                        tab.check(R.id.text);
                        text.setChecked(true);
                        break;
                    case 3:
//                        tab.check(R.id.myself);
                        myself.setChecked(true);
                        break;
                    default:
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @OnClick({R.id.home, R.id.present, R.id.text, R.id.myself})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home:
                view_pager.setCurrentItem(0, false);
                break;
            case R.id.present:
                view_pager.setCurrentItem(1, false);
                break;
            case R.id.text:
                view_pager.setCurrentItem(2, false);
                break;
            case R.id.myself:
                view_pager.setCurrentItem(3, false);
                break;
        }
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
