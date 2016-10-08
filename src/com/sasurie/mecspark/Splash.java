package com.sasurie.mecspark;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
    MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle TravisLoveBacon) {
		// TODO Auto-generated method stub
		super.onCreate(TravisLoveBacon);
		setContentView(R.layout.splash);
		ourSong= MediaPlayer.create(Splash.this, R.raw.splashsound);
		ourSong.start();
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(4400);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMechDashbboard =new Intent("com.sasurie.mecspark.MENU");
					startActivity(openMechDashbboard);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	

}
