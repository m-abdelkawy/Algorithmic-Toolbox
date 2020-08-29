//package Week5;

import java.util.Scanner;

public class ChangeDp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] coins = {1,3,4};
        System.out.println(getChange(m, coins));
	}

	private static int getChange(int money,int[] coins) {
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
