package com.ubs.fatca;

import com.ubs.fatca.util.PropertyLoader;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import ru.stqa.selenium.factory.WebDriverFactory;


/**
 * Base class for all the JUnit-based test classes
 */
public class JUnitTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  @ClassRule
  public static ExternalResource webDriverProperties = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      baseUrl = PropertyLoader.loadProperty("site.url");
      gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
      capabilities = PropertyLoader.loadCapabilities();
    };
  };

  @Rule
  public ExternalResource webDriver = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      driver = WebDriverFactory.getDriver(capabilities);
    };
  };
}
