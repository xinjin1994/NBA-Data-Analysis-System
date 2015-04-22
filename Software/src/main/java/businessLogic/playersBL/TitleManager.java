package businessLogic.playersBL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import vo.Title;

public class TitleManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4785753263305702617L;
	static HashMap<String, Titles> list;
	
	public TitleManager(){
		list = new HashMap<String, Titles>();
	}
	
	public ArrayList<Title> getTitles(String name){
		Titles titles = list.get(name);
		if(titles == null){
			return null;
		}else{
			return titles.getTitles();
		}
	}
	
	public void calculateData(){
		
	}
}

class Titles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2876672291248277331L;
	ArrayList<Title> titles;
	
	public Titles(){
		if(titles == null){
			titles = new ArrayList<Title>();
		}
	}
	
	public ArrayList<Title> getTitles(){
		return titles;
	}
}