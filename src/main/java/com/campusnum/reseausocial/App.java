package com.campusnum.reseausocial;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		String nom = "Boudonnat", prenom = "Alex", ville = "Annecy";
		byte age = 35;
		char next = 'O';
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bonjour, je m'appelle "+prenom+" "+nom+", j'habites à "+ville+" et j'ai "+age+" ans.");
		
		while (next == 'O') {
			System.out.println("Entrer votre prénom :");
			
			prenom = sc.nextLine();
			
			System.out.println("Entrer votre nom :");
			
			nom = sc.nextLine();
			
			System.out.println("Entrer votre ville :");
			
			ville = sc.nextLine();
			
			System.out.println("Entrer votre age :");
			
			age = sc.nextByte();
			sc.nextLine();
					
			System.out.println("Bonjour "+prenom+" "+nom+", tu habites à "+ville+" et tu as "+age+" ans.");
			
			do {
				System.out.println("Voulez-vous réessayer ? (O/N)");
			 	next = sc.nextLine().charAt(0);
			} while(next != 'O' && next != 'N');
			
		}
		
		System.out.println("Aurevoir et à bientôt !");

		
	}

}
