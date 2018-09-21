package com.karawalaya.alliantbankapp.ACTIVITIES_FRAGMENTS;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karawalaya.alliantbankapp.R;

public class AccountInformation extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account_information, container, false);

        /*View view = inflater.inflate(R.layout.fragment_account_information, container, false);
        TextView tv = view.findViewById(R.id.accountInfoTv);

        return view;*/
    }
}
