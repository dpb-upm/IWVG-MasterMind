package es.upm.miw.masterMind.controllers.local;

import es.upm.miw.masterMind.controllers.Error;
import es.upm.miw.masterMind.controllers.OperationControllerVisitor;
import es.upm.miw.masterMind.controllers.PutController;
import es.upm.miw.masterMind.models.Game;

public class LocalPutDemoController extends LocalColocateController implements PutController {

    LocalPutDemoController(Game game) {
        super(game);
    }

    public Error validateTarget(String attempt) {
        return super.validateTarget(attempt);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    public String getRandomAttempt() { return super.getStringRandomTokens(); }
}