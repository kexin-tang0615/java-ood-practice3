package edu.neu.khoury.cs5004.assignment9;

import java.util.List;
import java.util.Map;

/**
 * The interface Bank system.
 */
public interface IBankSystem {

  /**
   * Process transactions list.
   *
   * @param pairMap the pair map
   * @return the list
   */
  List<OutputInfo> processTransactions(Map<Integer, MsgDigitalSignaturePair> pairMap);
}
