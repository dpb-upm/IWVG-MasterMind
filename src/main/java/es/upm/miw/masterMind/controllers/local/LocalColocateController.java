package es.upm.miw.masterMind.controllers.local;

import es.upm.miw.masterMind.controllers.ColocateController;
import es.upm.miw.masterMind.controllers.OperationControllerVisitor;
import es.upm.miw.masterMind.models.Game;

class LocalColocateController extends LocalOperationController implements ColocateController {

    LocalColocateController(Game game) {
        super(game);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) { }

    /*@Override
    public boolean existMasterMind(String attempt) {
        return super.existMasterMind(attempt);
    }*/

    public int getLimitTokens() { return super.getLimitTokens(); }
}
