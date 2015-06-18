package daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectorJ;
import daoInterfaces.DALException;
import daoInterfaces.IOperatoerDAO;
import dto.OperatoerDTO;



public class MySQLOperatoerDAO implements IOperatoerDAO {
	public OperatoerDTO getOperatoer(int oprId) throws DALException {
		ResultSet rs = ConnectorJ.doQuery("SELECT * FROM operatoer WHERE opr_id = " + oprId);
		try {
			if (!rs.first()) throw new DALException("Operatoeren " + oprId + " findes ikke");
			return new OperatoerDTO (rs.getInt("opr_id"), rs.getInt("rolle"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"));
		}
		catch (SQLException e) {throw new DALException(e);
		}
	}

	public void createOperatoer(OperatoerDTO opr) throws DALException {		
		ConnectorJ.doUpdate(
				"INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password, rolle) VALUES " +
						"(" + opr.getOprId() + ", '" + opr.getOprNavn() + "', '" + opr.getIni() + "', '" + 
						opr.getCpr() + "', '" + opr.getPassword() + "', '" + opr.getType() + "')"
				);
	}

	public void updateOperatoer(OperatoerDTO opr) throws DALException {
		ConnectorJ.doUpdate(
				"UPDATE operatoer SET  opr_navn = '" + opr.getOprNavn() + "', ini =  '" + opr.getIni() + 
				"', cpr = '" + opr.getCpr() + "', password = '" + opr.getPassword() + "' WHERE opr_id = " +
				opr.getOprId());
	}
	
	public void deleteOperatoer(int id) throws DALException {
		ConnectorJ.doUpdate(
				"delete from operatoer where opr_id= " + id);
	}

	public List<OperatoerDTO> getOperatoerList() throws DALException {
		List<OperatoerDTO> list = new ArrayList<OperatoerDTO>();
		ResultSet rs = ConnectorJ.doQuery("SELECT * FROM operatoer");
		try
		{
			while (rs.next()) 
			{
				list.add(new OperatoerDTO(rs.getInt("opr_id"), rs.getInt("opr_type"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
	
	public boolean ifExist(int id) throws DALException{
		ResultSet rs = ConnectorJ.doQuery("SELECT * from operatoer WHERE opr_id = " + id);
		try {
			return rs.next();
		}	catch (SQLException e) { throw new DALException(e); }	
	}
}