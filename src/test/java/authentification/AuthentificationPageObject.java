package authentification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthentificationPageObject {


    // declaration des selecteurs

    public final static String USENAME_ID = "user-name";

   // public final static String PASSWORD_XPATH = "//*[@id=\"password\"]";
   public final static String PASSWORD_ID = "password";


  //  public final static String LOGIN_XPATH = "//*[@id=\"login-button\"]";
  public final static String LOGIN_ID = "login-button";

    public final static String VERIF_MSG_XPATH = "//*[@id=\"inventory_filter_container\"]/div";




    //declaration des elements web

    @FindBy(how = How.ID, using = USENAME_ID)
    public WebElement username;

    @FindBy (how = How.ID, using = PASSWORD_ID)
    public WebElement password;

    @FindBy (how = How.ID, using = LOGIN_ID)
    public WebElement login;

    @FindBy (how = How.XPATH  , using = VERIF_MSG_XPATH)
    public WebElement verifAccueil;




   //creation des methodes

    public void saisirUsername(String username) {

        this.username.sendKeys(username);

    }


    public void saisirPassword(String pwd) {
        this.password.sendKeys(pwd);
    }


    public void cliquerBtnlogin() {

        this.login.click();
    }

    public String msgObtenu() {
        return verifAccueil.getText() ;
        }





}
