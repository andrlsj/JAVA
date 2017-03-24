package idv.david.additional.iocollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class InitializeLeagues {
	public List<League> LeaguesInitialized(String fileName) {
		List<League> leagueList = new LinkedList<League>();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(fileName));
			String record;

			while ((record = reader.readLine()) != null) {
				String[] fields = record.split("-");

				int year = Integer.parseInt(fields[0]);
				String season = fields[1];
				String title = fields[2];

				// Add the new League item to the list
				League item = new League(year, season, title);
				leagueList.add(item);

			}

		} catch (Exception e) {
			System.err.println("Exception occured while processing the leagues file:" + e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
				}
			}
		}
		return leagueList;
	}
}
