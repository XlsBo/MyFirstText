package com.example.myfirsttext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MyTextDBHelper extends SQLiteOpenHelper{

	public static final String CREATE_THEME_LIST = "create table MyThemeList(" + "id integer primary key autoincrement," + "themeList text," + "date integer )";
	
	public MyTextDBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_THEME_LIST);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists MyThemeList");
		onCreate(db);
		
	}
}
