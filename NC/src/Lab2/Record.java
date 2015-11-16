package Lab2;

import Lab2.exception.UnknownImportanceStateException;
import Lab2.exception.WrongInputDataException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Overview:
 * @author Yashchuk A. F.
 * @version 1.0
 *
 */
public final class Record {
	/**  */
	private Importance importance;
	/**  */
	private String view;
	/**  */
	private String annotation;
	/**  */
	private String source;
	/**  */
	private Date date;
	/**  */
	private String message;
	/**  */
	private SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");


	/**
	 * Overview:
	 *
	 */
	public Record( Date date, Importance importance, String source, String message) throws WrongInputDataException, UnknownImportanceStateException {
		validateSourse(source);
		validateAnnotation(message);
		this.date = date;
		this.importance = importance;
		this.source = source;
		this.message = message;
		init(importance);
	}

	/**
	 * Overview:
	 *
	 */
	public Record(String event) throws WrongInputDataException {
		if(!parseEvent(event)) throw  new WrongInputDataException("incorrect input data!");
	}

	private boolean parseEvent(String event)  {
		String tmp [] = event.trim().split(" ");
		if(tmp.length < 3){
			System.out.println("event is short!");
			return false;

		} if(!validateDate(tmp[0],tmp[1]) ){
			System.out.println("invalid date!");
			return false;
		} if(!validateAndInitView(tmp[2])) {
			System.out.println("invalid view!");
			return false;
		}
		try {
			this.date = format.parse(tmp[0] + " " + tmp[1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.view = tmp[2];
		this.source = event.substring(26,event.length());
		return true;
	}

	/**
	 * Overview:
	 *
	 */
	private boolean validateAndInitView(String view) {
		if(view.equals(".")){
			importance = Importance.FIRST;
			return true;
		}if(view.equals("!")){
			importance = Importance.SECOND;
			return true;
		}if(view.equals("!!!")){
			importance = Importance.THRID;
			return true;
		}if(view.equals("!!!!")){
			importance = Importance.FOURTH;
			return true;
		}
		return false;
	}

	/**
	 * Overview:
	 *
	 */
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

	/**
	 * Overview:
	 *
	 */
	private void validateAnnotation(String annotation) throws WrongInputDataException {
		if(annotation.split("\n").length != 1 || annotation.split("\r").length != 1){
			throw new WrongInputDataException("Incorrect massage, massage must not contains line break");
		}
	}

	/**
	 * Overview:
	 *
	 */
	private void validateSourse(String source) throws WrongInputDataException {
		if(source.split(" ").length != 1){
			throw new WrongInputDataException("Source name must haven`t contains space!");
		}
	}

	/**
	 * Overview:
	 *
	 */
	private boolean validateDate(String date, String time){
		String dateRegx = "(19|20)\\d\\d[- -.](0[1-9]|1[012])[- -.](0[1-9]|[12][0-9]|3[01])";
		String timeRegx = "^([0-1]\\d|2[0-3])(:[0-5]\\d){2}$";
		Pattern dateP = Pattern.compile("(19|20)\\d\\d[- -.](0[1-9]|1[012])[- -.](0[1-9]|[12][0-9]|3[01])");
		Pattern timeP = Pattern.compile("^([0-1]\\d|2[0-3])(:[0-5]\\d){2}$");
		Matcher dateM = dateP.matcher(date);
		Matcher timeM = timeP.matcher(time);
		if(dateM.matches() && timeM.matches()){
			return true;
		}
		return false;
	}

	/**
	 * Overview:
	 *
	 */
	private String prepareView(){
		if(view.equals(".")){
			return view + "    ";
		}if(view.equals("!")){
			return view + "    ";
		}if(view.equals("!!!")){
			return view + "  ";
		}if(view.equals("!!!!")){
			return view + " ";
		}
		return view;
	}

	public Importance getImportance() {
		return importance;
	}

	public String getView() {
		return view;
	}

	public String getAnnotation() {
		return annotation;
	}

	public String getSource() {
		return source;
	}

	public Date getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}


	/**
	 * Overview:
	 *
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Record record = (Record) o;

		if (!date.equals(record.date)) return false;
		if (!source.equals(record.source)) return false;
		if (!view.equals(record.view)) return false;

		return true;
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public int hashCode() {
		int result = view.hashCode();
		result = 31 * result + source.hashCode();
		result = 31 * result + date.hashCode();
		return result;
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public String toString() {
		return  format.format(date) +
				" " + prepareView() +
				" " + source ;
	}

/*
	static class YearComparator implements Comparator<Composition> {

		@Override
		public int compare(Composition o1, Composition o2) {
			return o1.getYear().compareTo(o2.getYear());
		}
	}*/
}
