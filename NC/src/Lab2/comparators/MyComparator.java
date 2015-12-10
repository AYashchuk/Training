package Lab2.comparators;

import Lab2.domain.Record;

import java.util.Comparator;

public abstract class MyComparator implements Comparator<Record> {
	private Comparator comparator;

	@Override
	public int compare(Record r1, Record r2) {
		int comp = myCompair(r1,r2);
		if(comp == 0 && comparator != null) {
			return comparator.compare(r1,r2);
		}
		else {
			return comp;
		}
	}

	public MyComparator() {
	}

	public MyComparator(Comparator comparator) {
		this.comparator = comparator;
	}

	protected abstract int myCompair(Record record1, Record record2);
}
