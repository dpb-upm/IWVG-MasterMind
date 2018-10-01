package es.upm.miw.masterMind.controllers.local;

import es.upm.miw.masterMind.controllers.Error;
import es.upm.miw.masterMind.models.Game;
import es.upm.miw.masterMind.models.State;

public abstract class LocalController {

	private Game game;

	LocalController(Game game) {
		assert game != null;
		this.game = game;
	}

    void clear() {
        game.clear();
    }

    private boolean empty(String attempt) {
        assert attempt != null;
        return game.empty(attempt);
    }

    public boolean existMasterMind(String attempt) {
        boolean exist = game.existMasterMind(attempt);
        if (exist || this.endOfGame()) {
            game.setState(State.FINAL);
        }
        return exist;
    }

    private boolean endOfGame() {
	    return game.getLimitAttemps() < this.getTotalAttempt() + 1;
    }

    public int getTotalAttempt(){
        return game.totalAttempt();
    }

    public int getTotalInjured() {
        return game.getTotalInjured();
    }

    public int getTotalDead() {
        return game.getTotalDead();
    }

    String getStringRandomTokens() {
        return game.getStringRandomTokens();
    }

	State getState(){
		return game.getState();
	}

	protected int getLimitTokens() { return game.getLimitTokens(); }
	
	void setState(State state){
		assert state != null;
		game.setState(state);
	}

    public void setOption(int optionSelected){
	    assert optionSelected > 0 && optionSelected <= game.getLimitTokens();
		game.setOption(optionSelected);
		game.setTokens();
	}

    protected Error validateTarget(String attempt) {
        if (!this.empty(attempt)) {
            return Error.NOT_EMPTY;
        }
        return null;
    }
}
