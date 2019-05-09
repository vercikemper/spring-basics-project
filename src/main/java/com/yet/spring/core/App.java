package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.loggers.ConsoleEventLogger;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  private Client client;

  private EventLogger eventLogger;

  public static void main(String[] args){

    //@SuppressWarnings("resource") // We will remove this suppress in further lessons
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    App app = (App) ctx.getBean("app");

    app.logEvent("Some event for 1");
    app.logEvent("Some event for 2");
  }

  public App(Client client, EventLogger eventLogger) {
    super();
    this.client = client;
    this.eventLogger = eventLogger;
  }

  private void logEvent(String msg){
    eventLogger.logEvent(msg.replaceAll(client.getId(), client.getFullName()));
  }

}
