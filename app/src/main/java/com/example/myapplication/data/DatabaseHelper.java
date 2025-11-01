package com.saboresdomundo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sabores_do_mundo.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_PRODUTOS = "produtos";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_CATEGORIA = "categoria";
    public static final String COLUMN_QUANTIDADE = "quantidade";
    public static final String COLUMN_UNIDADE = "unidade";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_PRODUTOS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NOME + " TEXT NOT NULL, "
                + COLUMN_CATEGORIA + " TEXT NOT NULL, "
                + COLUMN_QUANTIDADE + " INTEGER DEFAULT 0, "
                + COLUMN_UNIDADE + " TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUTOS);
        onCreate(db);
    }
}