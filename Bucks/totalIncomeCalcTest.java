package Bucks;

import java.util.Scanner;

class totalIncomeCalcTest {
    public static void main(String[] args) {
        double monthlyTakeHomeOne;
        double monthlyTakeHomeTwo;
        Scanner scan = new Scanner(System.in);

        System.out.println("Please Enter Ben Monthly Income :");
        monthlyTakeHomeOne = scan.nextDouble();
        System.out.println("Please Enter Bun Monthly Income :");
        monthlyTakeHomeTwo = scan.nextDouble();
        totalIncomeCalc T = new totalIncomeCalc(monthlyTakeHomeOne, monthlyTakeHomeTwo);
        System.out.println("Your total Monthly Incomes is : " + T.incomeTotalFmtd);
        System.out.println("Your monthly expenses are     : " + T.monthlyExpensesFmtd);
        System.out.println("Your net savings is           : " + T.netSavingsFmtd);
        System.out.println("Your rental income 1 is       : " + T.rentalIncomeOneFmtd);
        System.out.println("Your rental income 2 is       : " + T.rentalIncomeTwoFmtd);
        System.out.println("Your rental income 3 is       : " + T.rentalIncomeThreeFmtd);
        scan.close();
    }
}