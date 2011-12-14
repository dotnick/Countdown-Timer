package com.nick.countdownTimer;

import android.os.CountDownTimer;

public class Timer extends CountDownTimer{
	
	public Timer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
	
	}
	
	@Override
	public void onFinish() {
		CountdownActivity.countdown_text.setText("Finished.");
		CountdownActivity.finishButton.setText("Ok");
		CountdownActivity.timerFinished = true;
		
		 
		// TODO: Fix Vibration
		//notifyFinished notifier = new notifyFinished();
}
	
	@Override
	public void onTick(long millisUntilFinished) {
		

		long remainingMs = millisUntilFinished;
		
		// Display meaningful time remaining instead of milliseconds.
		Integer h = new Integer((int) remainingMs/3600000);
		long remaining = remainingMs - (h*3600000);
		Integer m = new Integer((int) remaining/60000);
		remaining = remaining - (m*60000);
		Integer s = new Integer((int) (remaining /1000));
		
		String remainingH;
		String remainingM;
		String remainingS;
		
		if(h.equals(new Integer(0)))
			 remainingH = "00";
		else
			if(h<10)
				remainingH = "0"+h.toString();
			else
			remainingH = h.toString();
		
		if(m.equals(new Integer(0)))
			 remainingM = "00";
		else{
			if(m < 10)
				remainingM = "0"+m.toString();
			else
				remainingM = m.toString();
		}
		
		if(s<10)
			remainingS = "0"+s.toString();
		else
			remainingS = s.toString();
		
			
		if(remainingH.equals("00"))
			CountdownActivity.countdown_text.setText(remainingM+":"+remainingS);
		else
			CountdownActivity.countdown_text.setText(remainingH+":"+remainingM+":"+remainingS);
	}
	
}

