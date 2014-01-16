package com.homephonenew;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.*;

public class SetActivity extends Activity
{
	private Button   button_edit;
	private Button	 button_set;
	private EditText server_ip;
	private EditText server_port;
	private EditText tv_cid;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
	    setContentView(R.layout.activity_set);
	    getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
	    
	    //修改Activity标题
	    TextView title = (TextView) findViewById(R.id.title_text);
	    title.setText("设置");
	   
	    //初始化编辑框
	    init();
	    
	    //设置两个按钮关联消息响应函数
	    
	    //修改设置按钮，让编辑框可编辑；
		button_edit = (Button) findViewById(R.id.button_edit);
		button_edit.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				server_ip.setFocusableInTouchMode(true);
				server_port.setFocusableInTouchMode(true);
				tv_cid.setFocusableInTouchMode(true);
			}
		});
		
		//应用设置，修改public变量URL_Server；
		//编辑框再次置为不可编辑
		button_set = (Button) findViewById(R.id.button_set);
		button_set.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				MainActivity.URL_Server = 	
						"http://"+server_ip.getEditableText().toString()
						 +":"
						 +server_port.getEditableText().toString()
						 +"/myhomenew/phoneQuery?cid="
						 +tv_cid.getEditableText().toString();
				Toast toast = Toast.makeText(SetActivity.this, "应用成功！", Toast.LENGTH_LONG);
				toast.show();
				server_ip.setFocusable(false);
				server_port.setFocusable(false);
				tv_cid.setFocusable(false);
			}
		});
	    
	    
	    
	    
		
		
		
	}
	/*********************
	 * 初始化编辑框
	 */
	private void init()
	{
		server_ip = (EditText)findViewById(R.id.editText1);
		server_port = (EditText)findViewById(R.id.editText2);
		tv_cid = (EditText)findViewById(R.id.editText3);
		/*
		 * 初始值设置
		 */
		server_ip.setText("192.168.119.10");
		server_port.setText("8080");
		tv_cid.setText("abc");
		
		server_ip.setFocusable(false);
		server_port.setFocusable(false);
		tv_cid.setFocusable(false);
		
		MainActivity.URL_Server = 	
				"http://"+server_ip.getEditableText().toString()
				 +":"
				 +server_port.getEditableText().toString()
				 +"/myhomenew/phoneQuery?cid="
				 +tv_cid.getEditableText().toString();
	}
	/***************************
	 * 设置页底部的两个系统信息
	 */
	public void help(View v_help)
	{
		Toast toast = Toast.makeText(SetActivity.this, "填写确认网络设置，在相应功能区进行刷新", Toast.LENGTH_LONG);
		toast.show();
	}
	
	public void about(View v_about)
	{
		ImageView img = new ImageView(SetActivity.this);
		TextView txt = new TextView(SetActivity.this);
		img.setImageResource(R.drawable.ic_launcher);
		txt.setText("我的智能家居1.0   Copyright© 2014");
		txt.setTextSize(15);
		LinearLayout lay = new LinearLayout(SetActivity.this);
		lay.addView(img);
		lay.addView(txt);
		new AlertDialog.Builder(SetActivity.this)  
		                .setTitle("关于系统")
		                .setView(lay)
		                .setPositiveButton("确定", null)
		                .show();  
	}
}

