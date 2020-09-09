package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Random;

/**
 * Class BankClient contains information about a client from bank's perspective.
 */
public class BankClient extends AbstractClient implements IBankClient {

  private static final Integer MAX_DEPOSIT = 2000;
  private static final Integer MAX_WITHDRAWAL = 3000;
  private RsaKeyPair publicKey;
  private Integer depositLimit;
  private Integer withdrawalLimit;


  /**
   * Constructor that creates a new BankClient object, based upon all of the provided input
   * parameters.
   *
   * @param idNum the id num
   * @param publicKey the public key
   */
  public BankClient(Integer idNum, RsaKeyPair publicKey) {
    super(idNum);
    this.publicKey = publicKey;
    this.depositLimit = new Random().nextInt(MAX_DEPOSIT + 1);
    this.withdrawalLimit = new Random().nextInt(MAX_WITHDRAWAL + 1);
  }

  /**
   * Verify signature.
   *
   * @param message the message
   * @param signature the signature
   * @return the boolean value
   */
  @Override
  public Boolean verifySignature(Integer message, BigInteger signature) {
    BigInteger decode = signature.modPow(publicKey.getExponent(), publicKey.getModulus());
    boolean res = decode.equals(BigInteger.valueOf(message));
    if (!res) {
      System.out.println("Signature validation fails");
      System.out.println(String.format("Decoded: %s, original: %s", decode, message));
    }
    return res;
  }

  /**
   * Gets deposit limit.
   *
   * @return the deposit limit
   */
  public Integer getDepositLimit() {
    return depositLimit;
  }

  /**
   * Gets withdrawal limit.
   *
   * @return the withdrawal limit
   */
  public Integer getWithdrawalLimit() {
    return withdrawalLimit;
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
    BankClient that = (BankClient) obj;
    return Objects.equals(publicKey, that.publicKey)
        && Objects.equals(getDepositLimit(), that.getDepositLimit())
        && Objects.equals(getWithdrawalLimit(), that.getWithdrawalLimit());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), publicKey, getDepositLimit(), getWithdrawalLimit());
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "BankClient{"
        + "publicKey=" + publicKey
        + "} " + super.toString();
  }
}

