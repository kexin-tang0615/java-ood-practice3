package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ClientSystemTest {
  private ClientSystem clientSystem;
  private ClientSystem clientSystem1;

  @Before
  public void setUp() {
    clientSystem = new ClientSystem(5);
    clientSystem1 = new ClientSystem(1);
  }

  @Test
  public void testGenerateSignaturePairInvalid() {
    Map<Integer, MsgDigitalSignaturePair> data = clientSystem.generateSignaturePair(2, 100.0);
    for (Map.Entry<Integer, MsgDigitalSignaturePair> entry: data.entrySet()) {
      MsgDigitalSignaturePair pair = entry.getValue();
      RsaKeyPair pubKey = clientSystem.getClientSelf(entry.getKey()).getPublicKey();
      assertNotEquals(pair.getDigitalSignature().modPow(pubKey.getExponent(), pubKey.getModulus()),
          pair.getMessage());
    }
  }

  @Test
  public void testGetClientSelf() {
    assertEquals(clientSystem.getClientSelf(0).getIdNum(), Integer.valueOf(0));
  }

  @Test
  public void testGenerateClientDataToBank() {
    List<RequestPair> data = clientSystem.generateClientDataToBank();
    assertEquals(5, data.size());
  }

  @Test
  public void testGenerateSignaturePair() {
    Map<Integer, MsgDigitalSignaturePair> digitalSignaturePairMap =
        clientSystem.generateSignaturePair(1, Double.valueOf(0));
    for (Map.Entry<Integer, MsgDigitalSignaturePair> entry: digitalSignaturePairMap.entrySet()) {
      MsgDigitalSignaturePair pair = entry.getValue();
      ClientSelf clientSelf = clientSystem.getClientSelf(entry.getKey());

      assertEquals(BigInteger.valueOf(pair.getMessage()),
          pair.getDigitalSignature().modPow(clientSelf.getPublicKey().getExponent(),
              clientSelf.getPublicKey().getModulus()));
    }
  }

  @Test
  public void testToEquals() {
    assertEquals(clientSystem, clientSystem);
    assertNotEquals(clientSystem1, clientSystem);
    assertNotEquals(clientSystem, null);
    assertNotEquals(clientSystem, new Object());
  }

  @Test
  public void testHashCode() {
    assertNotEquals(clientSystem1.hashCode(), clientSystem.hashCode());
    assertEquals(clientSystem.hashCode(), clientSystem.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("This is a client system:\n"
        + "{clientSelfDatabase=This contains ClientSelf database:\n"
        + "{clientSelfMap={0=ClientSelf{id=0}}}, numOfClients=1}", clientSystem1.toString());
  }
}
