package edu.neu.khoury.cs5004.assignment9;

import java.util.List;
import java.util.Map;

/**
 * The interface Client system.
 */
public interface IClientSystem {

  /**
   * Gets client self.
   *
   * @param idNum the idNum
   * @return the client self
   */
  ClientSelf getClientSelf(Integer idNum);

  /**
   * Generate client data to bank list.
   *
   * @return the list
   */
  List<RequestPair> generateClientDataToBank();

  /**
   * Generate signature pair map.
   *
   * @param numOfVerifications the num of verifications
   * @param percentOfInvalidMsg the percent of invalid msg
   * @return the map
   */
  Map<Integer, MsgDigitalSignaturePair> generateSignaturePair(Integer numOfVerifications,
      Double percentOfInvalidMsg);

}
