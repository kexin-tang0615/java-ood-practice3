package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class RequestPairTest {

  private static final Integer TEST_ID = 10;
  private static final Integer TEST_ID_1 = 11;
  private static final RsaKeyPair DUMMY_KEY = new RsaKeyPair(BigInteger.ONE, BigInteger.TEN);
  private static final RsaKeyPair DUMMY_KEY_1 = new RsaKeyPair(BigInteger.TEN, BigInteger.TEN);
  private RequestPair requestPair;

  @Before
  public void setUp() {
    requestPair = new RequestPair(TEST_ID, DUMMY_KEY);
  }

  @Test
  public void testEquals() {
    assertEquals(requestPair, requestPair);
    assertNotEquals(requestPair, null);
    assertNotEquals(requestPair, new Object());
    assertEquals(requestPair, new RequestPair(TEST_ID, DUMMY_KEY));
    assertNotEquals(requestPair, new RequestPair(TEST_ID_1, DUMMY_KEY));
    assertNotEquals(requestPair, new RequestPair(TEST_ID, DUMMY_KEY_1));
  }

  @Test
  public void testGetter() {
    assertEquals(requestPair.getId(), TEST_ID);
    assertEquals(requestPair.getPubKey(), DUMMY_KEY);
  }

  @Test
  public void testHashCode() {
    assertEquals(requestPair.hashCode(), 2273);
  }

  @Test
  public void toString1() {
    assertEquals("This is a request pair:\n"
        + "{id = 10, key = RsaKeyPair {exponent = 1, modulus = 10}}", requestPair.toString());
  }
}
