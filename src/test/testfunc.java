package test;

import daoInterfaces.DALException;
import dto.OperatoerDTO;
import edu.example.client.service.FunctionalityService;
import edu.example.server.FunctionalityServiceImpl;

public class testfunc {
	public static void main(String[] args) {
		FunctionalityService f = new FunctionalityServiceImpl();
		try {
			f.createOperatoer(new OperatoerDTO(5, 2, "bobby shmurda", "GS9", "999999-9999", "hot nigga"));
		} catch (DALException e) {
			e.printStackTrace();
		}
		try {
			f.createOperatoer(new OperatoerDTO(1, 2, "ee", "dd", "dd", "dd"));
		} catch(DALException e) {
			e.printStackTrace();
		}
	}
}
