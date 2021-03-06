package edu.example.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.example.shared.dto.OperatoerDTO;
import edu.example.shared.dto.ProduktBatchDTO;
import edu.example.shared.dto.ProduktBatchKompDTO;
import edu.example.shared.dto.RaavareBatchDTO;
import edu.example.shared.dto.RaavareDTO;
import edu.example.shared.dto.ReceptDTO;
import edu.example.shared.dto.ReceptKompDTO;


public interface FunctionalityServiceAsync {
	void checkOprId(int oprId, AsyncCallback<Boolean> callback);
	void checkPasswordIntegrity(String psw, AsyncCallback<Boolean> callback);
	void checkRaavareId(int rvId, AsyncCallback<Boolean> callback);
	void checkReceptId(int receptId, AsyncCallback<Boolean> callback);
	void createOperatoer(OperatoerDTO op, AsyncCallback<Void> callback);
	void deleteOperatoer(OperatoerDTO op, AsyncCallback<Void> callback);
	void getProduktBatch(AsyncCallback<ProduktBatchDTO> callback);
	void getProduktBatchKomp(
			AsyncCallback<ArrayList<ProduktBatchKompDTO>> callback);
	void getRaavare(AsyncCallback<RaavareDTO> callback);
	void getRaavareBatch(AsyncCallback<RaavareBatchDTO> callback);
	void getRecept(AsyncCallback<ReceptDTO> callback);
	void getReceptKomp(AsyncCallback<ArrayList<ReceptKompDTO>> callback);
	void login(int oprId, String psw, AsyncCallback<Boolean> callback);
	void setOpr(int id, AsyncCallback<Void> callback);
	void setProduktBatch(int id, AsyncCallback<Void> callback);
	void setProduktBatchKomp(int id, AsyncCallback<Void> callback);
	void setRaavare(int id, AsyncCallback<Void> callback);
	void setRaavareBatch(int id, AsyncCallback<Void> callback);
	void setRecept(int id, AsyncCallback<Void> callback);
	void setReceptKomp(int id, AsyncCallback<Void> callback);
}
