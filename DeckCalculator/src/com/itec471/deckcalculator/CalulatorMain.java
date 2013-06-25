package com.itec471.deckcalculator;
// Brandon was here
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
/*
TEST-Added by CA 6/24/13 nore stuff*/
public class CalulatorMain extends Activity {
	public final static String SQFT_MESSAGE = "com.itec471.deckcalculator.MESSAGE";
	public final static String[] messages = {"Total Sq Feet: ", "Materials: ", "Total Price: "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calulator_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calulator_main, menu);
        return true;
    }
    
    /**
     *  Makes all necessary calculations for the deck
     */
    public void overallCalc(View view){
    	double len, width, sqft;
    	
    	Intent intent = new Intent(this, DisplayCalculations.class);
    	EditText lenText = (EditText)findViewById(R.id.edit_length);
    	EditText widthText = (EditText)findViewById(R.id.edit_width);
    	len = Double.valueOf(lenText.getText().toString());
    	width = Double.valueOf(widthText.getText().toString());
    	sqft = sqCalc(len, width);
    	intent.putExtra(SQFT_MESSAGE, String.valueOf(messages[0] + sqft));
    	startActivity(intent);
    	
    }
    
    private double sqCalc(double len, double width){
    	double conversionFactor = 144.0;
		
		return len * width / conversionFactor;
	}
    
}

//Testing to see if this is visible. 
//Test again MH

