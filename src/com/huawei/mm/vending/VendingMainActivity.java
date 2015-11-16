package com.huawei.mm.vending;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.huawei.mm.vending.frament.FoodFrament;
import com.huawei.mm.vending.frament.MagazineFrament;
import com.huawei.mm.vending.frament.PersonalFrament;
import com.huawei.mm.vending.frament.SoftDrinkFrament;
import com.huawei.mm.vending.frament.WineFrament;
import com.huawei.mm.vending.utils.Utils;


public class VendingMainActivity extends Activity {
	Button softDrink;
	Button food;
	Button wine;
	Button magazine;
	Button personal;

	
	ImageView sonic;
	ImageView nfc;
	
	AnimationDrawable animationDrawableNFC;
	AnimationDrawable animationDrawableSonic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vending_main);

		SoftDrinkFrament detail = new SoftDrinkFrament();
		android.app.FragmentTransaction ft = getFragmentManager()
				.beginTransaction();
		ft.replace(R.id.contentDetail, detail);
		ft.commit();
		sonic=(ImageView) this.findViewById(R.id.sonic);
		nfc=(ImageView) this.findViewById(R.id.nfc);
		softDrink = (Button) this.findViewById(R.id.Btn_softDrink);
		food = (Button) this.findViewById(R.id.Btn_food);
		wine = (Button) this.findViewById(R.id.Btn_Wine);
		magazine = (Button) this.findViewById(R.id.Btn_magazine);
		personal = (Button) this.findViewById(R.id.Btn_personalCare);

		softDrink.setBackgroundResource(R.drawable.btn_press);

		softDrink.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SoftDrinkFrament detail = new SoftDrinkFrament();
				android.app.FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.contentDetail, detail);
				ft.commit();

				softDrink.setBackgroundResource(R.drawable.btn_press);
				food.setBackgroundDrawable(null);
				wine.setBackgroundDrawable(null);
				magazine.setBackgroundDrawable(null);
				personal.setBackgroundDrawable(null);
			}
		});
		food.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				FoodFrament detail = new FoodFrament();
				android.app.FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.contentDetail, detail);
				ft.commit();

				softDrink.setBackgroundDrawable(null);
				food.setBackgroundResource(R.drawable.btn_press);
				wine.setBackgroundDrawable(null);
				magazine.setBackgroundDrawable(null);
				personal.setBackgroundDrawable(null);
			}
		});
		wine.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				WineFrament detail = new WineFrament();
				android.app.FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.contentDetail, detail);
				ft.commit();

				softDrink.setBackgroundDrawable(null);
				food.setBackgroundDrawable(null);
				wine.setBackgroundResource(R.drawable.btn_press);
				magazine.setBackgroundDrawable(null);
				personal.setBackgroundDrawable(null);
			}
		});
		magazine.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				MagazineFrament detail = new MagazineFrament();
				android.app.FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.contentDetail, detail);
				ft.commit();

				softDrink.setBackgroundDrawable(null);
				food.setBackgroundDrawable(null);
				wine.setBackgroundDrawable(null);
				magazine.setBackgroundResource(R.drawable.btn_press);
				personal.setBackgroundDrawable(null);
			}
		});
		personal.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PersonalFrament detail = new PersonalFrament();
				android.app.FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.contentDetail, detail);
				ft.commit();

				softDrink.setBackgroundDrawable(null);
				food.setBackgroundDrawable(null);
				wine.setBackgroundDrawable(null);
				magazine.setBackgroundDrawable(null);
				personal.setBackgroundResource(R.drawable.btn_press);
			}
		});
		animationDrawableNFC=(AnimationDrawable) nfc.getBackground();
		animationDrawableSonic=(AnimationDrawable) sonic.getBackground();
		
		
	        myIntentFilter = new IntentFilter();  
	        myIntentFilter.addAction(Utils.ACTION_NAME_NFC_OPEN);  
	        myIntentFilter.addAction(Utils.ACTION_NAME_NFC_CLOSE);  
	        myIntentFilter.addAction(Utils.ACTION_NAME_SONIC_OPEN);  
	        myIntentFilter.addAction(Utils.ACTION_NAME_SONIC_CLOSE);  
	        
			mBroadcastReceiver=new ActionBroadcastReceiver();
	        //注册广播        
	        registerReceiver(mBroadcastReceiver, myIntentFilter);
	}

	 @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}
	 
	 
	 
	 
	 
	 @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(mBroadcastReceiver!=null){
			registerReceiver(mBroadcastReceiver, myIntentFilter);
		}
	}





	ActionBroadcastReceiver mBroadcastReceiver;
	 IntentFilter myIntentFilter;
	class ActionBroadcastReceiver extends BroadcastReceiver{
			@Override
			public void onReceive(Context arg0, Intent intent) {
				// TODO Auto-generated method stub
				 String action = intent.getAction();  
		            if(action.equals(Utils.ACTION_NAME_NFC_OPEN)){  
		            	nfc.setVisibility(View.VISIBLE);
		        		animationDrawableNFC.start();
		            }else if(action.equals(Utils.ACTION_NAME_NFC_CLOSE)){
		            	nfc.setVisibility(View.INVISIBLE);
		            	animationDrawableNFC.stop();
		            }else if(action.equals(Utils.ACTION_NAME_SONIC_OPEN)){
		            	sonic.setVisibility(View.VISIBLE);
		        		animationDrawableSonic.start();
		            }else if(action.equals(Utils.ACTION_NAME_SONIC_CLOSE)){
		            	sonic.setVisibility(View.INVISIBLE);
		            	animationDrawableSonic.stop();
		            }else{
		            	
		            }
			}

		}



}
