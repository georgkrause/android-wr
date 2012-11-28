/**
 * 
 */
package net.georgkrause.depreciation;

import net.georgkrause.depreciation.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Start Activity of the app
 * @author georgkrause
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button call_depreciation_linear = (Button) findViewById(R.id.call_depreciation_linear);

		call_depreciation_linear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent LinearDepreciation = new Intent(
						MainActivity.this,
						net.georgkrause.depreciation.linear.CalculatorActivity.class);
				startActivity(LinearDepreciation);
			}
		});
		
		Button call_depreciation_mixed = (Button) findViewById(R.id.call_depreciation_mixed);
		call_depreciation_mixed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent MixedDepreciation = new Intent(
						MainActivity.this,
						net.georgkrause.depreciation.mixed.CalculatorActivity.class);
				startActivity(MixedDepreciation);
			}
		});
	}

}
