package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SecureBankVerificationSimulatorTest {

  private static final String[] INPUT_VALID = {"10", "5", "20", "test_folder/test.csv"};

  @Test
  public void testMain() {
    SecureBankVerificationSimulator.main(INPUT_VALID);
    List<String> outputList = readFromFileToList("test_folder/test.csv");
    assertEquals(
        "\"Date\", \"Time\", \"Client ID\", \"Message\", \"Digital signature\", \"Verified\", \"Transactions status\"",
        outputList.get(0));
    assertEquals(6, outputList.size());
  }

  private List<String> readFromFileToList(String fileName) {
    List<String> res = new ArrayList<>();
    try {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader reader = new BufferedReader(fileReader);
      String line = reader.readLine();
      while (line != null) {
        res.add(line);
        // read next line
        line = reader.readLine();
      }
      fileReader.close();
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return res;
  }
}
