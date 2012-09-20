package ro.isdc.wro.examples.processor;

import ro.isdc.wro.model.resource.ResourceType;
import ro.isdc.wro.model.resource.SupportedResourceType;
import ro.isdc.wro.model.resource.processor.impl.css.AbstractCssUrlRewritingProcessor;

@SupportedResourceType(ResourceType.CSS)
public class RelativePathPrependerPostProcessor extends AbstractCssUrlRewritingProcessor {
  /**
   * Changing the relative path of the resource.
   *
   * @param cssUri ignored by this method.
   * @param imageUrl URL that is converted.
   * @return resource URL with one more path level.
   */
  @Override
  protected String replaceImageUrl(final String cssUri, final String imageUrl) {
    if (imageUrl.startsWith("../")) {
      return "../" + imageUrl;
    }
    return imageUrl;
  }
}
