/*
package com.karawalaya.alliantbankapp.DAO_SERVICE.user_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.karawalaya.alliantbankapp.DAO_SERVICE.CommonDBHelper;
import com.karawalaya.alliantbankapp.POJO_MODEL.user_management.User;

public class UserManagementDAO {
    private CommonDBHelper commonDBHelper = null;

    public UserManagementDAO(Context context) {
        this.commonDBHelper = new CommonDBHelper(context);
    }

    public void addUSer(User user) {
        SQLiteDatabase sqLiteDatabase = commonDBHelper.open();

        ContentValues values = new ContentValues();
        values.put(UMQueries.UM_TABLE01_COL02, user.getName());
        values.put(UMQueries.UM_TABLE01_COL03, user.getEmail());
        values.put(UMQueries.UM_TABLE01_COL04, user.getPassword());

        sqLiteDatabase.insert(UMQueries.UM_TABLE01, null, values);
        commonDBHelper.close();
    }

    public boolean checkUSer(String email) {
        String[] columns = {
                UMQueries.UM_TABLE01_COL01
        };
        SQLiteDatabase sqLiteDatabase = commonDBHelper.open();
        String selection = UMQueries.UM_TABLE01_COL03 + "=?";
        String[] selectionArgs = {email};

        Cursor cursor = sqLiteDatabase.query(UMQueries.UM_TABLE01, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        commonDBHelper.close();

        if(cursorCount > 0)
            return true;
        return false;
    }

    public boolean checkUSser(String email, String password) {
        String[] columns = {
                UMQueries.UM_TABLE01_COL01
        };
        SQLiteDatabase sqLiteDatabase = commonDBHelper.open();
        String selection = UMQueries.UM_TABLE01_COL03 + "=? AND " + UMQueries.UM_TABLE01_COL04 + "=?";
        String[] selectionArgs = {email, password};

        Cursor cursor = sqLiteDatabase.query(UMQueries.UM_TABLE01, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        commonDBHelper.close();

        if(cursorCount > 0)
            return true;
        return false;
    }
}
*/
package com.karawalaya.alliantbankapp.DAO_SERVICE.user_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.karawalaya.alliantbankapp.DAO_SERVICE.DBHelper;
import com.karawalaya.alliantbankapp.DAO_SERVICE.transaction_management.TMQueries;
import com.karawalaya.alliantbankapp.POJO_MODEL.user_management.User;

public class UserManagementDAO {
    private DBHelper dbhelper;

    public UserManagementDAO(Context context) {
//        context.deleteDatabase("mad_2018_g3_07.db");
        this.dbhelper = new DBHelper(context);
    }

    public boolean seeWhetherPhysicallyRegistered(String email, String accNo) {
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        String[] selectionArgs = {email, accNo};
        Cursor cursor = sqLiteDatabase.rawQuery(TMQueries.TM_Query_UM_FIND, selectionArgs);

        if(cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                if(cursor.getString(10).equals(email) && cursor.getLong(12) == Integer.parseInt(accNo))
                    return true;
            }
        } else {
            return false;
        }
    return false;
    }

    public boolean addUser(User user) {
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        boolean bool;

        ContentValues values = new ContentValues();
        values.put(UMQueries.UM_TABLE01_COL02, user.getName());
        values.put(UMQueries.UM_TABLE01_COL03, user.getEmail());
        values.put(UMQueries.UM_TABLE01_COL04, user.getPassword());

        long result = sqLiteDatabase.insert(UMQueries.UM_TABLE01, null, values);

        if(result == -1)
            bool = false;
        else
            bool = true;

        sqLiteDatabase.close();
        return bool;
    }

    public boolean checkUser(String email) {
        String[] columns = {
                UMQueries.UM_TABLE01_COL01
        };
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        String selection = UMQueries.UM_TABLE01_COL03 + "=?";
        String[] selectionArgs = {email};

        Cursor cursor = sqLiteDatabase.query(UMQueries.UM_TABLE01, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();

        if(cursorCount > 0)
            return true;
        return false;
    }

    public boolean checkUser(String email, String password) {
        String[] columns = {
                UMQueries.UM_TABLE01_COL01
        };
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        String selection = UMQueries.UM_TABLE01_COL03 + "=? AND " + UMQueries.UM_TABLE01_COL04 + "=?";
        String[] selectionArgs = {email, password};

        Cursor cursor = sqLiteDatabase.query(UMQueries.UM_TABLE01, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();

        if(cursorCount > 0)
            return true;
        return false;
    }
}