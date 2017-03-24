package Util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {

    // 读取资源文件,并处理中文乱码
    public static Properties readPropertiesFile(String filename) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(filename);
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            properties.load(bf);
            inputStream.close(); // 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
    static public Properties readPropertiesAsStream(String filename) {
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(filename);
        try {
			props.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return props;
     } 
}
