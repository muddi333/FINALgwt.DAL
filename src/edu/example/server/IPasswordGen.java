package edu.example.server;

import java.io.Serializable;

public interface IPasswordGen extends Serializable {
	boolean checkCriteria(String psw);
}
