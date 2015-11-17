package Lab2Test;

import Lab2.ArrayJournal;
import Lab2.Record;
import Lab2.exception.WrongInputDataException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ArrayJournalTest {
	@Test
	public void creatingTest(){
		ArrayJournal arrayJournal = new ArrayJournal();
		assertEquals(arrayJournal.size(),0);
	}

	@Test
	public void addTest1() throws WrongInputDataException {
		ArrayJournal arrayJournal = new ArrayJournal();
		arrayJournal.add(new Record("2015-11-13 01:47:20 !!!!  Tester"));
		assertEquals(arrayJournal.size(), 1);
	}

	@Test
	public void addTest2() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		ArrayJournal arrayJournal = new ArrayJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		assertEquals(arrayJournal.size(), 30);
	}


	@Test
		 public void addTest3() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		ArrayJournal arrayJournal = new ArrayJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		arrayJournal.add(20,new Record(s + "20000"));
		assertEquals(arrayJournal.size(), 31);
	}

	@Test
	public void addTest4() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		ArrayJournal arrayJournal = new ArrayJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		record = new Record(s + "20000");
		arrayJournal.add(20,record);
		//arrayJournal.printRecords();
		assertEquals(record, arrayJournal.get(20));
		assertEquals(arrayJournal.size(), 31);
	}

	@Test
	public void addTest5() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		ArrayJournal arrayJournal = new ArrayJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		record = new Record(s + "20000");
		arrayJournal.add(record);
		assertEquals(record, arrayJournal.get(arrayJournal.size()-1));
	}

	@Test
	public void indexOfTest() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		ArrayJournal arrayJournal = new ArrayJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		record = new Record(s + "20000");
		arrayJournal.add(30,record);
		assertEquals(arrayJournal.indexOf(record), 30);
		assertEquals(arrayJournal.size(), 31);
	}

	@Test
	public void removeAllTest() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		ArrayJournal arrayJournal = new ArrayJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		arrayJournal.removeAll();
		assertEquals(arrayJournal.size(), 0);
	}

	@Test
	public void removeTest1() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		ArrayJournal arrayJournal = new ArrayJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		arrayJournal.remove(5);
		assertEquals(arrayJournal.size(), 29);
		arrayJournal.remove(0);
		arrayJournal.remove(arrayJournal.size()-1);
		//arrayJournal.printRecords();
	}

	@Test
	 public void removeTest2() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		ArrayJournal arrayJournal = new ArrayJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		arrayJournal.remove(0,10);
		assertEquals(arrayJournal.size(), 20);
		//arrayJournal.printRecords();
	}


	@Test
	 public void sortByDateTest() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		ArrayJournal arrayJournal = new ArrayJournal();
		Record record = new Record(s + "20000");
		Record record1 = new Record("2014-10-09 01:47:20 !!!!  Tester");
		Record record2 = new Record("2013-11-25 01:47:20 !!!!  Tester");
		Record record3 = new Record("2015-10-13 01:47:20 !!!!  Tester");
		Record record4 = new Record("2015-09-01 01:47:20 !!!!  Tester");
		Record record5 = new Record("2015-08-13 01:47:20 !!!!  Tester");
		Record record6 = new Record("2015-11-03 01:47:20 !!!!  Tester");
		Record record7 = new Record("2015-11-04 01:47:20 !!!!  Tester");
		Record record8 = new Record("2015-01-13 01:47:20 !!!!  Tester");

		arrayJournal.add(record);
		arrayJournal.add(record2);
		arrayJournal.add(record5);
		arrayJournal.add(record4);
		arrayJournal.add(record3);
		arrayJournal.add(record6);
		arrayJournal.add(record7);
		arrayJournal.add(record8);
		arrayJournal.add(record1);

		arrayJournal.sortByDate();

		assertEquals(arrayJournal.get(0),record2);
		assertEquals(arrayJournal.get(1),record1);
		assertEquals(arrayJournal.get(5),record3);
		assertEquals(arrayJournal.get(arrayJournal.size()-1),record);
	}



	@Test
	public void sortByImportanceDateTest() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		ArrayJournal arrayJournal = new ArrayJournal();
		Record record = new Record(s + "20000");
		Record record1 = new Record("2014-10-09 01:47:20 !!!!  Tester");
		Record record2 = new Record("2013-11-25 01:47:20 !!!   Tester");
		Record record3 = new Record("2015-10-13 01:47:20 !!!!  Tester");
		Record record4 = new Record("2015-09-01 01:47:20 .     Tester");
		Record record9 = new Record("2015-01-13 01:47:20 !!!!  Tester");
		Record record10 = new Record("2015-01-13 01:47:20 !     Tester");
		Record record5 = new Record("2015-08-13 01:47:20 !!!!  Tester");
		Record record6 = new Record("2015-11-03 01:47:20 !!!!  Tester");
		Record record7 = new Record("2015-11-04 01:48:20 !!!!  Tester");
		Record record8 = new Record("2015-01-13 01:47:19 !!!!  Tester");
		Record record11 = new Record("2015-01-13 01:47:20 .     Tester");

		arrayJournal.add(record);
		arrayJournal.add(record2);
		arrayJournal.add(record5);
		arrayJournal.add(record4);
		arrayJournal.add(record3);
		arrayJournal.add(record11);
		arrayJournal.add(record6);
		arrayJournal.add(record7);
		arrayJournal.add(record8);
		arrayJournal.add(record1);
		arrayJournal.add(record9);
		arrayJournal.add(record10);


		arrayJournal.sortByImportanceDate();

		assertEquals(arrayJournal.get(0),record11);
		assertEquals(arrayJournal.get(1),record4);
		assertEquals(arrayJournal.get(5),record8);
		assertEquals(arrayJournal.get(arrayJournal.size()-1),record);
	}


	@Test
	public void sortByImportanceSourceDateTest() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		ArrayJournal arrayJournal = new ArrayJournal();
		Record record = new Record(s + "20000");
		Record record1 = new Record("2014-10-09 03:20:20 !!!!  Tester1");
		Record record2 = new Record("2013-11-25 01:40:20 !!!   Tester2");
		Record record3 = new Record("2015-10-12 01:47:20 !!!   Tester3");
		Record record4 = new Record("2015-09-01 01:47:20 .     Tester4");
		Record record9 = new Record("2015-01-13 01:47:20 .     Tester5");
		Record record10 = new Record("2015-01-13 01:47:20 !     Tester6");
		Record record5 = new Record("2015-08-13 01:47:20 !     Tester7");
		Record record6 = new Record("2015-11-03 04:47:20 !!!   Tester8");
		Record record7 = new Record("2015-11-04 01:48:23 !!!!  Tester10");
		Record record8 = new Record("2015-01-13 01:47:19 !!!!  Tester10");
		Record record11 = new Record("2015-01-13 01:47:20 .     Tester0");

		arrayJournal.add(record);
		arrayJournal.add(record2);
		arrayJournal.add(record5);
		arrayJournal.add(record4);
		arrayJournal.add(record3);
		arrayJournal.add(record11);
		arrayJournal.add(record6);
		arrayJournal.add(record7);
		arrayJournal.add(record8);
		arrayJournal.add(record1);
		arrayJournal.add(record9);
		arrayJournal.add(record10);

		arrayJournal.sortByImportanceSourceDate();

		assertEquals(arrayJournal.get(0),record11);
		assertEquals(arrayJournal.get(1),record4);
		assertEquals(arrayJournal.get(5),record2);
		assertEquals(arrayJournal.get(arrayJournal.size()-1),record);
	}

}
