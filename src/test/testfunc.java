package test;

import daoInterfaces.DALException;
import dto.OperatoerDTO;
import functionality.Functionality;
import functionality.IFunctionality;

public class testfunc {
	public static void main(String[] args) {
		IFunctionality f = new Functionality();
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
