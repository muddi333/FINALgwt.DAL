package edu.example.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.example.shared.dto.DALException;
import edu.example.shared.dto.OperatoerDTO;
import edu.example.shared.dto.ProduktBatchDTO;
import edu.example.shared.dto.ProduktBatchKompDTO;
import edu.example.shared.dto.RaavareBatchDTO;
import edu.example.shared.dto.RaavareDTO;
import edu.example.shared.dto.ReceptDTO;
import edu.example.shared.dto.ReceptKompDTO;

@RemoteServiceRelativePath("exampleservice")
public interface FunctionalityService extends RemoteService{
	public void setOpr(int id) throws DALException;
	public void setRaavare(int id) throws DALException;
	public void setRaavareBatch(int id) throws DALException;
	public void setRecept(int id) throws DALException;
	public void setReceptKomp(int id) throws DALException;
	public void setProduktBatch(int id) throws DALException;
	public void setProduktBatchKomp(int id) throws DALException;
	public void createOperatoer(OperatoerDTO op) throws DALException;
	public void deleteOperatoer(OperatoerDTO op) throws DALException;
	public boolean checkOprId(int oprId) throws DALException;
	public boolean checkPasswordIntegrity(String psw);
	public boolean login(int oprId, String psw) throws DALException;
	public boolean checkReceptId(int receptId) throws DALException;
	public boolean checkRaavareId(int rvId) throws DALException;
	public RaavareDTO getRaavare() throws DALException;
	public RaavareBatchDTO getRaavareBatch() throws DALException;
	public ReceptDTO getRecept() throws DALException;
	public ProduktBatchDTO getProduktBatch() throws DALException;
	public ArrayList<ReceptKompDTO> getReceptKomp() throws DALException;
	public ArrayList<ProduktBatchKompDTO> getProduktBatchKomp();
}
