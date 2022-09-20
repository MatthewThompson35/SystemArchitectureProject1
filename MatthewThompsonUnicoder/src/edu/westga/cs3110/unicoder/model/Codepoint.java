package edu.westga.cs3110.unicoder.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Stack;

public class Codepoint {
	String codepoint;

	public Codepoint(String codepoint) {
		if (codepoint == null) {
			throw new NullPointerException("codepoint can not be null");
		}
		if (codepoint == "") {
			throw new IllegalArgumentException("codepoint can not be empty");
		}
		this.codepoint = codepoint;
	}

	public String getCodepoint() {
		return this.codepoint;
	}

	public String toUTF32() {
		String result = "0x";
		result += ("00000000" + this.codepoint.substring(2)).substring(this.codepoint.substring(2).length());
		return result;
	}

	public String toUTF16() {
		String result = "";
		String hex = this.codepoint.substring(2);
		int intValue = Integer.parseInt(hex, 16);
		if (intValue <= 0xFFFF) {
			result += "0x";
			result += ("0000" + hex).substring(hex.length());
		} else {
			intValue -= 0x10000;
			int high = (intValue >> 10) + 0xD800;
			int low = (intValue & 0x3FF) + 0xDC00;
			result += "0x";
			result += ("0000" + Integer.toHexString(high)).substring(Integer.toHexString(high).length());
			result += " 0x";
			result += ("0000" + Integer.toHexString(low)).substring(Integer.toHexString(low).length());
		}
		System.out.println(result);
		return result;
	}

	public String toUTF8() {
		String result = "";
		return result;
//		String hex = this.codepoint.substring(2);
//		String result = "0x";
//		Stack<String> stack = new Stack<String>();
//		int intValue = Integer.parseInt(hex, 16);
//		if(intValue >= 0x10000 && intValue <= 0x10FFFF) {
//			String binary = this.hexToBinary(this.codepoint.substring(2));
//			char[] list = binary.toCharArray();
//			int count = 0;
//			for(int i = list.length - 1; i >= 0; i--) {
//				if(count == 6) {
//					stack.push(String.valueOf(list[i]));
//					stack.push("10");
//					count++;
//				}
//				if(count == 12) {
//					stack.push(String.valueOf(list[i]));
//					stack.push("10");
//					count++;
//				}
//				stack.push(String.valueOf(list[i]));
//				count ++;
//			}
//			hex = new BigInteger(result, 2).toString(16);
//		}
//		return hex;
	}

	private String hexToBinary(String hex) {
		hex = hex.replaceAll("0", "0000");
		hex = hex.replaceAll("1", "0001");
		hex = hex.replaceAll("2", "0010");
		hex = hex.replaceAll("3", "0011");
		hex = hex.replaceAll("4", "0100");
		hex = hex.replaceAll("5", "0101");
		hex = hex.replaceAll("6", "0110");
		hex = hex.replaceAll("7", "0111");
		hex = hex.replaceAll("8", "1000");
		hex = hex.replaceAll("9", "1001");
		hex = hex.replaceAll("A", "1010");
		hex = hex.replaceAll("B", "1011");
		hex = hex.replaceAll("C", "1100");
		hex = hex.replaceAll("D", "1101");
		hex = hex.replaceAll("E", "1110");
		hex = hex.replaceAll("F", "1111");
		return hex;
	}

}
