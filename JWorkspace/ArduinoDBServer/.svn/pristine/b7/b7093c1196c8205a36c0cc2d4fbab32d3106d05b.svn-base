package Util;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class SystemUtil {
	public static void main(String[] args) {
		log("Free Memory:" + getFreeMemory());
		log("CPU Usage:" + getCPUUsage());
		log("Thread Count:" + getThreadCount("eclipse"));
		log("Free c: Space"+ getFreeDiskSpace("C:"));
	}
	
	private static void log(Object message) {
		System.out.println(message);
	}

	public static float getCPUUsage()
	{
		long start = System.nanoTime();
		int cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
		Random random = new Random(start);
		int seed = Math.abs(random.nextInt());
		int primes = 10000;
		long startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
		start = System.nanoTime();
		while (primes != 0) {
			if (isPrime(seed)) {
				primes--;
			}
			seed++;
		}
		return calcCPU(startCPUTime, start, cpuCount);
	}
	
	private static int calcCPU(long cpuStartTime, long elapsedStartTime, int cpuCount) {
		long end = System.nanoTime();
		long totalAvailCPUTime = cpuCount * (end - elapsedStartTime);
		long totalUsedCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime() - cpuStartTime;
		// log("Total CPU Time:" + totalUsedCPUTime + " ns.");
		// log("Total Avail CPU Time:" + totalAvailCPUTime + " ns.");
		float per = ((float) totalUsedCPUTime * 100) / (float) totalAvailCPUTime;
		//log(per);
		return (int) per;
	}

	private static boolean isPrime(int n) {
		// 2 is the smallest prime
		if (n <= 2) {
			return n == 2;
		}
		// even numbers other than 2 are not prime
		if (n % 2 == 0) {
			return false;
		}
		// check odd divisors from 3
		// to the square root of n
		for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	@SuppressWarnings({ "restriction" })
	public static long getFreeMemory()
	{
		int mb = 1024 * 1024;
		//int gb = 1024 * 1024 * 1024;
//		com.sun.management.OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
//				.getOperatingSystemMXBean();
		com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory
				.getOperatingSystemMXBean();
		long physicalfreeMemorySize = os.getFreePhysicalMemorySize();
		long lFreeMem = physicalfreeMemorySize / mb;
		return lFreeMem;		
	}
	
	public static int getThreadCount(String strThreadName) {
        Thread t = Thread.currentThread();
        t.setName(strThreadName);
        t.setPriority(1);
        return Thread.activeCount();
     }
	
	public static double getFreeDiskSpace(String strDrive)
	{
		int gb = 1024 * 1024 * 1024;
		File diskPartition = new File(strDrive);
//		File diskPartition1 = new File("D:");
		double freePartitionSpace = diskPartition.getFreeSpace() / gb;
		return freePartitionSpace;
	}
	
	public static String getIp(HttpServletRequest request) 
	{  
	    String ip = request.getHeader("x-forwarded-for");  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("Proxy-Client-IP");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getRemoteAddr();  
	    }  
	    return ip;  
	} 

}