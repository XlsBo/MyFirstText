package com.example.myfirsttext;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
	
	private MyTextDBHelper myTextDB;
	
	private List<String> textThemeList ;
	
	private ArrayAdapter<String> adapter;
	
	private SQLiteDatabase textDB;
	
	private String returnContent;
	
	private String returnTheme;
	
	private String itemTheme;
	
	private int itemId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		create = (Button) findViewById(R.id.create_item);
		listView = (ListView) findViewById(R.id.list_view);
		myTextDB = new MyTextDBHelper(this,"newThemeStore.db",null,4);
		create.setOnClickListener(this);
		textThemeList = new ArrayList<String>(); 
		adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,textThemeList);
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
		Intent readEditContent = new Intent(MainActivity.this,EditContent.class);
		Cursor cursor = textDB.query("MyThemeList",null,null,null,null,null,null);
		cursor.moveToPosition(position);
		itemId = cursor.getInt(cursor.getColumnIndex("id"));
		itemTheme = cursor.getString(cursor.getColumnIndex("themeList"));
		/*String changeString = Integer.toString(itemId);
		Log.d("MainActivity",changeString);
		Log.d("MainActivity",itemTheme);*/
		readEditContent.putExtra("textId", itemId);
		readEditContent.putExtra("textTheme", itemTheme);
		startActivity(readEditContent);
	}
	
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data) {
		switch(requestCode) {
		case 1:
			if(resultCode == RESULT_OK) {
				returnTheme = data.getStringExtra("themeText");
				returnContent = data.getStringExtra("contentText");
				textThemeList.add(returnTheme);
				adapter.notifyDataSetChanged();
				textDB = myTextDB.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("themeList", returnTheme);
				//values.put("content",returnContent);
				textDB.insert("MyThemeList", null, values);
			}
			break;
		default:
			break;
		}
	}
}
