package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.loggers.ConsoleEventLogger;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  private Client client;

  private EventLogger eventLogger;

  public static void main(String[] args){

    ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    App app = (App) ctx.getBean("app");

    Event event = ctx.getBean(Event.class);
    app.logEvent(event, "Some event for 1");

    event = ctx.getBean(Event.class);
    app.logEvent(event, "Some event for 2");

    ctx.close();
  }

  public App(Client client, EventLogger eventLogger) {
    super();
    this.client = client;
    this.eventLogger = eventLogger;
  }

  private void logEvent(Event event, String msg){
    event.setMsg(msg.replaceAll(client.getId(), client.getFullName()));
    eventLogger.logEvent(event);
  }

}
