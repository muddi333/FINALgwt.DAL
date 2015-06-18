package test;

import java.sql.SQLException;

import Connect.ConnectorJ;
import daoInterfaces.DALException;
import daoimpl.MySQLOperatoerDAO;

public class testOPR {
	public static void main(String[] args) throws DALException {

			try { new ConnectorJ(); } 
			catch (InstantiationException e) { e.printStackTrace(); }
			catch (IllegalAccessException e) { e.printStackTrace(); }
			catch (ClassNotFoundException e) { e.printStackTrace(); }
			catch (SQLException e) { e.printStackTrace(); }
			
		MySQLOperatoerDAO opr = new MySQLOperatoerDAO();
		
		
			opr.getOperatoer(1);


	}
}
