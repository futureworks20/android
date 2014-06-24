package com.example.androidextratopics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CheckLock extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		Intent intent = new Intent(CheckLock.this,ApplockkService.class);
		CheckLock.this.startService(intent);
	}

}
