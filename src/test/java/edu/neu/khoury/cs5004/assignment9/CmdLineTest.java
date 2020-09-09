package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CmdLineTest {

  private static final String[] INPUT_VALID = {"50", "10", "20", "test.csv"};
  private static final String[] INPUT_VALID2 = {"60", "20", "40", "test.csv"};
  private static final String[] INPUT_TOO_LESS = {"50"};
  private static final String[] INPUT_CLIENT_NEG = {"-1", "10", "20", "test.csv"};
  private static final String[] INPUT_VERIFICATION_NEG = {"50", "-1", "20", "test.csv"};
  private static final String[] INPUT_PERCENTAGE_NEG = {"50", "20", "-1", "test.csv"};
  private static final String[] INPUT_CLIENT_LARGE = {"50001", "10", "20", "test.csv"};
  private static final String[] INPUT_VERIFICATION_LARGE = {"50", "10001", "20", "test.csv"};
  private static final String[] INPUT_PERCENTAGE_LARGE = {"50", "10", "101", "test.csv"};

  private CmdLineParser parser;
  private CmdLineParser parser2;
  private CmdLineArguments cmdLineArguments;
  private CmdLineArguments cmdLineArguments2;

  @Before
  public void setUp() {
    parser = new CmdLineParser();
    parser2 = new CmdLineParser();
    cmdLineArguments = new CmdLineArguments();
    cmdLineArguments2 = new CmdLineArguments();
    cmdLineArguments = parser.processCmdLineArgs(INPUT_VALID);
    cmdLineArguments2 = parser2.processCmdLineArgs(INPUT_VALID2);
  }

  @Test
  public void testValidInput() {
    CmdLineArguments arguments = parser.processCmdLineArgs(INPUT_VALID);
    assertEquals(Integer.valueOf(50), arguments.getNumOfBankClients());
    assertEquals(Integer.valueOf(10), arguments.getNumOfVerifications());
    assertEquals(Double.valueOf(20.0), arguments.getPercentOfInvalidMsg());
    assertEquals("test.csv", arguments.getOutputFileName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooLessArgs() {
    parser.processCmdLineArgs(INPUT_TOO_LESS);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testClientsNegative() {
    parser.processCmdLineArgs(INPUT_CLIENT_NEG);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testClientsLarge() {
    parser.processCmdLineArgs(INPUT_CLIENT_LARGE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testVerificationNegative() {
    parser.processCmdLineArgs(INPUT_VERIFICATION_NEG);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testVerificationLarge() {
    parser.processCmdLineArgs(INPUT_VERIFICATION_LARGE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPercentageNegative() {
    parser.processCmdLineArgs(INPUT_PERCENTAGE_NEG);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPercentageLarge() {
    parser.processCmdLineArgs(INPUT_PERCENTAGE_LARGE);
  }

  @Test
  public void equals() {
    assertTrue(parser.equals(parser));
  }

  @Test
  public void equals2() {
    assertFalse(parser.equals("A"));
  }

  @Test
  public void equals3() {
    parser.processCmdLineArgs(INPUT_VALID);
    parser2.processCmdLineArgs(INPUT_VALID2);
    assertFalse(parser.equals(parser2));
  }

  @Test
  public void equals4() {
    assertFalse(parser.equals(null));
  }

  @Test
  public void equals5() {
    assertTrue(cmdLineArguments.equals(cmdLineArguments));
  }

  @Test
  public void equals6() {
    assertFalse(cmdLineArguments.equals("a"));
  }

  @Test
  public void equals7() {
    assertFalse(cmdLineArguments.equals(cmdLineArguments2));
  }

  @Test
  public void equals8() {
    assertFalse(cmdLineArguments.equals(null));
  }

  @Test
  public void hashCode1() {
    parser.processCmdLineArgs(INPUT_VALID);
    parser2.processCmdLineArgs(INPUT_VALID2);
    assertFalse(parser.hashCode() == parser2.hashCode());
  }

  @Test
  public void hashCode2() {
    assertFalse(cmdLineArguments.hashCode() == cmdLineArguments2.hashCode());
  }


  @Test
  public void toString1() {
    CmdLineArguments arguments = parser.processCmdLineArgs(INPUT_VALID);
    assertEquals("This is a commandline parser:\n"
            + "cmdLineArguments=CmdLineArguments{numOfBankClients=50, numOfVerifications=10, percentOfInvalidMsg=20.0, outputFileName='test.csv'}}",
        parser.toString());
  }
}
