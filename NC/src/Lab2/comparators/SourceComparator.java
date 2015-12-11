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
public class SourceComparator extends MyComparator {

	public SourceComparator() {
	}

	public SourceComparator(Comparator comparator) {
		super(comparator);
	}

	@Override
	protected int myCompair(Record record1, Record record2) {
		return record1.getSource().compareTo(record2.getSource());
	}
}
