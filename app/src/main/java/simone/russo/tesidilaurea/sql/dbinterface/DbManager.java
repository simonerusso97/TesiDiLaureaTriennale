package simone.russo.tesidilaurea.sql.dbinterface;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbManager {

    DatabaseHelper helper = null;
    private final static String DATABASE = "asset";
    private final static int VERSIONE_DATABASE = 1;

    public DbManager(Context context) {

        helper = new DatabaseHelper(context, DATABASE,
                null, VERSIONE_DATABASE);
    }
}