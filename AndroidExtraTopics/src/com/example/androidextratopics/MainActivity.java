package com.example.androidextratopics;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button getlist_app,getpdf,write_textfile,btn_web,btn_seat,lock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getlist_app = (Button)findViewById(R.id.button1);
		getpdf = (Button)findViewById(R.id.button2);
		write_textfile = (Button)findViewById(R.id.button3 );
		btn_web = (Button)findViewById(R.id.button4);
		lock = (Button)findViewById(R.id.button6);
		lock.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(MainActivity.this,CheckLock.class);
				startActivity(it);
			}
		});
		btn_seat = (Button)findViewById(R.id.button5);

		btn_seat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,NewSeatSelection.class);
				startActivity(intent);
			}
		});
		btn_web.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,WebView_html.class);
				startActivity(intent);
			}
		});
		getlist_app.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,GetListOfInstalledApps.class);
				startActivity(intent);
			}
		});
		getpdf.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,ListOfPDFS.class);
				startActivity(intent);
			}
		});
		write_textfile.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,WriteTextFile.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
