//package Week3;

import java.util.Scanner;

public class Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
	}

	private static int getChange(int m) {
        int nCoin = 0;
        
        if(m >= 10) {
        	nCoin+=m/10;
        	m%=10;
        }
        if(m >= 5) {
        	nCoin+=m/5;
        	m%=5;
        }
        if(m >= 1) {
        	nCoin+=m/1;
        	m%=1;
        }
        
        return nCoin;
    }
}
