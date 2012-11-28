package net.georgkrause.depreciation.mixed;

public class MixedDepreciation {
	
	private float price;
	private float percentage;
	private float ratio;
	private int years;
	private float[] remain;
	float amount;
	
	MixedDepreciation(float price, float percentage, int years) {
		this.price = price;
		this.percentage = percentage;
		this.ratio = this.percentage / 100;
		this.years = years;
		this.remain = new float[this.years+1];
	}

	/**
	 * @param args
	 */
	public void calculate() {	
		
		this.remain[0] = this.price;
		
		for (int i = 1; i <= this.years; i++) { // calculate for all the years
			
			this.amount = this.ratio * this.remain[i-1]; // calculate amount for the given percentage
			
			if (this.amount >= (this.remain[i-1] / (this.years - i + 1))) { 
				remain[i] = remain[i-1] - this.amount;
				remain[i] = this.remain[i-1] - this.amount;
			} else {
				remain[i] = this.remain[i-1] - (this.remain[i-1] / (this.years - i + 1));
			}
		}
	}

	public float getDepreciationPercentage() {
		return this.percentage;
	}

	public float getDepreciationRemain(int year) {
		return remain[year];
	}

}