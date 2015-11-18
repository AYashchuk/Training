package Lab2.journals;

import Lab2.domain.Record;
import Lab2.comparators.DateComparator;
import Lab2.comparators.ImportanceComparator;
import Lab2.comparators.SourceComparator;
import Lab2.exception.WrongInputDataException;
import Lab2.sorters.SimpleSorter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectionJournal implements Journal {

	/** Simple sorter for sort using different comparators */
	private SimpleSorter simpleSorter;
	/** Current journal */
	private List<Record> jornal;

	/**
	 * Overview:
	 * Copy constructor
	 * @param journal input journal which will be add to current journal
	 */
	public CollectionJournal(Journal journal) {
		this.add(journal);
	}

	/**
	 * Overview:
	 * Empty constructor
	 * create empty journal
	 */
	public CollectionJournal() {
		this.jornal = new ArrayList<>();
		simpleSorter = new SimpleSorter(new DateComparator(),new ImportanceComparator(),new SourceComparator());
	}

	/**
	 * Overview:
	 * This method add value {@link Lab2.Record} in journal{@link Lab2.journals.Journal}
	 * @param r - it is value that we would add
	 */
	@Override
	public void add(Record r) {
		jornal.add(r);
	}

	/**
	 * Overview:
	 * This method add journal {@link Lab2.journals.Journal} in current journal{@link Lab2.journals.Journal}
	 * @param j - it is Journal {@link Lab2.journals.Journal} which will based current journal
	 */
	@Override
	public void add(Journal j) {
		for(int i=0;i<j.size();i++){
			jornal.add(j.get(i));
		}
	}

	/**
	 * Overview:
	 * This method remove Record {@link Lab2.Record} in current journal{@link Lab2.journals.Journal}
	 * @param r - it is Record value which we would remove from journal
	 */
	@Override
	public void remove(Record r) {
		jornal.remove(r);
	}

	/**
	 * Overview:
	 * This method get Record {@link Lab2.Record} from current journal{@link Lab2.journals.Journal}
	 * @param index - it is index of which element we would get from journal
	 * @return Record - it is value Record{@link Lab2.Record} or his subclass
	 */
	@Override
	public Record get(int index) {
		return jornal.get(index);
	}

	/**
	 * Overview:
	 * This method set Record {@link Lab2.Record} in position index in current journal{@link Lab2.journals.Journal}
	 * @param index - it is index of which position we would insert element in journal
	 * @param  record - it is value which we would set
	 */
	@Override
	public void set(int index, Record record) {
		jornal.set(index,record);
	}

	/**
	 * Overview:
	 * This method add Record {@link Lab2.Record} in position index in current journal{@link Lab2.journals.Journal}
	 * @param index - it is index of which position we would insert element in journal
	 * @param  record - it is value which we would insert
	 */
	@Override
	public void insert(int index, Record record) {
		jornal.add(index, record);
	}

	/**
	 * Overview:
	 * Method remove record on index
	 * @param index - index which record must remove
	 */
	@Override
	public void remove(int index) {
		jornal.remove(index);
	}

	/**
	 * Overview:
	 * Method remove record in scope from index1 to index2
	 * @param fromIndex first scope
	 * @param toIndex second scope
	 */
	@Override
	public void remove(int fromIndex, int toIndex) {
		if(fromIndex>toIndex){
			int tmp = toIndex;
			toIndex = fromIndex;
			fromIndex = tmp;
		}if(fromIndex == toIndex) remove(fromIndex);
		for(int i=fromIndex;i<toIndex;i++){
			jornal.remove(i);
		}
	}

	/**
	 * Overview:
	 * This method remove all elements in journal
	 */
	@Override
	public void removeAll() {
		jornal.removeAll(jornal);
	}

	/**
	 * Overview:
	 * This method return capacity current journal{@link Lab2.journals.Journal}
	 * @return - size of journal
	 */
	@Override
	public int size() {
		return jornal.size();
	}

	/**
	 * Overview:
	 * This method compare source on Records which create on base String s
	 * and return new Journal with the same source
	 * @param s String value which based create Record
	 * @return new Journal with the same source
	 */
	@Override
	public Journal filter(String s) {
		Journal tmpJournal = new ArrayJournal<Record>();
		Record record = null;
		try {
			record = new Record(s);
		} catch (WrongInputDataException e) {
			e.printStackTrace();
			return  null;
		}
		for(int i=0;i<tmpJournal.size();i++){
			Record tmpRecord = jornal.get(i);
			if(tmpRecord.getSource().equals(record.getSource())){
				tmpJournal.add(jornal.get(i));
			}
		}
		return tmpJournal;
	}

	/**
	 * Overview:
	 * This method compare source on Records which date is located in period of date
	 * @param fromDate - start date period
	 * @param toDate - end of date period
	 * @return new Journal which date located in period of date
	 */
	@Override
	public Journal filter(Date fromDate, Date toDate) {
		if(fromDate.compareTo(toDate)>0){
			Date tmp = fromDate;
			fromDate = toDate;
			toDate = tmp;
		}
		Journal j = new ArrayJournal<Record>();
		for(int i=0;i<jornal.size();i++){
			Record tmpRecord = jornal.get(i);
			if(tmpRecord.getDate().compareTo(fromDate)>=0 && tmpRecord.getDate().compareTo(toDate)<=0){
				j.add(jornal.get(i));
			}
		}
		return j;
	}

	/**
	 * Overview:
	 * Method sort Journal by date
	 */
	@Override
	public void sortByDate() {
		simpleSorter.sortingByDate(this);
	}

	/**
	 * Overview:
	 * Method sort Journal by importance and date
	 */
	@Override
	public void sortByImportanceDate() {
		simpleSorter.sortingByImportanceDate(this);
	}

	/**
	 * Overview:
	 * Method sort Journal by importance, source and date
	 */
	@Override
	public void sortByImportanceSourceDate() {
		simpleSorter.sortingByImportanceSourceDate(this);
	}

	/**
	 * Overview:
	 * Method sort Journal by source and date
	 */
	@Override
	public void sortBySourceDate() {
		simpleSorter.sortingBySourceDate(this);
	}

	/**
	 * Overview:
	 * Method print all Records in Journal
	 */
	@Override
	public void printRecords() {
		if(jornal.size() == 0) System.out.println("[ ]");
		else
			for(int i=0;i<jornal.size();i++){
				System.out.println("["+jornal.get(i)+"]");
			}
	}
}
