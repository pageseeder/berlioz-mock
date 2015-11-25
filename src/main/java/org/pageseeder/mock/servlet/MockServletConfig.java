package org.pageseeder.mock.servlet;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class MockServletConfig implements ServletConfig {

  private String servletName;

  private Map<String, String> parameters = new HashMap<>();

  public MockServletConfig() {
    this.servletName = "org.example.UnnamedServlet";
  }

  @Override
  public String getInitParameter(String name) {
    return this.parameters.get(name);
  }

  @Override
  public Enumeration<String> getInitParameterNames() {
    return Collections.enumeration(this.parameters.values());
  }

  @Override
  public ServletContext getServletContext() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getServletName() {
    return this.servletName;
  }


  public void setInitParameter(String name, String value) {
    this.parameters.put(name, value);
  }
}
