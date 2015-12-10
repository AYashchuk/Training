package Lab2.domain;

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
 */
public final class Record {
	/** importance enum */
	private Importance importance;
	/** view of importance */
	private String view;
	/** annotation about record */
	private String annotation;
	/** records source */
	private String source;
	/** records date */
	private Date date;
	/** message about record */
	private String message;
	/** simple editor for date */
	private SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");


	/**
	 * Overview:
	 * base constructor with more important params
	 * @param date - records date
	 * @param importance records importance
	 * @param source records source
	 * @param message massage
	 */
	public Record(Date date, Importance importance, String source, String message) throws WrongInputDataException, UnknownImportanceStateException {
		validateSource(source);
		validateAnnotation(message);
		this.date = date;
		this.importance = importance;
		this.source = source;
		this.message = message;
		init(importance);
	}

	/**
	 * Overview:
	 * constructor give on input String s and parse they for the same view which return method toString()
	 * @param event - not parse record
	 * @throws Lab2.exception.WrongInputDataException - throw if input string incorrect
	 */
	public Record(String event) throws WrongInputDataException {
		if(!parseEvent(event)) throw  new WrongInputDataException("incorrect input data!");
	}

	/**
	 * Overview:
	 * This method parse input string to new Record
	 * @param event - input string
	 * @return tru - if method can create new Record, false if method cant parse input string
	 */
	private boolean parseEvent(String event)  {
		String tmp [] = event.trim().split("\\s+", 5);
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
	 * Method validate view
	 * @param view input view
	 * @return true if method can parse view, else - false
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
	 * method init annotation and view according importance
	 * @param importance it is current importance
	 * @throws Lab2.exception.UnknownImportanceStateException - throw if importance cant find
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
	 * Method validate annotation
	 * @param annotation - current annotation
	 * @throws Lab2.exception.WrongInputDataException - throw if annotation invalid
	 */
	private void validateAnnotation(String annotation) throws WrongInputDataException {
		if(annotation.split("\n").length != 1 || annotation.split("\r").length != 1){
			throw new WrongInputDataException("Incorrect massage, massage must not contains line break");
		}
	}

	/**
	 * Overview:
	 * Method validate source
	 * @param source - current source
     * @throws Lab2.exception.WrongInputDataException - throw if source invalid
	 */
	private void validateSource(String source) throws WrongInputDataException {
		if(source.split(" ").length != 1){
			throw new WrongInputDataException("Source name must haven`t contains space!");
		}
	}

	/**
	 * Overview:
	 * Method validate date
	 * @param date - current date
	 * @return true if date valid
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
	 * Method prepare view
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
	 * Method compare object with current record
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
	 * Method get hash code current record
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
	 * Method views current record
	 */
	@Override
	public String toString() {
		return  format.format(date) +
				" " + prepareView() +
				" " + source ;
	}
}
