package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class FolderZiper {
  public static void main(String[] a) throws Exception {
    //zipFolder("D:/MM/MMScheduler/data", "D:/MM/MMScheduler/data.zip");
    unzip("d:\\json-20130831.zip","d:");
  }

  public static void zipFolder(String srcFolder, String destZipFile) throws Exception {
    ZipOutputStream zip = null;
    FileOutputStream fileWriter = null;

    fileWriter = new FileOutputStream(destZipFile);
    zip = new ZipOutputStream(fileWriter);

    addFolderToZip("", srcFolder, zip);
    zip.flush();
    zip.close();
  }

  static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
      throws Exception {

    File folder = new File(srcFile);
    if (folder.isDirectory()) {
      addFolderToZip(path, srcFile, zip);
    } else {
      byte[] buf = new byte[1024];
      int len;
      FileInputStream in = new FileInputStream(srcFile);
      zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
      while ((len = in.read(buf)) > 0) {
        zip.write(buf, 0, len);
      }
      in.close();
    }
  }

  static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
      throws Exception {
    File folder = new File(srcFolder);

    for (String fileName : folder.list()) {
      if (path.equals("")) {
        addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
      } else {
        addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
      }
    }
  }
  
  public static void unzip(String zipFilePath,String unzipFilePath) throws Exception  
  {  
      ZipFile zipfile = new ZipFile(zipFilePath);  
      Enumeration<? extends ZipEntry> enu = zipfile.entries();  
      while(enu.hasMoreElements())  
      {  
          ZipEntry entry = (ZipEntry)enu.nextElement();  
          writeToDir(zipfile, entry, new File(unzipFilePath + File.separator + entry.getName()));  
      }  
  } 
  private static void writeToDir(ZipFile zip, ZipEntry entry, File toFile) throws Exception  
  {  
      if (!entry.isDirectory()) {  
          File file = toFile.getParentFile();  
          if (!file.exists())  
          {  
              file.mkdirs();  
          }  
//          if(toFile.exists())
//        	  toFile.delete();
          FileOutputStream fos = new FileOutputStream(toFile);  
          byte[] buffer = new byte[1024];  
          InputStream is = zip.getInputStream(entry);  
          int len;  
          while((len = is.read(buffer,0,buffer.length)) != -1)  
          {  
              fos.write(buffer,0,len);  
          }  
          fos.close();  
      }  
  }  
}