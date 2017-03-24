package idv.david.additional.iocollection;

public class League {
	private int year;
	private String season;
	private String title;

	public League(int year, String season, String title) {
		this.year = year;
		this.season = season;
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
