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
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private int hours;
	private int minutes;
	private int seconds;
	
	private EditText hoursBox;
	private EditText minutesBox;
	private EditText secondsBox;
	
	public static NotificationManager mNotificationManager;
	public static int HELLO_ID = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
        
      hoursBox = (EditText) findViewById(R.id.hoursBox);
      minutesBox = (EditText) findViewById(R.id.minutesBox);
	  secondsBox = (EditText) findViewById(R.id.secondsBox);
      Button startButton = (Button) findViewById(R.id.startButton);
       
      startButton.setOnClickListener(new View.OnClickListener() {
    
    	  public void onClick(View v) {
    		  if(!(hoursBox.getText().toString().equals("") 
    				  && minutesBox.getText().toString().equals("")
    				  && secondsBox.getText().toString().equals(""))) {
    			  
    		  
    			  Intent startCountdown = new Intent(MainActivity.this, CountdownActivity.class);
			
    			  startCountdown.putExtra("hours", hours);
    			  startCountdown.putExtra("minutes", minutes);
    			  startCountdown.putExtra("seconds", seconds);
		   
    			  if(hoursBox.getText().toString().equals(""))
    				  hoursBox.setText("0");
		    
    			  if(minutesBox.getText().toString().equals(""))
    				  minutesBox.setText("0");
		    
    			  if(secondsBox.getText().toString().equals(""))
    				  secondsBox.setText("0");
				    		
    			  hours = Integer.parseInt(hoursBox.getText().toString());
    			  minutes = Integer.parseInt(minutesBox.getText().toString());	
    			  seconds = Integer.parseInt(secondsBox.getText().toString());
		    
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
    	
    	hoursBox.setText("");
    	minutesBox.setText("");
    	secondsBox.setText("");
    }
}
