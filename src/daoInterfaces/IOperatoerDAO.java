package daoInterfaces;

import java.io.Serializable;
import java.util.List;

import dto.OperatoerDTO;

public interface IOperatoerDAO extends Serializable {
	OperatoerDTO getOperatoer(int oprId) throws DALException;
	List<OperatoerDTO> getOperatoerList() throws DALException;
	void createOperatoer(OperatoerDTO opr) throws DALException;
	void updateOperatoer(OperatoerDTO opr) throws DALException;
	void deleteOperatoer(int id) throws DALException;
	int getRolle(int oprId) throws DALException;
	boolean ifExist(int id) throws DALException;
}
