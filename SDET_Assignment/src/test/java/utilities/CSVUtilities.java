package utilities;

import com.github.javafaker.Faker;
import q1_amazon_test.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class CSVUtilities {

    public void writeAmazonProducts(List<Product> products, String filePath) throws IOException {
        FileWriter csvWriter = new FileWriter(filePath);
        try {
            csvWriter.append("Name");
            csvWriter.append(",");
            csvWriter.append("Description");
            csvWriter.append(",");
            csvWriter.append("Review");
            csvWriter.append(",");
            csvWriter.append("Cost");
            csvWriter.append("\n");

            for (Product p : products) {
                csvWriter.append(p.getName().replaceAll(",", ""));
                csvWriter.append(",");
                csvWriter.append(p.getDescription().replaceAll(",", "").replace("\n", "| "));
                csvWriter.append(",");
                csvWriter.append(p.getRating().toString());
                csvWriter.append(",");
                csvWriter.append(p.getPrice().toString());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();


        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            csvWriter.close();
        }
    }


    public void createStudentRecords(String filePath) throws IOException {
        Random random = new Random();
        Faker faker = new Faker();
        FileWriter csvWriter = new FileWriter(filePath);
        try {
            csvWriter.append("First Name");
            csvWriter.append(",");
            csvWriter.append("Last Name");
            csvWriter.append(",");
            csvWriter.append("Subject1");
            csvWriter.append(",");
            csvWriter.append("Subject2");
            csvWriter.append(",");
            csvWriter.append("Subject3");
            csvWriter.append(",");
            csvWriter.append("Subject4");
            csvWriter.append(",");
            csvWriter.append("Subject5");
            csvWriter.append("\n");

            for (int i = 0; i < 2500; i++) {
                csvWriter.append(faker.name().firstName());
                csvWriter.append(",");
                csvWriter.append(faker.name().lastName());
                csvWriter.append(",");
                csvWriter.append(random.nextInt(100) + 1 + "");
                csvWriter.append(",");
                csvWriter.append(random.nextInt(100) + 1 + "");
                csvWriter.append(",");
                csvWriter.append(random.nextInt(100) + 1 + "");
                csvWriter.append(",");
                csvWriter.append(random.nextInt(100) + 1 + "");
                csvWriter.append(",");
                csvWriter.append(random.nextInt(100) + 1 + "");
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();


        } catch (RuntimeException e) {
            e.printStackTrace();
            csvWriter.close();
        }
    }


    public void updateStudentRecords(String filePath, List<String[]> updatedValues) throws IOException {

        FileWriter csvWriter = new FileWriter(filePath);
        try {
            for (String[] arr : updatedValues) {
                for (int i = 0; i < arr.length; i++) {
                    csvWriter.append(arr[i]);
                    csvWriter.append(",");
                }
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();


        } catch (RuntimeException e) {
            e.printStackTrace();
            csvWriter.close();
        }
    }

}
