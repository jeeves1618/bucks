package Bucks;

import java.text.DecimalFormat;
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
        printSummary(oldTaxRegulation, takeHomeInstance);

        takeHomeInstance.calculateNewTakeHome();
        oldTaxRegulation = false;
        printSummary(oldTaxRegulation, takeHomeInstance);

        scan.close();
    }
    public static void printSummary(boolean oldRegieme, takeHome takeHomeInstance) {
        DecimalFormat ft = new DecimalFormat("Rs ##,##,###.##");
        
        System.out.println(" ");
        if (oldRegieme){
            System.out.println("================= SALARY COMPUTATION WITH DEDUCTIONS (OLD) ===================");
        }
        else{
            System.out.println("================= SALARY COMPUTATION WITHOUT DEDUCTIONS (NEW) ===================");
        }
        System.out.println("Your annual salary is         : " + ft.format(takeHomeInstance.annualSalary));
        System.out.println("Your annual tax liability is  : " + ft.format(takeHomeInstance.totalTax));
        System.out.println("Your monthly salary is        : " + ft.format(takeHomeInstance.annualSalary / 12.0));
        System.out.println("Your monthly tax liability is : " + ft.format(takeHomeInstance.totalTax / 12.0));
        System.out.println("Your monthly PF Contribution  : " + ft.format(takeHomeInstance.PF));
        System.out.println("Your net monthly take home is : " + ft.format(takeHomeInstance.monthlyTakeHome));
    }

}