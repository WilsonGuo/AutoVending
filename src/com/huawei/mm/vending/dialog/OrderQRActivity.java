package com.huawei.mm.vending.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.mm.vending.R;
import com.huawei.mm.vending.utils.Utils;

public class OrderQRActivity extends Activity{
	TextView price;
	ImageView qrImage;
	 private final static int MSG_END = 1888;
		Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				switch (msg.what) {
				case MSG_END:
					Intent intent=new Intent(OrderQRActivity.this, OrderOKActivity.class);
					OrderQRActivity.this.startActivity(intent);
					OrderQRActivity.this.finish();
					break;
				default:
					break;
				}

			}

		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_qr);
		price=(TextView) this.findViewById(R.id.price);
		price.setText(getIntent().getStringExtra("price"));
		qrImage=(ImageView) this.findViewById(R.id.qr_image);
		AssetManager mgr=getAssets();
		Typeface tf=Typeface.createFromAsset(mgr, "fonts/arial.ttf");
		price.setTypeface(tf);
		
		
		qrImage.setImageBitmap(Utils.createQRImage(price.getText().toString().substring(2)));
		handler.sendEmptyMessageDelayed(MSG_END, Utils.DELAY);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		handler.removeMessages(MSG_END);
		
	}
}
