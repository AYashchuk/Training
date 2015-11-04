package Lab1.domain;

public abstract class Sort {
	protected String nameOfSort;
	protected boolean mod;
	private long timeOfSort;

	public void sort(int [] array){
		long start = System.nanoTime();
		sorting(array);
		timeOfSort = System.nanoTime() - start;
	}

	public long getSortingTime(){
		return timeOfSort;
	}

	
	protected abstract void sorting(int array[]);

	public String getNameOfSort() {
		return nameOfSort;
	}

	public void setNameOfSort(String nameOfSort) {
		this.nameOfSort = nameOfSort;
	}

	public boolean isMod() {
		return mod;
	}

	public void setMod(boolean mod) {
		this.mod = mod;
	}

	@Override
	public String toString(){
		return nameOfSort;
	}

	public void setTimeOfSort(long timeOfSort) {
		this.timeOfSort = timeOfSort;
	}
}
