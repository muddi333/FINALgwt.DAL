package edu.example.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class sletPAGE extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private MainView main;

	public sletPAGE(MainView main){
		this.main = main;
		initWidget(this.vPanel);

		Label cpr = new Label("Indtast id");
		this.vPanel.add(cpr);
		TextBox tb1 = new TextBox();
		this.vPanel.add(tb1);
		
		
		Button btn1 = new Button("Slet");
		this.vPanel.add(btn1);
		
	}
}
