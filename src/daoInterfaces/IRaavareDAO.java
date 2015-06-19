package daoInterfaces;

import java.io.Serializable;
import java.util.List;

import dto.RaavareDTO;

public interface IRaavareDAO extends Serializable {
	RaavareDTO getRaavare(int raavareId) throws DALException;
	List<RaavareDTO> getRaavareList() throws DALException;
	void createRaavare(RaavareDTO raavare) throws DALException;
	void updateRaavare(RaavareDTO raavare) throws DALException;
}
