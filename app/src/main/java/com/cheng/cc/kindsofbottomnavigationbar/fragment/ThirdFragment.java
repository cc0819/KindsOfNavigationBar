package com.cheng.cc.kindsofbottomnavigationbar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cheng.cc.kindsofbottomnavigationbar.R;

/**
 * 引导页用的fragment抽象类
 * Created by Administrator on 2017/6/4.
 */
public class ThirdFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third,container,false);
    }

    @Override
    protected void lazyLoad() {

    }
}
