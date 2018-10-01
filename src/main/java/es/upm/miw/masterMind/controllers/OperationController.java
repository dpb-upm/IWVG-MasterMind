package es.upm.miw.masterMind.controllers;

public interface OperationController {

	void accept(OperationControllerVisitor operationControllerVisitor);
}

