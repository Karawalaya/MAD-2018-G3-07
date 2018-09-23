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

import com.karawalaya.alliantbankapp.DAO_SERVICE.transaction_management.TransactionManagementDAO;
import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Customer;
import com.karawalaya.alliantbankapp.R;

public class TransactionHistory extends Fragment {
    //Bundle Arguments.
    private static final String CUST_VAR_TRANSACTION_HISTORY = "customer";

    //Special Holding Attributes.
    private Customer customer = null;
    private TransactionManagementDAO tmdao;

    //Views.
    private TextView Account_Balance_TV01;
    private TextView Account_Balance_TV02;
    private TextView Account_Balance_TV03;
    private TextView Account_Balance_TV04;

    /**
     * This was used to create a communication between the MainActivity and this fragment.
     */
    public static TransactionHistory getInstance(Customer cust) {
        TransactionHistory transactionHistoryFrag = new TransactionHistory();
        Bundle transactionHistoryBundle = new Bundle();
        transactionHistoryBundle.putSerializable(CUST_VAR_TRANSACTION_HISTORY, cust);
        transactionHistoryFrag.setArguments(transactionHistoryBundle);

        return transactionHistoryFrag;
    }

    @Override
    public void onAttach(Context context) {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onAttach ===========================");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onCreate ===========================");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onCreateView ===========================");

        View fragTransactionHistoryView = inflater.inflate(R.layout.fragment_transaction_history, container, false);

        initializeObjects();
        initializeViews(fragTransactionHistoryView);

        if(getArguments() != null) {
            customer = (Customer) getArguments().getSerializable(CUST_VAR_TRANSACTION_HISTORY);
            customer = tmdao.getAccountDetails(customer);

            if(customer.getAccount() != null) {
                Account_Balance_TV01.setText(customer.getFirstName() + " " + customer.getLastName());
//                Account_Balance_TV02.setText(customer.getOnlineUser().getUserName());
                Account_Balance_TV03.setText(customer.getAccount().getAccountType());
                Account_Balance_TV04.setText(Double.toString(customer.getAccount().getBalance()));
            } else {

            }
        }

        return fragTransactionHistoryView;
    }

    private void initializeObjects() {
        tmdao = new TransactionManagementDAO(getActivity());
    }

    private void initializeViews(View fragTransactionHistoryView) {
/*        Account_Balance_TV01 = fragHomepageView.findViewById(R.id.Account_Balance_TV01);
        Account_Balance_TV02 = fragHomepageView.findViewById(R.id.Account_Balance_TV02);
        Account_Balance_TV03 = fragHomepageView.findViewById(R.id.Account_Balance_TV03);
        Account_Balance_TV04 = fragHomepageView.findViewById(R.id.Account_Balance_TV04);*/
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onActivityCreated ===========================");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onStart ===========================");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onResume  ===========================");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onPause ===========================");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onStop ===========================");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onDestroyView ===========================");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onDestroy ===========================");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i("Kara", "FRAGMENT =========================== TransactionHistory =========================== onDetach ===========================");
        super.onDetach();
    }
}
