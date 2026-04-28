import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// ✅ Correct locators
	private By firstNameLoc = By.id("first_name");
	private By lastNameLoc  = By.id("last_name");
	private By emailLoc     = By.id("email");
	private By subjectLoc   = By.id("subject");
	private By messageLoc   = By.id("message");
	private By btnSubmitLoc = By.className("btnSubmit");

	public By alertLoc = By.className("alert");

	public void fillForm() {

		// ✅ Wait for page to be ready (this fixes "too fast")
		WebElement firstName = wait.until(
				ExpectedConditions.visibilityOfElementLocated(firstNameLoc)
		);

		firstName.sendKeys("John");
		driver.findElement(lastNameLoc).sendKeys("Smith");
		driver.findElement(emailLoc).sendKeys("john.smith@example.com");

		new Select(driver.findElement(subjectLoc))
				.selectByValue("webmaster");

		driver.findElement(messageLoc)
				.sendKeys("Hello my name is John Smith. This message has more than fifty characters.");
	}

	public void submitForm() {
		driver.findElement(btnSubmitLoc).click();
	}
}
