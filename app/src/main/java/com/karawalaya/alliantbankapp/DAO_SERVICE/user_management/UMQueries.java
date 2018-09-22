package com.karawalaya.alliantbankapp.DAO_SERVICE.user_management;

public class UMQueries {
    public static final String UM_TABLE01 = "onlineUser";
    public static final String UM_TABLE01_COL01 = "userId";
    public static final String UM_TABLE01_COL02 = "userName";
    public static final String UM_TABLE01_COL03 = "userEmail";
    public static final String UM_TABLE01_COL04 = "userPassword";

    public static final String UM_Query_TABLE01_CREATE = "CREATE TABLE " + UM_TABLE01 + "(" + UM_TABLE01_COL01 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + UM_TABLE01_COL02 +
            " TEXT, " + UM_TABLE01_COL03 + " TEXT, " + UM_TABLE01_COL04 + " TEXT );";
    public static final String UM_Query_TABLE01_DROP = "DROP TABLE IF EXISTS " + UM_TABLE01 + ";";
    public static final String UM_Query_TABLE01_INSERT = "INSERT INTO " + UM_TABLE01 + "(" + UM_TABLE01_COL02 + ", " + UM_TABLE01_COL03 + ", " + UM_TABLE01_COL04 + ") VALUES (?, ?, ?);";
    public static final String UM_Query_TABLE01_SELECT_ALL = "SELECT * FROM " + UM_TABLE01 + ";";
}