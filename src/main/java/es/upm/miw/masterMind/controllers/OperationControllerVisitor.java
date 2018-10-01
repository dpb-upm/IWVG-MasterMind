package es.upm.miw.masterMind.controllers;

import es.upm.miw.masterMind.controllers.local.LocalContinueController;
import es.upm.miw.masterMind.controllers.local.LocalPutController;
import es.upm.miw.masterMind.controllers.local.LocalPutDemoController;
import es.upm.miw.masterMind.controllers.local.LocalStartController;

public interface OperationControllerVisitor {

	void visit(LocalStartController startController);
	
	void visit(LocalPutController putController);
	
	void visit(LocalPutDemoController putDemoController);
	
	void visit(LocalContinueController continueController);

}

