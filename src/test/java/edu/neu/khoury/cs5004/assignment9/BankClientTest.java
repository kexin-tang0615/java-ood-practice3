package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class BankClientTest {

  private RsaKeyPair publicKey;
  private RsaKeyPair publicKey2;
  private BankClient bankClient;
  private AbstractClient bankClient2;



  @Before
  public void setUp() throws Exception {
    publicKey = new RsaKeyPair(BigInteger.ONE, BigInteger.TEN);
    publicKey2 = new RsaKeyPair(BigInteger.valueOf(234), BigInteger.valueOf(776));
    bankClient = new BankClient(3, publicKey);
    bankClient2 = new BankClient(27, publicKey2);
  }

  @Test
  public void verifySignature() {
    assertEquals(false, bankClient.verifySignature(24, BigInteger.ONE));
  }

  @Test
  public void equals1() {
    assertTrue(bankClient.equals(bankClient));
  }

  @Test
  public void equals2() {
    assertFalse(bankClient.equals(new Object()));
  }

  @Test
  public void equals3() {
    assertFalse(bankClient.equals(null));
  }

  @Test
  public void equals4() {
    assertFalse(bankClient.equals(new BankClient(423, publicKey)));
  }

  @Test
  public void equals5() {
    assertFalse(bankClient.equals(new BankClient(423, publicKey2)));
  }

  @Test
  public void equals6() {
    assertTrue(bankClient2.equals(bankClient2));
  }

  @Test
  public void equals7() {
    assertFalse(bankClient2.equals("a"));
  }

  @Test
  public void hashCode1() {
    assertFalse(bankClient.hashCode() == bankClient2.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals("BankClient{publicKey=RsaKeyPair {exponent = 1, modulus = 10}} idNum=3",
        bankClient.toString());
  }
}
