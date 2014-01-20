package com.homephonenew;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class LightActivity extends Activity
{
	private Button refresh;
	public  static String re=null;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
		setContentView(R.layout.activity_light);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		
		 //修改Activity标题
	    TextView title = (TextView) findViewById(R.id.title_text);
	    title.setText("电灯监控");
	    
	    /*
	     * 设置刷新按钮响应函数，执行刷新灯操作
	     */
	    refresh = (Button) findViewById(R.id.button_refresh_light);
		
		refresh.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v_refresh_light)
			{
				// TODO Auto-generated method stub
				//使用URL连接数据库
				DownTask task = new DownTask(LightActivity.this);
				try {
					task.execute(new URL(MainActivity.URL_Server));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} 
		});
	}
	
	/*
	 * 	UI界面更新方法，由异步任务完成之后直接调用
	 */
	
	private int update()
	{
		// TODO Auto-generated method stub
		
		System.out.println(re);
		if(re.indexOf("Data is null")!=-1)
		{
			return 101;
		}
		
		/*
		 * 分离出灯数据，电视网关IP地址
		 */
		int start,end;
		String environments,tvIp,lights;
		String [] lightArray = new String[50]; int count_lights = 0;
		//String [] environmentArray = new String[50];
		
		start=re.indexOf("Light_id")+11;
		end=re.indexOf(",", start)-1;
		lights=re.substring(start,end)+";";
		
		start=re.indexOf("Environment_id")+17;
		end=re.indexOf(",", start)-1;
		environments=re.substring(start,end)+";";
		
		start=re.indexOf("ipAddress")+12;
		end=re.indexOf("}", start)-1;
		tvIp=re.substring(start,end);
		
		System.out.println(environments);
		System.out.println(lights);
		System.out.println(tvIp);
		
		
		
		
		/*
		 *	下面从灯数据串中提取单个的灯ID存到灯数组lightArray中； 
		 */
		
		for(int a=0,b=0; b < lights.length(); a++,b++)
		{
			while(lights.charAt(b)!=';')b++;
			lightArray[count_lights++]=lights.substring(a, b);
			a=b;
		}
		
		System.out.printf("总数:%d",count_lights);
		for(int i=count_lights;i<50;i++)
		{
			lightArray[i]="";
		}
		final int count_lights_final = count_lights;
		final String [] lightArray_final = lightArray;
		/*
		 * 下面用BaseAdapter显示listview内容
		 */
		ListView list1 = (ListView) findViewById(R.id.ListView1);
		
		//ArrayAdapter<String> adapter1 = new ArrayAdapter<String> (activity,R.layout.array_item,lightArray);
		
		BaseAdapter adapter1 = new BaseAdapter()
		{
			public int getCount() 
			{
				// TODO Auto-generated method stub
				return count_lights_final;
			}

			public Object getItem(int arg0)
			{
				// TODO Auto-generated method stub
				return null;
			}

			public long getItemId(int position)
			{
				// TODO Auto-generated method stub
				return position;
			}

			public View getView(final int position, View convertView, ViewGroup parent)
			{
				// TODO Auto-generated method stub
				LinearLayout line = new LinearLayout(LightActivity.this);
				line.setOrientation(0);
				//电灯标识
				TextView text = new TextView(LightActivity.this);
				text.setText("   电灯："+lightArray_final[position]+"   ");
				text.setTextSize(20);
				text.setTextColor(Color.BLACK);
				//电灯图片
				final ImageView image = new ImageView(LightActivity.this);
				image.setImageResource(R.drawable.lightoff);
				
				
				final Button button_open = new Button(LightActivity.this);
				button_open.setText("打开电灯");
				
				final Button button_close = new Button(LightActivity.this);
				button_close.setText("关闭电灯");
				
				//开灯按钮
				button_open.setOnClickListener(new OnClickListener()
				{

					public void onClick(View arg0)
					{
						// TODO Auto-generated method stub
						boolean re;
						re=openLight(lightArray_final[position]);
						if(re == true)
						{
							button_open.setEnabled(false);
							button_close.setEnabled(true);
							image.setImageResource(R.drawable.lighton);
							Toast toast_ok = Toast.makeText(LightActivity.this,"打开灯"+lightArray_final[position]+"成功！",Toast.LENGTH_LONG);
							toast_ok.setGravity(Gravity.CENTER, 0, 0); 
							toast_ok.show();
						}
						else
						{
							Toast toast_er = Toast.makeText(LightActivity.this,"打开灯"+lightArray_final[position]+"失败！",Toast.LENGTH_LONG);
							toast_er.setGravity(Gravity.CENTER, 0, 0); 
							toast_er.show();
						}
					}
				});
				
				//关灯按钮
				button_close.setOnClickListener(new OnClickListener()
				{

					public void onClick(View v)
					{
						// TODO Auto-generated method stub
						boolean re;
						re=closeLight(lightArray_final[position]);
						if(re == true)
						{
							button_open.setEnabled(true);
							button_close.setEnabled(false);
							image.setImageResource(R.drawable.lightoff);
							Toast toast_ok = Toast.makeText(LightActivity.this,"关闭灯"+lightArray_final[position]+"成功！",Toast.LENGTH_LONG);
							toast_ok.setGravity(Gravity.CENTER, 0, 0); 
							toast_ok.show();
						}
						else
						{
							Toast toast_er = Toast.makeText(LightActivity.this,"关闭灯"+lightArray_final[position]+"失败！",Toast.LENGTH_LONG);
							toast_er.setGravity(Gravity.CENTER, 0, 0); 
							toast_er.show();
						}
					}
				});
				
				line.addView(text);
				line.addView(button_open);
				line.addView(button_close);
				line.addView(image);
				line.setGravity(Gravity.CENTER);
				return line;
			}	
		};
		list1.setAdapter(adapter1);
		
		return 0;
	}
	
	/*
	 * 下面分别为开灯和关灯的控制
	 */
	private boolean openLight(String lightId) 
	{
		// TODO Auto-generated method stub
		Toast toast12 = Toast.makeText(LightActivity.this,"正在打开灯："+lightId+"......", Toast.LENGTH_LONG);
		toast12.show();
		/*
		 * 
		 */
		
		
		//若成功打开灯，返回true,按钮变灰，反则返回false
		return true;
	}
	
	private boolean closeLight(String lightId)
	{
		// TODO Auto-generated method stub
		Toast toast13 = Toast.makeText(LightActivity.this,"正在关闭灯："+lightId+"......", Toast.LENGTH_LONG);
		toast13.show();
		/*
		 * 
		 */
		
		
		//成功打开灯，返回true,按钮变灰，反则返回false
		return true;
	}
	
	class DownTask extends AsyncTask<URL, Integer, String>
	{
		// 可变长的输入参数，与AsyncTask.exucute()对应
		ProgressDialog pdialog;
		// 定义记录已经读取行的数量
		int hasRead = 0;
		Context mContext;

		public DownTask(Context ctx)
		{
			mContext = ctx;
		}

		@Override
		protected String doInBackground(URL... params)
		{
			StringBuilder sb = new StringBuilder();
			try
			{
				URLConnection conn = params[0].openConnection();
				// 打开conn连接对应的输入流，并将它包装成BufferedReader
				BufferedReader br = new BufferedReader(	new InputStreamReader(conn.getInputStream()	, "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null)
				{
					sb.append(line + "\n");
					hasRead++;
					publishProgress(hasRead);
				}
				return sb.toString();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		
		/*
		 * 在这里得到服务器返回的结果；
		 */
		@Override
		protected void onPostExecute(String result)
		{
			// 返回HTML页面的内容
			//show.setText(result);
			if(result!=null)
			{
				//Toast toast6 = Toast.makeText(activity, result, Toast.LENGTH_LONG);
				//toast6.show();
			}
			else
			{
				Toast toast2 = Toast.makeText(LightActivity.this, "刷新失败，网络连接出错！", Toast.LENGTH_LONG);
				toast2.show();
			}
			pdialog.dismiss();
			re=result;
			if(re!=null)
			{
				int out = update();
				if(out==101)
				{
					Toast toaster = Toast.makeText(LightActivity.this, "刷新失败，该电视未注册！", Toast.LENGTH_LONG);
					toaster.show();
				}
			}
		}

		@Override
		protected void onPreExecute()
		{
			pdialog = new ProgressDialog(mContext);
			// 设置对话框的标题
			pdialog.setTitle("任务正在执行中");
			// 设置对话框 显示的内容
			pdialog.setMessage("任务正在执行中，请等待...");
			// 设置对话框不能用“取消”按钮关闭
			pdialog.setCancelable(false);
			// 设置该进度条的最大进度值
			pdialog.setMax(100);
			// 设置对话框的进度条风格
			pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// 设置对话框的进度条是否显示进度
			pdialog.setIndeterminate(false);
			pdialog.show();
		}

		@Override
		protected void onProgressUpdate(Integer... values)
		{
			// 更新进度
			//show.setText("已经读取了【" + values[0] + "】行！");
			pdialog.setProgress(values[0]);
		}
	}
	
}
