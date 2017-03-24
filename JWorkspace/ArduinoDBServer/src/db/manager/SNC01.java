package db.manager;

public class SNC01 {
	private String machineName = "";
	private String ip = "";
	private String companyId = "";
	private String memo = "";
	private String enable = "";
	private String mac = "";
	private String mins="";

	public String getMachineName() {
		return this.machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getMins() {
		return mins;
	}

	public void setMins(String mins) {
		this.mins = mins;
	}

	@Override
	public String toString() {
		return "SNC01 [machineName=" + machineName + ", ip=" + ip + ", companyId=" + companyId + ", memo=" + memo
				+ ", enable=" + enable + ", mac=" + mac + ", mins=" + mins + "]";
	}

	

}
