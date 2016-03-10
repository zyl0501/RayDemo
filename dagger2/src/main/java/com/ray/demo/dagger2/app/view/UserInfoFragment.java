package com.ray.demo.dagger2.app.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ray.demo.dagger2.R;

/**
 * Created by Ray on 16/3/8.
 */
public class UserInfoFragment extends Fragment {
    TextView nameTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_info, container, false);
        nameTv = (TextView) view.findViewById(R.id.user_name);
        return view;
    }
}
