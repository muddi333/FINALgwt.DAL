package edu.example.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class opretPAGE extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private MainView main;
	
	public opretPAGE(MainView main){
		this.main = main;
		initWidget(this.vPanel);
		
		Label cpr = new Label("Cpr nr.");
		this.vPanel.add(cpr);
		TextBox tb1 = new TextBox();
		this.vPanel.add(tb1);
		
		Label bruger = new Label("Bruger id");
		this.vPanel.add(bruger);
		TextBox tb2 = new TextBox();
		this.vPanel.add(tb2);
		
		Label fornavn = new Label("Fornavn");
		this.vPanel.add(fornavn);
		TextBox tb3 = new TextBox();
		this.vPanel.add(tb3);
		
		Label efternavn = new Label("Efternavn");
		this.vPanel.add(efternavn);
		TextBox tb4 = new TextBox();
		this.vPanel.add(tb4);
		
		Label password = new Label("Password");
		this.vPanel.add(password);
		TextBox tb5 = new TextBox();
		this.vPanel.add(tb5);
		
		Label ini = new Label("Initialer");
		this.vPanel.add(ini);
		TextBox tb6 = new TextBox();
		this.vPanel.add(tb6);
		
		Label rolle = new Label("Brugerens rolle");
		this.vPanel.add(rolle);
		TextBox tb7 = new TextBox();
		this.vPanel.add(tb7);
		
		Label status = new Label("Status: ");
		this.vPanel.add(status);
		
		Button submit = new Button("Opret");
		
		this.vPanel.add(submit);
	}
}
