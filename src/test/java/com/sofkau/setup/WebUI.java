package com.sofkau.setup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {
    protected static final String ZONA_FIT_URL = "https://zonafit.co//";
    protected static WebDriver driver;
    protected void setUpWebdriver(){
        setUplog4j();
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.get(ZONA_FIT_URL);
        maximize();

    }
    protected void setUpWebdriver1(){
        setUplog4j();
        WebDriverManager.edgedriver().setup();
        EdgeOptions eo = new EdgeOptions();
        eo.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(eo);
        driver.get(ZONA_FIT_URL);
        maximize();
    }
    protected void setUpWebdriverUrl(){
        driver.get(ZONA_FIT_URL);
        maximize();
    }
    protected void generalSetUp(){
        setUplog4j();
        setUpWebdriver();
        setUpWebdriverUrl();
    }
    protected void  quitDriver() { driver.quit();}
    private void maximize(){
        driver.manage().window().maximize();
    }
    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

}
