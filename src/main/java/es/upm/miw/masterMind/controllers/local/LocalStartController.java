package es.upm.miw.masterMind.controllers.local;

import es.upm.miw.masterMind.controllers.OperationControllerVisitor;
import es.upm.miw.masterMind.models.Game;
import es.upm.miw.masterMind.models.State;

public class LocalStartController extends LocalOperationController {

	LocalStartController(Game game) {
		super(game);
    }

	@Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    public void setOption(int optionSelected){
        assert this.getState() == State.INITIAL;
        super.setOption(optionSelected);
        this.setState(State.IN_GAME);
    }

    public int getLimitTokens() { return super.getLimitTokens(); }
}
