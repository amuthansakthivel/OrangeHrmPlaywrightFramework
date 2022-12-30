package com.manager;

import com.config.ConfigFactory;

public final class NavigationManager {

  private NavigationManager() {
  }

  private static final String URL = ConfigFactory.getConfig().url();

  public static void launchUrl() {
    PlaywrightManager.getPage().navigate(URL);
  }
}