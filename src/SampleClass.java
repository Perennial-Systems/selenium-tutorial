import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleClass {
    private WebDriver driver;

    public static void main(String[] args) {
        for (String arg : args) {
            SampleClass c = new SampleClass();
            switch (arg) {
                case "chrome":
                    c.chrome();
                    c.run();
                    break;
                case "firefox":
                    c.firefox();
                    c.run();
                    break;
                default:
                    System.err.println("Invalid browser input. Please use either chrome or firefox");
            }
        }
    }

    private void chrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/ajitem/Downloads/chromedriver");
        this.driver = new ChromeDriver();
    }

    private void firefox() {
        System.setProperty("webdriver.gecko.driver", "/Users/ajitem/Downloads/geckodriver");
        this.driver = new FirefoxDriver();
    }

    private void run() {
        this.driver.get("https://www.google.com");

        checkElementAttribute("gNO89b", "value", "Google search");
        checkElementAttribute("RNmpXc", "value", "Im Feeling Lucky");

        this.driver.close();
    }

    private void checkElementAttribute(String className, String attributeName, String expectedValue) {
        WebElement element = this.driver.findElement(By.className(className));
        String value = element.getAttribute(attributeName);

        if (!value.equals(expectedValue)) {
            System.err.printf("FAILED for %s attribute with class path %s: expected %s but got %s\n", attributeName, className, expectedValue, value);
        }
    }
}
