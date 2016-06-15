package com.example.zxingtest;

import com.zxing.activity.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.main_activity);
		
		Intent intent = new Intent(MainActivity.this,CaptureActivity.class);
		startActivityForResult(intent, 0);
		
		((Button)this.findViewById(R.id.startBtn)).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				Intent intent = new Intent(MainActivity.this,CaptureActivity.class);
				startActivityForResult(intent, 0);
			}
		});
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		android.util.Log.d("test20141010", "resultCode="+resultCode);
		
		if (resultCode == RESULT_OK) {
			
			Toast.makeText(this, "骚描完成", Toast.LENGTH_SHORT).show();
			
			Bundle bundle = data.getExtras();
			String scanResult = bundle.getString("result");
			((TextView)this.findViewById(R.id.resultTxt)).setText(scanResult);
		}else{
			
			Toast.makeText(this, "扫描取消", Toast.LENGTH_SHORT).show();
			
		}
		
	}
	
}
