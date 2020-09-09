package edu.neu.khoury.cs5004.assignment9;


/**
 * Class CmdLineArguments contains information about a commandline arguments.
 */
public class CmdLineArguments {

  private Integer numOfBankClients;
  private Integer numOfVerifications;
  private Double percentOfInvalidMsg;
  private String outputFileName;

  /**
   * Constructor that creates a new CmdLineArguments object.
   */
  public CmdLineArguments() {
  }

  /**
   * Gets num of bank clients.
   *
   * @return the num of bank clients
   */
  public Integer getNumOfBankClients() {
    return numOfBankClients;
  }

  /**
   * Gets num of verifications.
   *
   * @return the num of verifications
   */
  public Integer getNumOfVerifications() {
    return numOfVerifications;
  }

  /**
   * Gets percent of invalid msg.
   *
   * @return the percent of invalid msg
   */
  public Double getPercentOfInvalidMsg() {
    return percentOfInvalidMsg;
  }

  /**
   * Gets output file name.
   *
   * @return the output file name
   */
  public String getOutputFileName() {
    return outputFileName;
  }


  /**
   * Sets num of bank clients.
   *
   * @param numOfBankClients the num of bank clients
   */
  public void setNumOfBankClients(String numOfBankClients) {
    this.numOfBankClients = Integer.parseInt(numOfBankClients);
  }

  /**
   * Sets num of verifications.
   *
   * @param numOfVerifications the num of verifications
   */
  public void setNumOfVerifications(String numOfVerifications) {
    this.numOfVerifications = Integer.parseInt(numOfVerifications);
  }

  /**
   * Sets percent of invalid msg.
   *
   * @param percentOfInvalidMesg the percent of invalid mesg
   */
  public void setPercentOfInvalidMsg(String percentOfInvalidMesg) {
    this.percentOfInvalidMsg = Double.parseDouble(percentOfInvalidMesg);
  }

  /**
   * Sets output file name.
   *
   * @param outputFileName the output file name
   */
  public void setOutputFileName(String outputFileName) {
    this.outputFileName = outputFileName;
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "CmdLineArguments{"
        + "numOfBankClients=" + numOfBankClients
        + ", numOfVerifications=" + numOfVerifications
        + ", percentOfInvalidMsg=" + percentOfInvalidMsg
        + ", outputFileName='" + outputFileName + '\''
        + '}';
  }
}