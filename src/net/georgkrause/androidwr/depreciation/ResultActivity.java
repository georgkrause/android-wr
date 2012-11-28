package net.georgkrause.androidwr.depreciation;

import net.georgkrause.androidwr.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

/**
 * shows a table with the result of the depreciation calculation
 * 
 * @author georgkrause
 * 
 */

public class ResultActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// select the layout for the activity
		setContentView(R.layout.activity_result);

		// get extras of the intent
		Bundle extras = getIntent().getExtras();

		// check if there are extras transfered
		if (extras == null) {
			return;
		}

		// load the values from the extras
		float price = (Integer) extras.get("price");
		int years = (Integer) extras.get("years");
		
		LinearDepreciation depreciation = new LinearDepreciation(price, years);
		depreciation.calculate();

		for(int i = 0; i <= years; i++) {
			float remain = depreciation.getDepreciationRemain(i);
			this.newTableRow(i, remain);
		}
	}

	/**
	 * adds a new Row to the result-table
	 * 
	 * @param year
	 * @param value
	 */
	public void newTableRow(int year, float value) {

		// select table layout and create new TableRow
		TableLayout table = (TableLayout) findViewById(R.id.resultTable);
		TableRow row = new TableRow(this);

		// Adds the year to a new TextView
		TextView text_year = new TextView(this);
		text_year.setText(Integer.toString(year));

		// Sets Layout for the TextView of the year
		TextView TV_year = (TextView) findViewById(R.id.ResultTableYears);
		LayoutParams layoutParamsYears = (LayoutParams) TV_year
				.getLayoutParams();
		text_year.setLayoutParams(layoutParamsYears);

		// Adds the TextView to the TableRow
		row.addView(text_year);

		// Adds the value to a new TextView
		TextView text_value = new TextView(this);
		text_value.setText(Float.toString(value));

		// Sets Layout for the TextView of the value
		TextView TV_value = (TextView) findViewById(R.id.ResultTableValue);
		LayoutParams layoutParamsValue = (LayoutParams) TV_value
				.getLayoutParams();
		text_year.setLayoutParams(layoutParamsValue);

		// Adds the TextView to the TableRow
		row.addView(text_value);

		// Adds the TableRow to the TableLayout
		table.addView(row, new TableLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	}

}
