package com.example.myfirsttext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyTextDB extends SQLiteOpenHelper{

	public static final String CREATE_THEME_LIST = "create table ThemeList (" + "id integer primary key autoincrement, "
	                                                          + "themeList text, "
			                                                  + "date integer )";
	public static final String CREATE_CONTENT = "create table Content (" + "id integer primary key autoincrement,"
			                                                           + "theme text, "
			                                                           + "content text,"
			                                                           + "media path)";
	public MyTextDB(Context context,String name,CursorFactory factory,int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_THEME_LIST);
		db.execSQL(CREATE_CONTENT);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
}
