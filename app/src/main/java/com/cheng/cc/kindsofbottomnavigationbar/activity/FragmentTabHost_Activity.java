package com.cheng.cc.kindsofbottomnavigationbar.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.cheng.cc.kindsofbottomnavigationbar.R;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.FirstFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.FourthFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.SecondFragment;
import com.cheng.cc.kindsofbottomnavigationbar.fragment.ThirdFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentTabHost_Activity extends AppCompatActivity {

    @BindView(android.R.id.tabhost)
    FragmentTabHost tabhost;

    private String title[] = {
            "one",
            "two",
            "three",
            "four"
    };

    private Class fragment[] = {
            FirstFragment.class,
            SecondFragment.class,
            ThirdFragment.class,
            FourthFragment.class
    };


    //    4.0控件，用法几乎和tabhost一样
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tabhost);
        ButterKnife.bind(this);

        Drawable images[] = new Drawable[4];

        images[0] = this.getResources().getDrawable(R.mipmap.home);
        images[1] = this.getResources().getDrawable(R.mipmap.present);
        images[2] = this.getResources().getDrawable(R.mipmap.text);
        images[3] = this.getResources().getDrawable(R.mipmap.myself);


        tabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        tabhost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < images.length; i++) {
            // Tab按钮添加文字和图片
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(title[i]).setIndicator("", images[i]);
            // 添加Fragment
            tabhost.addTab(tabSpec, fragment[i], null);
        }

    }
}
