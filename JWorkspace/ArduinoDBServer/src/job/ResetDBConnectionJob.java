package job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import db.dbmanager.DatabaseManagerC3P0;

public class ResetDBConnectionJob implements Job {
	private static Logger logger = Logger.getLogger(ResetDBConnectionJob.class);
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		  	logger.info("DBReset run...");
		  	 DatabaseManagerC3P0 c3p0 = DatabaseManagerC3P0.getInstance();
		  	c3p0.printDataSourceStats();
		  	c3p0.reset();
	}
}
