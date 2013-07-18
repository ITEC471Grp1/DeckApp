package com.itec471.deckcalculator;
//Chris GitHub test 7/12
//Matt H Test 7/15/2013 Another test from me again
//Jamie GitHub test 7/13
//Brandon test 7/15

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.util.Log;

/**
 * The main activity. Displays screen for entering deck information
 *   and passes the input to other classes for calculations, then
 *   starts the output activity.
 * @author ITEC-471 Grp2
 *
 */
public class CalulatorMain extends Activity {
	public final static String OUTPUT_MESSAGE = "com.itec471.deckcalculator.MESSAGE";
	public final static String TAG = "CalculatorMain";
	public ArrayList<String> results = new ArrayList<String>();
	private Configuration configuration;

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
     *  Initiates calculations and output for the deck
     *  @param view
     */
    public void initiateCalc(View view){
    	double len = 0, width = 0, height = 0, sqft = 0;
    	
    	// Create the intent for output
    	Intent intent = new Intent(this, DisplayCalculations.class);
    	
    	// Get the values input by user
    	EditText lenText = (EditText)findViewById(R.id.edit_length);
    	EditText widthText = (EditText)findViewById(R.id.edit_width);
    	EditText heightText = (EditText)findViewById(R.id.edit_height);
    	
    	// Convert string input to doubles. If nothing was input the 
    	//  value will be 0 and an error will be logged
    	try{
    		len = Double.valueOf(lenText.getText().toString());
    		width = Double.valueOf(widthText.getText().toString());
    		height = Double.valueOf(heightText.getText().toString());
    	}
    	catch(Exception e){
    		Log.e(TAG, "Error converting input to double");
    	}    	
    	
    	// Create the deck configuration
    	configuration = Configuration.getInstance(len, width, height);
    	
    	// Calculate total sq feet and add to output
    	sqft = configuration.getSqft();
    	results.add("Total Square Feet: " + sqft);
    	
    	// Add some formatting
    	results.add("  ");
    	results.add("Materials");
    	
    	// Create a calculator using the configuration argument
    	MaterialsCalculator calc = new MaterialsCalculator(configuration);
    	
    	// Get the list of lumber and add to the output
    	List<String> temp = calc.calculateLumber();
    	results.addAll(temp);
    	
    	// Get the list of hardware and add to the output
    		// to do....create the needed methods in the Hardware
    	    //   and MaterialsCalculator classes
    	
    	// Get the total price and add to output
    	results.add("  ");
    	results.add("Total Price: " + calc.getTotalPrice());
    	
    	// Pass the array to the the intent and start the activity
    	intent.putStringArrayListExtra(OUTPUT_MESSAGE, results);
    	startActivity(intent);    	
    }    
}
