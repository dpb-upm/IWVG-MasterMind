package es.upm.miw.masterMind;

import es.upm.miw.masterMind.controllers.local.LocalOperationController;

public interface Logic {
    LocalOperationController getOperationController();
}
