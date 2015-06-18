package edu.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class GWTPRojectTwo implements EntryPoint {
	
	public void onModuleLoad() {
		MainView mainView = new MainView();
		RootPanel.get().add(mainView);
	}
}