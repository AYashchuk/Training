package Lab2;

import Lab2.exception.WrongInputDataException;

import java.util.ArrayList;

public class AraryJournalRun {

	public static void main(String[] args) {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		ArrayList arrayJournal = new ArrayList();
		for(int i=0;i<30;i++){
			try {
				record = new Record(s + i);
			} catch (WrongInputDataException e) {
				e.printStackTrace();
			}
			arrayJournal.add(record);
		}
		try {
			arrayJournal.add(20,new Record(s + "20000"));
			System.out.println(arrayJournal.get(0));

			//System.out.println(arrayJournal.get(20));
		} catch (WrongInputDataException e) {
			e.printStackTrace();
		}

	}
}
