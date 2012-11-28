package net.georgkrause.depreciation.linear;

/**
 * Calculate the linear Depreciation
 * 
 * @author georgkrause
 * 
 */
public class LinearDepreciation {

	private float price;
	private int years;
	private float percentage;
	private float amount;

	LinearDepreciation(float price, int years) {
		this.price = price;
		this.years = years;
	}

	public void calculate() {
		this.amount = this.price / this.years;
		this.percentage = this.amount / this.price * 100;
	}

	public float getDepreciationAmount() {
		return this.amount;
	}

	public float getDepreciationPercentage() {
		return this.percentage;
	}

	public float getDepreciationRemain(int year) {
		float remain = 0;
		if (year <= this.years) {
			remain = this.price - (this.amount * year);
		}
		return remain;
	}
}
