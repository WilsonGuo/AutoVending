package com.huawei.mm.vending.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.mm.vending.R;
import com.huawei.mm.vending.utils.Utils;
import com.huawei.mm.vending.voice.SinVoicePlayer;
import com.huawei.mm.vending.voice.SinVoiceRecognition;

public class OrderAcousticSensorActivity extends Activity implements
		SinVoiceRecognition.Listener, SinVoicePlayer.Listener {
	TextView price;
	ImageView image;
	AnimationDrawable animationDrawable;
    private final static int MSG_END = 1888;
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case MSG_END:
				Intent mIntent = new Intent(Utils.ACTION_NAME_SONIC_CLOSE);  
		        sendBroadcast(mIntent);
				mSinVoicePlayer.stop();
				Intent intent=new Intent(OrderAcousticSensorActivity.this, OrderOKActivity.class);
				OrderAcousticSensorActivity.this.startActivity(intent);
				OrderAcousticSensorActivity.this.finish();
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_acoustic);
		price = (TextView) this.findViewById(R.id.price);
		price.setText(getIntent().getStringExtra("price"));
		AssetManager mgr = getAssets();
		Typeface tf = Typeface.createFromAsset(mgr, "fonts/arial.ttf");
		price.setTypeface(tf);

		mSinVoicePlayer = new SinVoicePlayer(CODEBOOK);
		mSinVoicePlayer.setListener(this);

		mRecognition = new SinVoiceRecognition(CODEBOOK);
		mRecognition.setListener(this);
		mSinVoicePlayer.play(
				Utils.sendStr(price.getText().toString().substring(2)), true,
				1000);
		
		image=(ImageView) this.findViewById(R.id.image);
		animationDrawable=(AnimationDrawable) image.getBackground();
		animationDrawable.start();
		
		
		Intent mIntent = new Intent(Utils.ACTION_NAME_SONIC_OPEN);  
        sendBroadcast(mIntent);  
        
        
		handler.sendEmptyMessageDelayed(MSG_END, Utils.DELAY);
	}

	// ************************************************************
	boolean isStart = false;
	private final static String TAG = "OrderAcousticSensorActivity";

	private final static String CODEBOOK = "12345";

	private SinVoicePlayer mSinVoicePlayer;
	private SinVoiceRecognition mRecognition;

	@Override
	public void onRecognitionStart() {
		Log.e(TAG, "onRecognitionStart");
	}

	@Override
	public void onRecognition(char ch) {
		Log.e(TAG, "onRecognition");
	}

	@Override
	public void onRecognitionEnd() {
		Log.e(TAG, "onRecognitionEnd");
	}

	@Override
	public void onPlayStart() {
		Log.e(TAG, "start play");
	}

	@Override
	public void onPlayEnd() {
		Log.e(TAG, "stop play");
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mRecognition.start();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Intent mIntent = new Intent(Utils.ACTION_NAME_SONIC_CLOSE);  
        sendBroadcast(mIntent);
		handler.removeMessages(MSG_END);
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mSinVoicePlayer.stop();
		mRecognition.stop();
		;
	}

}
