package edu.neu.khoury.cs5004.assignment9;

/**
 * The interface Bank client map.
 */
public interface IBankClientDatabase {

  /**
   * Add bank client.
   *
   * @param bankClient the bank client
   */
  void addBankClient(BankClient bankClient);

  /**
   * Gets bank client.
   *
   * @param idNum the id number
   * @return the bank client
   */
  BankClient getBankClient(Integer idNum);

}
