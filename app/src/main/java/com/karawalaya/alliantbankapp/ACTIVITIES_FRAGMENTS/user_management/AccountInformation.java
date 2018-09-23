package com.karawalaya.alliantbankapp.ACTIVITIES_FRAGMENTS.user_management;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karawalaya.alliantbankapp.R;

public class AccountInformation extends Fragment {

    @Override
    public void onAttach(Context context) {
        Log.i("Kara", "onAttach in AccountInformation");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("Kara", "onCreate in AccountInformation");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("Kara", "onCreateView in AccountInformation");
        return inflater.inflate(R.layout.fragment_account_information, container, false);

        /*View view = inflater.inflate(R.layout.fragment_account_information, container, false);
        TextView tv = view.findViewById(R.id.accountInfoTv);

        return view;*/
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("Kara", "onActivityCreated in AccountInformation");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("Kara", "onStart in AccountInformation");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("Kara", "onResume in AccountInformation");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("Kara", "onPause in AccountInformation");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("Kara", "onStop in AccountInformation");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i("Kara", "onDestroyView in AccountInformation");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("Kara", "onDestroy in AccountInformation");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i("Kara", "onDetach in AccountInformation");
        super.onDetach();
    }
}
