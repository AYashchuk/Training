package Lab2.comparators;

import Lab2.domain.Record;

/**
 * Overview:
 * This is class - comparator for date @see Lab2.Record
 * @author Yashchuk A. F.
 * @version 1.0
 * @see java.util.Comparator
 *
 */
public class DateComparator extends MyComparator {

	@Override
	protected int myCompair(Record r1, Record r2) {
		return r1.getDate().compareTo(r2.getDate());
	}
}
