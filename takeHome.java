import java.text.DecimalFormat;
import java.util.Scanner;

class takeHome {
    takeHome() {
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter your Annual Salary :");
        double professionalTax = 2496.0D, PF=0D, section80c = 150000.0D, standardDeduction = 50000.0D,
                houseLoanInt = 0D, employmentTax=2500.0D;
        double annualSalary = scan.nextDouble();
        scan.nextLine();
        System.out.println("Are you paying interest on your homeloan?");
        String homeLoanind = scan.nextLine().toUpperCase();
        if (homeLoanind.equals("Y") || homeLoanind.equals("YES")){
            System.out.println("What is you interest component for the whole year?");
            houseLoanInt = scan.nextDouble();
            if (houseLoanInt > 200000) houseLoanInt = 200000.0D;
            if (houseLoanInt < 200000) houseLoanInt = 0.0D;
        }
        System.out.println("Do you know your PF deduction?");
        String PFind = scan.nextLine().toUpperCase();
        if (PFind.equals("Y") || PFind.equals("YES")){
            System.out.println("What is your monthly PF deduction?");
            PF = scan.nextDouble();
            if (PF < 0) PF = 0.0D;
        }
        else{
            PF = (annualSalary * 0.4 *0.12)/12;
        }
        double totalTax = 0.0D, remainingSalary = 0.0D;
        int[] salarySlab = new int[]{250000, 250000, 500000, 1000000};
        double[] taxRate = new double[]{0.0D, 5.2D, 20.8D, 31.2D};
        int[] salarySlab2020 = new int[]{250000, 250000, 250000, 250000, 250000, 250000, 1000000};
        double[] taxRate2020 = new double[]{0.0D, 5.2D, 10.4D, 15.6D, 20.8D, 26.0D, 31.2D};

        DecimalFormat ft = new DecimalFormat("Rs ##,##,###.##");
        remainingSalary = annualSalary - section80c - standardDeduction - houseLoanInt - employmentTax;

        for(int i = 0; i < 4 && annualSalary > 0.0D; ++i) {
            totalTax += (double)salarySlab[i] * taxRate[i] / 100.0D;
            remainingSalary -= (double)salarySlab[i];
            if (i == 2) {
                salarySlab[i + 1] = (int)remainingSalary;
            }
        }

        System.out.println(" ");
        System.out.println("================= SALARY COMPUTATION WITH DEDUCTIONS (OLD) ===================");
        System.out.println("Your annual salary is         : " + ft.format(annualSalary));
        System.out.println("Your annual tax liability is  : " + ft.format(totalTax));
        System.out.println("Your monthly salary is        : " + ft.format(annualSalary/12.0));
        System.out.println("Your monthly tax liability is : " + ft.format(totalTax/12.0));
        System.out.println("Your monthly PF Contribution  : " + ft.format(PF));
        System.out.println("Your net monthly take home is : " +
                ft.format((annualSalary - totalTax - professionalTax - (PF*12)) / 12.0D));
        System.out.println(" ");
        remainingSalary = annualSalary;
        totalTax = 0.0D;
        for(int i = 0; i < 7 && annualSalary > 0.0D; ++i) {
            totalTax += (double)salarySlab2020[i] * taxRate2020[i] / 100.0D;
            remainingSalary -= (double)salarySlab2020[i];
            if (i == 5) {
                salarySlab2020[i + 1] = (int)remainingSalary;
            }
        }
        System.out.println(" ");
        System.out.println("================= SALARY COMPUTATION WITHOUT DEDUCTIONS (NEW) ===================");
        System.out.println("Your annual salary is         : " + ft.format(annualSalary));
        System.out.println("Your annual tax liability is  : " + ft.format(totalTax));
        System.out.println("Your monthly salary is        : " + ft.format(annualSalary/12.0));
        System.out.println("Your monthly tax liability is : " + ft.format(totalTax/12.0));
        System.out.println("Your monthly PF Contribution  : " + ft.format(PF));
        System.out.println("Your net monthly take home is : " +
                ft.format((annualSalary - totalTax - professionalTax - (PF*12)) / 12.0D));

        scan.close();
    }
}