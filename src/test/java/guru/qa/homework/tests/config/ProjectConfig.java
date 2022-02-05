package guru.qa.homework.tests.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({"file:./project.properties", "classpath:default.properties"})
public interface ProjectConfig extends Config {

  @Key("base.uri")
  @DefaultValue("https://reqres.in/")
  String getBaseUri();

}
