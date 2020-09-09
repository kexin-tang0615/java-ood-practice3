package edu.neu.khoury.cs5004.assignment9;


import java.util.Objects;

/**
 * Class CmdLineParser contains information about a commandline parser.
 */
public class CmdLineParser implements ICmdLineParser {

  private static final Integer MIN_NUM_BANK_CLIENT = 0;
  private static final Integer MAX_NUM_BANK_CLIENT = 50000;
  private static final Integer MIN_NUM_UNIQUE_VERIFICATION = 0;
  private static final Integer MAX_NUM_UNIQUE_VERIFICATION = 10000;
  private static final Double MIN_PERCENT_INVALID_MSG = 0.0;
  private static final Double MAX_PERCENT_INVALID_MSG = 100.0;
  private static final Integer COMMAND_LINE_LENGTH = 4;
  private CmdLineArguments cmdLineArguments;

  /**
   * Constructor that creates a new CmdLineParser object.
   */
  public CmdLineParser() {
    cmdLineArguments = new CmdLineArguments();
  }

  /**
   * Process the commandline arguments.
   *
   * @param args the args
   * @return a new CmdLineArguments object
   */
  @Override
  public CmdLineArguments processCmdLineArgs(String[] args) {
    String errMsg = "Error: illegal arguments.\n";
    if (args.length != COMMAND_LINE_LENGTH) {
      throw new IllegalArgumentException(errMsg);
    } else {
      if (checkNumOfBankClients(args[0]) && checkNumOfVerifications(args[1])
          && checkPercentOfInvalidMsg(args[2]) && checkCsvFile(args[3])) {
        cmdLineArguments.setNumOfBankClients(args[0]);
        cmdLineArguments.setNumOfVerifications(args[1]);
        cmdLineArguments.setPercentOfInvalidMsg(args[2]);
        cmdLineArguments.setOutputFileName(args[3]);
      } else {
        throw new IllegalArgumentException(errMsg);
      }
    }
    return cmdLineArguments;
  }

  /**
   * Helper method to check the number of bank clients.
   *
   * @param args argument
   * @return a boolean value
   */
  private static Boolean checkNumOfBankClients(String args) {
    return (Integer.parseInt(args) >= MIN_NUM_BANK_CLIENT
        && Integer.parseInt(args) <= MAX_NUM_BANK_CLIENT);
  }

  /**
   * Helper method to check the number of verification.
   *
   * @param args argument
   * @return a boolean value
   */
  private static Boolean checkNumOfVerifications(String args) {
    return (Integer.parseInt(args) >= MIN_NUM_UNIQUE_VERIFICATION
        && Integer.parseInt(args) <= MAX_NUM_UNIQUE_VERIFICATION);
  }

  /**
   * Helper method to check the percentage of invalid messages.
   *
   * @param args argument
   * @return a boolean value
   */
  private static Boolean checkPercentOfInvalidMsg(String args) {
    return (Double.parseDouble(args) >= MIN_PERCENT_INVALID_MSG
        && Double.parseDouble(args) <= MAX_PERCENT_INVALID_MSG);
  }

  /**
   * Helper method to check the output file is csv file.
   *
   * @param args argument
   * @return a boolean value
   */
  private static Boolean checkCsvFile(String args) {
    return args.toLowerCase().contains(".csv");
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
    CmdLineParser that = (CmdLineParser) obj;
    return Objects.equals(cmdLineArguments, that.cmdLineArguments);
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(cmdLineArguments);
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "This is a commandline parser:\n"
        + "cmdLineArguments=" + cmdLineArguments
        + '}';
  }
}