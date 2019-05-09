package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.ConsoleEventLogger;

public class App {

  private Client client;

  private ConsoleEventLogger eventLogger;

  public static void main(String[] args){
    App app = new App();

    app.client = new Client("1", "John Smith");

    app.eventLogger = new ConsoleEventLogger();

    app.logEvent("Some event for user 1");
  }

  private void logEvent(String msg){
    eventLogger.logEvent(msg.replaceAll(client.getId(), client.getFullName()));
  }

}
