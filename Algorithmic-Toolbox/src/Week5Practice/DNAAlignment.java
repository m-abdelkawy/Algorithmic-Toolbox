package Week5Practice;

public class DNAAlignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dna1 = "EDITING";
		String dna2 = "DISTANCE";

		System.out.println(align(dna1, dna2));
	}

	private static Alignment align(String dna1, String dna2) {
		if(dna1.length() == 0 && dna2.length() ==0) {
			return new Alignment();
		}
		else if(dna1.length() == 0) {
			Alignment result = align(dna1, dna2.substring(1));
			result.addMatch('-', dna2.charAt(0));
			return result;
		}
		else if(dna2.length() == 0) {
			Alignment result = align(dna1.substring(1), dna2);
		}
		else {
			Alignment first = align(dna1.substring(1), dna2);
			first.addMatch(dna1.charAt(0), '-');
			
			Alignment second = align(dna1, dna2.substring(1));
			second.addMatch('-', dna2.charAt(0));
			
			Alignment both = align(dna1.substring(1), dna2.substring(1));
			both.addMatch(dna1.charAt(0), dna2.charAt(0));
			
			int scFirst = first.score();
			int scSecond = second.score();
			int scBoth = both.score();
			
			if(scFirst >= scSecond && scFirst >= scBoth) {
				return first;
			}else if(scSecond >= scFirst && scSecond >= scBoth) {
				return second;
			}else {
				return both;
			}
		}
		return new Alignment();
	}

}
