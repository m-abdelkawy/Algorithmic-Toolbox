package Week5Practice;

public class Alignment {
	String dna1;
	String dna2;
	int scMatch = 2;
	int scMismatch = 1;
	int scIndel = 0;

	public Alignment() {
		dna1 = "";
		dna2 = "";
	}

	public void addMatch(char c1, char c2) {
		dna1 = c1 + dna1;
		dna2 = c2 + dna2;
	}

	public int score() {
		int score = 0;
		for (int i = 0; i < dna1.length(); i++) {
			if (dna1.charAt(i) == dna2.charAt(i)) {
				score += scMatch;
			} else {
				score -= scMismatch;
			}
		}
		return score;
	}

	public String toString() {
		return dna1 + "\n" + dna2;
	}
}
