package com.zodiac.zishulovelife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zodiac.zishulovelife.adapter.Fragment_Left_Adapter;
import com.zodiac.zishulovelife.tools.MyLog;
import com.zodiac.zishulovelife.zishulovelife.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iwatch on 2015/11/29.
 */
public class Fragment_Left_Dynamic extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager fragment_feed_left_viewpagerId;

    private TextView fragment_feed_left_tv_attention;
    private TextView fragment_feed_left_tv_hot;
    private TextView fragment_feed_left_tv_nearby;

    private List<Fragment> fragmentList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed_left,null);

        fragment_feed_left_viewpagerId = (ViewPager) view.findViewById(R.id.fragment_feed_left_viewpagerId);


        fragment_feed_left_tv_attention = (TextView) view.findViewById(R.id.fragment_feed_left_tv_attention);
        fragment_feed_left_tv_hot = (TextView) view.findViewById(R.id.fragment_feed_left_tv_hot);
        fragment_feed_left_tv_nearby = (TextView) view.findViewById(R.id.fragment_feed_left_tv_nearby);

        fragment_feed_left_tv_attention.setOnClickListener(this);
        fragment_feed_left_tv_hot.setOnClickListener(this);
        fragment_feed_left_tv_nearby.setOnClickListener(this);

        //设置热门为默认选中状态
        fragment_feed_left_tv_hot.setClickable(true);
        fragment_feed_left_tv_hot.setTextColor(getResources().getColor(R.color.color01));



        initFragment();



        return view;
    }

    private void initFragment() {
        fragmentList = new ArrayList<Fragment>();

        Fragment_Left_NearBy fragment_left_nearBy = new Fragment_Left_NearBy();
        Fragment_Left_Attention fragment_left_attention = new Fragment_Left_Attention();
        Fragment_Left_Hot fragment_left_hot = new Fragment_Left_Hot();

        fragmentList.add(fragment_left_attention);
        fragmentList.add(fragment_left_hot);
        fragmentList.add(fragment_left_nearBy);

        Fragment_Left_Adapter fragment_left_adapter = new Fragment_Left_Adapter(getFragmentManager(), fragmentList);

        fragment_feed_left_viewpagerId.setAdapter(fragment_left_adapter);
        fragment_feed_left_viewpagerId.setCurrentItem(1);

        fragment_feed_left_viewpagerId.setOnPageChangeListener(this);



    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        MyLog.log(getClass(), "viewpager滑动到了第" + position + "个位置");
        //设置默认显示
        fragment_feed_left_tv_hot.setTextColor(getResources().getColor(R.color.color01));

        if(position == 0) {
            fragment_feed_left_tv_attention.setTextColor(getResources().getColor(R.color.color01));
            fragment_feed_left_tv_hot.setTextColor(getResources().getColor(R.color.color02));
            fragment_feed_left_tv_nearby.setTextColor(getResources().getColor(R.color.color02));

        } else if(position == 1) {
            fragment_feed_left_tv_attention.setTextColor(getResources().getColor(R.color.color02));
            fragment_feed_left_tv_hot.setTextColor(getResources().getColor(R.color.color01));
            fragment_feed_left_tv_nearby.setTextColor(getResources().getColor(R.color.color02));

        } else {
            fragment_feed_left_tv_attention.setTextColor(getResources().getColor(R.color.color02));
            fragment_feed_left_tv_hot.setTextColor(getResources().getColor(R.color.color02));
            fragment_feed_left_tv_nearby.setTextColor(getResources().getColor(R.color.color01));

        }




    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /**
     * 当点击 关注，热门， 附近 时，跳转到对应的fragment
     * @param v
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fragment_feed_left_tv_attention:
                fragment_feed_left_viewpagerId.setCurrentItem(0);
                break;

            case R.id.fragment_feed_left_tv_hot:
                fragment_feed_left_viewpagerId.setCurrentItem(1);
                break;

            case R.id.fragment_feed_left_tv_nearby:
                fragment_feed_left_viewpagerId.setCurrentItem(2);
                break;
        }

    }
}
