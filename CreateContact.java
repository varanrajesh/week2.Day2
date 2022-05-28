package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact
{

    public static void main (String[] args)
    {
        String username = "DemoSalesManager";
        String password = "crmsfa";

        //Settingup WebDriver Manager's Chrome Driver
        WebDriverManager.chromedriver ( ).setup ( );
        ChromeDriver driver = new ChromeDriver ( );

        driver.manage ( ).window ( ).maximize ( );
        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 30 ) );

        //1. Launching URL "http://leaftaps.com/opentaps/control/login"
        driver.get ( "http://leaftaps.com/opentaps/control/login" );

        //2. Entering UserName and Password Using Id Locator
        //Login using username and password
        driver.findElement ( By.id ( "username" ) ).sendKeys ( username );
        driver.findElement ( By.id ( "password" ) ).sendKeys ( password );

        //3. Clickinging on Login Button using Class Locator
        driver.findElement ( By.className ( "decorativeSubmit" ) ).click ( );

        //4. Clickinging on CRM/SFA Link
        driver.findElement ( By.linkText ( "CRM/SFA" ) ).click ( );

        //5. Clicking on contacts Button
        driver.findElement ( By.linkText ( "Contacts" ) ).click ( );

        //6. Clicking on Create Contact
        driver.findElement ( By.linkText ( "Create Contact" ) ).click ( );

        //7. Enter FirstName Field Using id Locator
        driver.findElement ( By.id ( "firstNameField" ) ).sendKeys ( "Rajeshwaran" );

        //8. Enter LastName Field Using id Locator
        driver.findElement ( By.id ( "lastNameField" ) ).sendKeys ( "A" );

        //9. Enter FirstName(Local) Field Using id Locator
        driver.findElement ( By.id ( "createContactForm_firstNameLocal" ) ).sendKeys ( "Rajeshwaran" );

        //10. Enter LastName(Local) Field Using id Locator
        driver.findElement ( By.id ( "createContactForm_lastNameLocal" ) ).sendKeys ( "Angamuthu" );

        //11. Enter Department Field Using any Locator of Your Choice
        driver.findElement ( By.id ( "createContactForm_departmentName" ) ).sendKeys ( "Computer Science" );

        //12. Enter Description Field Using any Locator of your choice
        driver.findElement ( By.id ( "createContactForm_description" ) ).sendKeys ( "Description Enter here" );

        //13. Enter your email in the E-mail address Field using the locator of your choice
        driver.findElement ( By.id ( "createContactForm_primaryEmail" ) ).sendKeys ( "varanrajesh@gmail.com" );

        //14. Select State/Province as NewYork Using Visible Text
        Select province = new Select ( driver.findElement ( By.id ( "createContactForm_generalStateProvinceGeoId" ) ) );
        province.selectByVisibleText ( "New York" );

        //15. Clicking on Create Contact
        driver.findElement ( By.name ( "submitButton" ) ).click ( );

        //16. Clicking on edit button
        driver.findElement ( By.linkText ( "Edit" ) ).click ( );

        //17. Clear the Description Field using .clear
        driver.findElement ( By.id ( "updateContactForm_description" ) ).clear ( );

        //18. Fill ImportantNote Field with Any text
        driver.findElement ( By.id ( "updateContactForm_importantNote" ) ).sendKeys ( "Filling ImportantNote with Sample Data" );

        //19. Clicking on update button using Xpath locator
        driver.findElement ( By.xpath ( "//input[@name='submitButton']" ) ).click ( );

        //20. Get the Title of Resulting Page
        System.out.println ( "Title of the resulting Page: " + driver.getTitle ( ) );
        driver.close();

    }

}
