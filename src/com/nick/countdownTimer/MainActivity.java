package com.nick.countdownTimer;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends Activity {
	
	private int hours;
	private int minutes;
	private int seconds;
	
	private NumberPicker hoursPicker;
	private NumberPicker minutesPicker;
	private NumberPicker secondsPicker;
	
	public static NotificationManager mNotificationManager;
	public static int HELLO_ID = 1;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
          
      hoursPicker = (NumberPicker) findViewById(R.id.hoursPicker);
      minutesPicker = (NumberPicker) findViewById(R.id.minutesPicker);
	  secondsPicker = (NumberPicker) findViewById(R.id.secondsPicker);
	  Button startButton = (Button) findViewById(R.id.startButton);
	  
	  hoursPicker.setMinValue(0);
	  hoursPicker.setMaxValue(23);
	  hoursPicker.setFocusableInTouchMode(true);
	  minutesPicker.setMinValue(00);
	  minutesPicker.setMaxValue(59);
	  secondsPicker.setMinValue(00);
	  secondsPicker.setMaxValue(59);
	  
      startButton.setOnClickListener(new View.OnClickListener() {
    
    	  public void onClick(View v) {
    		  
    		  hours = hoursPicker.getValue();
			  minutes = minutesPicker.getValue();	
			  seconds = secondsPicker.getValue();
    		  
    		  if(!(hours == 0 && minutes == 0 && seconds == 0)) {
    			  
    			  Intent startCountdown = new Intent(MainActivity.this, CountdownActivity.class);
		    
    			  startCountdown.putExtra("hours", hours);
    			  startCountdown.putExtra("minutes", minutes);
    			  startCountdown.putExtra("seconds", seconds);
	   	
    			  String ns = Context.NOTIFICATION_SERVICE;
    			  mNotificationManager = (NotificationManager) getSystemService(ns);
    			  CharSequence tickerText = "Timer active.";
    			  int icon = R.drawable.logo;
        
    			  long when = System.currentTimeMillis();

    			  Notification notification = new Notification(icon, tickerText, when);
        
    			  CharSequence contentTitle = "Countdown Timer";
    			  CharSequence contentText = "Timer activated.";
    			  Intent notificationIntent = new Intent(MainActivity.this, CountdownActivity.class);
    			  PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 0, notificationIntent, HELLO_ID);
    			  notification.setLatestEventInfo(MainActivity.this, contentTitle, contentText, pIntent);
    			  notificationIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        
    			  mNotificationManager.notify(HELLO_ID, notification);
        
    			  startActivity(startCountdown);
    		  }
    	  }
    	 });
      
    }
    
    protected void onResume(){

    	super.onResume();
    	
    }
}
