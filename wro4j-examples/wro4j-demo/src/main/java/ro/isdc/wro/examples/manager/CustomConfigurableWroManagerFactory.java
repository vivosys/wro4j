package ro.isdc.wro.examples.manager;

import java.util.ArrayList;
import java.util.List;

import ro.isdc.wro.manager.factory.ConfigurableWroManagerFactory;
import ro.isdc.wro.model.WroModel;
import ro.isdc.wro.model.group.Group;
import ro.isdc.wro.util.Transformer;

public class CustomConfigurableWroManagerFactory extends ConfigurableWroManagerFactory {
  public CustomConfigurableWroManagerFactory() {
    addModelTransformer(new CustomModelTransformer());
  }
  
  private static class CustomModelTransformer implements Transformer<WroModel> {
    @Override
    public WroModel transform(final WroModel model)
        throws Exception {
      final List<Group> secureGroups = new ArrayList<Group>();
      for (final Group group : model.getGroups()) {
        Group secureGroup = new Group("https-" + group.getName());
        secureGroup.setResources(group.getResources());
        secureGroups.add(secureGroup);
      }
      for (Group group : secureGroups) {
        model.addGroup(group);
      }
      return model;
    }
  }
}
