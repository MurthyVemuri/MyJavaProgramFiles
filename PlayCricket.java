import java.util.*;

class Player {
	String playerName;
	int score;
	int idNumber;

	public Player(String playerName, int idNumber , int score ) {
		this.playerName = playerName;
		this.idNumber = idNumber;
		this.score = score;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public int getIdNumber() {
		return idNumber;
	}
}


class Ball {
	int ballValue;

	public int eachBall() {
		Random random = new Random();
		ballValue = random.nextInt(10);
		return ballValue;
	}
}


class Game {

	Ball ball;
	List<Player> players;

	Game() {
		players = new ArrayList<Player>();
		ball = new Ball();
	}


	public void addPlayer(Player player) {
		players.add(player);
	}


	public void startGame(Player player) {
		Random random = new Random();
		int score = player.getScore();
		while(true) {
			int scorePerBall = ball.eachBall();
			if(scorePerBall == 0) {		
				player.setScore(0);
				System.out.println(player.getPlayerName() + " Duck Out " + player.getScore());
				break;
			} else if(scorePerBall == 5) {
				player.setScore(score);
				System.out.println(player.getPlayerName() + " caught by someone " + player.getScore());
				break;
			} else if(scorePerBall == 7) {
				player.setScore(score);
				System.out.println(player.getPlayerName() + " run out " + player.getScore());
				break;
			} else if(scorePerBall == 8) {
				player.setScore(score);
				System.out.println(player.getPlayerName() + " LBW " + player.getScore());
				break;
			} else if(scorePerBall == 9) {
				player.setScore(score);
				System.out.println(player.getPlayerName() + " Stump out " + player.getScore());
				break;
			} else if(scorePerBall == 10) {
				player.setScore(score);
				System.out.println(player.getPlayerName() + " Caught & bowled " + player.getScore());
				break;
			}else {
				score += scorePerBall;
			}
		}
		
	}	
}



public class PlayCricket {

	public static void main(String[] args){
		Random random = new Random();
		Game game = new Game();

		Player p1 = new Player("Ganguly" , 99 ,0);

		game.addPlayer(p1);
		game.startGame(p1);
	}
}
