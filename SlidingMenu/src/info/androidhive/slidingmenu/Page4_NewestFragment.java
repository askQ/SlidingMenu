package info.androidhive.slidingmenu;

import info.androidhive.page_out.Page5_test;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Page4_NewestFragment extends Fragment {
	
	public Page4_NewestFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_newest, container, false);
         Button button_ask=(Button)rootView.findViewById(R.id.button_ask);
         
         button_ask.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), Page5_test.class);
				startActivity(intent); 
				getActivity().finish();
				
			}}
			);
        return rootView;
    }
}
