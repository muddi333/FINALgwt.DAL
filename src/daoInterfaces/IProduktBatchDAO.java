package daoInterfaces;

import java.io.Serializable;
import java.util.List;

import dto.ProduktBatchDTO;

public interface IProduktBatchDAO extends Serializable {
	ProduktBatchDTO getProduktBatch(int pbId) throws DALException;
	List<ProduktBatchDTO> getProduktBatchList() throws DALException;
	void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException;
	void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException;
	boolean ifExist(int id) throws DALException;
}
