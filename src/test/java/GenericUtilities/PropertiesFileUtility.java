package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFileUtility {
public String readDataFromPf(String key) throws Throwable {
FileInputStream fis=new FileInputStream(IconstantUtility.propetypath);
Properties p=new Properties();
p.load(fis);
String value = p.getProperty(key);
return value;

}
}