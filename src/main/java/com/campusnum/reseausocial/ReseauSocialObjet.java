package com.campusnum.reseausocial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReseauSocialObjet {

	String userList[][] = new String[3][4];
	String messages[][] = new String[3][10];
	int friends[][] = new int[3][3];

	int userId = 0, msgId, friendId, friendChoice;
	char next = '1', choice, change;
	boolean back;
	
	User newUser = new User();

	Scanner sc = new Scanner(System.in);

	public ReseauSocialObjet() {
		
		System.out.println("MON SUPER RESEAU SOCIAL\n\n");

		this.SignUp();

		do {
			System.out.println("\nMerci " + userList[userId][1] + " " + userList[userId][0] + ", que voulez vous faire maintenant ?");

			ShowMenu();

			choice = sc.nextLine().charAt(0);

			while (choice != '1' && choice != '2' && choice != '3' && choice != '4' && choice != '5' && choice != '6' && choice != '7' && choice != '8') {
				System.out.println("\nVeuillez taper une entrée valide.");
				choice = sc.nextLine().charAt(0);
			}

			switch (choice) {
			case '1':
				System.out.println("\nMon profile : ");

				ShowProfile();

				this.Return();

				break;
			case '2':

				this.Change();

				back = true;

				break;
			case '3':
				System.out.println("\nEcrivez votre message :");

				this.NewMsg();

				back = true;

				break;
			case '4':
				System.out.println("Mes messages :");

				ShowMsg();

				this.Return();

				break;
			case '5':
				System.out.println("Ajouter un ami :");

				if (userId > 0) {
					AddFriend();
				}

				this.Return();

				break;
			case '6':
				System.out.println("Mes amis :");
				
				ShowFriends();

				this.Return();

				break;
			case '7':
				userId++;

				SignUp();
				
				back = true;

				break;
			case '8':
				back = false;

				break;
			}
		} while (back == true);

		System.out.println("A bientot :)");

	}

	public static void main(String[] args) {

		ReseauSocialObjet reseauSocial = new ReseauSocialObjet();

	}

	public void SignUp() {
		
		if (userId < userList.length) {			
			System.out.println("Bonjour, veuillez entrer vous informations personnelles :");

			System.out.println("Quel est votre nom :");

			newUser.setNom(sc.nextLine());

			System.out.println("Quel est votre prénom :");

			newUser.setPrenom(sc.nextLine());

			System.out.println("Quel est votre ville :");

			newUser.setVille(sc.nextLine());

			System.out.println("Quel est votre age :");

			newUser.setAge(sc.nextLine());

			userList[userId][0] = newUser.getNom();
			userList[userId][1] = newUser.getPrenom();
			userList[userId][2] = newUser.getVille();
			userList[userId][3] = newUser.getAge();

			msgId = 0;
			friendId = 0;
		} else {
			userId--;
			System.out.println("Il n'y a plus de place !!!");
			back = true;
		}

		

	}

	public void Return() {

		do {
			System.out.println("\n1- Revenir au choix");
			System.out.println("2- Quitter l'appli");
			next = sc.nextLine().charAt(0);
		} while (next != '1' && next != '2');

		if (next == '2')
			back = false;
		else
			back = true;

	}

	public void Change() {
		
		System.out.println("\nModifier mes informations personnelles :");
		System.out.println("\nQue souhaitez-vous modifier ?");
		System.out.println("1- Nom");
		System.out.println("2- Prénom");
		System.out.println("3- Ville");
		System.out.println("4- Age");

		change = sc.nextLine().charAt(0);

		switch (change) {
		case '1':
			System.out.println("Nouveau nom :");
			userList[userId][0] = sc.nextLine();
			break;
		case '2':
			System.out.println("Nouveau prénom :");
			userList[userId][1] = sc.nextLine();
			break;
		case '3':
			System.out.println("Nouvelle ville :");
			userList[userId][2] = sc.nextLine();
			break;
		case '4':
			System.out.println("Nouvel age :");
			userList[userId][3] = sc.nextLine();
			break;
		}

	}

	public void NewMsg() {
		
		if (msgId < messages.length) {
			messages[userId][msgId] = sc.nextLine();
			msgId++;		
		} else {
			System.out.println("Votre messagerie est pleine");
		}

	}

	public void ShowMsg() {

		for (int i = 0; i <= msgId - 1; i++) {
			System.out.println("\n" + (i+1) + "- " + messages[userId][i]);
		}

	}
	
	public void AddFriend() {
		
		if (friendId < friends.length) {
			for (int i = 0; i < userId; i++) {
				System.out.println(i + "- " + userList[i][1] + " " + userList[i][0]);
			}
			
			friendChoice = sc.nextInt();
			sc.nextLine();
			friends[userId][friendId]= friendChoice;
			friendId++;
		} else {
			System.out.println("Vous ètes déjà bien assez d'amis !!!");
		}
		
	}
	
	public void ShowFriends() {
		
		for (int i = 0; i < friendId; i++) {
			System.out.println(userList[friends[userId][i]][1] + " " + userList[friends[userId][i]][0]);
		}
		
	}

	public void ShowProfile() {

		System.out.println("\nNom : " + userList[userId][0]);
		System.out.println("Prénom : " + userList[userId][1]);
		System.out.println("Ville : " + userList[userId][2]);
		System.out.println("Age : " + userList[userId][3]);
	}
	
	public static void ShowMenu() {

		System.out.println("1- Voir votre profile.");
		System.out.println("2- Modifier vos informations personnelles.");
		System.out.println("3- Ecrire un message.");
		System.out.println("4- Afficher les messages.");
		System.out.println("5- Ajouter un ami.");
		System.out.println("6- Afficher le nom des amis.");
		System.out.println("7- Ajouter un nouvel utlisateur.");
		System.out.println("8- Déconnexion.");
	}
	
}
