package edu.example.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class PAGE1 extends Composite {
	private HorizontalPanel hPanel = new HorizontalPanel();
	private MainView main;


	public PAGE1(MainView main){
		this.main = main;
		initWidget(this.hPanel);

		hPanel.setSpacing(10);

		Button bt1 = new Button("Opret");
		bt1.addClickHandler(new ls1Clickhandler());
		this.hPanel.add(bt1);

		Button bt2 = new Button("Slet");
		bt2.addClickHandler(new ls2Clickhandler());
		this.hPanel.add(bt2);

		Button bt3 = new Button("Ret");
		bt3.addClickHandler(new ls3Clickhandler());
		this.hPanel.add(bt3);

		Button bt4= new Button("Vis");
		this.hPanel.add(bt4);
	}

	private class ls1Clickhandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			main.opretPage();
		}
	}
	private class ls2Clickhandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			main.sletPage();
		}
	}
	private class ls3Clickhandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			main.retPage();
		}
	}
}