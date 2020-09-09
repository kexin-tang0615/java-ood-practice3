package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class TransactionVerifierTest {

  private BankClient bankClient;
  private BankClient bankClient2;
  private TransactionVerifier transactionVerifier;
  private TransactionVerifier transactionVerifier2;

  @Before
  public void setUp() throws Exception {
    Integer message = 22234;
    Integer message2 = 2355;
    bankClient = new BankClient(4631,
        new RsaKeyPair(BigInteger.valueOf(6321), BigInteger.valueOf(933)));
    transactionVerifier = new TransactionVerifier(message, bankClient);
    bankClient2 = new BankClient(432,
        new RsaKeyPair(BigInteger.valueOf(621), BigInteger.valueOf(93)));
    transactionVerifier2 = new TransactionVerifier(message2, bankClient2);
  }

  @Test
  public void getTransactionType() {
    assertEquals(TransactionType.DEPOSIT, transactionVerifier.getTransactionType());
  }

  @Test
  public void verifyAmount() {
    int limit = bankClient.getDepositLimit();
    int amount = 2223;
    if (amount <= limit) {
      assertEquals(true, transactionVerifier.verifyAmount());
    } else {
      assertEquals(false, transactionVerifier.verifyAmount());
    }
  }

  @Test
  public void verifyAmount2() {
    int limit = bankClient2.getWithdrawalLimit();
    int amount = 235;
    if (amount <= limit) {
      assertEquals(true, transactionVerifier2.verifyAmount());
    } else {
      assertEquals(false, transactionVerifier2.verifyAmount());
    }
  }

  @Test
  public void equals1() {
    assertTrue(transactionVerifier.equals(transactionVerifier));
    assertFalse(transactionVerifier.equals(transactionVerifier2));
    assertFalse(transactionVerifier.equals(null));
    assertFalse(transactionVerifier.equals(new Object()));
    assertFalse(transactionVerifier.equals("a"));
  }

  @Test
  public void hashCode1() {
    assertFalse(transactionVerifier.hashCode() == transactionVerifier2.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals(
        "TransactionVerifier{message=22234, bankClient=BankClient{publicKey=RsaKeyPair {exponent = 6321, modulus = 933}} idNum=4631}",
        transactionVerifier.toString());
  }
}