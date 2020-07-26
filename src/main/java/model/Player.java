package model;

public class Player {
	
	private String nickName;
	private int score;

	public Player(String nickName) {
		this.nickName = nickName;
		this.score = 0; // INICIALIZA A PONTUA��O DO JOGADOR COM 0
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public int getScore() {
		return score;
	}
	
	/*
	 * ADICIONA MAIS 1 NA PONTUA��O ATUAL DO JOGADOR
	 */
	public void addScore() {
		this.score += 1;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	/*
	 * CASO O JOGADOR MORRA POR A��O DO CEN�RIO
	 * SUBTRAI 1 DA PONTUA��O ATUAL DO JOGADOR
	 */
	public void addDeathByWorld() {
		this.score -= 1;
	}

	@Override
	public String toString() {
		return "\"" + nickName + "\"";
	}
	
	/*
	 *  IMPRIME A PONTUA��O DO JOGADOR
	 */
	public String toStringPlayerScore() {
		return toString() + ": " + getScore();
	}
}
