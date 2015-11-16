package Lab2.comparators;

import Lab2.Record;

import java.util.Comparator;

public class DateComparator implements Comparator<Record> {

		@Override
		public int compare(Record r1, Record r2) {
			return r1.getDate().compareTo(r2.getDate());
		}
}
