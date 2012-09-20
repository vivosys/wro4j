package ro.isdc.wro.examples.processor;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import ro.isdc.wro.model.group.Inject;
import ro.isdc.wro.model.group.processor.Injector;
import ro.isdc.wro.model.resource.Resource;
import ro.isdc.wro.model.resource.ResourceType;
import ro.isdc.wro.model.resource.SupportedResourceType;
import ro.isdc.wro.model.resource.processor.ResourcePostProcessor;


@SupportedResourceType(ResourceType.CSS)
public class AnotherRelativePathPrependerPostProcessor
    implements ResourcePostProcessor {
  @Inject
  private Injector injector;
  
  /**
   * {@inheritDoc}
   */
  public void process(final Reader reader, final Writer writer)
      throws IOException {
    final Resource resource = Resource.create("/", ResourceType.CSS);
    getProcessor().process(resource, reader, writer);
  }
  
  private RelativePathPrependerPostProcessor getProcessor() {
    final RelativePathPrependerPostProcessor processor = new RelativePathPrependerPostProcessor();
    injector.inject(processor);
    return processor;
  }
}
