package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double incSal, incServ, incCapGain, medExpenses, educExpenses;
		
		System.out.print("Annual income with salary: $ ");
		incSal = sc.nextDouble();
		System.out.print("Annual income with service provision: $ ");
		incServ = sc.nextDouble();
		System.out.print("Annual income with capital gain: $ ");
		incCapGain = sc.nextDouble();
		System.out.print("Medical expenses: $ ");
		medExpenses = sc.nextDouble();
		System.out.print("Educational expenses: $ ");
		educExpenses = sc.nextDouble();
		
		sc.close();
	}

}
