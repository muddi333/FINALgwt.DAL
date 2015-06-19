package daoimpl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectorJ;
import daoInterfaces.DALException;
import daoInterfaces.IReceptDAO;
import dto.ReceptDTO;



public class MySQLReceptDAO implements IReceptDAO, Serializable {

	@Override
	public ReceptDTO getRecept(int receptId) throws DALException {
		ResultSet rs = ConnectorJ.doQuery("SELECT * FROM recept WHERE recept_id = " + receptId);
		try {
			if (!rs.first()) throw new DALException("Recepten " + receptId + " findes ikke");
			return new ReceptDTO (rs.getInt("recept_id"), rs.getString("recept_navn"));
		}
		catch (SQLException e) {throw new DALException(e);
		}
	}

	@Override
	public List<ReceptDTO> getReceptList() throws DALException {
		List<ReceptDTO> list = new ArrayList<ReceptDTO>();
		ResultSet rs = ConnectorJ.doQuery("SELECT * FROM recept");
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptDTO(rs.getInt("recept_id"), rs.getString("recept_navn")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createRecept(ReceptDTO recept) throws DALException {
		ConnectorJ.doUpdate(
				"INSERT INTO recept(recept_id, recept_navn) VALUES " +
						"(" + recept.getReceptId() + ", '" + recept.getReceptNavn() + "')");	
	}

	@Override
	public void updateRecept(ReceptDTO recept) throws DALException {
		ConnectorJ.doUpdate(
				"UPDATE recept SET  recept_navn = '" + recept.getReceptNavn()+ 
				"' WHERE recept_id = " + recept.getReceptId());

	}

}
