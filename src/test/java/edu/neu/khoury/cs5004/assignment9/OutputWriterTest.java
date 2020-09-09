package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class OutputWriterTest {

  private static final String TEST_FILE = "test_file.csv";
  private static final String TEST_FOLDER = "test_folder/test_file.csv";
  private OutputWriter outputWriter;
  private List<OutputInfo> list;

  @Before
  public void setUp() {
    outputWriter = new OutputWriter(TEST_FILE);
    list = new ArrayList<>();
  }

  @Test
  public void testWriteToFileException() {
    OutputWriter writer = new OutputWriter(TEST_FOLDER);
    writer.writeToFile(list);
  }

  @Test
  public void testEquals() {
    assertEquals(outputWriter, outputWriter);
    assertEquals(outputWriter, new OutputWriter(TEST_FILE));
    assertNotEquals(outputWriter, null);
    assertNotEquals(outputWriter, new Object());
    assertNotEquals(outputWriter, new OutputWriter(TEST_FOLDER));
  }

  @Test
  public void testHashCode() {
    assertEquals(outputWriter.hashCode(), outputWriter.hashCode());
    assertNotEquals(new OutputWriter(TEST_FOLDER).hashCode(), outputWriter.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("This is an output writer:\n {fileName='test_file.csv'}", outputWriter.toString());
  }
}