package services;

public class TaxCalculator {
	
	private Double annualIncomeSalary; 
	private Double annualIncomeServiceProvision;
	private Double annualIncomeCapitalGain; 
	private Double medicalExpenses;
	private Double educationalExpenses;
	
	public TaxCalculator() {
	}
	
	public TaxCalculator(Double annualIncomeSalary, Double annualIncomeServiceProvision, 
			Double annualIncomeCapitalGain, Double medicalExpenses, 
			Double educationalExpenses) {
		this.annualIncomeSalary = annualIncomeSalary;
		this.annualIncomeServiceProvision = annualIncomeServiceProvision;
		this.annualIncomeCapitalGain = annualIncomeCapitalGain;
		this.medicalExpenses = medicalExpenses;
		this.educationalExpenses = educationalExpenses;
	}

	public Double getAnnualIncomeSalary() {
		return annualIncomeSalary;
	}

	public Double getAnnualIncomeServiceProvision() {
		return annualIncomeServiceProvision;
	}

	public Double getAnnualIncomeCapitalGain() {
		return annualIncomeCapitalGain;
	}

	public Double getMedicalExpenses() {
		return medicalExpenses;
	}

	public Double getEducationalExpenses() {
		return educationalExpenses;
	}
	
	private Double wageTax() {
		double monthlySalary = annualIncomeSalary / 12.0;
		if(monthlySalary < 3000.0) {
			return 0.0;
		}
		else if(monthlySalary < 5000.0) {
			return annualIncomeSalary * 0.10;
		}
		else {
			return annualIncomeSalary * 0.20;
		}
	}
	
	private Double serviceTax() {
		return annualIncomeServiceProvision * 0.15;
	}
	
	private Double capitalGainTax() {
		return annualIncomeCapitalGain * 0.20;
	}
	
	private Double totalGrossTax() {
		return wageTax() + serviceTax() + capitalGainTax();
	}
	
	private Double maximumDeductible() {
		return totalGrossTax() * 0.3;
	}
	
	private Double deductibleExpenses() {
		return medicalExpenses + educationalExpenses;
	}
	
	private Double rebate() {
		if(deductibleExpenses() > maximumDeductible()) {
			return maximumDeductible();
		} else {
			return deductibleExpenses();
		}
	}
	
	private Double taxDue() {
		return totalGrossTax() - rebate();
	}
}
