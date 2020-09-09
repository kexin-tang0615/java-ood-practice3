package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * Class ClientSystem contains information about client system.
 */
public class ClientSystem implements IClientSystem {

  private static final Integer BIT_LEN_FOR_INVALID = 8;
  private static final Integer FROM_INT_TO_PERCENT = 100;
  private ClientSelfDatabase clientSelfDatabase;
  private Integer numOfClients;

  /**
   * Constructor that creates a new ClientSystem object, based upon all of the provided input
   * parameters.
   *
   * @param numOfClients the num of clients
   */
  public ClientSystem(Integer numOfClients) {
    clientSelfDatabase = new ClientSelfDatabase();
    this.numOfClients = numOfClients;
    for (int i = 0; i < numOfClients; i++) {
      ClientSelf clientSelf = new ClientSelf(i);
      clientSelfDatabase.addClient(clientSelf);
    }
  }

  /**
   * Get ClientSelf object.
   *
   * @param idNum the idNum
   * @return a ClientSelf object
   */
  @Override
  public ClientSelf getClientSelf(Integer idNum) {
    return clientSelfDatabase.getClientSelf(idNum);
  }

  /**
   * Generate client data to bank.
   *
   * @return a list of RequestPair
   */
  @Override
  public List<RequestPair> generateClientDataToBank() {
    return this.clientSelfDatabase.generateClientData();
  }

  /**
   * Generate signature pair.
   *
   * @param numOfVerifications the num of verifications
   * @param percentOfInvalidMsg the percent of invalid msg
   * @return a map
   */
  @Override
  public Map<Integer, MsgDigitalSignaturePair> generateSignaturePair(
      Integer numOfVerifications,
      Double percentOfInvalidMsg) {

    Map<Integer, MsgDigitalSignaturePair> pairMap = new HashMap<>();
    List<Integer> listOfId = shuffle(numOfClients, numOfVerifications);
    for (Integer idNum : listOfId) {
      MsgDigitalSignaturePair pair;
      ClientSelf client = getClientSelf(idNum);
      if (checkMsgValid(percentOfInvalidMsg)) {
        System.out.println(String.format("Client %d will use valid signature", idNum));
        Integer message = client.generateMessage();
        BigInteger signature = client.generateRsaSignature(message);
        pair = new MsgDigitalSignaturePair(message, signature);
      } else {
        System.out.println(String.format("Client %d will use invalid signature", idNum));
        pair = new MsgDigitalSignaturePair(client.generateMessage(), getInvalidSignature());
      }
      pairMap.put(idNum, pair);
    }
    return pairMap;
  }

  /**
   * Helper method to get invalid signature.
   *
   * @return a BigInteger
   */
  private BigInteger getInvalidSignature() {
    SecureRandom rand = new SecureRandom();
    return new BigInteger(BIT_LEN_FOR_INVALID, rand);
  }

  /**
   * Helper method to shuffle clients.
   *
   * @param numOfClients total number of clients
   * @param numOfVerifications number of verification
   * @return a list of Integer
   */
  private List<Integer> shuffle(Integer numOfClients, Integer numOfVerifications) {
    List<Integer> list = new ArrayList<>();
    SecureRandom random = new SecureRandom();
    while (list.size() != numOfVerifications) {
      int idNum = random.nextInt(numOfClients);
      if (!list.contains(idNum)) {
        list.add(idNum);
      }
    }
    return list;
  }

  /**
   * Helper method to check message validity.
   *
   * @param percentOfInvalidMsg percentage of invalid message
   * @return a boolean value
   */
  private Boolean checkMsgValid(Double percentOfInvalidMsg) {
    Random randomPercentage = new SecureRandom();
    Double percentage = randomPercentage.nextDouble();
    return percentage >= percentOfInvalidMsg / FROM_INT_TO_PERCENT;
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
    ClientSystem that = (ClientSystem) obj;
    return Objects.equals(clientSelfDatabase, that.clientSelfDatabase)
        &&  Objects.equals(numOfClients, that.numOfClients);
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(clientSelfDatabase, numOfClients);
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "This is a client system:\n" + "{"
        + "clientSelfDatabase=" + clientSelfDatabase
        + ", numOfClients=" + numOfClients
        + '}';
  }
}
