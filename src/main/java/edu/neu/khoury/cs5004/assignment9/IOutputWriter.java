package edu.neu.khoury.cs5004.assignment9;

import java.util.List;

/**
 * The interface Output writer.
 */
public interface IOutputWriter {

  /**
   * Write to file.
   *
   * @param outputInfoList the output info list
   */
  void writeToFile(List<OutputInfo> outputInfoList);

}
