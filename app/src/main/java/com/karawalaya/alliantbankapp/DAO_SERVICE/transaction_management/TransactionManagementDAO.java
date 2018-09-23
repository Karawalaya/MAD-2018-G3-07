package com.karawalaya.alliantbankapp.DAO_SERVICE.transaction_management;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.karawalaya.alliantbankapp.DAO_SERVICE.DBHelper;
import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Account;
import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Customer;

public class TransactionManagementDAO {
    private DBHelper dbhelper;

    public TransactionManagementDAO(Context context) {
        this.dbhelper = new DBHelper(context);
    }

    public Customer getAccountDetails(Customer customer) {
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        String[] selectionArgs = {customer.getCustomerId()};

        Cursor cursor = sqLiteDatabase.rawQuery(TMQueries.TM_Query_TABLE02_SELECT_SPECIFIC, selectionArgs);

        Account account = null;
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            account = new Account(cursor.getString(0), cursor.getInt(1), cursor.getString(2), cursor.getDouble(3));
            customer.setAccount(account);
        } else {
            customer.setAccount(null);
        }
        return customer;
    }


}
