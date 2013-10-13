package com.example.coupinionsc;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AnswerActivity extends Activity 
{	
	UserManager user = new UserManager(); //creates a new user, later data will be passed in arguments
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_answer);
		
		//get the user's answer choice from the intent passed to this activity
		Intent myIntent = getIntent();
		//IMPORTANT: this is the user's answer that needs to be recorded to the database
		char userChoice = myIntent.getExtras().getChar("userChoice"); //this is the answer to the daily question
		
		TextView textLevelDisplay = (TextView) this.findViewById(R.id.textPoints);
		textLevelDisplay.setText("Level: " + user.getLevel());
		
		//initializes the buttons on the answer screen
		Button buttonVisitUSC = (Button) this.findViewById(R.id.buttonVisitUSC);
		Button buttonViewCoupons = (Button) this.findViewById(R.id.buttonViewCoupons);
		Button buttonVisitCoup = (Button) this.findViewById(R.id.buttonVisitCoup);
		
		//*The Click Listeners*
		//opens the USC site
		buttonVisitUSC.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				 //a little fight on easter egg
				Toast.makeText(getApplicationContext(), "Fight On!", Toast.LENGTH_LONG).show();
				
				//if clicked, open the USC web site
				Uri uri = Uri.parse("http://www.usc.edu");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);				
			}
		});
		
		//goes to the coupon viewing page (not made yet)
		buttonViewCoupons.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				//WORK IN PROGRESS		
				//Intent intent = new Intent(AnswerActivity.this,  );
				//startActivity(intent);				
			}
		});
		
		//goes to the Coupinions main site
		buttonVisitCoup.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				//if clicked, open the Coupinions web site
				Uri uri = Uri.parse("http://www.coupinions.us");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);				
			}
		});
	}//ends onCreate
}//ends the class
