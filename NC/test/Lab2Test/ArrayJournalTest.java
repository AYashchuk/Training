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
}
