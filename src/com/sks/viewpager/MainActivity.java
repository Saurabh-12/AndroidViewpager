package com.sks.viewpager;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends Activity {
	int noofsize = 5;
	ViewPager myPager = null;
	int count = 0;
	Timer timer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewPagerAdapter adapter = new ViewPagerAdapter(MainActivity.this,
				noofsize);
	    myPager = (ViewPager) findViewById(R.id.reviewpager);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);
		
		timer  = new Timer();
		timer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
             		   if(count<=5){
            			   myPager.setCurrentItem(count);
            			   count++;
            			   }else{
            				   count = 0;
            				   myPager.setCurrentItem(count);
            			   }
                    }
                });
            }
        }, 500, 3000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
