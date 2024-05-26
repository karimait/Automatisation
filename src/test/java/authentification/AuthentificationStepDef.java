package authentification;


import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.WaitMethods;

import java.io.IOException;

public class AuthentificationStepDef {


    // declaration


   // WebDriver driver;
    ChromeDriver driver;
    AuthentificationPageObject authentification;
    CommonMethods common = new  CommonMethods();

    WaitMethods waitMethods = new WaitMethods();


    public AuthentificationStepDef(){

        //driver = Setup.driver;
        driver= new ChromeDriver();

        authentification= new AuthentificationPageObject();
        PageFactory.initElements(driver,authentification);
    }






        @Given("je me connecte sur l'application")
        public void je_me_connecte_sur_l_application() throws IOException {
            driver.get("https://www.saucedemo.com/v1/index.html");

        }


    @When("je saisis le login {string}")
    public void je_saisis_le_login(String username) {
           //String selecteur = authentification.USENAME_ID;
           // waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 10);
            authentification.saisirUsername(username);
        }

    @When("je saisis le password {string}")
    public void je_saisis_le_password(String password) {

            //String selecteur = authentification.PASSWORD_ID;
           // waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 10);

            authentification.saisirPassword(password);


        }


        @When("je clique sur le bouton login")
        public void je_clique_sur_le_bouton_login() {

            //String selecteur = authentification.LOGIN_ID;
            //waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, selecteur, 10);

            authentification.cliquerBtnlogin();


        }
        @Then("je me redirige vers la page d'accueil s'affiche")
        public void je_me_redirige_vers_la_page_d_accueil_s_affiche() {

            String selecteur = authentification.VERIF_MSG_XPATH;
            waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 10);
            String messageObt = authentification.msgObtenu();
            String resultAttendu ="Products";
            Assertions.assertEquals(messageObt,resultAttendu);

        }




    @AfterStep
    public void afterStep(Scenario scenario) {

        //validate if scenario has failed
        if(scenario.isFailed()) {
            //final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            //scenario.attach(screenshot, "image/png", scenario.getName());
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }




   }

