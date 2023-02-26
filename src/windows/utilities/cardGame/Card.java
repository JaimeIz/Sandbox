package windows.utilities.cardGame;

import java.io.Serializable;

public class Card implements Serializable{
	
	private String question, answer;
	
	public Card() {
		question = null;
		answer = null;
	}

	public Card(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}
}
