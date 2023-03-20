package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebUI {
    private final Logger log = LoggerFactory.getLogger(WebUI.class);
    protected WebDriver driver;

    private void setUpDriver(String browser) {

        if (browser.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions opt = new EdgeOptions();
            opt.addArguments("-inprivate");
            driver = new EdgeDriver(opt);
        } else if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--remote-allow-origins=*", "--incognito");
            driver = new ChromeDriver(opt);
        } else {
            log.error("Wrong browser option");
        }
    }

    private void setUpDriverUrl(String url) {
        driver.get(url);
        maximize();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

    protected void generalSetup(String browser, String url) {
        setUpDriver(browser);
        setUpDriverUrl(url);
    }

    protected void quitDriver() {
        driver.quit();
    }
}