package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class ArgumentParserTest {
	private ArgumentParser p;
	
	@Before
	public void startUp()
	{
		p = new ArgumentParser();
	}
	@Test
	public void testAddArgument(){
		assertEquals(0,p.getNumArguments());
		p.addArguments("length");
		assertEquals(1,p.getNumArguments());
		p.addArguments("width");
		assertEquals(2,p.getNumArguments());
	}
	@Test
	public void testAddArgumentValue(){
		p.addArguments("length");
		p.addArguments("width");
		p.addArguments("height");
		p.setValue("7");
		p.setValue("5");
		p.setValue("2");
		assertEquals("7",p.getArgumentValue("length"));
		assertEquals("5",p.getArgumentValue("width"));
		assertEquals("2",p.getArgumentValue("height"));
	}
	@Test(expected = MissingValueException.class)
	public void testMissingArgumentValue() throws MissingValueException,TooManyValueException{
		p.addArguments("length");
		p.addArguments("width");
		p.addArguments("height");
		p.parse("7 5");
	}
	@Test(expected = TooManyValueException.class)
	public void testTooManyValue() throws TooManyValueException,MissingValueException{
		p.addArguments("length");
		p.addArguments("width");
		p.addArguments("height");
		p.parse("7 5 2 6 2");
	}
	@Test
	public void testSetDataType(){
		p.addArguments("length");
		p.addArguments("width");
		p.addArguments("height");
		p.setDataType("Integer");
		p.setDataType("Boolean");
		p.setDataType("String");
		assertEquals("Integer",p.getArgumentType("length"));
		assertEquals("Boolean",p.getArgumentType("width"));
		assertEquals("String",p.getArgumentType("height"));
	}
	@Test
	public void testGetOptionalArgumentFromCMD()throws TooManyValueException,MissingValueException{
		p.parse("--help --type -t");
		assertEquals(3,p.getOptArguments());
	}
	
}