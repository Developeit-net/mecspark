package com.sasurie.mecspark;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class StudyMaterials extends Activity {
WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studymaterials);
		
		webView= (WebView) findViewById(R.id.wv);
	    webView.setWebViewClient(new WebViewClient());
	    
	    webView.getSettings().setAppCacheMaxSize
	    (
	     20
	     *
	     1024
	     *
	     1024
	     );
	    webView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
	    webView.getSettings().setAllowFileAccess(true);
	    webView.getSettings().setJavaScriptEnabled(true);
	    webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
	    if
	    (
	     !isNetworkAvailable()
	     )
	    {
	    webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
	    	
	    }webView.loadUrl("http://googleweblight.com/?lite_url=http://www.rejinpaul.com/2013/12/mechanical-2nd-4th-6th-8th-semester-notes-anna-university-mech-notes.html?m%3D1&ei=huD_haJ9&lc=en-IN&s=1&m=511&ts=1443077224&sig=APONPFmzAxVuB3vF3vlI2vTgO7llqriycQAutombile");
	    
	   
	}
	

	private boolean isNetworkAvailable() {
		// TODO Auto-generated method stub
		ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo=connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo!=null && activeNetworkInfo.isConnected();
	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(event.getAction()==KeyEvent.ACTION_DOWN){switch(keyCode){case KeyEvent.KEYCODE_BACK:
		if(webView.canGoBack()){webView.goBack();}else{finish();
		}return true;}}
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

    
	
	
}


