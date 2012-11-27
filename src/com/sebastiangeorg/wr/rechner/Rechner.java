package com.sebastiangeorg.wr.rechner;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;

/**
 * import android.view.Menu; import android.view.View; import
 * android.view.View.OnClickListener; import android.widget.Button;
 */

public class Rechner extends Activity implements OnClickListener {

	private Button calculateButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rechner);

		calculateButton = (Button) findViewById(R.id.calculate_button);
		calculateButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		final Intent intent = new Intent(this,
				com.sebastiangeorg.wr.rechner.Ergebnis.class);

		EditText valuePrice = (EditText) findViewById(R.id.input_value_price);
		int valuePriceInt = Integer.parseInt(valuePrice.getText().toString());
		intent.putExtra("price", valuePriceInt);
		
		EditText valuePercentage = (EditText) findViewById(R.id.input_value_percentage);
		int valuepercentageInt = Integer.parseInt(valuePercentage.getText().toString());
		intent.putExtra("percentage", valuepercentageInt);
		
		EditText valueYears = (EditText) findViewById(R.id.input_value_years);
		int valueYearsInt = Integer.parseInt(valueYears.getText().toString());
		intent.putExtra("years", valueYearsInt);

		startActivity(intent);
	}

}
