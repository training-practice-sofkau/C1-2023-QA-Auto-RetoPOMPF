package setup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;
import static util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {
    protected WebDriver driver;



    private void setUpEdgeWebDriverUrl (String URL){
        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--remote-allow-origins=*");
        edgeoptions.addArguments("-inprivate");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(EdgeOptions.CAPABILITY, edgeoptions);
        edgeoptions.merge(capabilities);
        driver = new EdgeDriver(edgeoptions);
        driver.get(URL);
        maximize();
    }
    private void setUpChromeWebDriverUrl (String URL){
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        chromeoptions.addArguments("--incognito");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(EdgeOptions.CAPABILITY, chromeoptions);
        chromeoptions.merge(capabilities);
        driver = new ChromeDriver(chromeoptions);
        driver.get(URL);
        maximize();
    }
    protected void generalSetUp(String URL, String navegador) {
        setUplog4j();
        switch (navegador) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                setUpChromeWebDriverUrl(URL);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                setUpEdgeWebDriverUrl(URL);
                break;
            default:
                System.out.println("Navegador invalido");
                break;
        }


    }


    protected void quitDriver(){
        driver.quit();
    }

    private void maximize(){
        driver.manage().window().maximize();
    }
    protected void setUplog4j() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

}
