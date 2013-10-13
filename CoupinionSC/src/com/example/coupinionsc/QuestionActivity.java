package com.example.coupinionsc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuestionActivity extends Activity {

	//declare variables
	private static final char CHOICE_A = 'a';
	private static final char CHOICE_B = 'b';
	private static final char CHOICE_C = 'c';
	private static final char CHOICE_D = 'd';
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		
		//code for the buttons
		Button answerA = (Button) this.findViewById(R.id.answerButtonA);
		Button answerB = (Button) this.findViewById(R.id.answerButtonB);
		Button answerC = (Button) this.findViewById(R.id.answerButtonC);
		Button answerD = (Button) this.findViewById(R.id.answerButtonD);
		
		//*The Click Listeners*
		//pass choice a to the answer activity
		answerA.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				//a toast to tell the user what they chose
				Toast.makeText(getApplicationContext(), "You have chosen option " + CHOICE_A, Toast.LENGTH_LONG).show();
				//moves onto the next activity and passes the choice on
				Intent intent = new Intent(QuestionActivity.this, AnswerActivity.class);
				intent.putExtra("userChoice", CHOICE_A); //also pass in the user's answer
				startActivity(intent); //switch activities
			}
		});
		
		//pass choice b to the answer activity
		answerB.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				//a toast to tell the user what they chose
				Toast.makeText(getApplicationContext(), "You have chosen option " + CHOICE_B, Toast.LENGTH_LONG).show();
				//moves onto the next activity and passes the choice on
				Intent intent = new Intent(QuestionActivity.this, AnswerActivity.class);
				intent.putExtra("userChoice", CHOICE_B);
				startActivity(intent); //switch activities
			}
		});
		
		//pass choice c to the answer activity
		answerC.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				//a toast to tell the user what they chose
				Toast.makeText(getApplicationContext(), "You have chosen option " + CHOICE_C, Toast.LENGTH_LONG).show();
				//moves onto the next activity and passes the choice on
				Intent intent = new Intent(QuestionActivity.this, AnswerActivity.class);
				intent.putExtra("userChoice", CHOICE_C);
				startActivity(intent); //switch activities
			}
		});
				
		//pass choice d to the answer activity
		answerD.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				//a toast to tell the user what they chose
				Toast.makeText(getApplicationContext(), "You have chosen option " + CHOICE_D, Toast.LENGTH_LONG).show();
				//moves onto the next activity and passes the choice on
				Intent intent = new Intent(QuestionActivity.this, AnswerActivity.class);
				intent.putExtra("userChoice", CHOICE_D);
				startActivity(intent); //switch activities
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
		return true;
	}

}
