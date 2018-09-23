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
import android.widget.TextView;

import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Customer;
import com.karawalaya.alliantbankapp.R;

public class HomePage extends Fragment {
    private static final String CUST_VAR = "customer";

    private Customer customer = null;

    private TextView textView;

    public static HomePage newInstance(Customer cust) {
        HomePage homepageFrag = new HomePage();
        Bundle homepageBundle = new Bundle();
        homepageBundle.putSerializable(CUST_VAR, cust);
        homepageFrag.setArguments(homepageBundle);

        return homepageFrag;
    }

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
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        textView = view.findViewById(R.id.textView);

        if(getArguments() != null) {
            customer = (Customer) getArguments().getSerializable(CUST_VAR);
        }

        textView.setText(customer.getOnlineUser().getUserName());
        return view;
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
