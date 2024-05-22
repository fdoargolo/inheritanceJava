package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<TaxPayer> taxPayer = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int numberPayers = scanner.nextInt();
		scanner.nextLine();

		for (int i = 1; i <= numberPayers; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char accountType = scanner.next().charAt(0);
			scanner.nextLine();
			System.out.print("Name: ");
			String payerName = scanner.nextLine();
			System.out.print("Anual income: ");
			double payerIncome = scanner.nextDouble();

			if (accountType == 'i') {
				
				System.out.print("Health expenditures: ");
				double healthExpenditures = scanner.nextDouble();
				taxPayer.add(new Individual(payerName, payerIncome, healthExpenditures));
				
			} else if (accountType == 'c') {
				
				System.out.print("Number of employees: ");
				int numberEmployees = scanner.nextInt();
				scanner.nextLine();
				taxPayer.add(new Company(payerName, payerIncome, numberEmployees));
				
			}
		}
		
		System.out.println("\nTAXES PAID:");
		double totalTaxes = 0.0;

		for (TaxPayer account : taxPayer) {
			totalTaxes += account.taxValue();
			System.out.println(account.getName() + ": $ " + String.format("%.2f", account.taxValue()));
		}

		System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", totalTaxes));
		scanner.close();
	}

}
