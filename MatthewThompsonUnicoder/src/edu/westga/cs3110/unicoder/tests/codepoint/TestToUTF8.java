package edu.westga.cs3110.unicoder.tests.codepoint;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF8 {

	@Test
	public void testUTF8MinValueOneByte() {
		Codepoint codepoint = new Codepoint("0x0000");
		assertTrue("0x00".equalsIgnoreCase(codepoint.toUTF8()));
	}

	@Test
	public void testUTF8MaxValueOneByte() {
		Codepoint codepoint = new Codepoint("0x007F");
		assertTrue("0x7f".equalsIgnoreCase(codepoint.toUTF8()));
	}

	@Test
	public void testUTF8MinValueTwoBytes() {
		Codepoint codepoint = new Codepoint("0x0080");
		assertTrue("0xC2 0x80".equalsIgnoreCase(codepoint.toUTF8()));
	}

	@Test
	public void testUTF8MaxValueTwoBytes() {
		Codepoint codepoint = new Codepoint("0x07FF");
		assertTrue("0xDF 0xBF".equalsIgnoreCase(codepoint.toUTF8()));
	}

	@Test
	public void testUTF8MinValueThreeBytes() {
		Codepoint codepoint = new Codepoint("0x0800");
		assertTrue("0xE0 0xA0 0x80".equalsIgnoreCase(codepoint.toUTF8()));
	}

	@Test
	public void testUTF8MaxValueThreeBytes() {
		Codepoint codepoint = new Codepoint("0xFFFF");
		assertTrue("0xEF 0xBF 0xBF".equalsIgnoreCase(codepoint.toUTF8()));
	}

	@Test
	public void testUTF8MinValueFourBytes() {
		Codepoint codepoint = new Codepoint("0x10000");
		assertTrue("0xF0 0x90 0x80 0x80".equalsIgnoreCase(codepoint.toUTF8()));
	}

	@Test
	public void testUTF8MaxValueFourBytes() {
		Codepoint codepoint = new Codepoint("0x10FFFF");
		assertTrue("0xF4 0x8F 0xBF 0xBF".equalsIgnoreCase(codepoint.toUTF8()));
	}

}
