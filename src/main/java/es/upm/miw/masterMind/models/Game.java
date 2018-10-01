package es.upm.miw.masterMind.models;

public class Game {

    private State state;

    private Board board;

    private static final int NUM_PLAYERS = 2;

    private static final int LIMIT_ATTEMPS = 10;

    private int optionSelected;

    private int numberOfAttempt;

    public Game() {
        state = State.INITIAL;
        this.numberOfAttempt = 0;
        board = new Board();
    }

    public void clear() {
        board.clear();
    }

    public boolean empty(String attempt) { return board.empty(attempt); }

    public boolean existMasterMind(String attempt) {
        this.numberOfAttempt++;
        return board.existMasterMind(attempt);
    }

    public boolean esDemo() { return this.optionSelected == 2; }

    public State getState() {
        return state;
    }

    public int getNumPlayers() {
        return Game.NUM_PLAYERS;
    }

    public int getLimitTokens() {
        return board.getLimitTokens();
    }


    public int getTotalInjured() {
        return board.getTotalInjured();
    }

    public int getTotalDead() {
        return board.getTotalDead();
    }

    public String getStringRandomTokens() {
        return board.getRandomTokensToString();
    }

    public void setTokens() {
        board.setTokens();
    }

    public int getLimitAttemps() {
        return Game.LIMIT_ATTEMPS;
    }

    public void setOption(int optionSelected) {
        this.optionSelected = optionSelected;
        this.numberOfAttempt = 0;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int totalAttempt() {
        return this.numberOfAttempt;
    }
}
