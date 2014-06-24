package com.example.androidextratopics;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebView_html extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);
		WebView webView = (WebView)findViewById(R.id.webview);
		String summary = "<html><body>You scored <b>192</b> points.</body></html>";
		// " \"ROM\" "
		String summ = "<a href=\"http://melstephenson.isagenix.com\" target=\"_blank\"><img src=\"http://www.isagenix.com/us/en/file.ashx?id=0fb6969e-afaf-4cd6-8ba5-34d9d61c3973\"></a>";
		String newp = "<html><head><title> My Page</title></head><img src=\"http://www.isagenix.com/us/en/file.ashx?id=0fb6969e-afaf-4cd6-8ba5-34d9d61c3973\"><body bgcolor=\"green\" background=\"./test.jpg\">This is my first page </body></html>";
		String nn = "<a href='http://my.futureworktechnologies.com/mike/admin/ads/add' target='_blank'><img src=http://my.futureworktechnologies.com/mike/files/ad_image/140618122843FunXone-Innocent-and-Naughty-Baby-Pictures-10.jpg></a>";
		webView.loadData(nn, "text/html", null);
	}

}
