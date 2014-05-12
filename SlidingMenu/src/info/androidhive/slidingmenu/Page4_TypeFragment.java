package info.androidhive.slidingmenu;

import info.androidhive.page_out.Page5_test;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Page4_TypeFragment extends Fragment {
	
	public Page4_TypeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_type, container, false);
        Button button_BG=(Button)rootView.findViewById(R.id.button_BG);
        Button button_cloth=(Button)rootView.findViewById(R.id.button_cloth);
        Button button_3C=(Button)rootView.findViewById(R.id.button_3C);
        button_BG.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Page4_Type_BG_Fragment fragment = new Page4_Type_BG_Fragment();
		            FragmentManager fragmentManager = getFragmentManager();
					fragmentManager.beginTransaction()
							.replace(R.id.frame_container, fragment).commit();
		
			}}
			);
        button_cloth.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Page4_type_Cloth_Fragment fragment = new Page4_type_Cloth_Fragment();
		            FragmentManager fragmentManager = getFragmentManager();
					fragmentManager.beginTransaction()
							.replace(R.id.frame_container, fragment).commit();
		
			}}
			);
        button_3C.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Page4_type_3C_Fragment fragment = new Page4_type_3C_Fragment();
		            FragmentManager fragmentManager = getFragmentManager();
					fragmentManager.beginTransaction()
							.replace(R.id.frame_container, fragment).commit();
		
			}}
			);
        
        return rootView;
    }
}
