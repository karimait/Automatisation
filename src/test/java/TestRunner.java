import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.Utile;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RunWith(Cucumber.class)
@CucumberOptions(

        tags = {"@POEC24-1060"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report/cucumber.json","junit:target/surefire-reports/cucumber.xml"},
        glue = {"authentification"},
        features={"src/test/resources/features"}
)


public class TestRunner {
    static Utile ImportToXray = new Utile();
    @AfterClass
    public static void after() throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {
        ImportToXray.ImportToXray();
    }





}