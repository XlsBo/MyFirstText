package com.example.myfirsttext;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class EditContent extends Activity implements OnClickListener{

	private Button back;
	
	private Button save;
	
	private Button photo;
	
	private Button camera;
	
	private Button video;
	
	private Button voice;
	
	private EditText theme;
	
	private EditText content;
	
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
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.save:
			String theme_data = theme.getText().toString();
			Intent intent = new Intent();
			intent.putExtra("theme", theme_data);
			setResult(RESULT_OK,intent);
			finish();
		}
		
	}
}
