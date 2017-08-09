package com.cheng.cc.kindsofbottomnavigationbar.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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

import static com.cheng.cc.kindsofbottomnavigationbar.R.id.view_pager;

public class TextViewFrag_Activity extends AppCompatActivity {

    @BindView(view_pager)
    ViewPager viewPager;
    @BindView(R.id.home)
    TextView home;
    @BindView(R.id.present)
    TextView present;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.myself)
    TextView myself;

    private List<Fragment> data = new ArrayList<>();

    private Drawable drawableHome;
    private Drawable drawablePresent;
    private Drawable drawableText;
    private Drawable drawableMyself;
    private Drawable drawableHomeed;
    private Drawable drawablePresented;
    private Drawable drawableTexted;
    private Drawable drawableMyselfed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        ButterKnife.bind(this);

        data.add(new FirstFragment());
        data.add(new SecondFragment());
        data.add(new ThirdFragment());
        data.add(new FourthFragment());


        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        initView();

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                selectPosition(position, false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //装载
    private void initView() {
        drawableHome = getResources().getDrawable(R.mipmap.home);
        drawablePresent = getResources().getDrawable(R.mipmap.present);
        drawableText = getResources().getDrawable(R.mipmap.text);
        drawableMyself = getResources().getDrawable(R.mipmap.myself);

        drawableHomeed = getResources().getDrawable(R.mipmap.home_selected);
        drawablePresented = getResources().getDrawable(R.mipmap.present_selected);
        drawableTexted = getResources().getDrawable(R.mipmap.text_selected);
        drawableMyselfed = getResources().getDrawable(R.mipmap.myself_selected);

        drawableHome.setBounds(0, 0, drawableHome.getMinimumWidth(), drawableHome.getIntrinsicHeight());
        drawablePresent.setBounds(0, 0, drawablePresent.getMinimumWidth(), drawablePresent.getIntrinsicHeight());
        drawableText.setBounds(0, 0, drawableText.getMinimumWidth(), drawableText.getIntrinsicHeight());
        drawableMyself.setBounds(0, 0, drawableMyself.getMinimumWidth(), drawableMyself.getIntrinsicHeight());

        drawableHomeed.setBounds(0, 0, drawableHomeed.getMinimumWidth(), drawableHomeed.getIntrinsicHeight());
        drawablePresented.setBounds(0, 0, drawablePresented.getMinimumWidth(), drawablePresented.getIntrinsicHeight());
        drawableTexted.setBounds(0, 0, drawableTexted.getMinimumWidth(), drawableTexted.getIntrinsicHeight());
        drawableMyselfed.setBounds(0, 0, drawableMyselfed.getMinimumWidth(), drawableMyselfed.getIntrinsicHeight());

        //设置默认位置
        viewPager.setCurrentItem(1);
        present.setCompoundDrawables(null, drawablePresented, null, null);
        present.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    @OnClick({R.id.home, R.id.present, R.id.text, R.id.myself})
    public void onViewClicked(View view) {
        selectPosition(view.getId(), true);
    }



//    设置底部文字和图片的变化
    private void selectPosition(int position, boolean isView) {
        home.setTextColor(getResources().getColor(R.color.font));
        present.setTextColor(getResources().getColor(R.color.font));
        text.setTextColor(getResources().getColor(R.color.font));
        myself.setTextColor(getResources().getColor(R.color.font));

        home.setCompoundDrawables(null, drawableHome, null, null);
        present.setCompoundDrawables(null, drawablePresent, null, null);
        text.setCompoundDrawables(null, drawableText, null, null);
        myself.setCompoundDrawables(null, drawableMyself, null, null);

        if (isView){
            switch (position) {
                case R.id.home:
                    viewPager.setCurrentItem(0, false);
                    home.setCompoundDrawables(null, drawableHomeed, null, null);
                    home.setTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                case R.id.present:
                    viewPager.setCurrentItem(1, false);
                    present.setCompoundDrawables(null, drawablePresented, null, null);
                    present.setTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                case R.id.text:
                    viewPager.setCurrentItem(2, false);
                    text.setCompoundDrawables(null, drawableTexted, null, null);
                    text.setTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                case R.id.myself:
                    viewPager.setCurrentItem(3, false);
                    myself.setCompoundDrawables(null, drawableMyselfed, null, null);
                    myself.setTextColor(getResources().getColor(R.color.colorAccent));
                    break;
            }
        }else {
            switch (position) {
                case 0:
                    viewPager.setCurrentItem(0, false);
                    home.setCompoundDrawables(null, drawableHomeed, null, null);
                    home.setTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                case 1:
                    viewPager.setCurrentItem(1, false);
                    present.setCompoundDrawables(null, drawablePresented, null, null);
                    present.setTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                case 2:
                    viewPager.setCurrentItem(2, false);
                    text.setCompoundDrawables(null, drawableTexted, null, null);
                    text.setTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                case 3:
                    viewPager.setCurrentItem(3, false);
                    myself.setCompoundDrawables(null, drawableMyselfed, null, null);
                    myself.setTextColor(getResources().getColor(R.color.colorAccent));
                    break;
            }
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
