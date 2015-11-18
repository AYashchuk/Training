package Lab2.journals;

import Lab2.domain.Record;

import java.util.Date;

public interface Journal {
	void add(Record r);
	void add(Journal j);
	void remove(Record r);
	Record get(int index);
	void set(int index, Record record);
	void insert(int index, Record record);
	void remove(int index);
	void remove(int fromIndex, int toIndex);
	void removeAll();
	int size();
	Journal filter(String s);
	Journal filter(Date fromDate, Date toDate);
	void sortByDate();
	void sortByImportanceDate();
	void sortByImportanceSourceDate();
	void sortBySourceDate();
	void printRecords();
}
