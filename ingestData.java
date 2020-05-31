import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

class ingestData{
    ingestData(){

    }
    public static void main(String[] Args) {
        System.out.println("Inside ingestData");
        try {
            FileInputStream file=new FileInputStream(new File("C:\\Users\\Bunny\\Documents\\Bucks\\Accts.xlsx"));
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType())
                    {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "t");
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + cell.getCellType());
                    }
                }
                System.out.println("");
            }
            file.close();
        }
        catch (Exception e)
        {
            System.out.println("Inside exception");
            e.printStackTrace();
        }
    }
}