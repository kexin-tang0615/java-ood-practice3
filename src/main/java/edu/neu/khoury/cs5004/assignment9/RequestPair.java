package edu.neu.khoury.cs5004.assignment9;

import java.util.Objects;

/**
 * Class RequestPair contains information about a request pair.
 */
public class RequestPair {

  private Integer idNum;
  private RsaKeyPair key;

  /**
   * Constructor that creates a new RequestPair object, based upon all of the provided input
   * parameters.
   *
   * @param idNum the id
   * @param key the key
   */
  public RequestPair(Integer idNum, RsaKeyPair key) {
    this.idNum = idNum;
    this.key = key;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Integer getId() {
    return idNum;
  }

  /**
   * Gets key.
   *
   * @return the key
   */
  public RsaKeyPair getPubKey() {
    return key;
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
    RequestPair requestPair = (RequestPair) obj;
    return getId().equals(requestPair.getId())
        && getPubKey().equals(requestPair.getPubKey());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getId(), getPubKey());
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "This is a request pair:\n" + "{"
        + "id = " + idNum
        + ", key = " + key
        + '}';
  }
}
