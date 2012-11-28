package net.georgkrause.androidwr.depreciation;

import net.georgkrause.androidwr.R;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

/**
 * shows a form to calculate depreciation
 * 
 * @author georgkrause
 * 
 */

public class LinearDepreciationActivity extends Activity implements OnClickListener {

	private Button calculateButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_depreciation_calculator);

		calculateButton = (Button) findViewById(R.id.calculate_button);
		calculateButton.setOnClickListener(this);
	}

	@SuppressLint("ShowToast")
	@Override
	public void onClick(View v) {

		// create intent to call another activity
		final Intent resultIntent = new Intent(this,
				net.georgkrause.androidwr.depreciation.ResultActivity.class);

		// read inputs and safe them in the extras of the intent
		try {
			EditText valuePrice = (EditText) findViewById(R.id.input_value_price);
			int valuePriceInt = Integer.parseInt(valuePrice.getText()
					.toString());
			resultIntent.putExtra("price", valuePriceInt);

			EditText valueYears = (EditText) findViewById(R.id.input_value_years);
			int valueYearsInt = Integer.parseInt(valueYears.getText()
					.toString());
			resultIntent.putExtra("years", valueYearsInt);
		} catch (NumberFormatException e) {

			Toast Error = Toast.makeText(this, "Bitte fülle alle Felder aus!", Toast.LENGTH_SHORT);
			Error.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
			Error.show();
			
			return;
		}

		// calls the result activity
		startActivity(resultIntent);
	}
}
