package q2_csv_rewrite;

import org.testng.annotations.Test;
import utilities.CSVUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Question2 {

    @Test
    public void createAndRewriteFile() throws IOException {
        String delimiter = ",";
        CSVUtilities csvUtilities = new CSVUtilities();
        File file = new File("src/test/java/q2_csv_rewrite/student_records.csv");
        csvUtilities.createStudentRecords(file.getPath());




        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = " ";
            String[] tempArr;

            while ((line = bufferedReader.readLine()) != null) {
                tempArr = line.split(delimiter);
                for (String tempStr: tempArr) {
                    System.out.print(tempStr + " ");
                }
                System.out.println();
            }
            bufferedReader.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
