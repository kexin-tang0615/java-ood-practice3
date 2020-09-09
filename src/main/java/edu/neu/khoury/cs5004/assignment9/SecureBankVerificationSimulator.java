package edu.neu.khoury.cs5004.assignment9;

import java.util.List;
import java.util.Map;

/**
 * The type Secure bank verification simulator.
 */
public class SecureBankVerificationSimulator {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // Commandline Input example: 500 100 20.0 output.csv
    // 500 clients, 100 transactions, 20.0% invalid signature and output file is output.csv
    ICmdLineParser cmdLineParser = new CmdLineParser();
    CmdLineArguments arguments = cmdLineParser.processCmdLineArgs(args);

    ClientSystem clientSystem = new ClientSystem(arguments.getNumOfBankClients());
    List<RequestPair> clientDataToBank = clientSystem.generateClientDataToBank();
    Map<Integer, MsgDigitalSignaturePair> clientRequest = clientSystem.generateSignaturePair(
        arguments.getNumOfVerifications(),
        arguments.getPercentOfInvalidMsg());

    BankSystem bankSystem = new BankSystem(clientDataToBank);

    List<OutputInfo> outputInfoMap = bankSystem.processTransactions(clientRequest);

    OutputWriter writer = new OutputWriter(arguments.getOutputFileName());

    writer.writeToFile(outputInfoMap);
  }
}
