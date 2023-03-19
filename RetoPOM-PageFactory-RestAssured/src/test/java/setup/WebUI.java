package setup;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebUI {
    protected WebDriver driver;



    private void setUpWebDriverUrl (){
        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--remote-allow-origins=*");
        edgeoptions.addArguments("-inprivate");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(EdgeOptions.CAPABILITY, edgeoptions);
        edgeoptions.merge(capabilities);
        driver = new EdgeDriver(edgeoptions);
        driver.get(ConstantSetup.WEB_PAGE_URL);
        maximize();
    }

    protected void generalSetUp(){
        setUpWebDriverUrl();
    }

    protected void quitDriver(){
        driver.quit();
    }

    private void maximize(){
        driver.manage().window().maximize();
    }


}
