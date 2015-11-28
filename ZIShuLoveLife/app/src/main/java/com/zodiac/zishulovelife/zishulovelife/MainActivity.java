package com.zodiac.zishulovelife.zishulovelife;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.zodiac.zishulovelife.fragment.FragmentEvent;
import com.zodiac.zishulovelife.fragment.FragmentFeed;
import com.zodiac.zishulovelife.fragment.FragmentFound;
import com.zodiac.zishulovelife.fragment.FragmentMine;
import com.zodiac.zishulovelife.fragment.FragmentNotifyCation;

public class MainActivity extends FragmentActivity {
    private ImageView iv_main_btn_tab_feed;
    private ImageView iv_main_btn_tab_found;
    private ImageView iv_main_btn_tab_event;
    private ImageView iv_main_btn_tab_notifycation;
    private ImageView iv_main_btn_tab_mine;

    private android.support.v4.app.FragmentManager mFragmentManager;
    private Fragment mCurrentFragment;

    private FragmentFeed fragmentFeed;
    private FragmentFound fragmentFound;
    private FragmentEvent fragmentEvent;
    private FragmentNotifyCation fragmentNotifyCation;
    private FragmentMine fragmentMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_main_btn_tab_feed = (ImageView) findViewById(R.id.main_btn_tab_feed);
        iv_main_btn_tab_found = (ImageView) findViewById(R.id.main_btn_tab_found);
        iv_main_btn_tab_event = (ImageView) findViewById(R.id.main_btn_tab_event);
//        iv_main_btn_tab_notifycation = (ImageView) findViewById(R.id.main_btn_tab_notifycation);
        iv_main_btn_tab_mine = (ImageView) findViewById(R.id.main_btn_tab_mine);

        mFragmentManager = getSupportFragmentManager();

        //初始化选中ImageView
        initSelectorIv();

        //初始化Fragment
        initFragment();


    }

    private void initFragment() {
        fragmentFeed = new FragmentFeed();
        fragmentFound = new FragmentFound();
        fragmentEvent = new FragmentEvent();
        fragmentNotifyCation = new FragmentNotifyCation();
        fragmentMine = new FragmentMine();
        showFragment(fragmentFeed);

    }

    private void initSelectorIv() {
        iv_main_btn_tab_feed.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_feed_selected));
        iv_main_btn_tab_found.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_found));
        iv_main_btn_tab_event.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_event));
//        iv_main_btn_tab_notifycation.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_notifycation));
        iv_main_btn_tab_mine.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_mine));

    }

    public void click(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.main_btn_tab_feed:
                showFragment(fragmentFeed);

                if (!iv_main_btn_tab_feed.isClickable()) {
                    iv_main_btn_tab_feed.setClickable(false);
                } else {
                    iv_main_btn_tab_feed.setClickable(true);

                }

                iv_main_btn_tab_feed.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_feed_selected));
                iv_main_btn_tab_found.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_found));
                iv_main_btn_tab_event.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_event));
//                iv_main_btn_tab_notifycation.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_notifycation));
                iv_main_btn_tab_mine.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_mine));

                break;

            case R.id.main_btn_tab_found:
                showFragment(fragmentFound);
                iv_main_btn_tab_feed.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_feed));
                iv_main_btn_tab_found.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_found_selected));
                iv_main_btn_tab_event.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_event));
//                iv_main_btn_tab_notifycation.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_notifycation));
                iv_main_btn_tab_mine.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_mine));
                break;

            case R.id.main_btn_tab_event:
                showFragment(fragmentEvent);
                iv_main_btn_tab_feed.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_feed));
                iv_main_btn_tab_found.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_found));
                iv_main_btn_tab_event.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_event_selected));
//                iv_main_btn_tab_notifycation.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_notifycation));
                iv_main_btn_tab_mine.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_mine));
                break;


//            case R.id.main_btn_tab_notifycation:
//                showFragment(fragmentNotifyCation);
//                iv_main_btn_tab_feed.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_feed));
//                iv_main_btn_tab_found.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_found));
//                iv_main_btn_tab_event.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_event));
//                iv_main_btn_tab_notifycation.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_notifycation_selected));
//                iv_main_btn_tab_mine.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_mine));
//                break;

            case R.id.main_btn_tab_mine:
                showFragment(fragmentMine);
                iv_main_btn_tab_feed.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_feed));
                iv_main_btn_tab_found.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_found));
                iv_main_btn_tab_event.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_event));
//                iv_main_btn_tab_notifycation.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_notifycation));
                iv_main_btn_tab_mine.setImageDrawable(getResources().getDrawable(R.drawable.btn_tab_mine_selected));
                break;

        }
    }

    private void showFragment(Fragment fragment) {
        if (fragment == null) {
            /*Log.e("demo", "fragment is null");*/
            return;
        }
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        //		fragmentTransaction.remove(fragment);
        if (fragment.isAdded()) {

            fragmentTransaction.show(fragment);

        } else {

            fragmentTransaction.add(R.id.main_tabsconten, fragment);

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


}

