package data.GetData;

import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;
import org.ini4j.Ini;
import org.ini4j.Profile.Section;

public class GetData
{
    private static Logger logger = Logger.getLogger(GetData.class);

    public static HashMap<String,String> getSite(String filename, String sSection)
    {
        HashMap<String,String> hm = new HashMap<String,String>();
        Ini ini = null;
        try
        {
            ini = new Ini();
            ini.load(new File(filename));

        }
        catch (IOException e)
        {
            Locale defaultLocale = Locale.getDefault();
            ResourceBundle rb = ResourceBundle.getBundle("messages", defaultLocale);
            logger.error(filename + rb.getString("ConfigFormatError"));
            e.printStackTrace();
        }

        Section secTray = (Section) ini.get(sSection);
        hm.put("site", secTray.get("site"));       
        return hm;
    } 
}
