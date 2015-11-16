package com.huawei.mm.vending.order;

import java.text.DecimalFormat;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.mm.vending.R;
import com.huawei.mm.vending.dialog.OrderAcousticSensorActivity;
import com.huawei.mm.vending.dialog.OrderNFCActivity;
import com.huawei.mm.vending.dialog.OrderQRActivity;
import com.huawei.mm.vending.utils.Utils;
public class OrderFrament extends Fragment{
	ImageView order_1;
	ImageView order_2;
	ImageView order_3;
	ImageView order_4;
	
	TextView priceTxt,countTxt;
	TextView priceTxt_1,oldPriceTxt_1;
	TextView priceTxt_2,oldPriceTxt_2;
	TextView priceTxt_3,oldPriceTxt_3;
	TextView priceTxt_4,oldPriceTxt_4;
	TextView priceTxt_5,oldPriceTxt_5;
	Button btn_add,btn_del;
	
	int count=1;
	float perPrice=0.38f;
	float totalPrice=count*perPrice;
	
	float prefePrice_nfc=0.32f;
	float prefePrice_sonic=0.30f;
	float prefePrice_qr=0.35f;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		AssetManager mgr=getActivity().getAssets();
		Typeface tf=Typeface.createFromAsset(mgr, "fonts/arial.ttf");
		View view=inflater.inflate(R.layout.fragment_order, container,false);
		priceTxt=(TextView) view.findViewById(R.id.price_total);
	
		countTxt=(TextView) view.findViewById(R.id.count_total);
		countTxt.setText(""+count);
		priceTxt.setText("$ "+totalPrice);
		
		priceTxt.setTypeface(tf);
		countTxt.setTypeface(tf);
		
		
		priceTxt_1=(TextView) view.findViewById(R.id.price_new_1);
		oldPriceTxt_1=(TextView) view.findViewById(R.id.price_old_1);
		priceTxt_2=(TextView) view.findViewById(R.id.price_new_2);
		oldPriceTxt_2=(TextView) view.findViewById(R.id.price_old_2);
		priceTxt_3=(TextView) view.findViewById(R.id.price_new_3);
		oldPriceTxt_3=(TextView) view.findViewById(R.id.price_old_3);
		priceTxt_4=(TextView) view.findViewById(R.id.price_new_4);
		oldPriceTxt_4=(TextView) view.findViewById(R.id.price_old_4);
		priceTxt_5=(TextView) view.findViewById(R.id.price_new_5);
		oldPriceTxt_5=(TextView) view.findViewById(R.id.price_old_5);
		priceTxt_1.setText("$ "+count*prefePrice_nfc);
		priceTxt_2.setText("$ "+count*prefePrice_sonic);
		priceTxt_3.setText("$ "+count*prefePrice_qr);
		priceTxt_4.setText("$ "+count*perPrice);
		priceTxt_5.setText("$ "+count*perPrice);
		
		
		oldPriceTxt_1.setText("$ "+totalPrice);
		oldPriceTxt_2.setText("$ "+totalPrice);
		oldPriceTxt_3.setText("$ "+totalPrice);
		oldPriceTxt_4.setText("$ "+totalPrice);
		oldPriceTxt_5.setText("$ "+totalPrice);
		
		priceTxt_1.setTypeface(tf);
		priceTxt_2.setTypeface(tf);
		priceTxt_3.setTypeface(tf);
		priceTxt_4.setTypeface(tf);
		priceTxt_5.setTypeface(tf);
		
		oldPriceTxt_1.setTypeface(tf);
		oldPriceTxt_2.setTypeface(tf);
		oldPriceTxt_3.setTypeface(tf);
		oldPriceTxt_4.setTypeface(tf);
		oldPriceTxt_5.setTypeface(tf);
		
		oldPriceTxt_1.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线
		oldPriceTxt_1.getPaint().setAntiAlias(true);// 抗锯齿
		oldPriceTxt_2.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线
		oldPriceTxt_2.getPaint().setAntiAlias(true);// 抗锯齿
		oldPriceTxt_3.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线
		oldPriceTxt_3.getPaint().setAntiAlias(true);// 抗锯齿
		oldPriceTxt_4.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线
		oldPriceTxt_4.getPaint().setAntiAlias(true);// 抗锯齿
		oldPriceTxt_5.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线
		oldPriceTxt_5.getPaint().setAntiAlias(true);// 抗锯齿
		
		btn_add=(Button) view.findViewById(R.id.btn_add);
		btn_del=(Button) view.findViewById(R.id.btn_del);
		btn_add.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				if(arg1.getAction()==MotionEvent.ACTION_DOWN){
					
				}else if(arg1.getAction()==MotionEvent.ACTION_UP){
					count=count+1;
					totalPrice=count*perPrice;
					DecimalFormat df = new DecimalFormat("##0.00");  
					priceTxt.setText("$ "+df.format(totalPrice));
					countTxt.setText(""+count);
					
				
					priceTxt_1.setText("$ "+df.format(count*prefePrice_nfc));
					priceTxt_2.setText("$ "+df.format(count*prefePrice_sonic));
					priceTxt_3.setText("$ "+df.format(count*prefePrice_qr));
					priceTxt_4.setText("$ "+df.format(count*perPrice));
					priceTxt_5.setText("$ "+df.format(count*perPrice));
					
					oldPriceTxt_1.setText("$ "+df.format(totalPrice));
					oldPriceTxt_2.setText("$ "+df.format(totalPrice));
					oldPriceTxt_3.setText("$ "+df.format(totalPrice));
					oldPriceTxt_4.setText("$ "+df.format(totalPrice));
					oldPriceTxt_5.setText("$ "+df.format(totalPrice));
				}
				return false;
			}
		});
		btn_del.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				if(arg1.getAction()==MotionEvent.ACTION_DOWN){
					
				}else if(arg1.getAction()==MotionEvent.ACTION_UP){
					if(count>1){
						count=count-1;
					}
					totalPrice=count*perPrice;
					DecimalFormat df = new DecimalFormat("##0.00");  
					priceTxt.setText("$ "+df.format(totalPrice));
					countTxt.setText(""+count);
					
					priceTxt_1.setText("$ "+df.format(count*prefePrice_nfc));
					priceTxt_2.setText("$ "+df.format(count*prefePrice_sonic));
					priceTxt_3.setText("$ "+df.format(count*prefePrice_qr));
					priceTxt_4.setText("$ "+df.format(count*perPrice));
					priceTxt_5.setText("$ "+df.format(count*perPrice));
					
					
					oldPriceTxt_1.setText("$ "+df.format(totalPrice));
					oldPriceTxt_2.setText("$ "+df.format(totalPrice));
					oldPriceTxt_3.setText("$ "+df.format(totalPrice));
					oldPriceTxt_4.setText("$ "+df.format(totalPrice));
					oldPriceTxt_5.setText("$ "+df.format(totalPrice));
				}
				return false;
			}
		});
		
	
		btn_del=(Button) view.findViewById(R.id.btn_del);
		order_1=(ImageView) view.findViewById(R.id.order_1);
		order_1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				order_1.setBackgroundResource(R.drawable.order_selecter);
				order_2.setBackgroundDrawable(null);;
				order_3.setBackgroundDrawable(null);;
				
				Utils.price=priceTxt_1.getText().toString();
				Intent intent=new Intent(getActivity(), OrderNFCActivity.class);
				intent.putExtra("price", priceTxt_1.getText().toString());
				getActivity().startActivity(intent);
			}
		});
		order_2=(ImageView) view.findViewById(R.id.order_2);
		order_2.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				order_1.setBackgroundDrawable(null);
				order_2.setBackgroundResource(R.drawable.order_selecter);
				order_3.setBackgroundDrawable(null);
				Utils.price=priceTxt_2.getText().toString();
				Intent intent=new Intent(getActivity(), OrderAcousticSensorActivity.class);
				intent.putExtra("price", priceTxt_2.getText().toString());
				getActivity().startActivity(intent);
			}
		});
		order_3=(ImageView) view.findViewById(R.id.order_3);
		order_3.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				
				order_1.setBackgroundDrawable(null);
				order_2.setBackgroundDrawable(null);
				order_3.setBackgroundResource(R.drawable.order_selecter);
				Utils.price=priceTxt_3.getText().toString();
				Intent intent=new Intent(getActivity(), OrderQRActivity.class);
				intent.putExtra("price", priceTxt_3.getText().toString());
				getActivity().startActivity(intent);
			}
		});
		order_4=(ImageView) view.findViewById(R.id.order_4);
		order_4.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {

			}
		});
	
		
		
		
		return view;
	}

}
