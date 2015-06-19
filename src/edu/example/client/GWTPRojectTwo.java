package edu.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import edu.example.client.service.FunctionalityServiceClientImpl;

public class GWTPRojectTwo implements EntryPoint {
	
	public void onModuleLoad() {
		FunctionalityServiceClientImpl clientImpl = new FunctionalityServiceClientImpl(GWT.getModuleBaseURL() + "exampleservice");
		RootPanel.get().add(clientImpl.getView());
	}
}