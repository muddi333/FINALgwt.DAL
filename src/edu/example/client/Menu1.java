package edu.example.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Menu1 extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private MainView main;
	ListBox lb1;

	public Menu1(MainView main) {
		initWidget(this.vPanel);
		this.main = main;

		lb1 = new ListBox();
		lb1.addItem("Admin");
		lb1.addItem("Vaerkfoere");
		lb1.addItem("Farmaceut");

		this.vPanel.add(lb1);

		Label lb2 = new Label("Password:");
		this.vPanel.add(lb2);

		TextBox tb1 = new TextBox();
		this.vPanel.add(tb1);

		Button login = new Button("Login");
		login.addClickHandler(new ls1Clickhandler());
		this.vPanel.add(login);
		
//		Label test = new Label(lb1.getItemText(1));
//		this.vPanel.add(test);
		
		
	}

	private class ls1Clickhandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
				main.openPAGE1();
		}
	}
}
