package com.example.myfirsttext;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditContent extends Activity implements OnClickListener{

	private Button back;
	
	private Button save;
	
	private Button photo;
	
	private Button camera;
	
	private Button video;
	
	private Button voice;
	
	private EditText theme;
	
	private EditText content;
	
	private String itemTheme;
	
	private String theTheme;
	
	private String theContent;
	
	private int readTextRequest;
	
	private Intent readIntent;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.text_layout);
		back = (Button) findViewById(R.id.back);
		save = (Button) findViewById(R.id.save);
		photo = (Button) findViewById(R.id.photo);
		camera = (Button) findViewById(R.id.camera);
		video = (Button) findViewById(R.id.video);
		voice = (Button) findViewById(R.id.voice);
		theme = (EditText) findViewById(R.id.text_theme);
		content = (EditText) findViewById(R.id.text_content);
		back.setOnClickListener(this);
		save.setOnClickListener(this);
		photo.setOnClickListener(this);
		camera.setOnClickListener(this);
		video.setOnClickListener(this);
		voice.setOnClickListener(this);
		readIntent = getIntent();
		readTextRequest = readIntent.getIntExtra("textId",-1);
		/*String changeString = Integer.toString(readTextRequest);*/
		//Log.d("EditContent",readTextRequest);
		if(readTextRequest != -1) {
			theTheme = readIntent.getStringExtra("textTheme");
			Log.d("EditContent",theTheme);
			theContent = readIntent.getStringExtra("textContent");
			theme.setText(theTheme);
		}
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.save:
			String theme_data = theme.getText().toString();
			String text_content = content.getText().toString();
			Intent intent = new Intent();
			intent.putExtra("themeText", theme_data);
			intent.putExtra("contentText", text_content);
			setResult(RESULT_OK,intent);
			Toast.makeText(this, "save succeed", Toast.LENGTH_SHORT).show();
		}
		
	}
}
