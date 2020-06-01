package Bucks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class IngestH2db{
    private static final String QUERY = "select BALTYPE ,BALSUBTYPE ,BALDESCCODE ,BALAMOUNT from BALSHEET where BALACTIVEIND = ?";
    public static void main(String[] args) {
        int bsIterator = 0;
        DecimalFormat ft = new DecimalFormat("Rs ##,##,##0.00");
        bsheetElements[] bsheetElementsList = new bsheetElements[100];

        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCconnect.getConnection();
         // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            char myChar = 'A';
            preparedStatement.setNString(1,String.valueOf(myChar));
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                //Instantiate an Object for each individual member of Array
                bsheetElementsList[bsIterator] = new bsheetElements();

                bsheetElementsList[bsIterator].typeAssetOrLiability = rs.getString("BALTYPE");
                bsheetElementsList[bsIterator].subType = rs.getString("BALSUBTYPE");
                bsheetElementsList[bsIterator].itemDescription = rs.getString("BALDESCCODE");
                bsheetElementsList[bsIterator].cashValue = rs.getDouble("BALAMOUNT");
                bsheetElementsList[bsIterator].cashValueFmtd = ft.format(bsheetElementsList[bsIterator].cashValue);
                System.out.println(bsheetElementsList[bsIterator].typeAssetOrLiability + ","
                        + bsheetElementsList[bsIterator].subType + ","
                        + bsheetElementsList[bsIterator].itemDescription + ","
                        + bsheetElementsList[bsIterator].cashValue + ","
                        + bsheetElementsList[bsIterator].cashValueFmtd);
                bsIterator++;
            }
        } catch (SQLException e) {
            H2JDBCconnect.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }

}