package ExpenseAnalyzer;

public class ExpenseCalculatorTest {
    public static void main(String[] Args){

        System.out.println("Test Message");

        ExpenseCalculator e1 = new ExpenseCalculator("Bun", "Sal");
        System.out.println("apartmentMaintenance :" + e1.getApartmentMaintenanceFmtd());
        System.out.println("Brokerage" + e1.getBrokerageMaintenanceFmtd());
        System.out.println("CashWithdrawalsFmtd : " + e1.getCashWithdrawalsFmtd());
        System.out.println("CreditCardBillFmtd : " + e1.getCreditCardBillFmtd());
        System.out.println("DividendIncomeFmtd : " + e1.getDividendIncomeFmtd());
        System.out.println("ElectricityBillFmtd : " + e1.getElectricityBillFmtd());
        System.out.println("HomeInsuranceFmtd : " + e1.getHomeInsuranceFmtd());
        System.out.println("InterestIncomeFmtd : " + e1.getInterestIncomeFmtd());
        System.out.println("MonthlyEMIFmtd : " + e1.getMonthlyEMIFmtd());
        System.out.println("RentalIncomeFmtd : " + e1.getRentalIncomeFmtd());
        System.out.println("SalaryIncomeFmtd : " + e1.getSalaryIncomeFmtd());
        System.out.println("TotalIncomeFmtd : " + e1.getTotalIncomeFmtd());
        System.out.println("TotalExpensesFmtd : " + e1.getTotalExpensesFmtd());
        System.out.println("TotalSavingsFmtd : " + e1.getTotalSavingsFmtd());
        System.out.println("TotalDepositsFmtd : " + e1.getTotalDepositsFmtd());
        System.out.println("TotalWithdrawalsFmtd : " + e1.getTotalWithdrawalsFmtd());
        System.out.println("UnknownFmtd : " + e1.getUnknownFmtd());

    }
}