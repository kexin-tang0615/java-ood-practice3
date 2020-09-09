package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Class OutputInfo contains information that would be written in a csv file.
 */
public class OutputInfo {

  private LocalDate localDate;
  private LocalTime localTime;
  private Integer idNum;
  private Integer message;
  private BigInteger digitalSignature;
  private VerifiedStatus verifiedStatus;
  private TransactionStatus transactionStatus;

  /**
   * Constructor that creates a new OutputInfo object.
   */
  public OutputInfo() {
    this.localDate = LocalDate.now();
    this.localTime = LocalTime.now();

  }

  /**
   * Gets local date.
   *
   * @return the local date
   */
  public LocalDate getLocalDate() {
    return localDate;
  }

  /**
   * Gets local time.
   *
   * @return the local time
   */
  public LocalTime getLocalTime() {
    return localTime;
  }

  /**
   * Gets id num.
   *
   * @return the id num
   */
  public Integer getIdNum() {
    return idNum;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public Integer getMessage() {
    return message;
  }

  /**
   * Gets digital signature.
   *
   * @return the digital signature
   */
  public BigInteger getDigitalSignature() {
    return digitalSignature;
  }

  /**
   * Gets verified status.
   *
   * @return the verified status
   */
  public VerifiedStatus getVerifiedStatus() {
    return verifiedStatus;
  }

  /**
   * Gets transaction status.
   *
   * @return the transaction status
   */
  public TransactionStatus getTransactionStatus() {
    return transactionStatus;
  }

  /**
   * Sets id num.
   *
   * @param idNum the id num
   */
  public void setIdNum(Integer idNum) {
    this.idNum = idNum;
  }

  /**
   * Sets message.
   *
   * @param message the message
   */
  public void setMessage(Integer message) {
    this.message = message;
  }

  /**
   * Sets digital signature.
   *
   * @param digitalSignature the digital signature
   */
  public void setDigitalSignature(BigInteger digitalSignature) {
    this.digitalSignature = digitalSignature;
  }

  /**
   * Sets verified status.
   *
   * @param verifiedStatus the verified status
   */
  public void setVerifiedStatus(VerifiedStatus verifiedStatus) {
    this.verifiedStatus = verifiedStatus;
  }

  /**
   * Sets transaction status.
   *
   * @param transactionStatus the transaction status
   */
  public void setTransactionStatus(TransactionStatus transactionStatus) {
    this.transactionStatus = transactionStatus;
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
    OutputInfo that = (OutputInfo) obj;
    return Objects.equals(getLocalDate(), that.getLocalDate())
        && Objects.equals(getLocalTime(), that.getLocalTime())
        && Objects.equals(getIdNum(), that.getIdNum())
        && Objects.equals(getMessage(), that.getMessage())
        && Objects.equals(getDigitalSignature(), that.getDigitalSignature())
        && getVerifiedStatus() == that.getVerifiedStatus()
        && getTransactionStatus() == that.getTransactionStatus();
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects
        .hash(getLocalDate(), getLocalTime(), getIdNum(), getMessage(), getDigitalSignature(),
            getVerifiedStatus(), getTransactionStatus());
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "It contains following info along with the time/date when the requests were created:\n"
        + "{"
        + "idNum=" + idNum
        + ", message=" + message
        + ", digitalSignature=" + digitalSignature
        + ", verifiedStatus=" + verifiedStatus
        + ", transactionStatus=" + transactionStatus
        + '}';
  }
}
