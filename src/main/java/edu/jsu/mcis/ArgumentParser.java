package edu.jsu.mcis;

import java.util.*;
import java.io.*;

public class ArgumentParser {
	private HashMap <String, String> argValue;
	private HashMap <String, String> argType;
	private ArrayList<String> argumentNames;
	private ArrayList<String> argumentValues;
	private ArrayList<String> optionalArgument;
	private ArrayList<String> dataType;
	private int valueIn = 0;
	private int typeIn = 0;
	public ArgumentParser(){
		argValue= new HashMap<String, String>();
		argumentNames = new ArrayList<String>();
		argumentValues = new ArrayList<String>();
		optionalArgument = new ArrayList<String>();
		argType = new HashMap<String, String>();
	}
	public void addArguments(String str){
		argumentNames.add(str);
	}
	public void setValue(String value){
		argValue.put(argumentNames.get(valueIn),value);
		valueIn++;
	}
	public void setDataType(String type){
		argType.put(argumentNames.get(typeIn),type);
		typeIn++;
	}
	
	//public int getNumType(){
		//return dataType.size();
	//}
	public int getNumArguments(){
		return argumentNames.size();
	}
	public Object getArgumentValue(String name){
		if(argType.get(name) == "Integer")
			return Integer.parseInt(argValue.get(name));
		else if(argType.get(name) == "Boolean")
			return Boolean.parseBoolean(argValue.get(name));
		else if(argType.get(name) == "Float")
			return Double.parseDouble(argValue.get(name));
		else if(argType.get(name) == "String")
			return argValue.get(name);
		return argValue.get(name);
	}
	public String getArgumentType(String name){
		return argType.get(name);
	}
	public int getNumValues(){
		return argumentValues.size();
	}
	public int getOptArguments(){
		return optionalArgument.size();
	}
	public void parse(String str) throws MissingValueException,TooManyValueException{
		ArrayList<String> arg = new ArrayList<String>();
		Scanner scan = new Scanner(str);
		while(scan.hasNext()){
			arg.add(scan.next());
		}
		for(String s : arg)
		{
			if(s.startsWith("--")||s.startsWith("-"))
				optionalArgument.add(s);
			else {
				argumentValues.add(s);
			}
		}
		if(getNumArguments() > getNumValues())
			throw new MissingValueException("not enough!");
		else if(getNumArguments() < getNumValues())
			throw new TooManyValueException("too many");
		else if(getNumArguments() == getNumValues())
		{
			for(int i = 0; i < getNumArguments(); i++)
			{
				setValue(argumentValues.get(i));
			}
		}
		
	}
	public String getHelpText(){
		String help = "usage:";
		return help;
	}
}