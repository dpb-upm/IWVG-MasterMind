package es.upm.miw.masterMind;

import es.upm.miw.masterMind.controllers.local.LocalLogic;
import es.upm.miw.masterMind.controllers.local.LocalOperationController;
import es.upm.miw.masterMind.views.MasterMindView;

public class MasterMind {

	private Logic logic;
	
	private MasterMindView view;
	
	private MasterMind() {
		logic = new LocalLogic();
		view = new MasterMindView();
	}
	
	private void play() {
		LocalOperationController controller;
        do {
			controller = logic.getOperationController();
			if (controller != null){
				view.interact(controller);
			}
		} while (controller != null);
		
	}

	public static void main(String[] args) {
		new es.upm.miw.masterMind.MasterMind().play();
	}
}
