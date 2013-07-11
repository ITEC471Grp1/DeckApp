package com.itec471.deckcalculator;

import java.sql.Connection;
import java.util.ArrayList;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

/**
 * The output activity. Displays the calculated deck
 *  info and materials list and provides a save button
 * @author Jamie
 *
 */
public class DisplayCalculations extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_calculations);
		
		final GridView gridview = (GridView) findViewById(R.id.grid_view);
		
		// Get the message from the intent
		Intent intent = getIntent();
		ArrayList<String> messages = 
				intent.getExtras().getStringArrayList(CalulatorMain.OUTPUT_MESSAGE);
		
		// Create an adapter to display the list
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
				this,
				R.layout.list_layout,
				R.id.text_view1,
				messages);
		gridview.setAdapter(listAdapter);
		
		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_calculations, menu);
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
	
	public void saveToDb(View view){
		// to do...save the data to the database
		Configuration config = Configuration.getInstance();
		DBConn.save("jrouse5@radford.edu", "My Deck", config.getHeight(), config.getLength(),
					 config.getWidth(), config.getSqft()); 
	}
}
