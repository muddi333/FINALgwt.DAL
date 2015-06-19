package edu.example.server;

import java.io.Serializable;

public class PasswordGen implements IPasswordGen, Serializable {
	private static final int MINIMUM_SIZE = 6;
	String psw;
	char[] symbols = {'.', '-', '_', '+', '!', '?', '=' };

	public boolean checkCriteria(String psw) {
		if(psw.length() < MINIMUM_SIZE) return false;
		int x = 0;
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isLowerCase(psw.charAt(i))) {
				x++;
				break;
			}
		}
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isUpperCase(psw.charAt(i))) {
				x++;
				break;
			}
		}
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isDigit(psw.charAt(i))) {
				x++;
				break;
			}
		}
		for(int i = 0; i < psw.length(); i++) {
			if(Character.isLowerCase(psw.charAt(i))) {
				x++;
				break;
			}
		}
		if(symbolsCheck(psw))
			x++;
		return x > 2;

	}

	public boolean symbolsCheck(String psw) {
		for(int i = 0; i < symbols.length; i++) {
			for(int j = 0; j < psw.length(); j++) {
				if(psw.charAt(j) == symbols[i])
					return true;
			}
		}
		return false;
	}
}
