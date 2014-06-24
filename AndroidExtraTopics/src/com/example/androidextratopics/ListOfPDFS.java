package com.example.androidextratopics;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class ListOfPDFS extends Activity {
	ListView listView;
	String[] pdflist;
    File[] imagelist;
	ArrayList<String> arrayList = new ArrayList<String>();
	ArrayList<Drawable>arrayList2 = new ArrayList<Drawable>(); 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		listView = (ListView)findViewById(R.id.list);
		
		 File images = Environment.getExternalStorageDirectory();
	        imagelist = images.listFiles(new FilenameFilter() {
	            public boolean accept(File dir, String name) {
	                return ((name.endsWith(".pdf")));
	            }
	        });
	        Log.e("TAG NUMBER OF PDFS", imagelist.length+">>>");
	        
	        pdflist = new String[imagelist.length];
	        for (int i = 0; i < imagelist.length; i++) {
	            pdflist[i] = imagelist[i].getName();
	        }
		listView.setAdapter(new CustomAdapter());
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				final Intent intent = new Intent(ListOfPDFS.this, PdfViewerClass.class);
				Log.e("FILE PATH NAME", Environment.getExternalStorageDirectory()+"/"+pdflist[arg2]);
	            intent.putExtra(PdfViewerClass.EXTRA_PDFFILENAME, Environment.getExternalStorageDirectory()+"/"+pdflist[arg2]);
	            startActivity(intent);
			}
		});
	}
	
	
	class CustomAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return pdflist.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
			View rowview = layoutInflater.inflate(R.layout.layout_inflate, null);
			TextView textView = (TextView)rowview.findViewById(R.id.textView1);
			//ImageView imageView = (ImageView)rowview.findViewById(R.id.imageView1);
			textView.setText(pdflist[position]);
			//imageView.setBackgroundDrawable(arrayList2.get(position));
			return rowview;
		}
		
		
		
		
		
	}
	
	
	
}

