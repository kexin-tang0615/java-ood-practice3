package edu.neu.khoury.cs5004.assignment9;

/**
 * The interface Transaction verifier.
 */
public interface ITransactionVerifier {

  /**
   * Gets transaction type.
   *
   * @return the transaction type
   */
  TransactionType getTransactionType();

  /**
   * Verify amount boolean.
   *
   * @return the boolean
   */
  boolean verifyAmount();
}
