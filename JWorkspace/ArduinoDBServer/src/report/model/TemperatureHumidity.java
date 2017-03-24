package report.model;

public class TemperatureHumidity {
	private String DEVICE_NAME = "";
	private double TEMPERATURE = 0;
	private double HUMIDITY = 0;
	private String TM = "";
	
	public String getDEVICE_NAME()
	{
		return DEVICE_NAME;
	}
	public void setDEVICE_NAME(String dEVICE_NAME)
	{
		DEVICE_NAME = dEVICE_NAME;
	}
	public double getTEMPERATURE()
	{
		return TEMPERATURE;
	}
	public void setTEMPERATURE(double tEMPERATURE)
	{
		TEMPERATURE = tEMPERATURE;
	}
	public double getHUMIDITY()
	{
		return HUMIDITY;
	}
	public void setHUMIDITY(double hUMIDITY)
	{
		HUMIDITY = hUMIDITY;
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
		return "TemperatureHumidity [DEVICE_NAME=" + DEVICE_NAME + ", TEMPERATURE=" + TEMPERATURE + ", HUMIDITY="
				+ HUMIDITY + ", TM=" + TM + "]";
	}
}
