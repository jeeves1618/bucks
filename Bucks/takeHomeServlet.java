package Bucks;

class takeHomeServlet {

    double PF = 0D, houseLoanInt = 0D, annualSalary=120000.0D;
    takeHome takeHomeInstance = new takeHome(annualSalary, houseLoanInt ,PF);

    public void calculator() {

        houseLoanInt = 200000.0D;
        PF = (annualSalary * 0.4 * 0.12) / 12;
        takeHome takeHomeInstance = new takeHome(annualSalary, houseLoanInt ,PF);

        takeHomeInstance.calculateOldTakeHome();

        takeHomeInstance.calculateNewTakeHome();
    }

    public double returnAnnualSalary(){
        return takeHomeInstance.annualSalary;
    }
    /*public static void printSummary(boolean oldRegieme, takeHome takeHomeInstance) {
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
    }*/

}