package edu.westga.cs3110.unicoder.model;


public class Codepoint {
	String codepoint;
	
	public Codepoint() {
		codepoint = "0x1F682";
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
		return this.codepoint;
	}
	
	public String toUTF8() {
		return this.codepoint;
	}
	
	private String hexToBin(String hex){
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
