package edu.neu.khoury.cs5004.assignment9;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class BankClientDatabase contains information about a map of clients, where the information is
 * from the bank's perspective.
 */
public class BankClientDatabase implements IBankClientDatabase {

  private Map<Integer, BankClient> bankClientMap;

  /**
   * Constructor that creates a new BankClientDatabase object.
   */
  public BankClientDatabase() {
    this.bankClientMap = new HashMap<>();
  }

  /**
   * Add bank client to map.
   *
   * @param bankClient the bank client
   */
  @Override
  public void addBankClient(BankClient bankClient) {
    this.bankClientMap.put(bankClient.getIdNum(), bankClient);
  }

  /**
   * Gets bank client.
   *
   * @param idNum the id number
   * @return the bank client
   */
  @Override
  public BankClient getBankClient(Integer idNum) {
    return this.bankClientMap.get(idNum);
  }

  /**
   * Gets bank client map.
   *
   * @return the bank client map
   */
  public Map<Integer, BankClient> getBankClientMap() {
    return bankClientMap;
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
    BankClientDatabase that = (BankClientDatabase) obj;
    return Objects.equals(bankClientMap, that.bankClientMap);
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(bankClientMap);
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "BankClientDatabase{"
        + "bankClientMap=" + bankClientMap
        + '}';
  }
}