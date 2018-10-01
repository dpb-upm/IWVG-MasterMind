package es.upm.miw.masterMind.models;

import java.util.*;

class Board {

	private Map<Integer, Color> privateTokens;

	private static final int LIMIT_TOKENS = 4;
	private static final int LIMIT_COLORS = 6;

	private int dead;
	private int injured;

	Board() {
		privateTokens = new HashMap<>();
	}

	boolean existMasterMind(String attempt) {
		assert attempt != null;
		Map<Integer, Integer> visited = new HashMap<>();
		this.countDead(attempt, visited);
		this.countInjured(attempt, visited);
		return this.dead == Board.LIMIT_TOKENS;
	}

	private void countDead(String attempt, Map<Integer, Integer> visited){
		boolean equals;
		this.dead = 0;

		for (int i = 0; i < Board.LIMIT_TOKENS; i++){
			for (Map.Entry<Integer, Color> code : this.privateTokens.entrySet()) {
				equals = code.getValue().areEquals(attempt.charAt(i));
				if(!visited.containsKey(i) && !visited.containsValue(i) && equals && (i == code.getKey())) {
					visited.put(i,i);
					this.dead++;
				}
			}
		}
	}

	private void countInjured(String attempt, Map<Integer, Integer> visited){
		boolean equals;
		this.injured = 0;

		for (int i = 0; i < Board.LIMIT_TOKENS; i++){
			for (Map.Entry<Integer, Color> code : this.privateTokens.entrySet()) {
				equals = code.getValue().areEquals(attempt.charAt(i));
				if(!visited.containsKey(i) && !visited.containsValue(i) && equals) {
					visited.put(i,i);
					this.injured++;
				}
			}
		}
	}

	boolean empty(String attempt) {
		assert attempt != null;
		return true;
	}

	int getTotalInjured() {
		return this.injured;
	}

	int getTotalDead() {
		return this.dead;
	}

	int getLimitTokens() {
		return Board.LIMIT_TOKENS;
	}

	private String getStringTokens(Map<Integer, Color> randomTokens) {
		StringBuilder caracters = new StringBuilder();
		for (Map.Entry<Integer, Color> code : randomTokens.entrySet()) {
			caracters.append(code.getValue());
		}
		return caracters.toString();
	}

	String getRandomTokensToString() {
		return this.getStringTokens(this.generateSecretCode());
	}

	private Map<Integer, Color> generateSecretCode() {
		Map<Integer, Color> randomTokens = new HashMap<>();
		Random rand = new Random();
		int randNumber;

		for (int position = 0; position < Board.LIMIT_TOKENS; position++) {
			randNumber = rand.nextInt(Board.LIMIT_COLORS);
			randomTokens.put(position, Color.values()[randNumber]);
		}
		return randomTokens;
	}

	void setTokens() {
		this.privateTokens = this.generateSecretCode();
	}

	void clear() {
		this.privateTokens = new HashMap<>();;
	}
}