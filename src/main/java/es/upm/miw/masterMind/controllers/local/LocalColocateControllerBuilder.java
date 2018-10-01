package es.upm.miw.masterMind.controllers.local;

import es.upm.miw.masterMind.models.Game;

public class LocalColocateControllerBuilder {

    private static LocalColocateController[] colocateControllerArray;

    private Game game;

    LocalColocateControllerBuilder(Game game) {
        this.game = game;
        colocateControllerArray = new LocalColocateController[game.getNumPlayers()];
        this.build();
    }

    private void build() {
        for (int i = 0; i < game.getNumPlayers(); i++) {
            if(i == 0){
                colocateControllerArray[i] = new LocalPutController(game);
            } else {
                colocateControllerArray[i] = new LocalPutDemoController(game);
            }
        }
    }

    LocalColocateController getColocateController() {
        if (!game.esDemo()) {
            return colocateControllerArray[0];
        } else {
            return colocateControllerArray[1];
        }
    }
}