package info.androidhive.slidingmenu;

import info.androidhive.page_out.Page5_test;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Page4_type_Cloth_Fragment extends Fragment {
	
	public Page4_type_Cloth_Fragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.type_cloth, container, false);
  
        return rootView;
    }


}