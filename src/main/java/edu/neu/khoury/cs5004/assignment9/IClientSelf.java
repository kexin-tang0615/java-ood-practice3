package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;

/**
 * The interface Client self.
 */
public interface IClientSelf {

  /**
   * Generate message integer.
   *
   * @return the integer
   */
  Integer generateMessage();

  /**
   * Generate rsa signature big integer.
   *
   * @param message the message
   * @return the big integer
   */
  BigInteger generateRsaSignature(Integer message);
}
