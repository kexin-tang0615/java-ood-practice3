package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Class RsaKeyPair contains information about a RSA key pair.
 */
public class RsaKeyPair {

  private BigInteger exponent;
  private BigInteger modulus;

  /**
   * Constructor that creates a new RsaKeyPair object, based upon all of the provided input
   * parameters.
   *
   * @param exponent the exponent
   * @param modulus the modulus
   */
  public RsaKeyPair(BigInteger exponent, BigInteger modulus) {
    this.exponent = exponent;
    this.modulus = modulus;
  }

  /**
   * Get the first element in the key. GCD(first, second) = 1
   *
   * @return the first element.
   */
  public BigInteger getExponent() {
    return exponent;
  }

  /**
   * Get the second element in the key. GCD(first, second) = 1
   *
   * @return the second element.
   */
  public BigInteger getModulus() {
    return modulus;
  }

  /**
   * Returns the boolean value whether this equals to the given obj.
   *
   * @return the boolean value whether this equals to the given obj
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof RsaKeyPair)) {
      return false;
    }
    RsaKeyPair that = (RsaKeyPair) object;
    return getExponent().equals(that.getExponent())
        && getModulus().equals(that.getModulus());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getExponent(), getModulus());
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "RsaKeyPair {"
        + "exponent = " + exponent
        + ", modulus = " + modulus
        + '}';
  }
}