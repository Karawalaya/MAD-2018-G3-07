package com.karawalaya.alliantbankapp.DAO_SERVICE;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.karawalaya.alliantbankapp.DAO_SERVICE.transaction_management.TMQueries;
import com.karawalaya.alliantbankapp.DAO_SERVICE.user_management.UMQueries;
import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Account;
import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Customer;
import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Populate;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author Samarasekara S.A.M.I.D.
 */
public class DBHelper extends SQLiteOpenHelper{
//    public static CommonDBHelper instance = null;

    public static final String DATABASE_NAME = "mad_2018_g3_07.db";
    public static final int DATABASE_VERSION = 1;

/*    public static CommonDBHelper getInstance(Context context) {
        if(instance == null) {
            instance = new CommonDBHelper(context.getApplicationContext());
        }
        return instance;
    }*/

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        initDB(sqLiteDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TMQueries.TM_Query_TABLE01_CREATE);
        sqLiteDatabase.execSQL(TMQueries.TM_Query_TABLE02_CREATE);
        sqLiteDatabase.execSQL(UMQueries.UM_Query_TABLE01_CREATE);
/*        if(this.initDB(sqLiteDatabase))
            System.out.println("DB Initialized");
        else
            System.out.println("DB Not Initialized");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(UMQueries.UM_Query_TABLE01_DROP);
        sqLiteDatabase.execSQL(TMQueries.TM_Query_TABLE02_DROP);
        sqLiteDatabase.execSQL(UMQueries.UM_Query_TABLE01_DROP);
        onCreate(sqLiteDatabase);
    }

    public boolean initDB(SQLiteDatabase sqLiteDatabase) {
        Cursor res = sqLiteDatabase.rawQuery(TMQueries.TM_Query_TABLE01_SELECT_ALL, null);
        if(res.getCount() == 0) {
            Collection<Populate> populateList = new ArrayList<Populate>();

            Populate pop01 = new Populate();
            pop01.setCustomer(new Customer("CUST000001", "Isuru", "Qwerty", 22, "Male", "12/2 Abcdefg Road", "Hijklmn", "Western", 10001, "0771234567", "isuruqwerty@gmail.com"));
            pop01.setAccount(new Account("CUST000001", 123456789, 100000.23));
            populateList.add(pop01);

            Populate pop02 = new Populate();
            pop02.setCustomer(new Customer("CUST000002", "Keshi", "Uiop", 22, "Female", "16/6 Nopqrst Road", "uvwxyza", "Western", 10002, "0774567891", "keshiuiop@gmail.com"));
            pop02.setAccount(new Account("CUST000002", 456789123, 200045.48));
            populateList.add(pop02);

            for(Populate pop: populateList) {
                SQLiteStatement st01 = null;
                st01 = sqLiteDatabase.compileStatement(TMQueries.TM_Query_TABLE01_INSERT);
                st01.bindString(1, pop.getCustomer().getCustomerId());
                st01.bindString(2, pop.getCustomer().getFirstName());
                st01.bindString(3, pop.getCustomer().getLastName());
                st01.bindLong(4, pop.getCustomer().getAge());
                st01.bindString(5, pop.getCustomer().getGender());
                st01.bindString(6, pop.getCustomer().getAddressStreet());
                st01.bindString(7, pop.getCustomer().getAddressCity());
                st01.bindString(8, pop.getCustomer().getAddressProvince());
                st01.bindLong(9, pop.getCustomer().getAddressZip());
                st01.bindString(10, pop.getCustomer().getContactNumber());
                st01.bindString(11, pop.getCustomer().getEmail());

                long rowId01 = st01.executeInsert();

                if (rowId01 == -1)
                    return false;
                else {
                    SQLiteStatement st02 = null;
                    st02 = sqLiteDatabase.compileStatement(TMQueries.TM_Query_TABLE02_INSERT);
                    st02.bindString(1, pop.getAccount().getCustomerId());
                    st02.bindLong(2, pop.getAccount().getAccountNo());
                    st02.bindDouble(3, pop.getAccount().getBalance());

                    long rowId02 = st02.executeInsert();

                    if (rowId02 == -1)
                        return false;
                }
            }
        } else {
            return false;
        }
        return false;
    }

/*    public void addUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UMQueries.UM_TABLE01_COL02, user.getName());
        values.put(UMQueries.UM_TABLE01_COL03, user.getEmail());
        values.put(UMQueries.UM_TABLE01_COL04, user.getPassword());

        sqLiteDatabase.insert(UMQueries.UM_TABLE01, null, values);
        sqLiteDatabase.close();
    }

    public boolean checkUser(String email) {
        String[] columns = {
                UMQueries.UM_TABLE01_COL01
        };
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
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
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String selection = UMQueries.UM_TABLE01_COL03 + "=? AND " + UMQueries.UM_TABLE01_COL04 + "=?";
        String[] selectionArgs = {email, password};

        Cursor cursor = sqLiteDatabase.query(UMQueries.UM_TABLE01, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();

        if(cursorCount > 0)
            return true;
        return false;
    }*/
}
