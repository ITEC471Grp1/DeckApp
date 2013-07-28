package com.itec471.deckcalculator;

import java.sql.Connection;
import java.util.ArrayList;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

/**
 * The output activity. Displays the calculated deck
 *  info and materials list and provides a save button
 * @author Jamie
 *
 */
public class ActivityDisplayMaterialsList extends Activity {
	public final static String TAG = "Saving to DB";
	ArrayList<String> messages;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_materials);
		
		final TextView areaView = (TextView) findViewById(R.id.area);	
		final TextView priceView = (TextView) findViewById(R.id.total_price);
		final GridView gridView = (GridView) findViewById(R.id.grid_view);
		
		// Display the total square feet
		MaterialsCalculator calc = MaterialsCalculator.getInstance(null);
		areaView.setText(calc.getSquareFeetString());
		
		// Get the message from the intent
		Intent intent = getIntent();
		messages = intent.getExtras().getStringArrayList(ActivityCalulatorMain.OUTPUT_MESSAGE);
		
		// Create an adapter to display the list
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
				this,
				R.layout.list_layout,
				R.id.text_view1,
				messages);
		gridView.setAdapter(listAdapter);
		
		// Display the total price
		priceView.setText(calc.getPriceString());
		
		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_display_materials, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
	
	public void savePlan(View view){
		// Create the intent for output
    	Intent intent = new Intent(this, SaveActivity.class);
    	intent.putStringArrayListExtra("ar", messages);
    	startActivity(intent);
	}
}
