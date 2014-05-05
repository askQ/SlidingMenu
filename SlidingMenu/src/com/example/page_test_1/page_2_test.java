package com.example.page_test_1;

import info.androidhive.slidingmenu.R;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class page_2_test extends Activity 
{
   //摰��
   private ImageView mImg;
   private DisplayMetrics mPhone;
   private final static int CAMERA = 66 ;
   private final static int PHOTO = 99 ;
        
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.page_2_test);
      
    //assign button
      Button button1=(Button)findViewById(R.id.button1);
                
      //霈����閫��摨�
      mPhone = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(mPhone);
            
      mImg = (ImageView) findViewById(R.id.img);
      Button mCamera = (Button) findViewById(R.id.camera);
      Button mPhoto = (Button) findViewById(R.id.photo);
      
      
		button1.setOnClickListener(new Button.OnClickListener(){
		public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(page_2_test.this, page3.class);
			startActivity(intent); 
			page_2_test.this.finish(); 
		}}
		);
                
      mCamera.setOnClickListener(new OnClickListener()
      {
         @Override
         public void onClick(View v) 
         {
         //���豢��嚗蒂撠��批������兄D�∠���改��startActivityForResult銝葆�叵equestCode�脰��澆嚗���摰敺���撘���卻nActivityResult
         ContentValues value = new ContentValues();
         value.put(Media.MIME_TYPE, "image/jpeg");                                      
         Uri uri= getContentResolver().insert(Media.EXTERNAL_CONTENT_URI,
                                              value); 
         Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
         intent.putExtra(MediaStore.EXTRA_OUTPUT, uri.getPath());  
         startActivityForResult(intent, CAMERA);      
         }
      });
                
      mPhoto.setOnClickListener(new OnClickListener()
      {
         @Override
         public void onClick(View v) 
         {
         //���貊倏�貊����startActivityForResult銝葆�叵equestCode�脰��澆嚗��暺�貊�敺���撘�卻nActivityResult
         Intent intent = new Intent();
         intent.setType("image/*");
         intent.setAction(Intent.ACTION_GET_CONTENT);
         startActivityForResult(intent, PHOTO);
         }
      });
   }
        
   //�摰������澆甇文撘�
   @Override 
   protected void onActivityResult(int requestCode, int resultCode,Intent data)
   {
      //�requestCode�斗�臬�粹��璈����貊倏��怎�嚗�data銝null
      if ((requestCode == CAMERA || requestCode == PHOTO ) && data != null)
      {
         //���抒�頝臬�uri
         Uri uri = data.getData();
         ContentResolver cr = this.getContentResolver();
                      
         try
         {
         //霈���抒�嚗��Bitmap
         Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));

         //�斗�抒��箸帖����游�嚗蒂�脣ScalePic�斗���臬閬�銵葬��
         if(bitmap.getWidth()>bitmap.getHeight())ScalePic(bitmap,
                                                          mPhone.heightPixels);
         else ScalePic(bitmap,mPhone.widthPixels);
         } 
         catch (FileNotFoundException e)
         {
         }
      }
                
      super.onActivityResult(requestCode, resultCode, data);
   }
        
   private void ScalePic(Bitmap bitmap,int phone)
   {
      //蝮格瘥��身��
      float mScale = 1 ;
                
      //憒���撖砍漲憭扳��撖砍漲��銵葬�橘��血��湔撠���付mageView��
      if(bitmap.getWidth() > phone )
      {
         //�斗蝮格瘥�
         mScale = (float)phone/(float)bitmap.getWidth();
                      
         Matrix mMat = new Matrix() ;
         mMat.setScale(mScale, mScale);
                          
         Bitmap mScaleBitmap = Bitmap.createBitmap(bitmap,
                                                   0,
                                                   0,
                                                   bitmap.getWidth(),
                                                   bitmap.getHeight(),
                                                   mMat,
                                                   false);
         mImg.setImageBitmap(mScaleBitmap);
      }
   else mImg.setImageBitmap(bitmap);
   }
}