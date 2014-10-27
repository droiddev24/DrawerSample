package com.example.drawersample;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author Vishwas Sharma
 * This activity is to show the fully custom use of Drawer layout.
 * In this drawer layout, nothing is default of Android. We have customized every single thing in here.
 * This is activity with no title bar. We have a title bar of our own. We can do everything as we want.
 */
public class MainActivity extends Activity implements OnClickListener {

	private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.2F);

	private Button activity2Bt;
	private RelativeLayout flyoutDrawerRl;
	private DrawerLayout mDrawerLayout;
	private ImageView flyoutIv;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//this is left layout, that stays hidden and is only shown on button click
		flyoutDrawerRl=(RelativeLayout)findViewById(R.id.left_drawer);
		
		//this is parent layout
		mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
		mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
		
		//top left button on screen, on which click, we will open drawer
		flyoutIv=(ImageView)findViewById(R.id.iv_menu);
		flyoutIv.setOnClickListener(this);
		
		//you can get all the buttons in layout and do whatever you want.
		activity2Bt=(Button)findViewById(R.id.bt_activity2);
		activity2Bt.setOnClickListener(this);

		//this method contains code for setting open and close listeners on drawer layout/flyout menu
		setListenerOnDrawer();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.iv_menu:
			//we are giving an animation on button click, so that it looks like
			//button was actually clicked.
			v.startAnimation(buttonClick);
			if(mDrawerLayout.isDrawerOpen(flyoutDrawerRl)){
				mDrawerLayout.closeDrawers();
			}
			else{
				mDrawerLayout.openDrawer(flyoutDrawerRl);
			}
			break;
		case R.id.bt_activity2:
			//start another activity here on button click or do anything you want on that button click
			break;
		}
	}

	//following overriden methods are essestial for setting up drawer layout
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		//we can handle other action bar items here later...

		return super.onOptionsItemSelected(item);
	}

	//this methods sets the listeners on drawer layout
	private void setListenerOnDrawer(){
		mDrawerToggle=new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_launcher,
				R.string.app_name, R.string.app_name){
			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
			}
		};
		//		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

}
