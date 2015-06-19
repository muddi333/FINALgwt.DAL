package edu.example.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import daoInterfaces.DALException;
import dto.OperatoerDTO;
import dto.ProduktBatchDTO;
import dto.ProduktBatchKompDTO;
import dto.RaavareBatchDTO;
import dto.RaavareDTO;
import dto.ReceptDTO;
import dto.ReceptKompDTO;

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
	public int getOprClearance(int oprId) throws DALException;
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
