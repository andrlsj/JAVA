package report.model;

public class PM
{
	private String DEVICE_NAME = "";
	private double PM_VALUE = 0;
	private String TM = "";
	
	public String getDEVICE_NAME()
	{
		return DEVICE_NAME;
	}
	public void setDEVICE_NAME(String dEVICE_NAME)
	{
		DEVICE_NAME = dEVICE_NAME;
	}
	public double getPM_VALUE()
	{
		return PM_VALUE;
	}
	public void setPM_VALUE(double pM_VALUE)
	{
		PM_VALUE = pM_VALUE;
	}
	public String getTM()
	{
		return TM;
	}
	public void setTM(String tM)
	{
		TM = tM;
	}
	
	@Override
	public String toString()
	{
		return "PM [DEVICE_NAME=" + DEVICE_NAME + ", PM_VALUE=" + PM_VALUE + ", TM=" + TM + "]";
	}	
}
