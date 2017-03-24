package job;

//import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class reSendDataJob implements Job  {
	//private static Logger logger = Logger.getLogger(Min30HttpDataReaderJob.class);
	
	public static void main(String[] args) {
		System.out.println("reSendDataJob run...");
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		reSendData.resend();
		
	}

}
