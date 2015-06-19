package edu.example.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import daoInterfaces.DALException;
import edu.example.client.service.FunctionalityService;

public class Menu1 extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private MainView main;
	private FunctionalityService func;
	
	private int oprId;
	private String psw;
	private Label lb1;
	private Label lb2;
	
	public Menu1(MainView main, FunctionalityService func) {
		this.func = func;
		initWidget(this.vPanel);
		this.main = main;

		lb1 = new Label("Operatoer id");
		this.vPanel.add(lb1);
		
		TextBox tb1 = new TextBox();
		this.vPanel.add(tb1);

		lb2 = new Label("Password:");
		this.vPanel.add(lb2);

		TextBox tb2 = new TextBox();
		this.vPanel.add(tb2);

		Button login = new Button("Login");
		login.addClickHandler(new ls1Clickhandler());
		this.vPanel.add(login);
		
//		Label test = new Label(lb1.getItemText(1));
//		this.vPanel.add(test);
		
		
	}

	private class ls1Clickhandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			oprId = Integer.parseInt(lb1.getText());
			psw = lb2.getText();
				try {
					if(func.login(oprId, psw)) {
						main.openPAGE1(func.getOprClearance(oprId));
					}
				} catch (DALException e) {
					e.printStackTrace();
				}
		}
	}
}
