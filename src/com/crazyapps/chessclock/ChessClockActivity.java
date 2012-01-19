package com.crazyapps.chessclock;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.crazyapps.chessclock.CountDown.CountDownListener;

public class ChessClockActivity extends Activity {

	private final long	INITIAL_TIME	= 10000;

	private CountDown	countDown1;
	private CountDown	countDown2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		countDown1 = (CountDown) findViewById(R.id.countdown1);
		countDown2 = (CountDown) findViewById(R.id.countdown2);

		defCountDownBehavior(countDown1, countDown2);
		defCountDownBehavior(countDown2, countDown1);

		defButtonBehavior();
	}

	private void defCountDownBehavior(final CountDown mainCountDown, final CountDown adverseCountDown) {
		mainCountDown.setTotal(INITIAL_TIME);

		mainCountDown.setCountDownListener(new CountDownListener() {

			public void onClick(View v) {
				mainCountDown.pause();
				adverseCountDown.start();
			}

			public void onFinish() {
				toast("Done");
			}
		});
	}

	private void defButtonBehavior() {
		((Button) findViewById(R.id.button1)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				toast("Todo");
			}
		});
	}

	private void toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}

}