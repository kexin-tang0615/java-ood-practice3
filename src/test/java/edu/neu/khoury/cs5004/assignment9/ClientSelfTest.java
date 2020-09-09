package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class ClientSelfTest {

  private ClientSelf clientSelf;

  @Before
  public void setUp() {
    clientSelf = new ClientSelf(0);
  }

  @Test
  public void getPublicKey() {
    assertNotNull(clientSelf.getPublicKey());
  }

  @Test
  public void generateMessage() {
    assertNotNull(clientSelf.generateMessage());
  }

  @Test
  public void generateRsaSignature() {
    BigInteger signature = clientSelf.generateRsaSignature(123);
    assertEquals(signature.modPow(clientSelf.getPublicKey().getExponent(),
        clientSelf.getPublicKey().getModulus()),
        BigInteger.valueOf(123));
  }

  @Test
  public void testToEquals() {
    assertEquals(clientSelf, clientSelf);
    assertEquals(clientSelf, new ClientSelf(0));
    assertNotEquals(clientSelf, null);
    assertNotEquals(clientSelf, new ClientSelf(1));
    assertNotEquals(clientSelf, new Object());
  }

  @Test
  public void testHashCode() {
    assertEquals(clientSelf.hashCode(), clientSelf.hashCode());
    assertNotEquals(clientSelf.hashCode(), new ClientSelf(1).hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("ClientSelf{id=0}", clientSelf.toString());
  }
}