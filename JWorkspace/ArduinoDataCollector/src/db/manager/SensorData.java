package db.manager;

public class SensorData {
	private int id=0;
	private String machineId="";
	private String sensorType="";
	private float value=0;
	private String systemDT="";
	private boolean transferred;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getSystemDT() {
		return systemDT;
	}
	public void setSystemDT(String systemDT) {
		this.systemDT = systemDT;
	}
	public boolean isTransferred() {
		return transferred;
	}
	public void setTransferred(boolean transferred) {
		this.transferred = transferred;
	}
	@Override
	public String toString() {
		return "SensorData [id=" + id + ", machineId=" + machineId + ", sensorType=" + sensorType + ", value=" + value
				+ ", systemDT=" + systemDT + ", transferred=" + transferred + "]";
	}

	
}
