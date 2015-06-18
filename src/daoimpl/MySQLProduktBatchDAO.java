package daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectorJ;
import daoInterfaces.DALException;
import daoInterfaces.IProduktBatchDAO;
import dto.ProduktBatchDTO;


public class MySQLProduktBatchDAO implements IProduktBatchDAO {

	@Override
	public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
		ResultSet rs = ConnectorJ.doQuery("SELECT * FROM produktbatch WHERE pb_id = " + pbId);
		try {
			if (!rs.first()) throw new DALException("Produktbatchen " + pbId + " findes ikke");
			return new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id"));
		}
		catch (SQLException e) {throw new DALException(e);
		}
	}

	@Override
	public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
		List<ProduktBatchDTO> list = new ArrayList<ProduktBatchDTO>();
		ResultSet rs = ConnectorJ.doQuery("SELECT * FROM produktbatch");
		try
		{
			while (rs.next())
			{
				list.add(new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProduktBatch(ProduktBatchDTO produktbatch)
			throws DALException {
		ConnectorJ.doUpdate(
				"INSERT INTO produktbatch(pb_id, status, recept_id) VALUES " +
						"(" + produktbatch.getPbId() + ", '" + produktbatch.getStatus()+ "', '" + produktbatch.getReceptId() + "')");
	}

	@Override
	public void updateProduktBatch(ProduktBatchDTO produktbatch)
			throws DALException {
		ConnectorJ.doUpdate(
				"UPDATE produktbatch SET  status = '" + produktbatch.getStatus() + "', recept_id =  '" + produktbatch.getReceptId() + 
				"' WHERE pb_id = " + produktbatch.getPbId());
	}
	
	public void updateProduktBatchStatus(ProduktBatchDTO produktbatch)
			throws DALException {
		ConnectorJ.doUpdate(
				"UPDATE produktbatch SET  status = '" + produktbatch.getStatus() + "' WHERE pb_id = " + produktbatch.getPbId());
	}
	
	public boolean ifExist(int id) throws DALException{
		ResultSet rs = ConnectorJ.doQuery("SELECT * from produktbatch WHERE pb_id = " + id);
		try {
			return rs.next();
		}	catch (SQLException e) { throw new DALException(e); }	
	}
}
