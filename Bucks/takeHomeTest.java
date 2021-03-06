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
            if (houseLoanInt < 0) houseLoanInt = 0.0D;
        }

        System.out.println("Do you know your PF deduction?");
        String PFind = scan.nextLine().toUpperCase();
        if (PFind.equals("Y") || PFind.equals("YES")) {
            System.out.println("What is your monthly PF deduction?");
            PF = scan.nextDouble();
            if (PF < 0) PF = 0.0D;
        }

        System.out.println("Who are you?");
        String whoAmI = scan.nextLine();
        //takeHome takeHomeInstance = new takeHome(annualSalary, houseLoanInt ,PF);
        takeHome takeHomeInstance = new takeHome(whoAmI);
        takeHomeInstance.calculateOldTakeHome();
        oldTaxRegulation = true;
        printSummary(oldTaxRegulation, takeHomeInstance);

        takeHomeInstance.calculateNewTakeHome();
        oldTaxRegulation = false;
        printSummary(oldTaxRegulation, takeHomeInstance);

        scan.close();
    }
    public static void printSummary(boolean oldRegieme, takeHome takeHomeInstance) {
        System.out.println(" ");
        if (oldRegieme){
            System.out.println("================= SALARY COMPUTATION WITH DEDUCTIONS (OLD) ===================");
        }
        else{
            System.out.println("================= SALARY COMPUTATION WITHOUT DEDUCTIONS (NEW) ===================");
        }
        System.out.println("Your annual salary is         : " + takeHomeInstance.getAnnualSalaryFmtd());
        System.out.println("Your annual tax liability is  : " + takeHomeInstance.getTotalTaxFmtd());
        System.out.println("Your monthly salary is        : " + takeHomeInstance.getMonthlySalaryFmtd());
        System.out.println("Your monthly tax liability is : " + takeHomeInstance.getMonthlyTaxFmtd());
        System.out.println("Your monthly PF Contribution  : " + takeHomeInstance.getPFFmtd());
        System.out.println("Your net monthly take home is : " + takeHomeInstance.getMonthlyTakeHomeFmtd());
    }
}