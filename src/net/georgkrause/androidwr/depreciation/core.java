package net.georgkrause.androidwr.depreciation;


public class core {
	
	/**
	 * 
	 * @param value Geld
	 * @param percentage Prozentsatz
	 * @param years Jahre
	 */
	public float calculate(float value, float percentage, int years) {
		
		float linear = 0; // Restbetrag
		for (int year = years; year > 0; year--) {
			percentage = percentage / 100;
			linear = percentage * value;
			if (linear >= (value / year)) {
				value = value - linear;
				return value;
			} else {
				value = value - (value / year);
				return value;
			}

		}
		return 0;

	}

}