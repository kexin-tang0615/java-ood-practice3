package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RSAKeyGeneratorTest {

  private RsaKeyGenerator generator;

  @Before
  public void setUp() {
    generator = new RsaKeyGenerator();
  }

  @Test
  public void testVerifyKey() {
    for (int i = 0; i < 10; i++) {
      RsaKeyPair pubKey = generator.getPublicKey();
      RsaKeyPair priKey = generator.getPrivateKey();
      BigInteger signature = BigInteger.valueOf(i)
          .modPow(pubKey.getExponent(), pubKey.getModulus());
      BigInteger decode = signature.modPow(priKey.getExponent(), priKey.getModulus());

      assertEquals(BigInteger.valueOf(i), decode);
    }
  }

}
