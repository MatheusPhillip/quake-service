package model;

import java.util.ArrayList;

public class Game{
	private int total_kills;
	private int worldScore;
	private String id;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	
	public Game(int id) {
		this.total_kills = 0; // INICIALIZA A QUANTIDADE TOTAL DE MORTES NO JOGO COM 0
		this.worldScore = 0;  // INICIALIZA A PONTUA��O DE MORTES PELO CEN�RIO COM 0
		this.id = "game_"+ id;
	}


	public int getTotal_kills() {
		return total_kills;
	}

	// INCREMENTA MAIS 1 NA PONTUA��O TOTAL DO JOGO
	public void addTotal_killsScore() {
		this.total_kills += 1;
	}


	public int getWorldScore() {
		return worldScore;
	}

	// INCREMENTA MAIS 1 NA PONTUA��O DE MORTES POR CEN�RIO NO JOGO
	public void addWorldScore() {
		this.worldScore += 1;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public ArrayList<Player> getPlayers() {
		return players;
	}


	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	// ADICIONA UM JOGADOR NA LISTA DE JOGADORES DESTE JOGO
	public void addPlayer(Player player) {
		for(int i = 0; i < players.size(); i ++) {
			if(players.get(i).getNickName().equals(player.getNickName())) { // N�O PERMITE NOMES DE JOGADORES REPETIDOS
				System.out.println("Player ja cadastrado nesse jogo.");
				return;
			}
		}
		players.add(player); // ADICIONA JOGADOR
	}
	
	
	/*
	 * ESTE M�TODO TEM POR OBJETIVO DEFINIR O TIPO DE MORTE SOFRIDA PELO JOGADOR
	 * O PAR�METRO LINE REPRESENTA A LINHA DO ARQUIVO GAMES.LOG 
	 * O PAR�METRO PLAYERNICKNAME REPRESENTA O NOME DO JOGADOR QUE MORREU
	 */
	public void MeanOfDeath(String line, String playerNickName) {
		String meanOfDeath = line.substring(line.lastIndexOf("by") + 3, line.length()); // PEGA O ELEMENTO MOD NO FINAL DA LINHA
		String typeOfWorldKill; // REPRESENTA COMO O JOGADOR MORREU
		switch(TypesOfDeath.valueOf(meanOfDeath)) {
		case MOD_CRUSH:
			typeOfWorldKill = "foi esmagado.";
			break;
		case MOD_FALLING:
			typeOfWorldKill = "caiu de uma altura muito alta.";
			break;
		case MOD_TRIGGER_HURT:
			typeOfWorldKill = "estava ferido e caiu de uma altura que o matou.";
			break;
		default:
			typeOfWorldKill = "morte por cenario n�o especificada.";
			break;
		}
		System.out.println("O player \"" + playerNickName + "\" morreu pois " + typeOfWorldKill);
	
	}
	
	/*
	 * ESTE M�TODO TEM POR OBJETIVO DEFINIR O TIPO DE MORTE SOFRIDA DE UM JOGADOR POR OUTRO
	 * O PAR�METRO LINE REPRESENTA A LINHA DO ARQUIVO GAMES.LOG
	 * O PAR�METRO PLAYERNICKNAME REPRESENTA O NOME DO JOGADOR QUE MATOU
	 * O PAR�METRO PLAYERKILLEDNICKNAME REPRESENTA O NOME DO JOGADOR QUE MORREU
	 */
	public void MeanOfDeath(String line, String playerNickName, String playerKilledNickName) {
		String meanOfDeath = line.substring(line.lastIndexOf("by") + 3, line.length()); // PEGA O ELEMENTO MOD NO FINAL DA LINHA
		String typeOfGun; // REPRESENTA O NOME DE ARMA UTILIZADA 
		switch(TypesOfDeath.valueOf(meanOfDeath)) {
		case MOD_BFG:
			typeOfGun = "BFG";
			break;
		case MOD_MACHINEGUN:
			typeOfGun = "Machinegun";
			break;
		case MOD_BFG_SPLASH:
			typeOfGun = "BFGSplash";
			break;
		case MOD_RAILGUN:
			typeOfGun = "Railgun";
			break;
		case MOD_ROCKET:
			typeOfGun = "Rocket";
			break;
		case MOD_SHOTGUN:
			typeOfGun = "Shotgun";
			break;
		case MOD_ROCKET_SPLASH:
			typeOfGun = "RocketSplash";
			break;
		case MOD_TELEFRAG:
			typeOfGun = "Telefrag";
			break;
		default:
			typeOfGun = "N�o especificada.";
			break;
		}
		System.out.println("O player \"" + playerNickName + "\" matou o player \"" + playerKilledNickName + "\" usando a arma " + typeOfGun + ".");
	}
	
	public void showAllPlayersScore() {
		for(int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getNickName() + ":" + players.get(i).getScore());
		}
	}
	
	@Override
	public String toString() {
		return id + ": {\n" 
				  + "\t" + "total_kills: " + total_kills + ";\n" 
				  + "\t" + toStringPlayers() +"\n"
				  + "\t" + toStringPlayersScore();
	}
	
	/*
	 *  IMPRIME OS JOGADORES DE MANEIRA ORGANIZADA
	 */
	private String toStringPlayers() {
		return "players: " + players.toString();
	}
	
	/*
	 *  IMPRIME A PONTUA��O DE CADA JOGADOR DE FORMA ORGANIZADA
	 */
	private String toStringPlayersScore() {
		String score = "kills: {\n";
		for(int i = 0; i < players.size(); i++) {
			score += "\t\t";
			score += players.get(i).toStringPlayerScore();
			if(i < players.size() - 1) {
				score += ",";
			}
			score += "\n";
		}
		score += "\t" + "}";
		return score;
	}
}
