package com.itec471.deckcalculator;

import java.text.NumberFormat;
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
public class ActivityCalulatorMain extends Activity {
	public final static String OUTPUT_MESSAGE = "com.itec471.deckcalculator.MESSAGE";
	public final static String TAG = "CalculatorMain";
	public ArrayList<String> results = new ArrayList<String>();
	private DeckModel deckModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_calulator_main, menu);
        return true;
    }
    
    /**
     *  Initiates calculations and output for the deck
     *  @param view
     */
    public void initiateCalc(View view){
    	double len = 0, width = 0, height = 0;
    	
    	// Create the intent for output
    	Intent intent = new Intent(this, ActivityDisplayMaterialsList.class);
    	
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
    	deckModel = DeckModel.getInstance(len, width, height);
    	
    	// Set the type of decking
    	deckModel.setDeckingType(MaterialType.SPAN_RATED_DECKING);
    	
    	// Create a calculator using the configuration argument
    	MaterialsCalculator calc = MaterialsCalculator.getInstance(this.getAssets());
    	
    	// Get the list of lumber and add to the output
    	List<String> temp = calc.calculateMaterials();
    	results.addAll(temp);
    	
    	// Pass the array to the the intent and start the activity
    	intent.putStringArrayListExtra(OUTPUT_MESSAGE, results);
    	startActivity(intent);    	
    }    
}
