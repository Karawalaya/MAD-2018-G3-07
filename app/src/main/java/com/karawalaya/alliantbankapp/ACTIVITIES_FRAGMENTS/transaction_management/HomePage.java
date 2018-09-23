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
    //Bundle Arguments.
    private static final String CUST_VAR_HOMEPAGE = "customer";

    //Special Holding Attributes.
    private Customer customer = null;

    //Views.
    private TextView textView;

    /**
     * This was used to create a communication between the MainActivity and this fragment.
     */
    public static HomePage getInstance(Customer cust) {
        HomePage homepageFrag = new HomePage();
        Bundle homepageBundle = new Bundle();
        homepageBundle.putSerializable(CUST_VAR_HOMEPAGE, cust);
        homepageFrag.setArguments(homepageBundle);

        return homepageFrag;
    }

    @Override
    public void onAttach(Context context) {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onAttach ===========================");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onCreate ===========================");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onCreateView ===========================");
        View fragHomepageView = inflater.inflate(R.layout.fragment_home_page, container, false);

        initializeViews(fragHomepageView);

        if(getArguments() != null) {
            customer = (Customer) getArguments().getSerializable(CUST_VAR_HOMEPAGE);
        }

        textView.setText(customer.getOnlineUser().getUserName());
        return fragHomepageView;
    }

    /**
     * This was used to initialize the views.
     */
    public void initializeViews(View fragHomepageView) {
        textView = fragHomepageView.findViewById(R.id.textView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onActivityCreated ===========================");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onStart ===========================");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onResume  ===========================");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onPause ===========================");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onStop ===========================");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onDestroyView ===========================");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onDestroy ===========================");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i("Kara", "FRAGMENT =========================== HomePage =========================== onDetach ===========================");
        super.onDetach();
    }
}
