package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double annualIncomeSalary, annualIncomeServiceProvision, annualIncomeCapitalGain, 
		medicalExpenses, educationalExpenses;
		
		System.out.print("Annual income with salary: $ ");
		annualIncomeSalary = sc.nextDouble();
		System.out.print("Annual income with service provision: $ ");
		annualIncomeServiceProvision = sc.nextDouble();
		System.out.print("Annual income with capital gain: $ ");
		annualIncomeCapitalGain = sc.nextDouble();
		System.out.print("Medical expenses: $ ");
		medicalExpenses = sc.nextDouble();
		System.out.print("Educational expenses: $ ");
		educationalExpenses = sc.nextDouble();
		
		sc.close();
	}

}
