/*
 * Copyright (c) 2008. All rights reserved.
 */
package ro.isdc.wro.model.resource;

/**
 * Make a distinction between resource type. Can be CSS or JS.
 *
 * @author Alex Objelean
 * @created Created on Oct 30, 2008
 */
public enum ResourceType {
  CSS {
    @Override
    public String getContentType() {
      return "text/css";
    }
  },
  JS {
    @Override
    public String getContentType() {
      return "text/javascript";
    }
  },
  HTML {
    @Override
    public String getContentType() {
      return "text/html";
    }
  }
  ;
  /**
   * @return the content type of the resource type.
   */
  public abstract String getContentType();

  /**
   * @return {@link ResourceType} associated to the string representation of the type.
   */
  public static ResourceType get(final String typeAsString) {
    return ResourceType.valueOf(typeAsString.toUpperCase());
  }
}
