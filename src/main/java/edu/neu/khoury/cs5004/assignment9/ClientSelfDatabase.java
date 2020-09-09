package edu.neu.khoury.cs5004.assignment9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class ClientSelfDatabase contains information about a client's database.
 */
public class ClientSelfDatabase implements IClientSelfDatabase {

  private Map<Integer, ClientSelf> clientSelfMap;


  /**
   * Constructor that creates a new ClientSelfDatabase object.
   */
  public ClientSelfDatabase() {
    this.clientSelfMap = new HashMap<>();
  }

  /**
   * Add client to map.
   *
   * @param clientSelf - a ClientSelf object
   */
  @Override
  public void addClient(ClientSelf clientSelf) {
    this.clientSelfMap.put(clientSelf.getIdNum(), clientSelf);
  }

  /**
   * Get ClientSelf Object.
   *
   * @param idNum the id num
   * @return a ClientSelf Object
   */
  @Override
  public ClientSelf getClientSelf(Integer idNum) {
    return this.clientSelfMap.get(idNum);
  }

  /**
   * Generate client data.
   *
   * @return a list of RequestPair
   */
  @Override
  public List<RequestPair> generateClientData() {
    List<RequestPair> list = new ArrayList<>();
    for (Map.Entry<Integer, ClientSelf> entry : clientSelfMap.entrySet()) {
      list.add(new RequestPair(entry.getKey(), entry.getValue().getPublicKey()));
    }
    return list;
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
    ClientSelfDatabase that = (ClientSelfDatabase) obj;
    return Objects.equals(clientSelfMap, that.clientSelfMap);
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(clientSelfMap);
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "This contains ClientSelf database:\n" + "{"
        + "clientSelfMap=" + clientSelfMap
        + '}';
  }
}
