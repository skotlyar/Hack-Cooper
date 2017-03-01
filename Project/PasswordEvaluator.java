package Project;

import java.util.Scanner;

public class PasswordEvaluator {
	
	public int pass_strength (String password) {
		int score = 0, numLetters=0, numNumbers=0;
		String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
		
		// 1. ADDITIONS
		
		//Check for length of password
		score += password.length()*4;
		
		//Check for Uppercase Letters and Lowercase Letters
		for (int i = 0; i < password.length(); i++) {
			if ( Character.isUpperCase(password.charAt(i)) ||
					Character.isLowerCase(password.charAt(i)) ) 
				{numLetters++;}
		}
		score += (2 * (password.length() - numLetters));
			
		// Check for Numbers
		for (int j = 0; j < password.length(); j++) {
			if ( Character.isDigit(password.charAt(j)) )
				{numNumbers++;}
		}
		score += (4 * numNumbers);
		
		//Check for symbols
		for (int k = 0; k < password.length(); k++) {
			if ( specialChars.contains(password.substring(k,k+1)) )
				score += 6;
		}
		
		// 2. DEDUCTIONS
		
		//Check for if password is Letters Only and Numbers Only
		if (numNumbers == 0 || numLetters == 0)
			score -= password.length();
		
		//Check for sequential characters (3 characters or more)
		for (int l = 0; l < password.length() - 2; l++) {
			if ( (password.charAt(l) == password.charAt(l+1) + 1) && password.charAt(l) == (password.charAt(l+2) + 2) )
				score -= 3;
		}
		
		// Check for consecutive Lower Case Letters, consecutive Upper Case Letters,
		//  and Consecutive Numbers
		for (int m = 0; m < password.length() - 1; m++) {
			if ( (Character.isLowerCase(password.charAt(m)) && Character.isLowerCase(password.charAt(m + 1)))
					|| (Character.isUpperCase(password.charAt(m)) && Character.isUpperCase(password.charAt(m + 1)))
							|| (Character.isDigit(password.charAt(m)) && Character.isDigit(password.charAt(m + 1))) )
				score -= 2;
			
		}
		// Check for consecutive Upper Case Letters
		for (int n = 0; n < password.length() - 1; n++) {
			if ( Character.isUpperCase(password.charAt(n)) && Character.isLowerCase(password.charAt(n + 1)) )
				score -= 2;
		}
		
		// 3. CHECK IF SCORE IS WITHIN THE RANGE 1 AND 100
		
		if (score > 100)
			score = 100;
		if (score < 1)
			score = 1;
		
		return score;
	}

	public void main1() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your password: ");
		String a = input.nextLine();
		
		System.out.println("Your password's strength (1-100) is: " + pass_strength(a));
	}
	public static void main(String [] args) {
		PasswordEvaluator ob = new PasswordEvaluator();
		ob.main1();
	}
}
