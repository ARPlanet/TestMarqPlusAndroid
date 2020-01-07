package com.example.testmarqplus;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("NewApi") public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button Btn=(Button)findViewById(R.id.btn55);
		Btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view){

				if(isAppInstalled("com.marq.plus")==true){
					Intent intent = new Intent(); 					
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("marqplus://com.marq.plus/"));
					//ComponentName comp = new ComponentName("com.marq.plus", "com.marq.plus.unity.MarqUnityPlayerActivity");
					//intent.setComponent(comp);
					MainActivity.this.startActivity(intent);	
				}else{
					Intent intent = new Intent(); 					
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.marq.plus"));
					MainActivity.this.startActivity(intent);	
				}								
			}
		});	
	}
	private boolean isAppInstalled(String packageName) {
	    PackageManager pm = getPackageManager();
	    boolean installed = false;
	    try {
	       pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
	       installed = true;
	    } catch (PackageManager.NameNotFoundException e) {
	       installed = false;
	    }
	    return installed;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
