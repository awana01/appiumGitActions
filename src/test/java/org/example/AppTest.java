package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;



public class AppTest {
    public AndroidDriver driver;
    @BeforeTest()
    public void initTest() throws MalformedURLException, InterruptedException {
       System.out.println(System.getProperty("os.name"));
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(UiAutomator2Options.AUTOMATION_NAME_OPTION,"UiAutomator2");
        dc.setCapability(UiAutomator2Options.PLATFORM_VERSION_OPTION,"ANDROID 10");
        if(System.getProperty("os.name").contains("Windows")) {
            dc.setCapability(UiAutomator2Options.UDID_OPTION, "192.168.1.100:5555");
        }else {
            dc.setCapability(UiAutomator2Options.DEVICE_NAME_OPTION, "Android Emulator");
        }
        // dc.setCapability(UiAutomator2Options.APP_ACTIVITY_OPTION,"");
        // dc.setCapability(UiAutomator2Options.APP_PACKAGE_OPTION,"");
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        Thread.sleep(5000);
    }

    @AfterTest()
    public void finalizeTest(){

    }


    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Hello World");
        assertTrue( true );

    }
}
