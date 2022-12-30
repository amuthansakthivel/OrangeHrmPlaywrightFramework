package com.factory;

import com.config.ConfigFactory;
import com.config.FrameworkConfig;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public final class BrowserContextFactory {

  private BrowserContextFactory() {
  }

  private static final Map<String, Function<Playwright, Supplier<Browser>>> BROWSER_MAP = new HashMap<>();
  private static final FrameworkConfig CONFIG = ConfigFactory.getConfig();
  private static final String BROWSER = CONFIG.browser().toLowerCase();
  private static final boolean IS_HEADLESS = CONFIG.headless();

  static {
    BROWSER_MAP.put("firefox", playwright -> () -> playwright.firefox().launch(getLaunchOptions()));
    BROWSER_MAP.put("chrome", playwright -> () -> playwright.chromium().launch(getLaunchOptions()));
  }

  public static BrowserContext getBrowserContext(Playwright playwright) {
    return BROWSER_MAP.get(BROWSER).apply(playwright).get().newContext();
  }

  private static BrowserType.LaunchOptions getLaunchOptions() {
    return new BrowserType.LaunchOptions().setHeadless(IS_HEADLESS).setChannel(BROWSER);
  }

}