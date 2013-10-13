package com.example.coupinionsc;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import com.androidplot.pie.PieChart;
import com.androidplot.pie.PieRenderer;
import com.androidplot.pie.Segment;
import com.androidplot.pie.SegmentFormatter;
import com.example.coupinions.R;

public class AnswerActivity extends Activity 
{	

    private TextView donutSizeTextView;
    private SeekBar donutSizeSeekBar;

    private PieChart pie;

    private Segment s1;
    private Segment s2;
    private Segment s3;
    private Segment s4;
    
    //Number of votes for each answer choice, updated from database
    private int votes1;
    private int votes2;
    private int votes3;
    private int votes4;
    
    //The actual answer choices, updated from database
    private String opinion1;
    private String opinion2;
    private String opinion3;
    private String opinion4;    
	
	UserManager user = new UserManager(); //creates a new user, later data will be passed in arguments
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		this.setContentView(R.layout.activity_answer);
		
		//get the user's answer choice from the intent passed to this activity
		Intent myIntent = getIntent();
		//IMPORTANT: this is the user's answer that needs to be recorded to the database
		char userChoice = myIntent.getExtras().getChar("userChoice"); //this is the answer to the daily question
				
		TextView textLevelDisplay = (TextView) this.findViewById(R.id.textPoints);
		textLevelDisplay.setText("Level: " + user.getLevel());
		
		//DISPLAYING GRAPHS FOR RESULTS
		//for demo purposes, made up data
        //real numbers and strings should be obtained from database
        votes1 = 50; votes2 = 34; votes3 = 78; votes4 = 32;
        opinion1 = "Opinion1"; opinion2 = "Opinion2"; opinion3 = "Opinion3"; opinion4 = "Opinion4";
        
        // initialize our XYPlot reference:
        pie = (PieChart) findViewById(R.id.mySimplePieChart);               
        donutSizeSeekBar = (SeekBar) findViewById(R.id.donutSizeSeekBar);
        
        donutSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {}

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                pie.getRenderer(PieRenderer.class).setDonutSize(seekBar.getProgress()/100f,
                        PieRenderer.DonutMode.PERCENT);
                pie.redraw();
                updateDonutText();
            }
        });

        donutSizeTextView = (TextView) findViewById(R.id.donutSizeTextView);
        updateDonutText();
        

        s1 = new Segment(opinion1, votes1);
        s2 = new Segment(opinion2, votes2);
        s3 = new Segment(opinion3, votes3);
        s4 = new Segment(opinion4, votes4);

        pie.addSeries(s1, new SegmentFormatter(
                Color.rgb(193,28,28), Color.DKGRAY,Color.DKGRAY, Color.DKGRAY));
        pie.addSeries(s2, new SegmentFormatter(
                Color.rgb(135,208,127), Color.DKGRAY,Color.DKGRAY, Color.DKGRAY));
        pie.addSeries(s3, new SegmentFormatter(
                Color.rgb(239,232,33), Color.DKGRAY,Color.DKGRAY, Color.DKGRAY));
        pie.addSeries(s4, new SegmentFormatter(
                Color.rgb(31,150,201), Color.DKGRAY,Color.DKGRAY, Color.DKGRAY));

        pie.getBorderPaint().setColor(Color.RED);
        pie.getBackgroundPaint().setColor(Color.TRANSPARENT);
	}
	
	
	    protected void updateDonutText() {
	        donutSizeTextView.setText(donutSizeSeekBar.getProgress() + "%");
	    
		
	    //BUTTON FUNCTIONALITY	 
		
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
				//WORK IN PROGRESS, currently using for graph testing purposes		
				//Intent intent = new Intent(AnswerActivity.this, PlotActivity.class);
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
