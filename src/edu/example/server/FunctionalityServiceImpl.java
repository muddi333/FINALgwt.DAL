package edu.example.server;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.example.client.service.FunctionalityService;
import edu.example.server.connector.ConnectorJ;
import edu.example.server.daoImpl.MySQLOperatoerDAO;
import edu.example.server.daoImpl.MySQLProduktBatchDAO;
import edu.example.server.daoImpl.MySQLProduktBatchKompDAO;
import edu.example.server.daoImpl.MySQLRaavareBatchDAO;
import edu.example.server.daoImpl.MySQLRaavareDAO;
import edu.example.server.daoImpl.MySQLReceptDAO;
import edu.example.server.daoImpl.MySQLReceptKompDAO;
import edu.example.server.daoInterface.IOperatoerDAO;
import edu.example.server.daoInterface.IProduktBatchDAO;
import edu.example.server.daoInterface.IProduktBatchKompDAO;
import edu.example.server.daoInterface.IRaavareBatchDAO;
import edu.example.server.daoInterface.IRaavareDAO;
import edu.example.server.daoInterface.IReceptDAO;
import edu.example.server.daoInterface.IReceptKompDAO;
import edu.example.shared.dto.DALException;
import edu.example.shared.dto.OperatoerDTO;
import edu.example.shared.dto.ProduktBatchDTO;
import edu.example.shared.dto.ProduktBatchKompDTO;
import edu.example.shared.dto.RaavareBatchDTO;
import edu.example.shared.dto.RaavareDTO;
import edu.example.shared.dto.ReceptDTO;
import edu.example.shared.dto.ReceptKompDTO;

public class FunctionalityServiceImpl extends RemoteServiceServlet implements FunctionalityService {
	private IPasswordGen pswgen;
	private IRaavareDAO raavareData;
	private IRaavareBatchDAO rbData;
	private IReceptDAO receptData;
	private IReceptKompDAO rkData;
	private IProduktBatchDAO pbData;
	private IProduktBatchKompDAO pbkData;
	private IOperatoerDAO opData;
	private RaavareDTO raavare;
	private RaavareBatchDTO raavareBatch;
	private ReceptDTO recept;
	private ArrayList<ReceptKompDTO> receptKomp;
	private ProduktBatchDTO productBatch;
	private ArrayList<ProduktBatchKompDTO> pbKomp;
	private OperatoerDTO operatoer;	

	public FunctionalityServiceImpl() {
		try { new ConnectorJ(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		
		pswgen = new PasswordGen();
		raavareData = new MySQLRaavareDAO();
		rbData = new MySQLRaavareBatchDAO();
		receptData = new MySQLReceptDAO();
		rkData = new MySQLReceptKompDAO();
		pbData = new MySQLProduktBatchDAO();
		pbkData = new MySQLProduktBatchKompDAO();
		opData = new MySQLOperatoerDAO();
	}

	@Override
	public void setOpr(int id) throws DALException {
		this.operatoer = opData.getOperatoer(id);
	}

	public void setRaavare(int id) throws DALException {
		raavare = raavareData.getRaavare(id);
	}
	public void setRaavareBatch(int id) throws DALException {
		raavareBatch = rbData.getRaavareBatch(id);
	}
	public void setRecept(int id) throws DALException{
		recept = receptData.getRecept(id);
	}
	public void setReceptKomp(int id) throws DALException {
		receptKomp = (ArrayList)rkData.getReceptKompList(id);
	}
	public void setProduktBatch(int id) throws DALException {
		productBatch = pbData.getProduktBatch(id);
	}
	public void setProduktBatchKomp(int id) throws DALException {
		pbKomp = (ArrayList)pbkData.getProduktBatchKompList();
	}

	public void createOperatoer(OperatoerDTO op) throws DALException {
		if(!opData.ifExist(op.getOprId())) {
			opData.createOperatoer(op);
		} else throw new DALException("ID allerede i brug");
	}

	public void deleteOperatoer(OperatoerDTO op) throws DALException {
		if(opData.ifExist(op.getOprId())) {
			if(opData.getOperatoer(op.getOprId()).getType()!= 0)
			opData.deleteOperatoer(op.getOprId());
		}else throw new DALException("Operatoer findes ikke");
	}

	@Override
	public boolean checkOprId(int oprId) throws DALException {
		return opData.ifExist(oprId);
	}

	@Override
	public boolean checkPasswordIntegrity(String psw) {
		return pswgen.checkCriteria(psw);
	}

	@Override
	public boolean login(int oprId, String psw) throws DALException {
		return psw.equals(opData.getOperatoer(oprId).getPassword());
	}
	
	public boolean checkRaavareId(int id) throws DALException {
		return rbData.ifExist(id);
	}

	@Override
	public boolean checkReceptId(int receptId) throws DALException {
		return pbData.ifExist(receptId);
	}

	@Override
	public RaavareBatchDTO getRaavareBatch() {
		return raavareBatch;
	}

	@Override
	public RaavareDTO getRaavare() {
		return raavare;
	}

	@Override
	public ReceptDTO getRecept() {
		return recept;
	}

	@Override
	public ProduktBatchDTO getProduktBatch() {
		return productBatch;
	}

	@Override
	public ArrayList<ReceptKompDTO> getReceptKomp() {
		return receptKomp;
	}


	@Override
	public ArrayList<ProduktBatchKompDTO> getProduktBatchKomp() {
		return pbKomp;
	}

}
