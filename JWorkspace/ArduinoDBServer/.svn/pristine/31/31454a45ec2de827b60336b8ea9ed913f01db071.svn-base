package job;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory; 
import org.quartz.SchedulerMetaData;
import org.quartz.impl.StdSchedulerFactory; 

public class TaskScheduler 
{
	// Logger  
	private static Logger logger;   
	private static Scheduler scheduler;       
	
	public TaskScheduler() 
	{   
	    logger = Logger.getLogger(TaskScheduler.class); 	    
	    DOMConfigurator.configure("./config/log4j.xml"); 
		initScheduler();  
	}                
       
	public void initScheduler() {   

		try {             
			StdSchedulerFactory factory = new StdSchedulerFactory();               
			// �{���]�w�Ƶ{ properties           
//			Properties properties = new Properties();      
//			properties.put("org.quartz.", arg1)
			/*          
			properties.put("org.quartz.scheduler.instanceName","DefaultQuartzScheduler");  
			properties.put("org.quartz.scheduler.rmi.export","false");   
			properties.put("org.quartz.scheduler.rmi.proxy","false");   
			properties.put("org.quartz.scheduler.wrapJobExecutionInUserTransaction","false");   
			properties.put("org.quartz.threadPool.class","org.quartz.simpl.SimpleThreadPool"); 
			properties.put("org.quartz.threadPool.threadCount","5");     
			properties.put("org.quartz.threadPool.threadPriority","5");   
			properties.put("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread","true");       
			properties.put("org.quartz.jobStore.misfireThreshold","60000");      
			properties.put("org.quartz.jobStore.class","org.quartz.simpl.RAMJobStore");   
			properties.put("org.quartz.plugin.jobInitializer.validating","false"); 
			properties.put("org.quartz.plugin.jobInitializer.validatingSchema","false");
			properties.put("org.quartz.plugin.jobInitializer.class","org.quartz.plugins.xml.JobInitializationPlugin"); 
			properties.put("org.quartz.plugin.jobInitializer.fileNames","quartz-jobs.xml"); 
			properties.put("org.quartz.plugin.jobInitializer.overWriteExistingJobs","false"); 
			properties.put("org.quartz.plugin.jobInitializer.failOnFileNotFound","true"); 
			factory.initialize(properties);  	*/		
			factory.initialize("./config/quartz.properties");
			
			SchedulerFactory sf = (StdSchedulerFactory)factory;       
			scheduler = sf.getScheduler();  

			//Placing a Scheduler in Stand-by Mode              
			//scheduler.standby();          
			} catch (SchedulerException e) {      
				e.printStackTrace();          
				logger.error(e);        
				}     
			}           
	
	/**       
	 * 
	 * @param jobsConfig        
	 * @throws Exception        */   
	public void initJobs() throws Exception 
	{           
           logger.info("initJobs");
      
		}               
	
	/**         * @throws SchedulerException        */       
	public void startScheduler() throws SchedulerException
	{            
		//   Scheduler will not execute jobs until it has been started (though they can be scheduled before start())             
		scheduler.start();		
        SchedulerMetaData metaData = scheduler.getMetaData();
        logger.info(metaData.getSummary());
	}               
	/**       
	 *  
	 *  @throws SchedulerException        */       
	public void shutdownScheduler() throws SchedulerException 
	{           
		scheduler.shutdown();    
	}       
	
  
	public static void main(String[] args) 
	{                     
		TaskScheduler scheduler = new TaskScheduler();         
		try {          
			scheduler.initJobs();      
			scheduler.startScheduler();       
		} catch (Exception e) {            
			e.printStackTrace();        
		}    
	}     
	
}  

