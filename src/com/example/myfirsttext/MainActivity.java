package com.example.myfirsttext;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener ,OnItemClickListener{

	private Button create;
	
	private ListView listView;
	
	private MyTextDB myTextDB;
	
	private List<String> themeList ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		create = (Button) findViewById(R.id.create_item);
		listView = (ListView) findViewById(R.id.list_view);
		myTextDB =new MyTextDB(this,"ThemeStore.db",null,1);
		create.setOnClickListener(this);
		//给主题列表添加适配器,未完成 
		themeList = new ArrayList<String>(); 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,themeList);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}
	
	@Override
	public void onClick(View v) {

		Intent intent = new Intent(MainActivity.this,EditContent.class);
		startActivityForResult(intent,1);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent,View view,int position, long id ) {
		
	}
	
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data) {
		switch(requestCode) {
		case 1:
			if(resultCode == RESULT_OK) {
				String returnTheme = data.getStringExtra("theme");
				themeList.add(returnTheme);
				SQLiteDatabase db = myTextDB.getReadableDatabase();
				ContentValues values = new ContentValues();
				values.put("themeList", returnTheme);
			}
			break;
		default:
			break;
		}
	}
}
