package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;

/**
 * Class ClientSelf contains information about a client from client's perspective.
 */
public class ClientSelf extends AbstractClient implements IClientSelf {

  private static final Integer MAX_NUM_MESSAGE = 30000;

  private RsaKeyPair publicKey;
  private RsaKeyPair privateKey;
  private RsaKeyGenerator rsaKeyGenerator;

  /**
   * Constructor that creates a new ClientSelf object, based upon all of the provided input
   * parameters.
   *
   * @param idNum the id num
   */
  public ClientSelf(Integer idNum) {
    super(idNum);
    this.rsaKeyGenerator = new RsaKeyGenerator();
    this.publicKey = rsaKeyGenerator.getPublicKey();
    this.privateKey = rsaKeyGenerator.getPrivateKey();
    System.out.println(String.format("Generate RSA key pair for client %d", idNum));
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
   * Generate message.
   *
   * @return an Integer
   */
  public Integer generateMessage() {
    Random random = new SecureRandom();
    return random.nextInt(MAX_NUM_MESSAGE + 1);
  }

  /**
   * Generate RSA signature.
   *
   * @param message the message
   * @return a BigInteger
   */
  public BigInteger generateRsaSignature(Integer message) {
    BigInteger bigIntMessage = BigInteger.valueOf(message);
    return bigIntMessage.modPow(this.privateKey.getExponent(), this.privateKey.getModulus());
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
    ClientSelf that = (ClientSelf) obj;
    return Objects.equals(getIdNum(), that.getIdNum());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getPublicKey(), privateKey, rsaKeyGenerator);
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "ClientSelf{"
        + "id=" + getIdNum()
        + '}';
  }
}
