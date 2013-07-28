package com.itec471.deckcalculator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;

public class SaveActivity extends Activity {
	public final static String TAG = "SaveActivity";
	ArrayList<String> messages;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save);
		// Show the Up button in the action bar.
		setupActionBar();
		
		// Get the message from the intent
		Intent intent = getIntent();
		messages = intent.getExtras().getStringArrayList("ar");
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.save, menu);
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
	
	/**
	 * Attempts to save the data to a database. If the database is 
	 *  unavailable, the data is saved to a file.
	 * @param view
	 */
	public void saveToDb(View view){
		// to do...save the data to the database
		final TextView errorView = (TextView) findViewById(R.id.invalid_input);
		DeckModel deckModel = DeckModel.getInstance();
		String email ="";
		String planName ="";
		boolean hasInput = false;
		
		// reset the error message
		errorView.setText("");
		
		EditText emailText = (EditText)findViewById(R.id.edit_email);
    	EditText planNameText = (EditText)findViewById(R.id.edit_planname);
    	
    	// get the exitText content	
    	email = emailText.getText().toString();
    	planName = planNameText.getText().toString();
    	
    	// check for something input
    	if (!email.equals("") && !planName.equals("")){
    		hasInput = true;
    	}
    	else{
    		errorView.setText("You must enter an email and plan name");
    	}
    	
    	// if there was input proceed
    	if (hasInput){    	
	    	/* database connection in progress
	    	try{
	    		DBConn.save(email, planName, deckModel.getHeight(), deckModel.getLength(),
						 deckModel.getWidth(), deckModel.getSqft()); 
	    	} catch (Exception e){ */
	    //		Log.e(TAG, "Cannot save to database. Database unavailable.");
	    		saveToFile(view, email, planName, this);
	    //	}
    	}
   	}
	
	/**
	 * Saves the materials list to a file
	 * @param view
	 * @param email
	 * @param planName
	 * @param context
	 */
	public void saveToFile(View view, String email, String planName, ContextWrapper context){
		final TextView errorView = (TextView) findViewById(R.id.invalid_input);
		MaterialsCalculator calc;
		
		try {
		//	OutputStream out = context.openFileOutput("materialsLists.txt", Context.MODE_APPEND);
			OutputStreamWriter out = new OutputStreamWriter(openFileOutput("materialsLists.txt", 0));
			BufferedWriter bw = new BufferedWriter(out);
			calc = MaterialsCalculator.getInstance();
			String [] files = context.fileList();
			
			// write the email and plan name to identify the list
			bw.write(email);
			bw.newLine();
			bw.write(planName);
			bw.newLine();
			
			// write the number of square feet
			bw.write(calc.getSquareFeetString());
			bw.newLine();
			
			// write the list of materials
			for (String str : messages){
				bw.write(str);
				bw.newLine();
			}
			
			// write the total price
			bw.write(calc.getPriceString());
			bw.newLine();
			
			// write a flag to indicate end of list
			bw.write("eol");
			bw.newLine();
			
			// save and close
			bw.flush();
			bw.close();
			
			// display success message
			errorView.setText("Plan Save Successful!");
			
		} catch (IOException e) {
			errorView.setText("Unable To Save Plan");
			String tag = "SaveActivity";
			Log.e(tag , "File not found");
		}
		
	}
}
