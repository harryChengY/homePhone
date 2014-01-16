package com.homephonenew;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class HealthActivity extends Activity
{
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
		setContentView(R.layout.activity_health);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		
		 //ÐÞ¸ÄActivity±êÌâ
	    TextView title = (TextView) findViewById(R.id.title_text);
	    title.setText("½¡¿µ¼à¿Ø");
	}
}
