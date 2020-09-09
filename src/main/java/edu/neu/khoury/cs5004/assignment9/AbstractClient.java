package edu.neu.khoury.cs5004.assignment9;


/**
 * * Abstract class AbstractClient contains information about a client.
 */
public abstract class AbstractClient {

  private Integer idNum;

  /**
   * Constructor that creates a new AbstractClient object, based upon all of the provided input
   * parameters.
   *
   * @param idNum the id num
   */
  public AbstractClient(Integer idNum) {
    this.idNum = idNum;
  }

  /**
   * Gets id num.
   *
   * @return the id num
   */
  public Integer getIdNum() {
    return idNum;
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "idNum=" + idNum;
  }
}