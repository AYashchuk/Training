package Lab1.service.sorterCreator;

import Lab1.domain.*;

public abstract class SorterCreator {
	protected Sort sort;

	public abstract Sort createSort(Enum typeOfSort);

}
