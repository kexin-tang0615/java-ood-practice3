package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;

/**
 * The interface Bank client.
 */
public interface IBankClient {

  /**
   * Verify signature boolean.
   *
   * @param message the message
   * @param signature the signature
   * @return the boolean
   */
  Boolean verifySignature(Integer message, BigInteger signature);
}
