package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class BankSystem contains information about bank system.
 */
public class BankSystem implements IBankSystem {

  private BankClientDatabase bankClientDatabase;

  /**
   * Constructor that creates a new BankClientDatabase object, based upon all of the provided input
   * parameters.
   *
   * @param clients the clients
   */
  public BankSystem(List<RequestPair> clients) {
    this.bankClientDatabase = new BankClientDatabase();
    for (RequestPair item : clients) {
      BankClient bankClient = new BankClient(item.getId(), item.getPubKey());
      bankClientDatabase.addBankClient(bankClient);
    }
  }

  /**
   * Process transactions.
   *
   * @param pairMap the pair map
   * @return a list of OutputInfo objects
   */
  @Override
  public List<OutputInfo> processTransactions(Map<Integer, MsgDigitalSignaturePair> pairMap) {
    List<OutputInfo> outputInfoList = new ArrayList<>();

    // counter for matched signature and valid transaction. used for console output.
    int countSignatureNoMatch = 0;
    int countValid = 0;

    for (Map.Entry<Integer, MsgDigitalSignaturePair> entry : pairMap.entrySet()) {
      OutputInfo outputInfo = new OutputInfo();

      MsgDigitalSignaturePair pair = entry.getValue();
      Integer idNum = entry.getKey();

      Integer msg = pair.getMessage();
      BigInteger signature = pair.getDigitalSignature();

      BankClient bankClient = this.bankClientDatabase.getBankClient(idNum);
      TransactionVerifier verifier = new TransactionVerifier(msg, bankClient);

      Boolean verifiedSignature = bankClient.verifySignature(msg, signature);
      if (verifiedSignature) {
        countSignatureNoMatch++;
      }

      Boolean verifiedAmount = verifier.verifyAmount();
      Boolean verified = verifiedSignature && verifiedAmount;
      if (verified) {
        System.out.println("Transaction is valid.");
        countValid++;
        if (verifier.getTransactionType() == TransactionType.DEPOSIT) {
          outputInfo.setTransactionStatus(TransactionStatus.DEPOSIT_ACCEPTED);
          outputInfo.setVerifiedStatus(VerifiedStatus.YES);
        } else {
          outputInfo.setTransactionStatus(TransactionStatus.WITHDRAWAL_ACCEPTED);
          outputInfo.setVerifiedStatus(VerifiedStatus.YES);
        }
      } else {
        System.out.println("Transaction is not valid.");

        if (verifier.getTransactionType() == TransactionType.DEPOSIT) {
          outputInfo.setTransactionStatus(TransactionStatus.DEPOSIT_REJECTED);
          outputInfo.setVerifiedStatus(VerifiedStatus.NO);
        } else {
          outputInfo.setTransactionStatus(TransactionStatus.WITHDRAWAL_REJECTED);
          outputInfo.setVerifiedStatus(VerifiedStatus.NO);
        }
      }
      outputInfo.setIdNum(idNum);
      outputInfo.setDigitalSignature(signature);
      outputInfo.setMessage(msg);

      outputInfoList.add(outputInfo);
    }
    System.out.println(
        String.format("Signature match %d/%d", countSignatureNoMatch, outputInfoList.size()));
    System.out.println(String.format("Valid transaction %d/%d", countValid, outputInfoList.size()));

    return outputInfoList;
  }

  /**
   * Returns the boolean value whether this equals to the given obj.
   *
   * @return the boolean value whether this equals to the given obj
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    BankSystem that = (BankSystem) obj;
    return Objects.equals(bankClientDatabase, that.bankClientDatabase);
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(bankClientDatabase);
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "BankSystem{"
        + "bankClientDatabase=" + bankClientDatabase
        + '}';
  }
}
