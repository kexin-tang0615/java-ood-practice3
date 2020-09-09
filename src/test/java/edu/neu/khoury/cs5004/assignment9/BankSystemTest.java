package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class BankSystemTest {

  private BankSystem bankSystem;
  private BankSystem bankSystem2;
  private RsaKeyPair key2;

  @Before
  public void setUp() throws Exception {
    RsaKeyPair key = new RsaKeyPair(BigInteger.ONE, BigInteger.TEN);
    RequestPair requestPair = new RequestPair(0, key);
    RequestPair requestPair2 = new RequestPair(452, key2);
    key2 = new RsaKeyPair(BigInteger.valueOf(4422), BigInteger.valueOf(32));
    List<RequestPair> requestPairList = new ArrayList<>();
    requestPairList.add(requestPair);
    bankSystem = new BankSystem(requestPairList);
    List<RequestPair> requestPairList2 = new ArrayList<>();
    requestPairList2.add(requestPair2);
    bankSystem2 = new BankSystem(requestPairList2);
  }

  @Test
  public void processTransactions() {
    OutputInfo outputInfo = new OutputInfo();
    ClientSystem clientSystem = new ClientSystem(1);
    Map<Integer, MsgDigitalSignaturePair> clientRequest = clientSystem.generateSignaturePair(1,0.0);
    List<OutputInfo> outputInfoList = new ArrayList<>();
    outputInfoList = bankSystem.processTransactions(clientRequest);
    assertEquals(1, outputInfoList.size());
    assertEquals(VerifiedStatus.NO, outputInfoList.get(0).getVerifiedStatus());

  }

  @Test
  public void equals1() {
    assertTrue(bankSystem.equals(bankSystem));
    assertFalse(bankSystem.equals(bankSystem2));
    assertFalse(bankSystem.equals(null));
    assertFalse(bankSystem.equals(new Object()));
    assertFalse(bankSystem.equals("a"));
  }

  @Test
  public void hashCode1() {
    assertFalse(bankSystem.hashCode() == bankSystem2.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals(
        "BankSystem{bankClientDatabase=BankClientDatabase{bankClientMap={0=BankClient{publicKey=RsaKeyPair {exponent = 1, modulus = 10}} idNum=0}}}",
        bankSystem.toString());
  }
}