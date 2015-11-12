package Lab2;

import Lab2.exception.UnknownImportanceStateException;
import Lab2.exception.WrongSourceNameException;

import java.util.Date;

public final class Record {
	private final Importance importance;
	private String view;
	private String annotation;
	private String source;
	private Date date;


	/*public Record(Importance importance, String view, String annotation, String source, Date date) {
		this.importance = importance;
		this.view = view;
		this.annotation = annotation;
		this.source = source;
		this.date = date;
	}
*/
	public Record(Importance importance, String source) throws UnknownImportanceStateException, WrongSourceNameException {
		this.importance = importance;
		cheackSourse(source);
		annotation = null;
		init(importance);
	}

	private void cheackSourse(String source) throws WrongSourceNameException {
		if(source.split(" ").length != 0){
			throw new WrongSourceNameException("Source name must haven`t contains space!");
		}
	}

	private void init(Importance importance) throws UnknownImportanceStateException {
		switch (importance){
			case FIRST:{
				view = ".";
				annotation = "Сообщение о восстановлении после отказа или о нормальной работе";
			break;}
			case SECOND:{
				view = "!";
				annotation = "Предупреждение или сообщение о незначительной ошибке";
			break;}
			case THRID:{
				view = "!!!";
				annotation = "Сообщение о серьезной ошибке";
			break;}
			case FOURTH:{
				view = "!!!!";
				annotation = "Сообщение о критической ошибке";
			break;}
			default:{
				throw new UnknownImportanceStateException("This importance not declared!");
			}
		}



	}
	public Importance getImportance() {
		return importance;
	}
}
