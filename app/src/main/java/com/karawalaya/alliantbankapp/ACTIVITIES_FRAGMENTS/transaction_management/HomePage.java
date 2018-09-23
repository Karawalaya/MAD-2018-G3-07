package com.karawalaya.alliantbankapp.ACTIVITIES_FRAGMENTS.transaction_management;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karawalaya.alliantbankapp.R;

public class HomePage extends Fragment {

    @Override
    public void onAttach(Context context) {
        Log.i("Kara", "onAttach in HomePage");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("Kara", "onCreate in HomePage");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("Kara", "onCreateView in HomePage");
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("Kara", "onActivityCreated in HomePage");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("Kara", "onStart in HomePage");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("Kara", "onResume in HomePage");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("Kara", "onPause in HomePage");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("Kara", "onStop in HomePage");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i("Kara", "onDestroyView in HomePage");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("Kara", "onDestroy in HomePage");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i("Kara", "onDetach in HomePage");
        super.onDetach();
    }
}
