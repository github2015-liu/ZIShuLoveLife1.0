package com.zodiac.zishulovelife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zodiac.zishulovelife.tools.MyLog;
import com.zodiac.zishulovelife.zishulovelife.R;


/**
 * Created by iwatch on 2015/11/28.
 */
public class FragmentFeed extends Fragment implements View.OnClickListener {

    private TextView fragment_feed_title_tv_dynamic;
    private TextView fragment_feed_tv_yue;
    private TextView fragment_feed_title_tv_senddynamic;




    private android.support.v4.app.FragmentManager mFragmentManager;
    private Fragment mCurrentFragment;
    private Fragment_Left_Dynamic fragment_left_dynamic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyLog.log(getClass(),"您来到了首页");
        View view = inflater.inflate(R.layout.fragment_feed, null);



        //动态
        fragment_feed_title_tv_dynamic = (TextView) view.findViewById(R.id.fragment_feed_title_tv_dynamic);

        //约伴
        fragment_feed_tv_yue = (TextView) view.findViewById(R.id.fragment_feed_tv_yue);

        //发动态
        fragment_feed_title_tv_senddynamic = (TextView) view.findViewById(R.id.fragment_feed_title_tv_senddynamic);

        fragment_feed_title_tv_dynamic.setClickable(true);
        fragment_feed_title_tv_dynamic.setTextColor(getResources().getColor(R.color.color01));
        //初始化fragment
        initFragment();

        //显示当前选中fragment
        showFragment(fragment_left_dynamic);



        fragment_feed_title_tv_dynamic.setOnClickListener(this);



        return view;
    }


    private void initFragment() {
        mFragmentManager = getFragmentManager();
        fragment_left_dynamic = new Fragment_Left_Dynamic();

    }




    private void showFragment(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        //		fragmentTransaction.remove(fragment);
        if (fragment.isAdded()) {

            fragmentTransaction.show(fragment);

        } else {

            fragmentTransaction.add(R.id.fragment_feed_tabsconten, fragment);

        }
        if (mCurrentFragment != null) {

            // 解决ImageView 第二次点击时要传进来的fragment隐藏
            if (mCurrentFragment == fragment) {
                fragmentTransaction.commit();
                return;
            }

            fragmentTransaction.hide(mCurrentFragment);
        }

        fragmentTransaction.commit();
        mCurrentFragment = fragment;
    }


    @Override
    public void onClick(View v) {

        //当动态被点击时，设置为不可以点击
        if(fragment_feed_title_tv_dynamic.isClickable()) {
            fragment_feed_title_tv_dynamic.setClickable(false);
        } else {
            fragment_feed_title_tv_dynamic.setClickable(true);

        }

        fragment_feed_title_tv_dynamic.setTextColor(getResources().getColor(R.color.color01));
        //初始化Fragment

    }
}
