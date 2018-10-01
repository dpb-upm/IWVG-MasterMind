package es.upm.miw.masterMind.controllers;

public interface StartControllerInterface extends OperationController {

    void setOption(int optionSelected);

    int getLimitTokens();
}
