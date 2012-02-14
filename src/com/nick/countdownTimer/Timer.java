package com.nick.countdownTimer;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Vibrator;

public class Timer extends CountDownTimer{
	
	public static Ringtone r;
	public static Vibrator v;
	private static int HELLO_ID = MainActivity.HELLO_ID;
	private Context mContext;
	
	public Timer(long millisInFuture, long countDownInterval, Context mContext) {
			super(millisInFuture, countDownInterval);
			this.mContext = mContext;
	}
	
	@Override
	public void onFinish() {
		CountdownActivity.countdown_text.setText("Finished.");
		CountdownActivity.finishButton.setText("Ok");
		CountdownActivity.timerFinished = true;
		
		v = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
		final long[] pattern = {1,300,75,300,75,300,75,300,3000,300,75,300,75,300,75,300};
		v.vibrate(pattern, -1);
		MainActivity.mNotificationManager.cancel(HELLO_ID);
		Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		r = RingtoneManager.getRingtone(mContext, notification);
		r.play();
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

