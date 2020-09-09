package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class BankClientDatabaseTest {

  private BankClient bankClient;
  private BankClient bankClient2;
  private BankClientDatabase bankClientDatabase;
  private BankClientDatabase bankClientDatabase2;

  @Before
  public void setUp() throws Exception {
    RsaKeyPair publicKey = new RsaKeyPair(BigInteger.valueOf(231), BigInteger.valueOf(2345));
    RsaKeyPair publicKey2 = new RsaKeyPair(BigInteger.valueOf(1244), BigInteger.TEN);
    bankClient = new BankClient(23, publicKey);
    bankClient2 = new BankClient(452, publicKey2);
    bankClientDatabase = new BankClientDatabase();
    bankClientDatabase.addBankClient(bankClient);
    bankClientDatabase.addBankClient(bankClient2);
    bankClientDatabase2 = new BankClientDatabase();
    bankClientDatabase2.addBankClient(bankClient);

  }

  @Test
  public void addBankClient() {
    assertEquals(bankClient, bankClientDatabase.getBankClientMap().get(23));
  }

  @Test
  public void getBankClient() {
    assertEquals(bankClient2, bankClientDatabase.getBankClient(452));
  }

  @Test
  public void equals1() {
    assertTrue(bankClientDatabase.equals(bankClientDatabase));
    assertFalse(bankClientDatabase.equals(bankClientDatabase2));
    assertFalse(bankClientDatabase.equals(null));
    assertFalse(bankClientDatabase.equals(new Object()));
    assertFalse(bankClientDatabase.equals("q"));
  }

  @Test
  public void hashCode1() {
    assertFalse(bankClientDatabase.hashCode() == bankClientDatabase2.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals(
        "BankClientDatabase{bankClientMap={452=BankClient{publicKey=RsaKeyPair "
            + "{exponent = 1244, modulus = 10}} idNum=452, 23=BankClient{publicKey=RsaKeyPair "
            + "{exponent = 231, modulus = 2345}} idNum=23}}",
        bankClientDatabase.toString());
  }
}