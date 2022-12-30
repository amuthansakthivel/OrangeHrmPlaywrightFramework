package com.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "system:env",
    "file:${user.dir}/src/test/resources/config.properties",
    "file:${user.dir}/src/test/resources/staging-config.properties",
    "file:${user.dir}/src/test/resources/development-config.properties",
})
public interface FrameworkConfig extends Config {

  @DefaultValue("chrome")
  String browser();

  boolean headless();

  @Key("${environment}.url")
  String url();

  @DefaultValue("staging")
  String environment();
}