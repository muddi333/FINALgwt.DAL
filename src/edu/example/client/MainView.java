package edu.example.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.service.FunctionalityService;
import edu.example.server.*;

public class MainView extends Composite {
	private VerticalPanel contentPanel = new VerticalPanel();
	private FunctionalityService func;

	public MainView(){
		func = new FunctionalityServiceImpl();
		initWidget(this.contentPanel);
		this.contentPanel.setBorderWidth(1);

		Menu1 menu = new Menu1(this, func);
		this.contentPanel.add(menu);


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
}
