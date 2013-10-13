package com.example.coupinionsc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class SignIn extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		// Show the Up button in the action bar.
		setupActionBar();
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
	
	 /** Called when the user clicks the Sign In button */
    public void verifySignIn(View page0) {
        // Normally, this would go and verify the User's information with the db
    	// Currently, it goes straight to the question page
    	Intent intent = new Intent(this, QuestionActivity.class);
    	startActivity(intent);    	
    }
     /** Called when the user clicks the Sign Up button */
    public void signUpPage(View page1) {
    	// Goes to the Sign Up Page
    	Intent intent = new Intent(this, SignUpPage.class);
    	startActivity(intent);
    }
    /** Called when the user clicks the Hack On! button */
    public void displayLogo(View page2) {
    	//Displays the HackSC Logo
    	Intent intent = new Intent(this, HackSCLogo.class);
    	startActivity(intent);
    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_in, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
