package Week5Practice;

public class MinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] coins = {6,5,1};
		int money = 9;
		
		System.out.println(dpChange(money, coins));
	}
	
	private static int recursiveChange(int money, int[] coins) {
		if(money==0) return 0;
		
		//if (money < 0) return 0;
		
		int minCoins = Integer.MAX_VALUE;
		//int numCoins = 0;
		for (int i = 0; i < coins.length; i++) {
			if (money >= coins[i]) {
				int numCoins = recursiveChange(money-coins[i], coins);
				if(numCoins+1 < minCoins) minCoins=numCoins+1;
			}
		}
		return minCoins;
	}
	
	private static int dpChange(int money, int[] coins) {
		int[] minNumCoins= new int[money + 1];
		minNumCoins[0] =0;
		for (int i = 1; i <= money; i++) {
			minNumCoins[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if(i>=coins[j]) {
					int numCoins = minNumCoins[i - coins[j]]+1;
					if(numCoins < minNumCoins[i]) {
						minNumCoins[i]= numCoins; 
					}
				}
			}
		}
		
		return minNumCoins[money];
	}

}
