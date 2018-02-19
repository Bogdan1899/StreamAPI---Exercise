import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ExportToExcel {

    private static final String INPUT_PATH_VARIABLE =
            "D:\\Bogdan\\SoftUni\\SoftUni 3.0\\Java Fundamentals\\Advanced Java\\Stream API\\08. Java-Advanced-Stream-API-Exercises\\08. Java-Advanced-Stream-API-Exercises\\StudentData.txt";

    private static final String OUTPUT_PATH_VARIABLE =
            "D:\\Bogdan\\SoftUni\\SoftUni 3.0\\Java Fundamentals\\Advanced Java\\Stream API\\08. Java-Advanced-Stream-API-Exercises\\08. Java-Advanced-Stream-API-Exercises\\StudentData2.xlsx";

    public static void main(String[] args) throws IOException {

        XSSFWorkbook oopCourseResult = new XSSFWorkbook();
        XSSFSheet oopCourseSheet = oopCourseResult.createSheet("Softuni OOP Course Results");
        File inputFile = new File(INPUT_PATH_VARIABLE);
        File outputFile = new File(OUTPUT_PATH_VARIABLE);
        Map<String, String[]> stats = new HashMap<>();

        try(BufferedReader bfr = new BufferedReader(new FileReader(inputFile))){
            String line = bfr.readLine();

            while (line != null){
                String[] inputArgs = line.split("\t");
                String facultyNumber = inputArgs[0];
                stats.put(facultyNumber, new String[inputArgs.length]);

                for (int i = 0; i < inputArgs.length; i++) {
                    stats.get(facultyNumber)[i] = inputArgs[i];
                }

                line = bfr.readLine();
            }
        }

        int rowNumber = 0;

        for (Map.Entry<String, String[]> student : stats.entrySet()) {
            Row row = oopCourseSheet.createRow(rowNumber++);
            int cellNumber = 0;

            for (String data : student.getValue()) {
                Cell cell = row.createCell(cellNumber++);
                cell.setCellValue(data);
            }
        }

        try(FileOutputStream out = new FileOutputStream(outputFile)){
            oopCourseResult.write(out);
        }
    }
}
