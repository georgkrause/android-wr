package net.georgkrause.androidwr.depreciation;

import net.georgkrause.androidwr.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;

/**
 * shows a form to calculate depreciation
 * 
 * @author georgkrause
 * 
 */

public class CalculatorActivity extends Activity implements OnClickListener {

	private Button calculateButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);

		calculateButton = (Button) findViewById(R.id.calculate_button);
		calculateButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		// create intent to call another activity
		final Intent resultIntent = new Intent(this,
				net.georgkrause.androidwr.depreciation.ResultActivity.class);

		// read inputs and safe them in the extras of the intent
		EditText valuePrice = (EditText) findViewById(R.id.input_value_price);
		int valuePriceInt = Integer.parseInt(valuePrice.getText().toString());
		resultIntent.putExtra("price", valuePriceInt);

		EditText valuePercentage = (EditText) findViewById(R.id.input_value_percentage);
		int valuepercentageInt = Integer.parseInt(valuePercentage.getText()
				.toString());
		resultIntent.putExtra("percentage", valuepercentageInt);

		EditText valueYears = (EditText) findViewById(R.id.input_value_years);
		int valueYearsInt = Integer.parseInt(valueYears.getText().toString());
		resultIntent.putExtra("years", valueYearsInt);

		// calls the result activity
		startActivity(resultIntent);
	}

}
