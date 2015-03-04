package edu.jsu.mcis;

import java.util.*;
import java.io.*;

public class ArgumentParser {
	private HashMap <String, String> map;
	private ArrayList<String> argumentNames;
	private ArrayList<String> argumentValues;
	public ArgumentParser(){
		map= new HashMap<String, String>();
		argumentNames = new ArrayList<String>();
		argumentValues = new ArrayList<String>();
	}
	public void addArguments(String str){
		argumentNames.add(str);
	}
	public void addArguments(String name, String value){
		argumentNames.add(name);
		map.put(name,value);
	}
	public int getNumArguments(){
		return argumentNames.size();
	}
	public String getArgumentValue(String name){
		return map.get(name);
	}
	public int getNumValues(){
		return argumentValues.size();
	}
	public void parse(String str) throws MissingValueException{
		Scanner scan = new Scanner(str);
		while(scan.hasNext()){
			argumentValues.add(scan.next());
		}
		int countArgValues = 0;
		int numberValues = 0;
		if(getNumArguments() > getNumValues())
			throw new MissingValueException("not enough!");
		
	}
}