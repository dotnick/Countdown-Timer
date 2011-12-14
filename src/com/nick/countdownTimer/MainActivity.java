package com.nick.countdownTimer;


import android.app.Activity;
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
	   	startActivity(startCountdown);
  	  
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
