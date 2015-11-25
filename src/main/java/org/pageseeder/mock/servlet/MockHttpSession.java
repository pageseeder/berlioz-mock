package org.pageseeder.mock.servlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class MockHttpSession implements HttpSession {

  private long creationTime = System.currentTimeMillis();

  private String id = UUID.randomUUID().toString();

  private Map<String, Object> attributes = new HashMap<>();

  private boolean valid = true;

  private int maxInactiveInterval = 60;

  @Override
  public long getCreationTime() {
    checkIfValid();
    return this.creationTime;
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public long getLastAccessedTime() {
    checkIfValid();
    // TODO Auto-generated method stub
    return this.creationTime;
  }

  @Override
  public ServletContext getServletContext() {
    return null;
  }

  @Override
  public void setMaxInactiveInterval(int interval) {
    this.maxInactiveInterval = interval;
  }

  @Override
  public int getMaxInactiveInterval() {
    return this.maxInactiveInterval;
  }

  @Override
  public HttpSessionContext getSessionContext() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Object getAttribute(String name) {
    checkIfValid();
    return this.attributes.get(name);
  }

  @Override
  public Object getValue(String name) {
    checkIfValid();
    return this.attributes.get(name);
  }

  @Override
  public Enumeration<String> getAttributeNames() {
    checkIfValid();
    return Collections.enumeration(this.attributes.keySet());
  }

  @Override
  public String[] getValueNames() {
    checkIfValid();
    List<String> names = new ArrayList<>(this.attributes.keySet());
    return names.toArray(new String[names.size()]);
  }

  @Override
  public void setAttribute(String name, Object value) {
    checkIfValid();
    this.attributes.put(name, value);
  }

  @Override
  public void putValue(String name, Object value) {
    checkIfValid();
    this.attributes.put(name, value);
  }

  @Override
  public void removeAttribute(String name) {
    checkIfValid();
    this.attributes.remove(name);
  }

  @Override
  public void removeValue(String name) {
    checkIfValid();
    this.attributes.remove(name);
  }

  @Override
  public void invalidate() {
    this.valid = false;
  }

  @Override
  public boolean isNew() {
    // TODO Auto-generated method stub
    return false;
  }


  private void checkIfValid() {
    if (!this.valid) throw new IllegalStateException("HttpSession is no longer valid");
  }
}
