package Lab2.comparators;

import Lab2.domain.Record;

import java.util.Comparator;

/**
 * Overview:
 * This is class - comparator for importance @see Lab2.Record
 * @author Yashchuk A. F.
 * @version 1.0
 * @see java.util.Comparator
 *
 */
public class ImportanceComparator extends MyComparator {

	public ImportanceComparator() {
	}

	public ImportanceComparator(Comparator comparator) {
		super(comparator);
	}

	@Override
	protected int myCompair(Record record1, Record record2) {
		return record1.getImportance().compareTo(record2.getImportance());
	}
}
