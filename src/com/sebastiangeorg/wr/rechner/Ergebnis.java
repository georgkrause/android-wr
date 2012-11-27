package com.sebastiangeorg.wr.rechner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

public class Ergebnis extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_result);
	    
	    Bundle extras = getIntent().getExtras();
	    
	    if(extras == null) {
	    	return;
	    }
	    
	    float price =  (Integer) extras.get("price");
	    int years = (Integer) extras.get("years");
	    float percentage = (Integer) extras.get("percentage");
	    //float percentage = (float) 1.0;
	    
	    this.newTableRow(years, percentage);
		this.newTableRow(years, price);
	}
	
	public void newTableRow(int year, float value) {
		TableLayout table = (TableLayout) findViewById(R.id.resultTable);
		TableRow row = new TableRow(this);

		// create a new TextView
		TextView text_year = new TextView(this);
		// set the text to "text xx"
		text_year.setText(Integer.toString(year));

		final TextView TV_year = (TextView) findViewById(R.id.ResultTableYears);
		final LayoutParams layoutParamsYears = (LayoutParams) TV_year
				.getLayoutParams();

		text_year.setLayoutParams(layoutParamsYears);
		
		row.addView(text_year);

		// create a new TextView
		TextView text_value = new TextView(this);
		// set the text to "text xx"
		text_value.setText(Float.toString(value));

		final TextView TV_value = (TextView) findViewById(R.id.ResultTableValue);
		final LayoutParams layoutParamsValue = (LayoutParams) TV_value
				.getLayoutParams();

		text_year.setLayoutParams(layoutParamsValue);

		row.addView(text_value);

		table.addView(row, new TableLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	}

}
