package ExpenseAnalyzer;

import Bucks.RupeeFormatter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ExpenseCalculator {
    private double totalSavings;
    private double apartmentMaintenance;
    private double electricityBill;
    private double creditCardBill;
    private double salaryIncome;
    private double interestIncome;
    private double rentalIncome;
    private double dividendIncome;
    private double brokerageMaintenance;
    private double monthlyEMI;
    private double homeInsurance;
    private double transferOut;
    private double transferIn;
    private double cashWithdrawals;
    private double totalWithdrawals;
    private double totalDeposits;
    private double Unknown;

    private String transactionRemarks;
    private String fileWithPathname;

    DecimalFormat ft = new DecimalFormat("Rs ##,##,##0.00");
    RupeeFormatter rf = new RupeeFormatter();

    public ExpenseCalculator(String accountHolder, String accountType){

        if (accountHolder == "Ben")
            fileWithPathname = "C:\\dev\\Data\\BenAcctSal.xlsx";
        else
            fileWithPathname = "C:\\dev\\Data\\BunAcctSal.xlsx";

        IngestStatementExcel balanceSheet = new IngestStatementExcel(fileWithPathname);
        //IngestH2db balanceSheet = new IngestH2db();
        AccountStatement AccountStatementEntry = new AccountStatement();
        ArrayList<AccountStatement> AccountStatementList;
        AccountStatementList = balanceSheet.transferData();
        for (int i=0; i < AccountStatement.numofElements; i++){
            transactionRemarks = AccountStatementList.get(i).transactionRemarks;
            if(transactionRemarks.contains("INF/INFT/") && transactionRemarks.contains("/Self")) {
                AccountStatementList.get(i).entryCategory = "Savings";
                totalSavings = totalSavings + AccountStatementList.get(i).withdrawalAmount - AccountStatementList.get(i).depositAmount;
                totalWithdrawals = totalWithdrawals + AccountStatementList.get(i).withdrawalAmount;
                totalDeposits = totalDeposits + AccountStatementList.get(i).depositAmount;
            } else
            if(transactionRemarks.contains("BIL/INFT/") && transactionRemarks.toUpperCase().contains("RENT")) {
                rentalIncome = rentalIncome + AccountStatementList.get(i).depositAmount;
                totalDeposits = totalDeposits + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Rental Income";
            } else
            if((transactionRemarks.contains("BIL/INFT/") && transactionRemarks.toUpperCase().contains("EMI"))
                    || transactionRemarks.toUpperCase().contains("ACH/HDFCLTD")){
                monthlyEMI = monthlyEMI + AccountStatementList.get(i).withdrawalAmount;
                totalWithdrawals = totalWithdrawals + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Monthly EMI";
            } else
            if ((transactionRemarks.contains("BIL/INFT/")) && AccountStatementList.get(i).withdrawalAmount > 0) {
                transferOut = transferOut + AccountStatementList.get(i).withdrawalAmount;
                totalWithdrawals = totalWithdrawals + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Transfer Out";
            } else
            if ((transactionRemarks.contains("BIL/INFT/")) && AccountStatementList.get(i).depositAmount > 0) {
                transferIn = transferIn + AccountStatementList.get(i).withdrawalAmount;
                totalDeposits = totalDeposits + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Transfer In";
            } else
            if(transactionRemarks.contains("Rev Sweep From") || transactionRemarks.toUpperCase().contains("AUTOSWEEP")){
                AccountStatementList.get(i).entryCategory = "Bookentries";
            } else
            if(transactionRemarks.contains("ATM") || transactionRemarks.toUpperCase().contains("CASH WDL")){
                cashWithdrawals = cashWithdrawals + AccountStatementList.get(i).withdrawalAmount;
                totalWithdrawals = totalWithdrawals + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Cash Withdrawals";
            } else
            if(transactionRemarks.contains("State Bank/SBCOLLECT")){
                apartmentMaintenance = apartmentMaintenance + AccountStatementList.get(i).withdrawalAmount;
                totalWithdrawals = totalWithdrawals + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Apartment Maintenance";
            } else
            if(transactionRemarks.contains("BIL/ONL/") && transactionRemarks.toUpperCase().contains("EB")){
                electricityBill = electricityBill + AccountStatementList.get(i).withdrawalAmount;
                totalWithdrawals = totalWithdrawals + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Electricity Expenses";
            }  else
            if(transactionRemarks.contains("Closure Proceeds")){
                interestIncome = interestIncome + AccountStatementList.get(i).depositAmount;
                totalDeposits = totalDeposits + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Interest Income";
            } else
            if(transactionRemarks.toUpperCase().contains("ICICI BANK CREDIT")){
                creditCardBill = creditCardBill + AccountStatementList.get(i).withdrawalAmount;
                totalWithdrawals = totalWithdrawals + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Credit Card Bills";
            } else
            if(transactionRemarks.contains("NEFT") && transactionRemarks.toUpperCase().contains("BNY MELLON")){
                salaryIncome = salaryIncome + AccountStatementList.get(i).depositAmount;
                totalDeposits = totalDeposits + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Salary";
            } else
            if(transactionRemarks.contains("CMS/ SBIDIV") || transactionRemarks.toUpperCase().contains("DIVIDEND")){
                dividendIncome = dividendIncome + AccountStatementList.get(i).depositAmount;
                totalDeposits = totalDeposits + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Dividend Income";
            } else
            if(transactionRemarks.contains("Amalfi2705/HIRANANDAN/UTIB00")){
                totalSavings = totalSavings + AccountStatementList.get(i).withdrawalAmount;
                totalWithdrawals = totalWithdrawals + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
            } else {
                Unknown = Unknown + AccountStatementList.get(i).withdrawalAmount + AccountStatementList.get(i).depositAmount;
                AccountStatementList.get(i).entryCategory = "Unknown";
            }
            }
        }
    public String getTotalSavingsFmtd(){
        return rf.formattedRupee(ft.format(totalSavings));
    }
    public String getApartmentMaintenanceFmtd(){
        return rf.formattedRupee(ft.format(apartmentMaintenance));
    }
    public String getElectricityBillFmtd(){
        return rf.formattedRupee(ft.format(electricityBill));
    }
    public String getCreditCardBillFmtd(){
        return rf.formattedRupee(ft.format(creditCardBill));
    }
    public String getSalaryIncomeFmtd(){
        return rf.formattedRupee(ft.format(salaryIncome));
    }
    public String getInterestIncomeFmtd(){
        return rf.formattedRupee(ft.format(interestIncome));
    }
    public String getMonthlyEMIFmtd(){
        return rf.formattedRupee(ft.format(monthlyEMI));
    }
    public String getRentalIncomeFmtd(){
        return rf.formattedRupee(ft.format(rentalIncome));
    }
    public String getDividendIncomeFmtd(){
        return rf.formattedRupee(ft.format(dividendIncome));
    }
    public String getBrokerageMaintenanceFmtd(){
        return rf.formattedRupee(ft.format(brokerageMaintenance));
    }
    public String getHomeInsuranceFmtd(){
        return rf.formattedRupee(ft.format(homeInsurance));
    }
    public String getTransferOutFmtd(){
        return rf.formattedRupee(ft.format(transferOut));
    }
    public String getTransferInFmtd(){
        return rf.formattedRupee(ft.format(transferIn));
    }
    public String getCashWithdrawalsFmtd(){
        return rf.formattedRupee(ft.format(cashWithdrawals));
    }
    public String getUnknownFmtd(){
        return rf.formattedRupee(ft.format(Unknown));
    }
    public String getTotalWithdrawalsFmtd(){
        return rf.formattedRupee(ft.format(totalWithdrawals));
    }
    public String getTotalDepositsFmtd(){
        return rf.formattedRupee(ft.format(totalDeposits));
    }
    public String getTotalIncomeFmtd(){
        return rf.formattedRupee(ft.format(salaryIncome + dividendIncome + interestIncome + rentalIncome));
    }
    public String getTotalExpensesFmtd(){
        return rf.formattedRupee(ft.format(apartmentMaintenance + electricityBill + creditCardBill + monthlyEMI
                + brokerageMaintenance + homeInsurance + cashWithdrawals));
    }
}
