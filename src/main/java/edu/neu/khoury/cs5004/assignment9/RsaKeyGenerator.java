package edu.neu.khoury.cs5004.assignment9;


import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Class RsaKeyGenerator contains information about a RSA key generator.
 */
public class RsaKeyGenerator {

  private static final Integer BIGINT_BIT_LEN = 16;
  private RsaKeyPair privateKey;
  private RsaKeyPair publicKey;

  /**
   * Constructor that creates a new RsaKeyGenerator object.
   */
  public RsaKeyGenerator() {
    BigInteger randomPrime1 = generateSecRandomPrime();
    BigInteger randomPrime2 = generateSecRandomPrime();
    while (randomPrime1.equals(randomPrime2)) {
      randomPrime2 = generateSecRandomPrime();
    }
    BigInteger phiN = randomPrime1.subtract(BigInteger.ONE)
        .multiply(randomPrime2.subtract(BigInteger.ONE));
    BigInteger modulus = randomPrime1.multiply(randomPrime2);
    BigInteger privateExponent = getRelativePrime(modulus, phiN);
    BigInteger publicExponent = privateExponent.modInverse(phiN);
    privateKey = new RsaKeyPair(privateExponent, modulus);
    publicKey = new RsaKeyPair(publicExponent, modulus);
  }

  /**
   * Gets private key.
   *
   * @return the private key
   */
  public RsaKeyPair getPrivateKey() {
    return privateKey;
  }

  /**
   * Gets public key.
   *
   * @return the public key
   */
  public RsaKeyPair getPublicKey() {
    return publicKey;
  }

  /**
   * Generate Random Prime.
   *
   * @return a BigInteger
   */
  private BigInteger generateSecRandomPrime() {
    SecureRandom randomGenerator;
    // https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom
    randomGenerator = new SecureRandom();
    BigInteger randomInteger = BigInteger.probablePrime(BIGINT_BIT_LEN, randomGenerator);
    boolean foundPrime = false;
    while (!foundPrime) {
      if (isPrime(randomInteger)) {
        foundPrime = true;
      } else {
        randomInteger = randomInteger.nextProbablePrime();
      }
    }
    return randomInteger;
  }

  /**
   * Helper method to check if it's prime.
   *
   * @param bigInteger a BigInteger
   * @return a boolean value
   */
  private boolean isPrime(BigInteger bigInteger) {
    // Reference: https://stackoverflow.com/questions/32035259/fastest-algorithm-to-find-if-a-biginteger-is-a-prime-number-or-not/32035340
    if (bigInteger.compareTo(BigInteger.ONE) <= 0) {
      return false;
    }
    BigInteger two = BigInteger.valueOf(2);
    if (!two.equals(bigInteger) && BigInteger.ZERO.equals(bigInteger.mod(two))) {
      return false;
    }
    for (BigInteger odd = BigInteger.valueOf(3); odd.multiply(odd).compareTo(bigInteger) < 1;
        odd = odd.add(two)) {
      if (BigInteger.ZERO.equals(bigInteger.mod(odd))) {
        return false;
      }
    }
    return true;
  }

  /**
   * Get gcd.
   *
   * @param num1 a BigInteger
   * @param num2 a BigInteger
   * @return a BigInteger
   */
  private BigInteger getGcd(BigInteger num1, BigInteger num2) {
    if (num1.compareTo(BigInteger.ZERO) == 0) {
      return num2;
    }
    return getGcd(num2.mod(num1), num1);
  }

  /**
   * Get relative prime.
   *
   * @param bigInteger a BigInteger
   * @param phiX a BigInteger
   * @return a BigInteger
   */
  private BigInteger getRelativePrime(BigInteger bigInteger, BigInteger phiX) {
    SecureRandom randomGenerator;
    // https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom
    randomGenerator = new SecureRandom();
    while (true) {
      BigInteger randomInteger = new BigInteger(BIGINT_BIT_LEN, randomGenerator);
      if (getGcd(randomInteger, bigInteger).compareTo(BigInteger.ONE) == 0
          && getGcd(randomInteger, phiX).compareTo(BigInteger.ONE) == 0) {
        return randomInteger;
      }
    }
  }
}
