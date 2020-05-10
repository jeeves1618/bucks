package Bucks;
import java.text.DecimalFormat;

class takeHome {
    private double houseLoanInt;
    private double professionalTax;
    private double PF;
    private double section80c;
    private double standardDeduction;
    private double employmentTax;
    private double annualSalary;
    private double monthlyTakeHome;
    private double totalTax;

    DecimalFormat ft = new DecimalFormat("Rs ##,##,###.##");

    takeHome() {
    }

    public takeHome(double annualSalary, double houseLoanInt, double pf) {
        professionalTax = 2496.0D;
        section80c = 150000.0D;
        standardDeduction = 50000.0D;
        employmentTax=2500.0D;

        this.houseLoanInt = houseLoanInt;
        this.PF = pf;
        this.annualSalary = annualSalary;
    }

    public void calculateOldTakeHome() {

        double remainingSalary = 0.0D;
        totalTax = 0.0D;
        int[] salarySlab = new int[]{250000, 250000, 500000, 1000000};
        double[] taxRate = new double[]{0.0D, 5.2D, 20.8D, 31.2D};

        remainingSalary = annualSalary - section80c - standardDeduction - houseLoanInt - employmentTax;

        for (int i = 0; i < 4 && annualSalary > 0.0D; ++i) {
            totalTax += (double) salarySlab[i] * taxRate[i] / 100.0D;
            remainingSalary -= (double) salarySlab[i];
            if (i == 2) {
                salarySlab[i + 1] = (int) remainingSalary;
            }
        }
        monthlyTakeHome = (annualSalary - totalTax - professionalTax - (PF*12)) / 12.0D;
    }

    public void calculateNewTakeHome() {

        double remainingSalary = 0.0D;
        totalTax = 0.0D;
        int[] salarySlab2020 = new int[]{250000, 250000, 250000, 250000, 250000, 250000, 1000000};
        double[] taxRate2020 = new double[]{0.0D, 5.2D, 10.4D, 15.6D, 20.8D, 26.0D, 31.2D};

        remainingSalary = annualSalary;
        for (int i = 0; i < 7 && annualSalary > 0.0D; ++i) {
            totalTax += (double) salarySlab2020[i] * taxRate2020[i] / 100.0D;
            remainingSalary -= (double) salarySlab2020[i];
            if (i == 5) {
                salarySlab2020[i + 1] = (int) remainingSalary;
            }
        }
        monthlyTakeHome = (annualSalary - totalTax - professionalTax - (PF * 12)) / 12.0D;
    }

    public void printSummary(boolean oldRegieme) {
        System.out.println(" ");
        if (oldRegieme){
            System.out.println("================= SALARY COMPUTATION WITH DEDUCTIONS (OLD) ===================");
        }
        else{
            System.out.println("================= SALARY COMPUTATION WITHOUT DEDUCTIONS (NEW) ===================");
        }
        System.out.println("Your annual salary is         : " + ft.format(annualSalary));
        System.out.println("Your annual tax liability is  : " + ft.format(totalTax));
        System.out.println("Your monthly salary is        : " + ft.format(annualSalary / 12.0));
        System.out.println("Your monthly tax liability is : " + ft.format(totalTax / 12.0));
        System.out.println("Your monthly PF Contribution  : " + ft.format(PF));
        System.out.println("Your net monthly take home is : " + ft.format(monthlyTakeHome));
    }
}
