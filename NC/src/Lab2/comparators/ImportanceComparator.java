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
public class ImportanceComparator implements Comparator <Record>{
	@Override
	public int compare(Record r1, Record r2) {
		return r1.getImportance().compareTo(r2.getImportance());
	}
}
