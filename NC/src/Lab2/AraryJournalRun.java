package Lab2;

import Lab2.exception.WrongInputDataException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AraryJournalRun {

	public static void main(String[] args) throws WrongInputDataException {
		ArrayJournal arrayJournal = new ArrayJournal();
		Record record8 = new Record("2015-01-13 01:47:19 !!!!  Tester10");
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		try {
			System.out.println(arrayJournal.filter(format.parse("2015-01-13 01:47:19"), format.parse("2013-01-13 01:47:19")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
