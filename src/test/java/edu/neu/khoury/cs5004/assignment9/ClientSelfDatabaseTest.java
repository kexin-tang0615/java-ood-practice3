package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ClientSelfDatabaseTest {

  private ClientSelfDatabase clientSelfDatabase;
  private ClientSelf clientSelf;

  @Before
  public void setUp() {
    clientSelfDatabase = new ClientSelfDatabase();
    clientSelf = new ClientSelf(0);
  }

  @Test
  public void addAndGetClient() {
    clientSelfDatabase.addClient(clientSelf);
    assertEquals(clientSelf, clientSelfDatabase.getClientSelf(0));
  }

  @Test
  public void generateClientData() {
    clientSelfDatabase.addClient(clientSelf);
    List<RequestPair> data = clientSelfDatabase.generateClientData();
    assertEquals(data.size(), 1);
    assertEquals(clientSelf.getPublicKey(), data.get(0).getPubKey());
  }

  @Test
  public void testToEquals() {
    ClientSelfDatabase clientSelfDatabase1 = new ClientSelfDatabase();
    clientSelfDatabase1.addClient(clientSelf);

    assertEquals(clientSelfDatabase, clientSelfDatabase);
    assertNotEquals(clientSelfDatabase, clientSelfDatabase1);
    assertNotEquals(clientSelfDatabase, null);
    assertNotEquals(clientSelfDatabase1, new Object());

    clientSelfDatabase.addClient(clientSelf);
    assertEquals(clientSelfDatabase, clientSelfDatabase1);
  }

  @Test
  public void testToHashCode() {
    ClientSelfDatabase clientSelfDatabase1 = new ClientSelfDatabase();
    clientSelfDatabase1.addClient(clientSelf);
    assertEquals(clientSelfDatabase.hashCode(),
        clientSelfDatabase.hashCode());
    assertNotEquals(clientSelfDatabase1.hashCode(),
        clientSelfDatabase.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("This contains ClientSelf database:\n"
        + "{clientSelfMap={}}",
        clientSelfDatabase.toString());
  }
}