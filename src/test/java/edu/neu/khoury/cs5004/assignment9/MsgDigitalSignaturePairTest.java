package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class MsgDigitalSignaturePairTest {

  private MsgDigitalSignaturePair pair;

  @Before
  public void setUp() {
    pair = new MsgDigitalSignaturePair(1, BigInteger.TEN);
  }

  @Test
  public void testToEquals() {
    assertEquals(pair, pair);
    assertEquals(pair, new MsgDigitalSignaturePair(1, BigInteger.TEN));
    assertNotEquals(pair, null);
    assertNotEquals(pair, new Object());
    assertNotEquals(pair, new MsgDigitalSignaturePair(2, BigInteger.TEN));
    assertNotEquals(pair, new MsgDigitalSignaturePair(1, BigInteger.ONE));
  }

  @Test
  public void testHashCode() {
    assertEquals(1002, pair.hashCode());
  }

  @Test
  public void testGetter() {
    assertEquals(Integer.valueOf(1), pair.getMessage());
    assertEquals(BigInteger.TEN, pair.getDigitalSignature());
  }

  @Test
  public void toString1() {
    assertEquals("This is a Message Digital Signature Pair {message = 1, digitalSignature = 10}",
        pair.toString());
  }
}
