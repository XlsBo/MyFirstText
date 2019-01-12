package com.example.myfirsttext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MyTextDBHelper extends SQLiteOpenHelper{

	public static final String CREATE_THEME_LIST = "create table MyThemeItem(" + "id integer primary key autoincrement," + "themeList text," + "content text," + "number integer )";
	public static final String CREATE_CONTENT = "create table ThemeList(" + "id integer primary key autoincrement," + "themeList text," + "content text," + "date integer )";
	
	public MyTextDBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_THEME_LIST);
		db.execSQL(CREATE_CONTENT);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists MyThemeItem");
		db.execSQL("drop table if exists ThemeList");
		onCreate(db);
		
	}
}
