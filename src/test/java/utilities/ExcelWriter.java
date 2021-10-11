package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelWriter {
    Utilities utilities = new Utilities();
    File file = new File("src/main/resources/apartment_data/nov-dec.xlsx");

    public static XSSFWorkbook workbook = new XSSFWorkbook();

    public void setWorkbook() {
        workbook = new XSSFWorkbook();
    }

    public void writeExcelSheet(Map<String, List<Map<String, String>>> excelDataMap, String sheetName) throws IOException {

        XSSFSheet sheet = workbook.createSheet(sheetName);

        XSSFRow row;

        //    int rowid = (sheet.getLastRowNum() == -1) ? 0 : sheet.getLastRowNum();
        //    System.out.println("rowid = " + rowid);
        int rowid = 0;

        row = sheet.createRow(rowid++);
        Cell header = row.createCell(0);
        header.setCellValue("Days of stay");
        header = row.createCell(1);
        header.setCellValue("Bedroom number");
        header = row.createCell(2);
        header.setCellValue("Occupancy");
        header = row.createCell(3);
        header.setCellValue("Number Of Beds");
        header = row.createCell(4);
        header.setCellValue("Price");


        for (String mapKey : excelDataMap.keySet()) {
            List<Map<String, String>> excelData = excelDataMap.get(mapKey);
            row = sheet.createRow(rowid++);
            row = sheet.createRow(rowid++);
            Cell cellForHouseName = row.createCell(2);
            cellForHouseName.setCellValue(mapKey);
            row = sheet.createRow(rowid++);


            double sumForHouse = 0.00;
            int numberOfDays = 0;
            double average = 0.00;
            double assumption = 0.00;

            for (Map<String, String> maps : excelData) {

                row = sheet.createRow(rowid++);
                int cellid = 0;
                Cell cell = row.createCell(cellid++);
                cell.setCellValue(maps.get("Date"));

                cell = row.createCell(cellid++);
                cell.setCellValue(maps.get("Bedroom Number"));

                cell = row.createCell(cellid++);
                cell.setCellValue(maps.get("Occupancy"));

                cell = row.createCell(cellid++);
                cell.setCellValue(maps.get("Number of beds"));

                cell = row.createCell(cellid++);
                cell.setCellValue(maps.get("Price"));

                numberOfDays++;
                sumForHouse += utilities.getPrice(maps.get("Price"));
            }

            average = sumForHouse / numberOfDays;
            assumption = average * 30;
            row = sheet.createRow(rowid++);

            Cell cell = row.createCell(1);
            cell.setCellValue("Sum For Available days: $" + sumForHouse);
            cell = row.createCell(2);
            cell.setCellValue("Average per day: $" + average);
            cell = row.createCell(3);
            cell.setCellValue("Assumption for the full month: $" + assumption);


            row = sheet.createRow(rowid++);


        }

        if (!file.exists()) {
            file = new File("src/main/resources/apartment_data/apartments_nov-dec.xlsx");
        }
        FileOutputStream out = new FileOutputStream(file);

        workbook.write(out);
        out.close();

    }

}
