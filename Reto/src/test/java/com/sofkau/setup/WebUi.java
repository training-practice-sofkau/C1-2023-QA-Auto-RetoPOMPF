package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.setup.ConstantSetup.DEMO_QA_URL;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUi {

    protected WebDriver driver;
    private void setUpWebdriverUrlChrome(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cap);
        driver=new ChromeDriver(options);
        driver.get(DEMO_QA_URL);
        maximize();
    }
    protected void generalSetupChrome(){
        setUplog4j();
        setUpWebdriverChrome();
        setUpWebdriverUrlChrome();
    }
    private void setUpWebdriverChrome(){
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.edgedriver().setup();
    }

    private void setUpWebdriverUrlEdge(){
        driver=new EdgeDriver();
        driver.get(DEMO_QA_URL);
        maximize();
    }

    protected void generalSetupEdge(){
        setUplog4j();
        setUpWebdriverEdge();
        setUpWebdriverUrlEdge();
    }
    private void setUpWebdriverEdge(){
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    protected void quiteDriver(){
        driver.quit();
    }

    private void maximize(){
        driver.manage().window().maximize();
    }

    public void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
