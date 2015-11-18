package Lab2.comparators;

import Lab2.domain.Record;

import java.util.Comparator;

/**
 * Overview:
 * This is class - comparator for source @see Lab2.Record
 * @author Yashchuk A. F.
 * @version 1.0
 * @see java.util.Comparator
 *
 */
public class SourceComparator implements Comparator<Record> {
	@Override
	public int compare(Record r1, Record r2) {
		return r1.getSource().compareTo(r2.getSource());
	}
}
