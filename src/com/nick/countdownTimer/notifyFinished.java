package com.nick.countdownTimer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;

public class notifyFinished extends Activity {
	
	/*public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Vibrator v = 
		vibrate(v);
	}*/
	
	Vibrator v;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		v.vibrate(200);
	}

}
