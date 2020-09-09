package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class OutputInfoTest {

  private OutputInfo outputInfo;
  private OutputInfo outputInfo2;

  @Before
  public void setUp() throws Exception {
    Integer idNum = 1;
    Integer message = 2345;
    BigInteger digitalSignature = BigInteger.TEN;
    VerifiedStatus verifiedStatus = VerifiedStatus.YES;
    TransactionStatus transactionStatus = TransactionStatus.DEPOSIT_ACCEPTED;
    outputInfo = new OutputInfo();
    outputInfo2 = new OutputInfo();
    outputInfo.setIdNum(idNum);
    outputInfo.setDigitalSignature(digitalSignature);
    outputInfo.setMessage(message);
    outputInfo.setVerifiedStatus(verifiedStatus);
    outputInfo.setTransactionStatus(transactionStatus);

  }


  @Test
  public void getIdNum() {
    assertEquals((Integer) 1, outputInfo.getIdNum());
  }

  @Test
  public void getMessage() {
    assertEquals((Integer) 2345, outputInfo.getMessage());
  }

  @Test
  public void getDigitalSignature() {
    assertEquals(BigInteger.TEN, outputInfo.getDigitalSignature());
  }

  @Test
  public void getVerifiedStatus() {
    assertEquals(VerifiedStatus.YES, outputInfo.getVerifiedStatus());
  }

  @Test
  public void getTransactionStatus() {
    assertEquals(TransactionStatus.DEPOSIT_ACCEPTED, outputInfo.getTransactionStatus());
  }

  @Test
  public void equals1() {
    assertTrue(outputInfo.equals(outputInfo));
  }

  @Test
  public void equals2() {
    assertFalse(outputInfo.equals(outputInfo2));
  }

  @Test
  public void equals3() {
    assertFalse(outputInfo.equals(null));
  }

  @Test
  public void equals4() {
    assertFalse(outputInfo.equals(new Object()));
    assertFalse(outputInfo.equals("a"));
  }

  @Test
  public void equals6() {
    outputInfo2.setIdNum(1);
    outputInfo2.setMessage(234);
    outputInfo2.setDigitalSignature(BigInteger.TEN);
    outputInfo2.setVerifiedStatus(VerifiedStatus.YES);
    outputInfo2.setTransactionStatus(TransactionStatus.DEPOSIT_ACCEPTED);
    assertFalse(outputInfo.equals(outputInfo2));
  }

  @Test
  public void equals7() {
    outputInfo2.setIdNum(1);
    outputInfo2.setMessage(2345);
    outputInfo2.setDigitalSignature(BigInteger.valueOf(652));
    outputInfo2.setVerifiedStatus(VerifiedStatus.YES);
    outputInfo2.setTransactionStatus(TransactionStatus.DEPOSIT_ACCEPTED);
    assertFalse(outputInfo.equals(outputInfo2));
  }

  @Test
  public void equals8() {
    outputInfo2.setIdNum(1);
    outputInfo2.setMessage(2345);
    outputInfo2.setDigitalSignature(BigInteger.TEN);
    outputInfo2.setVerifiedStatus(VerifiedStatus.NO);
    outputInfo2.setTransactionStatus(TransactionStatus.DEPOSIT_ACCEPTED);
    assertFalse(outputInfo.equals(outputInfo2));
  }

  @Test
  public void equals9() {
    outputInfo2.setIdNum(1);
    outputInfo2.setMessage(2345);
    outputInfo2.setDigitalSignature(BigInteger.TEN);
    outputInfo2.setVerifiedStatus(VerifiedStatus.YES);
    outputInfo2.setTransactionStatus(TransactionStatus.WITHDRAWAL_ACCEPTED);
    assertFalse(outputInfo.equals(outputInfo2));
  }

  @Test
  public void hashCode1() {
    assertFalse(outputInfo.hashCode() == outputInfo2.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals(
        "It contains following info along with the time/date when the requests were created:\n"
            + "{idNum=1, message=2345, digitalSignature=10, verifiedStatus=YES, transactionStatus=DEPOSIT_ACCEPTED}",
        outputInfo.toString());
  }
}