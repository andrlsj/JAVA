package db.manager;

public class SNC02 {
	private String sncx02_01="";    // TagName
	private String sncx02_02="";	// 機能代碼
	private float sncx02_03=0;		// 數值
	private String sncx02_04="";    // 紀錄時間
	public String getSncx02_01() {
		return sncx02_01;
	}
	public void setSncx02_01(String sncx02_01) {
		this.sncx02_01 = sncx02_01;
	}
	public String getSncx02_02() {
		return sncx02_02;
	}
	public void setSncx02_02(String sncx02_02) {
		this.sncx02_02 = sncx02_02;
	}
	public float getSncx02_03() {
		return sncx02_03;
	}
	public void setSncx02_03(float sncx02_03) {
		this.sncx02_03 = sncx02_03;
	}
	public String getSncx02_04() {
		return sncx02_04;
	}
	public void setSncx02_04(String sncx02_04) {
		this.sncx02_04 = sncx02_04;
	}
	@Override
	public String toString() {
		return "SNCX [sncx02_01=" + sncx02_01 + ", sncx02_02=" + sncx02_02
				+ ", sncx02_03=" + sncx02_03 + ", sncx02_04=" + sncx02_04 + "]";
	}	
}
