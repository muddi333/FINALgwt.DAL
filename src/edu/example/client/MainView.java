package edu.example.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite {
	private VerticalPanel contentPanel = new VerticalPanel();


	public MainView(){
		initWidget(this.contentPanel);
		this.contentPanel.setBorderWidth(1);

		Menu1 menu = new Menu1(this);
		this.contentPanel.add(menu);


	}
	public void openPAGE1(){
		this.contentPanel.clear();
		PAGE1 page1 = new PAGE1(this);
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
