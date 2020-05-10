package Bucks;

import java.util.Scanner;

class takeHomeTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter your Annual Salary :");
        double PF = 0D, houseLoanInt = 0D;
        double annualSalary = scan.nextDouble();
        boolean oldTaxRegulation;
        scan.nextLine();
        System.out.println("Are you paying interest on your homeloan?");
        String homeLoanind = scan.nextLine().toUpperCase();
        if (homeLoanind.equals("Y") || homeLoanind.equals("YES")) {
            System.out.println("What is you interest component for the whole year?");
            houseLoanInt = scan.nextDouble();
            if (houseLoanInt > 200000) houseLoanInt = 200000.0D;
            if (houseLoanInt < 200000) houseLoanInt = 0.0D;
        }

        System.out.println("Do you know your PF deduction?");
        String PFind = scan.nextLine().toUpperCase();
        if (PFind.equals("Y") || PFind.equals("YES")) {
            System.out.println("What is your monthly PF deduction?");
            PF = scan.nextDouble();
            if (PF < 0) PF = 0.0D;
        } else {
            PF = (annualSalary * 0.4 * 0.12) / 12;
        }

        takeHome takeHomeInstance = new takeHome(annualSalary, houseLoanInt ,PF);

        takeHomeInstance.calculateOldTakeHome();
        oldTaxRegulation = true;
        takeHomeInstance.printSummary(oldTaxRegulation);

        takeHomeInstance.calculateNewTakeHome();
        oldTaxRegulation = false;
        takeHomeInstance.printSummary(oldTaxRegulation);

        scan.close();
    }
}