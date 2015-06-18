package test;

import java.sql.SQLException;

import Connect.ConnectorJ;
import daoInterfaces.DALException;
import daoimpl.MySQLOperatoerDAO;
import dto.OperatoerDTO;

public class testDBAL {
	public static void main(String[] args) {
		try { new ConnectorJ(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		MySQLOperatoerDAO opr = new MySQLOperatoerDAO();

		OperatoerDTO oprDTO;
		try {
//			opr.createOperatoer(oprDTO = new OperatoerDTO(4,1, "Olivier","SOSA","000000-0606","hawhawhaw"));
//			opr.createOperatoer(oprDTO = new OperatoerDTO(6,3, "Olivier2","SOSA2","000000-6602","hawhawhaw"));
			opr.createOperatoer(oprDTO = new OperatoerDTO(7,2, "Haidermus","Everyday","123456-6602","halla"));
		}  catch (DALException e) { System.out.println(e.getMessage()); }
	}
}
