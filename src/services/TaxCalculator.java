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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nINCOME TAX REPORT\n");
		sb.append("\nCONSOLIDATED INCOME:\n");
		sb.append("Wage tax: $ " + String.format("%.2f%n", wageTax()));
		sb.append("Service tax: $ " + String.format("%.2f%n", serviceTax()));
		sb.append("Capital gain tax: $ " + String.format("%.2f%n", capitalGainTax()));
		sb.append("\nDEDUCTIONS:\n");
		sb.append("Maximum deductible: $ " + String.format("%.2f%n", maximumDeductible()));
		sb.append("Deductible expenses: $ " + String.format("%.2f%n", deductibleExpenses()));
		sb.append("\nSUMMARY:\n");
		sb.append("Total gross tax: $ " + String.format("%.2f%n", totalGrossTax()));
		sb.append("Rebate: $ " + String.format("%.2f%n", rebate()));
		sb.append("Tax due: $ " + String.format("%.2f%n", taxDue()));
		return sb.toString();
	}
}
