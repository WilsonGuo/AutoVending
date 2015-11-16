package com.huawei.mm.vending.frament;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.huawei.mm.vending.R;
import com.huawei.mm.vending.order.OrderFrament;
public class SoftDrinkFrament extends Fragment{
	Button orderBtn;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view= inflater.inflate(R.layout.fragment_softdrink, container,false);
		orderBtn=(Button) view.findViewById(R.id.btn_order);
		orderBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
		    	OrderFrament detail = new OrderFrament();
			    android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
			    ft.replace(R.id.contentDetail, detail);
			    ft.commit();
			}
		});
		return view;
	}

}
