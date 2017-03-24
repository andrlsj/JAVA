package util;

import java.io.File;
import java.io.IOException;

public class ProcessLockUtil {
	public static void main(String[] args) {
		ProcessLockUtil processUtil = ProcessLockUtil.getInstance();
		System.out.println(processUtil.ProcessLock());
		//System.out.println(processUtil.ReleaseLock());
		System.out.println(processUtil.isLocked());
	}

	private static ProcessLockUtil instance;
	private static File lockFileDir = new File(".");
	private static String lockFileName = "xxx.lock";
	private static File lockFile = new File(lockFileDir, lockFileName);

	public static ProcessLockUtil getInstance() {
		synchronized (ProcessLockUtil.class) {
			if (instance == null) {
				instance = new ProcessLockUtil();
			}
		}
		return instance;
	}
	
	public String getLockFileName() {
		return lockFileName;
	}

	public void setLockFileName(String strFileName) {
		lockFileName = strFileName;
	}

	public boolean ProcessLock() {	
		lockFile = new File(lockFileDir, lockFileName);
		boolean bResult = false;
		try {
			lockFile.createNewFile();
			bResult = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bResult;
	}
	
	public boolean isLocked()
	{
		boolean bResult = false;
		if(lockFile !=null)
		{
			bResult = lockFile.exists();
		}
		return bResult;
	}

	// Release
	public boolean ReleaseLock() {
		boolean bResult = false;
		if (lockFile != null) {
			bResult = lockFile.delete();
		}
		return bResult;
	}

}