package entities;

public class Individual extends TaxPayer {
	private Double healthExpenditures;

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double taxValue() {
		double tax = 0.0;

		if (anualIncome < 200)
			tax = anualIncome * 0.15;
		else if (anualIncome >= 20000)
			tax = anualIncome * 0.25;

		if (healthExpenditures > 0)
			tax -= (healthExpenditures * 0.50);
		return tax;
	}

}
