/*
 * Copyright (C) 2011.
 * All rights reserved.
 */
package ro.isdc.wro.examples.manager;

import ro.isdc.wro.examples.processor.AnotherRelativePathPrependerPostProcessor;
import ro.isdc.wro.manager.factory.standalone.DefaultStandaloneContextAwareManagerFactory;
import ro.isdc.wro.model.resource.processor.factory.ProcessorsFactory;
import ro.isdc.wro.model.resource.processor.factory.SimpleProcessorsFactory;
import ro.isdc.wro.model.resource.processor.impl.css.CssImportPreProcessor;

/**
 * @author Alex Objelean
 */
public class CustomWroManagerFactory extends DefaultStandaloneContextAwareManagerFactory {
  /**
   * Custom factory.
   */
  @Override
  protected ProcessorsFactory newProcessorsFactory() {
    final SimpleProcessorsFactory factory = new SimpleProcessorsFactory();
    /* PreProcessors */
    factory.addPreProcessor(new CssImportPreProcessor());
    factory.addPostProcessor(new AnotherRelativePathPrependerPostProcessor());
//  factory.addPostProcessor(new RelativePathPrependerPostProcessor());
    /* PostProcessors */
    return factory;
  }
}

