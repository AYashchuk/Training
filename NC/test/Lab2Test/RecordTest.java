package Lab2Test;

import Lab2.domain.Importance;
import Lab2.domain.Record;
import Lab2.exception.UnknownImportanceStateException;
import Lab2.exception.WrongInputDataException;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class RecordTest {


	@Test
	public void constructorTest() throws UnknownImportanceStateException, WrongInputDataException {
		Record record  = record = new Record(new Date(), Importance.FIRST,"Tester", "Test message");
		assertEquals(Importance.FIRST, record.getImportance());
		assertEquals(record.getSource(), "Tester");
		assertEquals(record.getMessage(), "Test message");
	}



	@Test
	public void TestParseEventOnConstructor() throws WrongInputDataException {
		Record record1 = record1 = new Record("2015-11-13 01:47:20 !     Tester");
		assertEquals(record1.getDate(), "2015-11-13 01:47:20");
		assertEquals(record1.getView(), "!");
		assertEquals(record1.getSource(), "Tester");
	}

	@Test (expected = WrongInputDataException.class)
	public void incorrectInitSourse() throws UnknownImportanceStateException, WrongInputDataException {
		Record record = new Record(new Date(), Importance.FIRST,"Tester test", "Test message");
	}

	@Test (expected = WrongInputDataException.class)
	public void incorrectInitMessage() throws UnknownImportanceStateException, WrongInputDataException {
		Record record = new Record(new Date(), Importance.FIRST,"Tester test", "Test \nmessage");
	}

	@Test (expected = WrongInputDataException.class)
	public void incorrectInitView() throws  WrongInputDataException {
		Record record = new Record("2015-11-13 01:47:20 g Tester");
	}

	@Test (expected = WrongInputDataException.class)
	public void incorrectInitLength() throws WrongInputDataException {
		Record record = new Record("2015-11-13 01:47:20 !     ");
	}

	@Test (expected = WrongInputDataException.class)
	public void incorrectInitDate() throws WrongInputDataException {
		Record record = new Record("2015-13-13 01:47:20 !      Tester");
	}

	@Test (expected = WrongInputDataException.class)
	public void incorrectInitTime() throws WrongInputDataException {
		Record record = new Record("2015-13-13 01:61:20 !      Tester");
	}

}
