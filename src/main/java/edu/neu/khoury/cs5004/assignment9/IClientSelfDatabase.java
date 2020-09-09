package edu.neu.khoury.cs5004.assignment9;

import java.util.List;

/**
 * The interface Client self map.
 */
public interface IClientSelfDatabase {

  /**
   * Generate client data list.
   *
   * @return the list
   */
  List<RequestPair> generateClientData();

  /**
   * Add client.
   *
   * @param clientSelf the client self
   */
  void addClient(ClientSelf clientSelf);

  /**
   * Gets client self.
   *
   * @param idNum the id num
   * @return the client self
   */
  ClientSelf getClientSelf(Integer idNum);
}
