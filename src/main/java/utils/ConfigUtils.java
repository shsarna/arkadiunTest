package utils;

import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigUtils {

    public static String applicationUrl = "";

    static {

        Properties propertiesObj = new Properties();
        String path = System.getProperty("user.dir")+"/src/test/resources/config.properties";
        System.out.println("Properties file path ..." + path);

        try {
            propertiesObj.load(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Reporter.log("FileNotFoundException found : " + e);
        } catch (IOException e) {
            e.printStackTrace();
            Reporter.log("IOException found : " + e);
        }
        applicationUrl = propertiesObj.getProperty("url");

    }
}




