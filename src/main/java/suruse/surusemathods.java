package suruse;

import cucumber.api.java.en.Given;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class surusemathods extends App {
    @Test    /*Blank Data(create stream) And error Message Verification*/
    void Stream() throws InterruptedException {

        login("ankitp@jsbot.io", "asdf1234");
        Thread.sleep(5000);
        WebElement createSteam = driver.findElement(By.xpath("html/body/div[1]/nav/div[1]/div/div[1]/a"));
        createSteam.click();
        Thread.sleep(4000);
        WebElement Add = driver.findElement(By.xpath(".//*[@id='modal']/div[4]/form/div[6]/input[2]"));
        Add.click();

        WebElement errorMessage = driver.findElement(By.xpath(".//*[@id='modal']/div[4]/form/div[5]/p"));


        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue( errorMessage.getText().equals("Title should be from 3 to 50 characters"),
                "Message is displayed like : " + errorMessage.getText());
    }
    @Test   /*Stream Create with '1' Alfabate*/
void  addstm ()throws InterruptedException{

      login("ankitp@jsbot.io", "asdf1234");
      Thread.sleep(5000);
      WebElement Createsteam = driver.findElement(By.xpath("html/body/div[1]/nav/div[1]/div/div[1]/a"));
      Createsteam.click();
      Thread.sleep(5000);

      createStream(1,1);
      WebElement errorMessage = driver.findElement(By.xpath(".//*[@id='modal']/div[4]/form/div[5]/p"));
      Assert.assertTrue(errorMessage.isDisplayed());
      Assert.assertTrue( errorMessage.getText().equals("Title should be from 3 to 50 characters"),
              "Message is displayed like : " + errorMessage.getText());

}
    @Test   /*Stream Create with 2 Alfabate*/
    void  addstm2 ()throws InterruptedException{
        login("ankitp@jsbot.io", "asdf1234");
        Thread.sleep(5000);
        WebElement createSteam = driver.findElement(By.xpath("html/body/div[1]/nav/div[1]/div/div[1]/a"));
        createSteam.click();
        Thread.sleep(5000);
        createStream(2,2);
        WebElement errorMessage = driver.findElement(By.xpath(".//*[@id='modal']/div[4]/form/div[5]/p"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue( errorMessage.getText().equals("Title should be from 3 to 50 characters"), "Message is displayed like : " + errorMessage.getText());

    }
    @Test   /*Stream Create with 3 Alfabate*/
    void  addstm3 ()throws InterruptedException{

        login("ankitp@jsbot.io", "asdf1234");
        Thread.sleep(5000);
        int i = 1;
        while(i<=2) {
            createSteam();
            Thread.sleep(5000);
            createStream(3, 3);
            Thread.sleep(5000);
            i++;
        }
    }
    @Test   /*Unregister User Name At Login Page*/
    void unregisterUser () {
        login("ankit@jsbot.io", "asdf1234");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'login failed')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(errorMessage.getText().equals(errorMessage.getText()));
    }
    @Test   /*Remove Stream */
    void removeStream () throws InterruptedException {
        login("ankitp@jsbot.io", "asdf1234");
        int i = 1;
        while (i <= 10) {
            Thread.sleep(6000);
            myStream();
            Thread.sleep(6000);
            like();
            Thread.sleep(6000);
            myStream();
            Thread.sleep(4000);
            WebElement dots = driver.findElement(By.xpath("//section/div[3]/div[2]/a[2]"));
            dots.click();
            WebElement remove = driver.findElement(By.xpath("//section/div[3]/div[2]/div[2]/a[6]"));
            remove.click();
            Thread.sleep(1000);
            WebElement Yes = driver.findElement(By.xpath(".//*[@id='modal']/div[4]/div/div/input[1]"));
            Yes.click();
            Thread.sleep(4000);
            i++;
        }
    }
    @Test /*Login With Facebook*/
    void facebookLogin () throws InterruptedException {
        Thread.sleep(4000);
        WebElement fblogin = driver.findElement(By.xpath("//section/div[3]//div/a[1]"));
        fblogin.click();
        Thread.sleep(4000);
       /* String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(By.linkText("https://www.facebook.com/dialog/oauth?response_type=code&redi" +
                "rect_uri=http%3A%2F%2Fdev.suruse.com%2Fauth%2Ffacebook%2Fcallback&scope=email&client_id=" +
                "178334065859821")).sendKeys(selectLinkOpeninNewTab);*/
        // WebElement fbfail = driver.findElement(By.xpath(".//*[contains(text(),'Domains field')]"));
        WebElement findError = driver.findElement(By.xpath(".//*[@class='_50f3']"));
        Thread.sleep(4000);
        Assert.assertTrue(findError.isDisplayed());
        Assert.assertTrue(findError.getText().equals("Warning\n" +
                        "Can't load URL: The domain of this URL isn't included in the app's domains. To be able to load this " +
                        "URL, add all domains and sub-domains of your app to the App Domains field in your app settings."),
                "Message is displayed like : " + findError.getText());

    }
    @Test
     void signUp () throws InterruptedException {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement signup = driver.findElement(By.xpath("//aside//div[1]/div[6]/a[2]"));
        signup.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement fullName = driver.findElement(By.xpath("//form/div/div[1]/input[1]"));
        fullName.sendKeys("MrAnkitp#");
        WebElement errorMessage = driver.findElement(By.xpath("//section/div[3]/form/p[4]"));
        try {
            errorMessage.isDisplayed();
            errorMessage.getText().equals(" Name should be from 3 to 50 characters and can contain only " +
                                             "letters, space, dashes and apostrophe" + errorMessage.getText());
        }
        catch (Exception e){

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement userName = driver.findElement(By.xpath("//form/div/div[1]/input[2]"));
        userName.sendKeys("automatio");
        /*Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = p.matcher("userName");
        WebElement error = driver.findElement(By.xpath("//section/div[3]/form/p[4]"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertTrue(error.getText().equals("Username should be from 3 to 30 characters and can contain " +
                "only letters, numbers and underscore"));
        boolean b = m.find();*/

        WebElement eMail = driver.findElement(By.xpath("//form/div/div[1]/input[3]"));
        eMail.sendKeys("asdf12345@gmail.com");
        WebElement password = driver.findElement(By.xpath("//form/div/div[1]/input[4]"));
        password.sendKeys("asdf1234");
        WebElement cunformPassword = driver.findElement(By.xpath("//form/div/div[1]/input[5]"));
        cunformPassword.sendKeys("asdf1234");
        WebElement Agreement = driver.findElement(By.xpath("//form//div[1]/label/input"));
        Agreement.click();
        WebElement SUp = driver.findElement(By.xpath("//section/div[3]/form/input"));
        SUp.click();
        Thread.sleep(5000);
        WebElement signIn = driver.findElement(By.xpath("//section/div[3]/div[1]/p[2]/a"));
        signIn.click();
        Thread.sleep(5000);





    }


}

