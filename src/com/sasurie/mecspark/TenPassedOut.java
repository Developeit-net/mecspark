package com.sasurie.mecspark;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class TenPassedOut extends Activity {
WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten);
		
		webView= (WebView) findViewById(R.id.ten1);
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
	    	
	    }webView.loadUrl("http://goo.gl/forms/J3bbf6Ro1X");
	    
	   
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


