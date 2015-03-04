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
		p.addArguments("length","7");
		p.addArguments("width","5");
		p.addArguments("height","2");
		assertEquals("7",p.getArgumentValue("length"));
		assertEquals("5",p.getArgumentValue("width"));
		assertEquals("2",p.getArgumentValue("height"));
	}
	@Test(expected = MissingValueException.class)
	public void testMissingArgumentValue() throws MissingValueException{
		p.addArguments("length");
		p.addArguments("width");
		p.addArguments("height");
		p.parse("7 5");
	}
}