package com.tests;

import com.manager.BrowserManager;
import com.manager.NavigationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestSetup {

  @BeforeEach
  public void setUp() {
    BrowserManager.initBrowser();
    NavigationManager.launchUrl();
  }

  @AfterEach
  public void tearDown() {
   BrowserManager.tearDown();
  }
}