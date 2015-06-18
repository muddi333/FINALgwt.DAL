package functionality;

import java.sql.SQLException;
import java.util.ArrayList;

import Connect.ConnectorJ;
import daoInterfaces.DALException;
import daoInterfaces.IProduktBatchDAO;
import daoInterfaces.IProduktBatchKompDAO;
import daoInterfaces.IRaavareBatchDAO;
import daoInterfaces.IRaavareDAO;
import daoInterfaces.IReceptDAO;
import daoInterfaces.IReceptKompDAO;
import daoInterfaces.IOperatoerDAO;
import daoimpl.MySQLOperatoerDAO;
import daoimpl.MySQLProduktBatchDAO;
import daoimpl.MySQLProduktBatchKompDAO;
import daoimpl.MySQLRaavareBatchDAO;
import daoimpl.MySQLRaavareDAO;
import daoimpl.MySQLReceptDAO;
import daoimpl.MySQLReceptKompDAO;
import dto.OperatoerDTO;
import dto.ProduktBatchDTO;
import dto.ProduktBatchKompDTO;
import dto.RaavareBatchDTO;
import dto.RaavareDTO;
import dto.ReceptDTO;
import dto.ReceptKompDTO;

public class Functionality implements IFunctionality {
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

	public Functionality() {
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
		return psw.equals(opData.getOperatoer(oprId).getPassword()) && (oprId > 9);
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
