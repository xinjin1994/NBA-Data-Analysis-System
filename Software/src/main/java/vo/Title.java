package vo;

import enums.Terminology;
import enums.Titles;

public class Title {
	Titles title;
	Terminology field;
	String time;
	
	public Title(Titles title, Terminology field, String time){
		this.title = title;
		this.field = field;
		this.time = time;
	}

	public Titles getTitle() {
		return title;
	}

	public Terminology getField() {
		return field;
	}

	public String getTime() {
		return time;
	}
	
}
