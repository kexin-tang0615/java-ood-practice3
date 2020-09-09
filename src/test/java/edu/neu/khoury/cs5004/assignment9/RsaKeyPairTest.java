package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class RsaKeyPairTest {

  private RsaKeyPair key;

  @Before
  public void setUp() {
    key = new RsaKeyPair(BigInteger.ONE, BigInteger.TEN);
  }

  @Test
  public void testGetter() {
    assertEquals(key.getExponent(), BigInteger.ONE);
    assertEquals(key.getModulus(), BigInteger.TEN);
  }

  @Test
  public void testEquals() {
    assertEquals(key, key);
    assertNotEquals(key, null);
    assertNotEquals(key, new Object());
    assertEquals(key, new RsaKeyPair(BigInteger.ONE, BigInteger.TEN));
    assertNotEquals(key, new RsaKeyPair(BigInteger.TEN, BigInteger.TEN));
    assertNotEquals(key, new RsaKeyPair(BigInteger.ONE, BigInteger.ONE));
  }

  @Test
  public void hashCode1() {
    RsaKeyPair key2 = new RsaKeyPair(BigInteger.ONE, BigInteger.ONE);
    assertFalse(key.hashCode() == key2.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals("RsaKeyPair {exponent = 1, modulus = 10}", key.toString());
  }


}
