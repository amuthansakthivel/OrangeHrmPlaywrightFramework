package com.manager;

import com.factory.BrowserContextFactory;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;

public final class BrowserManager {

  private BrowserManager() {
  }

  public static void initBrowser() {
    Playwright playwright = PlaywrightManager.getPlaywrightInstance();
    BrowserContext browserContext = BrowserContextFactory.getBrowserContext(playwright);
    PlaywrightManager.setBrowserContext(browserContext);
  }

  public static void initBrowserWithExistingLoginState() {
    Playwright playwright = PlaywrightManager.getPlaywrightInstance();
    BrowserContext browserContext = BrowserContextFactory.getExistingBrowserContext(playwright);
    PlaywrightManager.setBrowserContext(browserContext);
  }

  public static void tearDown() {
    PlaywrightManager.cleanUp();
  }
}