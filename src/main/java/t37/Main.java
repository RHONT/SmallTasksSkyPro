package t37;

/**
 * Дан класс Car и Upgrade. У Car есть поле id и upgrades (List‹Upgrade›). У Upgrade есть id и name.
 * Также есть 2 таблицы Excel: Car и Upgrade. В таблице Car колонка upgrades заполняется в формате id1,id2,id3
 * Напишите программу,
 * которая будет читать таблицы и на основе этого сформирует List объектов Car, содержащих нужные апгрейды из таблицы.
 *
 * Использовалась библиотека Fastexcel
 */

import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Map<String, String> readCar;
        Map<String, String> readUpgrade;
        Map<String, List<String>> resultMap = new HashMap<>();

        readCar = readExcel("src/main/resources/Car.xlsx");
        readUpgrade=readExcel("src/main/resources/Upgrade.xlsx");

        if (!readCar.isEmpty() && !readUpgrade.isEmpty()) {
            for (Map.Entry<String,String> element: readCar.entrySet()) {
                resultMap.put(
                        element.getKey(),
                        getListStringUpgrades(readUpgrade, readCar.get(element.getKey())));
            }
        }
       resultMap.forEach((k,v)-> System.out.println("id машины = " + k + "\n" + "Комплектующие:" + v));
    }

    public static Map<String,String> readExcel(String fileLocation) {
        Map<String, String> data = new HashMap<>();

        try (FileInputStream file = new FileInputStream(fileLocation);
             ReadableWorkbook wb = new ReadableWorkbook(file)) {

            Sheet sheet = wb.getFirstSheet();
            try (Stream<Row> rows = sheet.openStream().skip(1)) { // пропускаю шапку
                rows.forEach(r -> {
                    Optional<String> key=r.getCellAsString(0);
                    Optional<String> value=r.getCellAsString(1);
                    if (key.isPresent() && value.isPresent()) {
                      data.put(key.get(), value.get());
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static List<String> getListStringUpgrades(Map<String, String> mapUpgrade, String rowData){
        List<String> upgradeId = new ArrayList<>(Arrays.asList(rowData.split(","))); // разбиваю id1,id2,id3
        List<String> upgradeList = new ArrayList<>();
        for (var element:upgradeId) {
            if (mapUpgrade.containsKey(element)) {
                upgradeList.add(mapUpgrade.get(element));
            }
        }
        return upgradeList;
    }

}
