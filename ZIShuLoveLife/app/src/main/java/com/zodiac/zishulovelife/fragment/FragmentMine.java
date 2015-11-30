package com.zodiac.zishulovelife.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zodiac.zishulovelife.zishulovelife.LoginActivity;
import com.zodiac.zishulovelife.zishulovelife.R;


/**
 * Created by iwatch on 2015/11/28.
 */
public class FragmentMine extends Fragment implements View.OnClickListener {


    private ImageView fragment_mine_profile_image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);

        fragment_mine_profile_image = (ImageView) view.findViewById(R.id.fragment_mine_profile_image);

        fragment_mine_profile_image.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);

    }
}
