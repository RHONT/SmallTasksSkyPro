package t35;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Работаем с .xls и .xlsx документами
 *
 * При работе с более новым форматом файла .xlsx мы бы использовали классы XSSFWorkbook, XSSFSheet, XSSFRow и XSSFCell.
 *
 * Для работы со старым форматом .xls мы используем классы HSSFWorkbook, HSSFSheet, HSSFRow и HSSFCell.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(new File("src/main/resources/OldExcel.xls"));
        // заносим в рабочую книгу данные из файла
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        // читаем данные из листов
        Map<Integer, List<String>> dataMap = readSheet(workbook, 0);
        Map<Integer, List<String>> dataMap2 = readSheet(workbook, 1);

        System.out.println(dataMap);
        System.out.println(dataMap2);

        workbook.close();
        file.close();
        //////////////////////

        HSSFWorkbook bookForWrite = createNewStyleBook();
        writeBook(bookForWrite,"src/main/resources/CreateOldExcel.xls");


    }

    private static void writeBook(HSSFWorkbook bookForWrite, String path) throws IOException {

        File currDir = new File(path);
        FileOutputStream outputStream = new FileOutputStream(currDir);
        bookForWrite.write(outputStream);
        bookForWrite.close();
        outputStream.close();


    }

    public static HSSFWorkbook createNewStyleBook(){
        HSSFWorkbook workBook = new HSSFWorkbook();

        HSSFSheet sheet = workBook.createSheet("Persons");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        HSSFRow header = sheet.createRow(0);

        HSSFCellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        HSSFFont font = workBook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        HSSFCell headerCell = header.createCell(0);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Age");
        headerCell.setCellStyle(headerStyle);

/////////////////////////
        HSSFCellStyle style = workBook.createCellStyle();
        style.setWrapText(true);

        HSSFRow row = sheet.createRow(1);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("John Smith");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue(20);
        cell.setCellStyle(style);

        return workBook;

    }

    public static Map<Integer,List<String>> readSheet(HSSFWorkbook workbook,int indexOfPage){
        HSSFSheet sheet = workbook.getSheetAt(indexOfPage);
        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:  {
                        data.get(i).add(cell.getRichStringCellValue().getString());
                    } break;
                    case NUMERIC: {
                        if (DateUtil.isCellDateFormatted(cell)) {
                            data.get(i).add(cell.getDateCellValue() + "");
                        } else {
                            data.get(i).add(cell.getNumericCellValue() + "");
                        }
                    } break;

                    default: data.get(i).add(" ");
                }
            }
            i++;
        }
        return data;
    }
}
