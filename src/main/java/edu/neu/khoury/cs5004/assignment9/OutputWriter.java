package edu.neu.khoury.cs5004.assignment9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/**
 * Class OutputWriter contains information about an output writer.
 */
public class OutputWriter implements IOutputWriter {

  private static final String HEADER =
      "\"Date\", \"Time\", \"Client ID\", \"Message\", \"Digital signature\", "
          + "\"Verified\", \"Transactions status\"";
  private String fileName;

  /**
   * Constructor that creates a new OutputWriter object, based upon all of the provided input
   * parameters.
   *
   * @param fileName the file name
   */
  public OutputWriter(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Write to file.
   *
   * @param outputInfoList the output info list
   */
  @Override
  public void writeToFile(List<OutputInfo> outputInfoList) {
    try {
      File file = new File(fileName);

      OutputStream outputStream = new FileOutputStream(file);
      BufferedWriter bufferedWriter = new BufferedWriter(
          new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

      bufferedWriter.write(HEADER);
      bufferedWriter.newLine();
      for (OutputInfo info : outputInfoList) {
        String fileContents = "\"" + info.getLocalDate() + "\"" + ", "
            + "\"" + info.getLocalTime() + "\"" + ", "
            + "\"" + info.getIdNum() + "\"" + ", "
            + "\"" + info.getMessage() + "\"" + ", "
            + "\"" + info.getDigitalSignature() + "\"" + ", "
            + "\"" + info.getVerifiedStatus() + "\"" + ", "
            + "\"" + info.getTransactionStatus() + "\"";
        bufferedWriter.write(fileContents);
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
      outputStream.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  /**
   * Returns the boolean value whether this equals to the given obj.
   *
   * @return the boolean value whether this equals to the given obj
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    OutputWriter that = (OutputWriter) obj;
    return Objects.equals(fileName, that.fileName);
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(fileName);
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "This is an output writer:\n " + "{"
        + "fileName='" + fileName + '\''
        + '}';
  }
}
