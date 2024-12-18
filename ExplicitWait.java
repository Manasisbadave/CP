package Erp.Automation.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ExplicitWait {

	public static WebElement waitForElement(RemoteWebDriver driver, String locator, int i, String locatorType) {

		FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(250));

		wait.withTimeout(Duration.ofSeconds(i));
		wait.ignoring(NoSuchElementException.class);
		wait.withMessage("Time Out reached.");

		if (locatorType.equalsIgnoreCase("id"))
			return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		else if (locatorType.equalsIgnoreCase("xpath"))
			return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		else if (locatorType.equalsIgnoreCase("name"))
			return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
		else
			return null;
	}

	public static WebElement waitForElement(RemoteWebDriver driver, WebElement e, int i) {
		FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(250));

		wait.withTimeout(Duration.ofSeconds(i));
		wait.ignoring(NoSuchElementException.class);
		wait.withMessage("Time Out reached.");

		if (e != null)
			return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(e));
		else
			return null;
	}

	public static WebElement waitForElementToBeClickAble(RemoteWebDriver driver, String locator, int i,
			String locatorType) {
		FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(250));

		wait.withTimeout(Duration.ofSeconds(i));
		wait.ignoring(NoSuchElementException.class);
		wait.withMessage("Time Out reached.");

		if (locatorType.equalsIgnoreCase("id"))

			return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
		else if (locatorType.equalsIgnoreCase("xpath"))

			return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		else if (locatorType.equalsIgnoreCase("name"))
			return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.name(locator)));
		else
			return null;
	}

	public static WebElement waitForElementToBeClickAble(RemoteWebDriver driver, WebElement e, int i) {
		FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(250));

		wait.withTimeout(Duration.ofSeconds(i));
		wait.ignoring(NoSuchElementException.class);
		wait.withMessage("Time Out reached.");

		if (e != null)
			return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(e));
		else
			return null;
	}

	public static boolean waitForTextTobeVisible(RemoteWebDriver driver, WebElement e, int i, String text) {

		FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(250));

		wait.withTimeout(Duration.ofSeconds(i));
		wait.ignoring(NoSuchElementException.class);
		wait.withMessage("Time Out reached.");

		if (e != null) {
			if (wait.until(ExpectedConditions.textToBePresentInElement(e, text))) {
				return true;
			}
		}
		return false;

	}
}
