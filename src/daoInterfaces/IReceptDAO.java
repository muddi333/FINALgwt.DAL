package daoInterfaces;

import java.io.Serializable;
import java.util.List;

import dto.ReceptDTO;

public interface IReceptDAO extends Serializable {
	ReceptDTO getRecept(int receptId) throws DALException;
	List<ReceptDTO> getReceptList() throws DALException;
	void createRecept(ReceptDTO recept) throws DALException;
	void updateRecept(ReceptDTO recept) throws DALException;
}
