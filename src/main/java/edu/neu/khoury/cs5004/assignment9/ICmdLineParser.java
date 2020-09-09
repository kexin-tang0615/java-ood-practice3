package edu.neu.khoury.cs5004.assignment9;

/**
 * The interface Cmd line parser.
 */
public interface ICmdLineParser {

  /**
   * Process cmd line args cmd line arguments.
   *
   * @param args the args
   * @return the cmd line arguments
   */
  CmdLineArguments processCmdLineArgs(String[] args);

}