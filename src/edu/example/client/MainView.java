package edu.example.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.service.FunctionalityService;
import edu.example.client.service.FunctionalityServiceClientImpl;
import edu.example.client.service.FunctionalityServiceClientInt;
import edu.example.server.*;

public class MainView extends Composite {
	private VerticalPanel contentPanel = new VerticalPanel();
	private FunctionalityServiceClientImpl service;

	private int oprId;
	private String psw;
	private Label lb1;
	private Label lb2;
	private TextBox tb1;
	private TextBox tb2;
	private Label lbtest;

	public MainView(FunctionalityServiceClientImpl service){
		this.service = service;
		initWidget(this.contentPanel);

		lb1 = new Label("Operatoer id");
		this.contentPanel.add(lb1);
		
		tb1 = new TextBox();
		this.contentPanel.add(tb1);

		lb2 = new Label("Password:");
		this.contentPanel.add(lb2);

		tb2 = new TextBox();
		this.contentPanel.add(tb2);

		Button login = new Button("Login");
		login.addClickHandler(new ls1Clickhandler());
		this.contentPanel.add(login);
	}



	public FunctionalityServiceClientImpl getImpl() {
		return service;
	}

	public void choseView() {
		contentPanel.clear();
		lbtest = new  Label("skiftet");
		
	}

	public void openPAGE1(int clearance){
		this.contentPanel.clear();
		PAGE1 page1 = new PAGE1(this, clearance);
		this.contentPanel.add(page1);
	}
	public void opretPage(){
		this.contentPanel.clear();
		opretPAGE opretPage = new opretPAGE(this);
		this.contentPanel.add(opretPage);
	}
	public void sletPage(){
		this.contentPanel.clear();
		sletPAGE sletPage = new sletPAGE(this);
		this.contentPanel.add(sletPage);
	}
	public void retPage(){
		this.contentPanel.clear();
		retPAGE retPage = new retPAGE(this);
		this.contentPanel.add(retPage);
	}

	private class ls1Clickhandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			try {
				oprId = Integer.parseInt(tb1.getText());
				psw = lb2.getText();
				service.login(oprId, psw);
			} catch (Exception e) {
				Window.alert("Please enter a number as ID");
			}
		}
	}
}
