package Lab2.comparators;

import Lab2.domain.Record;

/**
 * Overview:
 * This is class - comparator for source @see Lab2.Record
 * @author Yashchuk A. F.
 * @version 1.0
 * @see java.util.Comparator
 *
 */
public class SourceComparator extends MyComparator {

	@Override
	protected int myCompair(Record record1, Record record2) {
		return record1.getSource().compareTo(record2.getSource());
	}
}
