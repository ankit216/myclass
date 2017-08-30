package suruse;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.stream.Stream;


public class App {
    WebDriver driver;
    @BeforeTest /*Open Chrome Browser*/
    public void Test1() {
        System.setProperty("webdriver.chrome.driver", "D:/ChromeWD/chromedriver.exe");
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dev.suruse.com/#/sign-in");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void login(String email, String password)
    {
        WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
        Username.sendKeys(email);

        WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
        Password.sendKeys(password);

        WebElement Login = driver.findElement(By.xpath("//input[@class='button primary']"));
        Login.click();
    }

    public void createStream(int streamLength, int noteLength) {
        //RandomStringUtils Method
        String streamName = RandomStringUtils.randomAlphanumeric(streamLength);
        String streamNote = RandomStringUtils.randomAlphanumeric(noteLength);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement StreamName = driver.findElement(By.xpath(".//*[@name='name']"));
        StreamName.sendKeys(streamName);
        WebElement StreamNote = driver.findElement(By.xpath(".//*[@name='notes']"));
        StreamNote.sendKeys(streamNote);
        WebElement Add1 = driver.findElement(By.xpath(".//*[@id='modal']/div[4]/form/div[6]/input[2]"));
        Add1.click();
    }
    public void createSteam () {
        WebElement createSteam = driver.findElement(By.xpath("//div[1]/nav//div[1]/a"));
        createSteam.click();

    }
    public void myStream (){
            WebElement myStream1 = driver.findElement(By.xpath("//*[contains(text(),'My Stream')]"));
            myStream1.click();
    }
    public void like () {
             WebElement like = driver.findElement(By.xpath("//body//nav/div[1]//div[3]/a[3]"));
             like.click();


        }

}

