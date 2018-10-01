package es.upm.miw.masterMind.controllers.local;

import es.upm.miw.masterMind.models.Game;
import es.upm.miw.masterMind.controllers.OperationControllerVisitor;

public abstract class LocalOperationController extends LocalController {

	LocalOperationController(Game game) {
		super(game);
	}
	
	public abstract void accept(OperationControllerVisitor operationControllerVisitor);
}