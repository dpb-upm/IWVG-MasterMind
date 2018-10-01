package es.upm.miw.masterMind.controllers.local;

import es.upm.miw.masterMind.controllers.ContinueController;
import es.upm.miw.masterMind.controllers.OperationControllerVisitor;
import es.upm.miw.masterMind.models.Game;
import es.upm.miw.masterMind.models.State;

public class LocalContinueController extends LocalOperationController implements ContinueController {

    LocalContinueController(Game game) {
        super(game);
    }

    public void resume(boolean another) {
        assert this.getState() == State.FINAL;
        if (another) {
            this.clear();
            this.setState(State.INITIAL);
        } else {
            this.setState(State.EXIT);
        }
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
