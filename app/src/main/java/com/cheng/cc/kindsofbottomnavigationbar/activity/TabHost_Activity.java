package com.cheng.cc.kindsofbottomnavigationbar.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.cheng.cc.kindsofbottomnavigationbar.R;


public class TabHost_Activity extends TabActivity {

//    一次加载消耗内存,4.0之后已经放弃了
    private TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
        tabHost = getTabHost();


        Intent intent1 = new Intent(TabHost_Activity.this, First_Activity.class);
        Intent intent2 = new Intent(TabHost_Activity.this, Second_Activity.class);
        Intent intent3 = new Intent(TabHost_Activity.this, Third_Activity.class);
        Intent intent4 = new Intent(TabHost_Activity.this, Four_Activity.class);

        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("",getResources().getDrawable(R.mipmap.home))
                .setContent(intent1));
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("", getResources().getDrawable(R.mipmap.present))
                .setContent(intent2));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("", getResources().getDrawable(R.mipmap.text))
                .setContent(intent3));
        tabHost.addTab(tabHost.newTabSpec("tab4")
                .setIndicator("", getResources().getDrawable(R.mipmap.myself))
                .setContent(intent4));

        tabHost.setCurrentTab(0);

    }

}
