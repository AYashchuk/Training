package Lab2Test;

import Lab2.ArrayJournal;
import Lab2.CollectionJournal;
import Lab2.Journal;
import Lab2.Record;
import Lab2.exception.WrongInputDataException;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class CollectionJournalTest {
	@Test
	public void creatingTest(){
		Journal arrayJournal = new CollectionJournal();
		assertEquals(arrayJournal.size(),0);
	}

	@Test
	public void addTest1() throws WrongInputDataException {
		Journal arrayJournal = new CollectionJournal();
		arrayJournal.add(new Record("2015-11-13 01:47:20 !!!!  Tester"));
		assertEquals(arrayJournal.size(), 1);
	}

	@Test
	public void addTest2() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		Journal arrayJournal = new CollectionJournal();
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
		Journal arrayJournal = new CollectionJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		arrayJournal.insert(20,new Record(s + "20000"));
		//arrayJournal.printRecords();
		assertEquals(arrayJournal.size(), 31);
	}

	@Test
	public void addTest4() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		Journal arrayJournal = new CollectionJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		record = new Record(s + "20000");
		arrayJournal.insert(20,record);
		//arrayJournal.printRecords();
		assertEquals(record, arrayJournal.get(20));
		assertEquals(arrayJournal.size(), 31);
	}

	@Test
	public void addTest5() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		Journal arrayJournal = new CollectionJournal();
		for(int i=0;i<30;i++){
			record = new Record(s + i);
			arrayJournal.add(record);
		}
		record = new Record(s + "20000");
		arrayJournal.add(record);
		assertEquals(record, arrayJournal.get(arrayJournal.size()-1));
	}

	@Test
	public void removeAllTest() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Record record = null;
		Journal arrayJournal = new CollectionJournal();
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
		Journal arrayJournal = new CollectionJournal();
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
		Journal arrayJournal = new CollectionJournal();
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
		Journal arrayJournal = new CollectionJournal();
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
		Journal arrayJournal = new CollectionJournal();
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
		Journal arrayJournal = new CollectionJournal();
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


	@Test
	public void filterTest1() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Journal arrayJournal = new CollectionJournal();
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



		Journal j = arrayJournal.filter("2015-01-13 01:47:19 !!!!  Tester10");
		for(int i=0;i<j.size();i++){
			assertEquals(j.get(i).getSource(), "Tester10");
		}
	}

	@Test
	public void filterTest2() throws WrongInputDataException {
		String s = "2015-11-13 01:47:20 !!!!  Tester";
		Journal arrayJournal = new CollectionJournal();
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

		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		Date date1 = null;
		Date date2 = null;
		try {
			date2 = format.parse("2015-01-13 01:47:20");
			date1 = format.parse("2013-11-25 01:40:20");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Journal j = arrayJournal.filter(date1,date2);
		for(int i=0;i<j.size();i++){
			Record tmpRecord = j.get(i);
			Date tmpDate = tmpRecord.getDate();
			assertTrue(tmpDate.compareTo(date1) >=0);
			assertTrue(tmpDate.compareTo(date2) <=0);
		}
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void setExceptionTest() throws WrongInputDataException {
		Journal arrayJournal = new CollectionJournal();
		Record record1 = new Record("2014-10-09 03:20:20 !!!!  Tester1");
		Record record2 = new Record("2013-11-25 01:40:20 !!!   Tester2");
		arrayJournal.add(record1);
		arrayJournal.add(record2);
		arrayJournal.set(3, record1);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void addExceptionTest() throws WrongInputDataException {
		ArrayJournal arrayJournal = new ArrayJournal();
		Record record1 = new Record("2014-10-09 03:20:20 !!!!  Tester1");
		Record record2 = new Record("2013-11-25 01:40:20 !!!   Tester2");
		arrayJournal.add(record1);
		arrayJournal.add(record2);
		arrayJournal.add(3, record1);
	}
}
