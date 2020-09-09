package edu.neu.khoury.cs5004.assignment9;

import java.util.Objects;

/**
 * Class TransactionVerifier contains information about a transaction verifier.
 */
public class TransactionVerifier implements ITransactionVerifier {

  private static final Integer LAST_DIGIT_BOUND = 5;
  private static final Integer MODULUS = 10;
  private Integer message;
  private BankClient bankClient;

  /**
   * Constructor that creates a new TransactionVerifier object, based upon all of the provided input
   * parameters.
   *
   * @param message the message
   * @param bankClient the bank client
   */
  public TransactionVerifier(Integer message, BankClient bankClient) {
    this.message = message;
    this.bankClient = bankClient;
  }

  /**
   * Get transaction type.
   *
   * @return TransactionType
   */
  public TransactionType getTransactionType() {
    int lastDigit = message % MODULUS;
    if (lastDigit < LAST_DIGIT_BOUND) {
      return TransactionType.DEPOSIT;
    } else {
      return TransactionType.WITHDRAW;
    }
  }

  /**
   * Verify amount.
   *
   * @return a boolean value
   */
  public boolean verifyAmount() {
    int lastDigit = message % MODULUS;
    int amount = (this.message - lastDigit) / MODULUS;

    int limit;
    if (getTransactionType() == TransactionType.DEPOSIT) {
      limit = this.bankClient.getDepositLimit();

    } else {
      limit = this.bankClient.getWithdrawalLimit();
    }
    boolean res = amount <= limit;
    if (!res) {
      System.out.println(
          String.format("Transaction %s amount is not valid. Limit is %d, but actual is %d",
              getTransactionType(),
              limit,
              amount));
    }
    return res;
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
    TransactionVerifier that = (TransactionVerifier) obj;
    return Objects.equals(message, that.message)
        && Objects.equals(bankClient, that.bankClient);
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(message, bankClient);
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "TransactionVerifier{"
        + "message=" + message
        + ", bankClient=" + bankClient
        + '}';
  }
}
