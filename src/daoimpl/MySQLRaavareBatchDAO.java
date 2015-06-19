package daoimpl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectorJ;
import daoInterfaces.DALException;
import daoInterfaces.IRaavareBatchDAO;
import dto.RaavareBatchDTO;



public class MySQLRaavareBatchDAO implements IRaavareBatchDAO, Serializable {

	@Override
	public RaavareBatchDTO getRaavareBatch(int rbId) throws DALException {
		ResultSet rs = ConnectorJ.doQuery("SELECT * FROM raavarebatch WHERE rb_id = " + rbId);
		try {
			if (!rs.first()) throw new DALException("Raavarebatchen " + rbId+ " findes ikke");
			return new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde"));
		}
		catch (SQLException e) {throw new DALException(e);
		}
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
		List<RaavareBatchDTO> list = new ArrayList<RaavareBatchDTO>();
		ResultSet rs = ConnectorJ.doQuery("SELECT * FROM raavarebatch");
		try
		{
			while (rs.next()) 
			{
				list.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList(int raavareId)
			throws DALException {
		List<RaavareBatchDTO> list = new ArrayList<RaavareBatchDTO>();
		ResultSet rs = ConnectorJ.doQuery("SELECT * FROM raavarebatch WHERE raavare_id = " + raavareId);
		try
		{
			while (rs.next()) 
			{
				list.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		ConnectorJ.doUpdate(
				"INSERT INTO raavarebatch(rb_id, raavare_id, maengde) VALUES " +
				"(" + raavarebatch.getRbId() + ", '" + raavarebatch.getRaavareId() + "', '" + raavarebatch.getMaengde() + "')");

	}

	@Override
	public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		ConnectorJ.doUpdate(
				"UPDATE raavarebatch SET  raavare_id = '" + raavarebatch.getRaavareId() + "', maengde =  '" + raavarebatch.getMaengde() + 
				"' WHERE rb_id = " + raavarebatch.getRbId());	
	}

	public boolean ifExist(int id) throws DALException{
		ResultSet rs = ConnectorJ.doQuery("SELECT * from raavarebatch WHERE raavareId = " + id);
		try {
			return rs.next();
		}	catch (SQLException e) { throw new DALException(e); }	
	}
}
