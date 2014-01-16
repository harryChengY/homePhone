package com.homephonenew;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.*;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity
{

	protected static String URL_Server="http://192.168.119.10:8080/myhomenew/phoneQuery?cid=abc";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		setContentView(R.layout.activity_main);
		
		final TextView  wetMain = (TextView)findViewById(R.id.textWet);
		final TextView  bingxiangMain = (TextView)findViewById(R.id.textBingxiang);
		final TextView  setMain = (TextView)findViewById(R.id.textSet);
		final TextView  kongtiaoMain = (TextView)findViewById(R.id.textKongtiao);
		final TextView  lightMain = (TextView)findViewById(R.id.textLight);
		final TextView  healthMain = (TextView)findViewById(R.id.textHealth);
		final TextView  videoMain = (TextView)findViewById(R.id.textVideo);
		
		/*
		 * 温湿度监控入口
		 */
		wetMain.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				Intent intentForWet = new Intent(MainActivity.this,WetActivity.class);
				wetMain.setScaleX(1);
				wetMain.setScaleY(1);
				startActivity(intentForWet);
			}
		});
		wetMain.setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v0, MotionEvent event0)
			{
				// TODO Auto-generated method stub
				switch(event0.getAction())
				{
					case MotionEvent.ACTION_DOWN: 
					{
						wetMain.setScaleX((float) 0.92);
						wetMain.setScaleY((float) 0.92);
					}
				}
				return false;
			}
		});
		/*
		 * 冰箱监控入口
		 */
		bingxiangMain.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg1)
			{
				// TODO Auto-generated method stub
				Intent intentForBingxiang = new Intent(MainActivity.this,BingxiangActivity.class);
				bingxiangMain.setScaleX(1);
				bingxiangMain.setScaleY(1);
				startActivity(intentForBingxiang);
			}
		});
		bingxiangMain.setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v1, MotionEvent event1)
			{
				// TODO Auto-generated method stub
				switch(event1.getAction())
				{
					case MotionEvent.ACTION_DOWN: 
					{
						bingxiangMain.setScaleX((float) 0.92);
						bingxiangMain.setScaleY((float) 0.92);
					}
				}
				return false;
			}
		});
		/*
		 * 设置入口
		 */
		setMain.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg2)
			{
				// TODO Auto-generated method stub
				Intent intentForSet = new Intent(MainActivity.this,SetActivity.class);
				setMain.setScaleX(1);
				setMain.setScaleY(1);
				startActivity(intentForSet);
			}
		});
		setMain.setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v2, MotionEvent event2)
			{
				// TODO Auto-generated method stub
				switch(event2.getAction())
				{
					case MotionEvent.ACTION_DOWN: 
					{
						setMain.setScaleX((float) 0.92);
						setMain.setScaleY((float) 0.92);
					}
				}
				return false;
			}
		});
		/*
		 * 空调监控入口
		 */
		kongtiaoMain.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg3)
			{
				// TODO Auto-generated method stub
				Intent intentForKongtiao = new Intent(MainActivity.this,KongtiaoActivity.class);
				kongtiaoMain.setScaleX(1);
				kongtiaoMain.setScaleY(1);
				startActivity(intentForKongtiao);
			}
		});
		kongtiaoMain.setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v3, MotionEvent event3)
			{
				// TODO Auto-generated method stub
				switch(event3.getAction())
				{
					case MotionEvent.ACTION_DOWN: 
					{
						kongtiaoMain.setScaleX((float) 0.92);
						kongtiaoMain.setScaleY((float) 0.92);
					}
				}
				return false;
			}
		});
		/*
		 * 电灯监控入口
		 */
		lightMain.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg4)
			{
				// TODO Auto-generated method stub
				Intent intentForLight = new Intent(MainActivity.this,LightActivity.class);
				lightMain.setScaleX(1);
				lightMain.setScaleY(1);
				startActivity(intentForLight);
			}
		});
		lightMain.setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v4, MotionEvent event4)
			{
				// TODO Auto-generated method stub
				switch(event4.getAction())
				{
					case MotionEvent.ACTION_DOWN: 
					{
						lightMain.setScaleX((float) 0.92);
						lightMain.setScaleY((float) 0.92);
					}
				}
				return false;
			}
		});
		/*
		 * 健康监控入口
		 */
		healthMain.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg5)
			{
				// TODO Auto-generated method stub
				Intent intentForHealth = new Intent(MainActivity.this,HealthActivity.class);
				healthMain.setScaleX(1);
				healthMain.setScaleY(1);
				startActivity(intentForHealth);
			}
		});
		healthMain.setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v5, MotionEvent event5)
			{
				// TODO Auto-generated method stub
				switch(event5.getAction())
				{
					case MotionEvent.ACTION_DOWN: 
					{
						healthMain.setScaleX((float) 0.92);
						healthMain.setScaleY((float) 0.92);
					}
				}
				return false;
			}
		});
		/*
		 * 视频监控入口
		 */
		videoMain.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg6)
			{
				// TODO Auto-generated method stub
				Intent intentForVideo = new Intent(MainActivity.this,VideoActivity.class);
				videoMain.setScaleX(1);
				videoMain.setScaleY(1);
				startActivity(intentForVideo);
			}
		});
		videoMain.setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v6, MotionEvent event6)
			{
				// TODO Auto-generated method stub
				switch(event6.getAction())
				{
					case MotionEvent.ACTION_DOWN: 
					{
						videoMain.setScaleX((float) 0.92);
						videoMain.setScaleY((float) 0.92);
					}
				}
				return false;
			}
		});
		
	}
	
}
