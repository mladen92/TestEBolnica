package q2_csv_rewrite;

import org.testng.annotations.Test;
import utilities.CSVUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2 {

    @Test
    public void createAndRewriteFile() throws IOException {
        String delimiter = ",";
        CSVUtilities csvUtilities = new CSVUtilities();
        File file = new File("src/test/java/q2_csv_rewrite/student_records.csv");
        csvUtilities.createStudentRecords(file.getPath());
        List<String[]> updatedWithAverage = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = " ";
            String[] tempArr;

            while ((line = bufferedReader.readLine()) != null) {
                tempArr = line.split(delimiter);
                double sum = 0.00;
                int index = 0;
                String[] updatedRow = new String[tempArr.length + 1];
                rowLoop:
                for (String str : tempArr) {
                    updatedRow[index] = str;
                    index++;
                    if (Character.isDigit(str.charAt(0))) {
                        sum += Double.parseDouble(str);
                    } else {
                        continue rowLoop;
                    }
                }
                if (sum == 0.00) {
                    updatedRow[index] = "Average";
                } else {
                    updatedRow[index] = "" + sum / 5;
                }

                updatedWithAverage.add(updatedRow);
            }
            csvUtilities.updateStudentRecords(file.getPath(),updatedWithAverage);
            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
