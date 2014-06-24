package com.example.androidextratopics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WriteTextFile extends Activity {
	Button button,button2;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write_textfile);
		button = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		textView = (TextView)findViewById(R.id.textView1);
				
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				writeTextFile(textView.getText().toString());
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				readTextFile();
			}
		});
				
	}
public void writeTextFile(String data)
{
	try {
	File myFile = new File("/sdcard/mysdfile.txt");
	myFile.createNewFile();
	FileOutputStream fOut = new FileOutputStream(myFile);
	OutputStreamWriter myOutWriter = 
							new OutputStreamWriter(fOut);
	myOutWriter.append(data);
	myOutWriter.close();
	fOut.close();
	Toast.makeText(getBaseContext(),
			"Done writing SD 'mysdfile.txt'",
			Toast.LENGTH_SHORT).show();
} catch (Exception e) {
	Toast.makeText(getBaseContext(), e.getMessage(),
			Toast.LENGTH_SHORT).show();
}
}

public void readTextFile()
{
	try {
		File myFile = new File("/sdcard/mysdfile.txt");
		FileInputStream fIn = new FileInputStream(myFile);
		BufferedReader myReader = new BufferedReader(
				new InputStreamReader(fIn));
		String aDataRow = "";
		String aBuffer = "";
		while ((aDataRow = myReader.readLine()) != null) {
			aBuffer += aDataRow + "\n";
		}
		Toast.makeText(getBaseContext(),
				aBuffer,
				Toast.LENGTH_SHORT).show();
		myReader.close();
		Toast.makeText(getBaseContext(),
				"Done reading SD 'mysdfile.txt'",
				Toast.LENGTH_SHORT).show();
	} catch (Exception e) {
		Toast.makeText(getBaseContext(), e.getMessage(),
				Toast.LENGTH_SHORT).show();
	}
}
}
