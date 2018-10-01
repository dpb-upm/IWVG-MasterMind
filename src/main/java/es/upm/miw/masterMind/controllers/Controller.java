package es.upm.miw.masterMind.controllers;

import es.upm.miw.masterMind.models.State;

public interface Controller {

    void clear();

    boolean empty(String attempt);

    boolean existMasterMind(String attempt);

    boolean endOfGame();

    int getTotalAttempt();

    int getTotalInjured();

    int getTotalDead();

    String getStringRandomTokens();

    State getState();

    int getLimitTokens();

    void setState(State state);

    void setOption(int optionSelected);

    Error validateTarget(String attempt);
}
