import com.sun.javafx.PlatformUtil;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HotelBookingTest{

    WebDriver driver = new ChromeDriver();

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;
  

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();

        driver.get("https://www.cleartrip.com/");
       
        By hotelLink =By.linkText("Hotels");
        getElement(driver,hotelLink).click();

       By localityTextBox =By.id("Tags");
       getElement(driver,localityTextBox).sendKeys("Indiranagar, Bangalore");
      List<WebElement> location = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
    

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

        driver.quit();

    }
    
    public static WebElement getElement(WebDriver driver, By locator) {
    	WebDriverWait wait  = new WebDriverWait(driver,15);
    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    	WebElement element =driver.findElement(locator);
    	return element;
    }

    private void setDriverPath() {
    	 if (PlatformUtil.isMac()) {
             System.setProperty("webdriver.chrome.driver", "chromedriver");
         }
         else if (PlatformUtil.isWindows()) {
             System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
         }
         else if (PlatformUtil.isLinux()) {
             System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
