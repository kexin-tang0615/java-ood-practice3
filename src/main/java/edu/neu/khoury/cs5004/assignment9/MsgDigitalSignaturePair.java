package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Class MsgDigitalSignaturePair contains information about a message digital signature pair.
 */
public class MsgDigitalSignaturePair {

  private Integer message;
  private BigInteger digitalSignature;

  /**
   * Constructor that creates a new MsgDigitalSignaturePair object, based upon all of the provided
   * input parameters.
   *
   * @param message the message
   * @param digitalSignature the digital signature
   */
  public MsgDigitalSignaturePair(Integer message, BigInteger digitalSignature) {
    this.message = message;
    this.digitalSignature = digitalSignature;
  }


  /**
   * Gets message.
   *
   * @return the message
   */
  public Integer getMessage() {
    return message;
  }

  /**
   * Gets digital signature.
   *
   * @return the digital signature
   */
  public BigInteger getDigitalSignature() {
    return digitalSignature;
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
    MsgDigitalSignaturePair pair = (MsgDigitalSignaturePair) obj;
    return getMessage().equals(pair.getMessage())
        && getDigitalSignature().equals(pair.getDigitalSignature());
  }


  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getMessage(), getDigitalSignature());
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "This is a Message Digital Signature Pair {"
        + "message = " + message
        + ", digitalSignature = " + digitalSignature
        + '}';
  }
}