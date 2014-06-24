package com.example.androidextratopics;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class GetListOfInstalledApps extends Activity {
	ListView listView;
	ArrayList<String> arrayList = new ArrayList<String>();
	ArrayList<Drawable>arrayList2 = new ArrayList<Drawable>(); 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		listView = (ListView)findViewById(R.id.list);
		final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		final List pkgAppsList = getPackages();
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,android.R.id.text1,arrayList);
		listView.setAdapter(new CustomAdapter());
	}
	class PInfo {
	    private String appname = "";
	    private String pname = "";
	    private String versionName = "";
	    private int versionCode = 0;
	    private Drawable icon;
	    private void prettyPrint() {
	        Log.e("TAG",appname + "\t" + pname + "\t" + versionName + "\t" + versionCode);
	    }
	}
	private ArrayList<PInfo> getPackages() {
	    ArrayList<PInfo> apps = getInstalledApps(false); /* false = no system packages */
	    final int max = apps.size();
	    for (int i=0; i<max; i++) {
	        apps.get(i).prettyPrint();
	    }
	    return apps;
	}

	private ArrayList<PInfo> getInstalledApps(boolean getSysPackages) {
	    ArrayList<PInfo> res = new ArrayList<PInfo>();        
	    List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
	    for(int i=0;i<packs.size();i++) {
	        PackageInfo p = packs.get(i);
	        if ((!getSysPackages) && (p.versionName == null)) {
	            continue ;
	        }
	        PInfo newInfo = new PInfo();
	        newInfo.appname = p.applicationInfo.loadLabel(getPackageManager()).toString();
	        newInfo.pname = p.packageName;
	        newInfo.versionName = p.versionName;
	        newInfo.versionCode = p.versionCode;
	        newInfo.icon = p.applicationInfo.loadIcon(getPackageManager());
	        arrayList.add( newInfo.appname);
	        arrayList2.add(newInfo.icon);
	        res.add(newInfo);
	    }
	    return res; 
	}
	
	
	class CustomAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrayList.size();
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
			ImageView imageView = (ImageView)rowview.findViewById(R.id.imageView1);
			textView.setText(arrayList.get(position));
			imageView.setBackgroundDrawable(arrayList2.get(position));
			return rowview;
		}
		
		
		
		
		
	}
	
	
	
}
