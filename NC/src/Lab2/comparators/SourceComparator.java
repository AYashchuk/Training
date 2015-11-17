package Lab2.comparators;

import Lab2.Record;

import java.util.Comparator;

public class SourceComparator implements Comparator<Record> {
	@Override
	public int compare(Record r1, Record r2) {
		return r1.getSource().compareTo(r2.getSource());
	}
}
