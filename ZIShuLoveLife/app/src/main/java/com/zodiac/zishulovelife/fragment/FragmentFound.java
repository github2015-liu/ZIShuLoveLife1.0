package com.zodiac.zishulovelife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zodiac.zishulovelife.zishulovelife.R;


/**
 * Created by iwatch on 2015/11/28.
 */
public class FragmentFound extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_found, null);
        return view;
    }
}
