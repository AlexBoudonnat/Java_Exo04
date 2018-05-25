package com.campusnum.reseausocial;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class ReseauSocialObjet {

	ArrayList<Message> messages = new ArrayList<Message>();
	ArrayList<Friend> friends = new ArrayList<Friend>();
	ArrayList<User> userList = new ArrayList<User>();
	HashMap<String, User> users = new HashMap<String, User>();
	
	User user1= new User("Alex", "Boud", "Annecy", "35", "Boubou");
	User user2 = new User("Vincent", "Newhouse", "Aix", "39", "Bibi");
	User user3 = new User("Theo", "Basso", "Cran", "26", "Toto");

	private String prenom, nom, ville, age, pseudo, regex = "^\\d{1}$", choices, text, sender, recipient = "";

	int userId, msgId, friendId, friendChoice, nomId, prenomId, id;
	char next = '1', choice, change;
	boolean back, firstConnection = true, recipientExist;

	User newUser = null;
	Moderator moderator = null;
	Message message = null;
	Friend friend = null;

	Scanner sc = new Scanner(System.in);

	public ReseauSocialObjet() throws Exception {

		System.out.println("MON SUPER RESEAU SOCIAL\n");
		
		// Avec une ArrayList
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userId = userList.size();
		
		// Avec une HashMap
//		users.put(user1.getNom()+user1.getPrenom(), user1);
//		users.put(user2.getNom()+user2.getPrenom(), user2);
//		users.put(user3.getNom()+user3.getPrenom(), user3);
//		Iterator<String> i = users.keySet().iterator();
//		while (i.hasNext()) {
//			String key = (String) i.next();
//			User Value = users.get(key);
//			System.out.println(Value.getPrenom() + " " + Value.getNom());
//			
//		}
		
		connexion();

	}

	public static void main(String[] args) throws Exception {

		ReseauSocialObjet reseauSocial = new ReseauSocialObjet();

	}

	public void connexion() {
		System.out.println("\nSouhaitez-vous vous connecter(C), vous inscrire(I) ou voir la liste(L) des utilisateurs ?");
		choice = sc.nextLine().toUpperCase().charAt(0);
		if (choice != 'C' && choice != 'I' && choice != 'L') {
			System.out.println("Veuillez choisir entre \"C\", \"I\" et \"L\".");
			connexion();
		}
		switch (choice) {
		case 'I':
			userId = userList.size();
			SignUp();
			break;

		case 'C':
			SignIn();
			break;

		case 'L':
			showUsers();
			break;
		}
		back = true;
		firstConnection = true;
		ShowMenu();
	}
	
	public void showUsers() {
		for (int i = 0; i < userList.size(); i++) {
			System.out.println("- " + userList.get(i).getPseudo() + " (" + userList.get(i).getPrenom() + " " + userList.get(i).getNom() + ")");
		}
		connexion();
	}

	public void SignIn() {
		System.out.println("Quel est votre nom ?");
		nom = sc.nextLine();
		nomId = -1;
		System.out.println("Quel est votre prénom ?");
		prenom = sc.nextLine();
		prenomId = -1;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getNom().equals(nom)) {
				nomId = i;
			}
			if (userList.get(i).getPrenom().equals(prenom)) {
				prenomId = i;
			}
		}
//		System.out.println(nomId + prenomId);
		if (nomId != prenomId || nomId == -1 || prenomId == -1) {
			System.out.println("ce compte n'existe pas.\n");
			connexion();
		} else {
			userId = nomId;
		}
	}

	public void SignUp() {

		System.out.println("Veuillez entrer vous informations personnelles :");

		System.out.println("Quel est votre nom :");
		nom = sc.nextLine();

		System.out.println("Quel est votre prénom :");
		prenom = sc.nextLine();

		System.out.println("Choisissez un pseudo :");
		pseudo = sc.nextLine();

		System.out.println("Quel est votre ville :");
		ville = sc.nextLine();

		System.out.println("Quel est votre age :");
		age = sc.nextLine();

		System.out.println("Cet utilisateur sera-t-il moderateur ? (O/N)");

		choice = sc.nextLine().toUpperCase().charAt(0);

		while (choice != 'O' && choice != 'N') {
			System.out.println("Cet utilisateur sera-t-il moderateur ? (O/N)");

			choice = sc.nextLine().toUpperCase().charAt(0);
		}

		if (choice == 'N') {

			try {
				newUser = new User(prenom, nom, ville, age, pseudo);
				userList.add(newUser);
			} catch (Exception e) {
				SignUp();
			}

		} else {

			try {
				moderator = new Moderator(prenom, nom, ville, age, pseudo);
				while (choice != '1' && choice != '2') {

					System.out.println("Avec quel niveau de modération ? (1/2)");

					choice = sc.nextLine().charAt(0);

				}

				if (choice == '2') {

					moderator.setModeratingLevel(2);

				}

				userList.add(moderator);
				System.out.println("\nBonjour Monsieur le modérateur de niveau "
						+ userList.get(userId).getModeratingLevel() + " !!!");
			} catch (Exception e) {
				SignUp();
			}

		}
		sender = ((User) userList.get(userId)).getPseudo();
		msgId = 0;
		friendId = 0;

	}

	public void Return() {

		do {
			System.out.println("\n1- Revenir au choix");
			System.out.println("2- Quitter l'appli");
			next = sc.nextLine().charAt(0);
		} while (next != '1' && next != '2');

		if (next == '2') {
			back = false;
			System.out.println("A bientot :)");
			connexion();
		} else
			ShowMenu();

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
			userList.get(userId).setNom(sc.nextLine());
			break;
		case '2':
			System.out.println("Nouveau prénom :");
			userList.get(userId).setPrenom(sc.nextLine());
			break;
		case '3':
			System.out.println("Nouvelle ville :");
			userList.get(userId).setVille(sc.nextLine());
			break;
		case '4':
			System.out.println("Nouvel age :");
			userList.get(userId).setAge(sc.nextLine());
			break;
		}

	}

	public void NewMsg() {
		recipientExist = false;
		sender = userList.get(userId).getPseudo();
		System.out.println("A qui ? (Ecrivez le pseudo d'un utilisateur)");
		recipient = sc.nextLine();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getPseudo().equals(recipient)) {
				recipientExist = true;
			}
		} if (!recipientExist) {
			System.out.println("Cet utilisateur n'existe pas...");
			NewMsg();
		} else {
		System.out.println("Ecrivez votre message :");
		text = sc.nextLine();
		message = new Message(text, sender, recipient);
		messages.add(message);
		msgId++;
		}

	}

	public void ShowMsg() {

		int j = 1;
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getSender().equals(userList.get(userId).getPseudo())) {
				System.out.println(
						"\n" + j + "- " + messages.get(i).getText() + " (" + messages.get(i).getRecipient() + ")");
				j++;
			}
		}

	}

	public void recievedMsg() {

		int j = 1;
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getRecipient().equals(userList.get(userId).getPseudo())) {
				System.out.println(
						"\n" + j + "- " + messages.get(i).getText() + " (" + messages.get(i).getSender() + ")");
				j++;
			}
		}
		
	}

	public void deleteMsg() {

		int j = 1, deleteId;
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getSender().equals(userList.get(userId).getPseudo())) {
				System.out.println(
						"\n" + j + "- " + messages.get(i).getText() + " (" + messages.get(i).getRecipient() + ")");
				j++;
			}
		}
		deleteId = (sc.nextInt() - 1);
		sc.nextLine();
		if (deleteId > (j - 1) && deleteId >= 0) {
			System.out.println("Veuillez saisir un nombre valide.");
		} else {
			messages.remove(deleteId);
			System.out.println("Votre message a bien été effacé.");
		}
		ShowMenu();
	}

	public void AddFriend() {
		
		boolean alreadyFriend = false;
		for (int i = 0; i < userList.size(); i++) {
			if (!userList.get(i).getPseudo().equals(userList.get(userId).getPseudo())) {
				alreadyFriend = false;
				if (userList.get(userId).getFriendsIndexSize() > 0) {
					for (int j = 0; j < userList.get(userId).getFriendsIndexSize(); j++) {
						if (userList.get(userId).getFriendsIndex(j) == i) {
							alreadyFriend = true;
						}
					}
					if (!alreadyFriend) {
						System.out.println(i + "- " + userList.get(i).getPseudo() + " (" + userList.get(i).getPrenom() + " " + userList.get(i).getNom() + ")");
					}
				} else {
				System.out.println(i + "- " + userList.get(i).getPseudo() + " (" + userList.get(i).getPrenom() + " " + userList.get(i).getNom() + ")");
				}
			}

		}

		test();
		sc.nextLine();

		while (friendChoice >= userList.size()) {
			System.out.println("Veuillez entrer un des chiffres proposés :");
			test();
			sc.nextLine();
		}
		if (friendChoice != userId) {
			if (userList.get(userId).getFriendList().contains(friendChoice)) {
				System.out.println("Vous êtes déjà ami avec cet utilisateur.");
				ShowMenu();
			} else {
				userList.get(userId).setFriendsIndex(friendChoice);
				userList.get(friendChoice).setFriendsIndex(userId);
				friend = new Friend(sender, ((User) userList.get(friendChoice)).getPseudo());
				friends.add(friend);
				System.out.println(userList.get(friendChoice).getPrenom() + " " + userList.get(friendChoice).getNom()
						+ " est maintenant votre ami.");
				friendId++;
			}
		} else {
			System.out.println("Vous ne pouvez pas devenir ami avec vous même !\n");
			ShowMenu();
		}

	}

	public void ShowFriends() {

		for (int i = 0; i < ((User) userList.get(userId)).getFriendsIndexSize(); i++) {
			System.out.println((i+1) + "- " + userList.get(((User) userList.get(userId)).getFriendsIndex(i)).getPseudo() + " (" + userList.get(((User) userList.get(userId)).getFriendsIndex(i)).getPrenom() + " "
					+ userList.get(((User) userList.get(userId)).getFriendsIndex(i)).getNom() + ")");
		}
		System.out.println("Pour supprimer un ami, entrer son numéro.");
		System.out.println("Pour retourner au menu taper \"0\"");
		friendChoice = (sc.nextInt() - 1);
		sc.nextLine();
		if (friendChoice < userList.get(userId).getFriendsIndexSize() && friendChoice >= 0) {
			System.out.println("Vous n'êtes plus ami avec "+ userList.get(userList.get(userId).getFriendsIndex(friendChoice)).getPrenom() + " " + userList.get(userList.get(userId).getFriendsIndex(friendChoice)).getNom() + ".");
			userList.get(userId).removeFriendsIndex(friendChoice);
		}
		ShowMenu();

	}

	public void ShowProfile() {

		System.out.println("\nNom : " + userList.get(userId).getNom());
		System.out.println("Prénom : " + userList.get(userId).getPrenom());
		System.out.println("Ville : " + userList.get(userId).getVille());
		System.out.println("Age : " + userList.get(userId).getAge() + "ans");
	}

	public void ShowMenu() {

		welcomeMessage();

		System.out.println("\n1- Voir votre profile.");
		System.out.println("2- Modifier vos informations personnelles.");
		System.out.println("3- Ecrire un message.");
		System.out.println("4- Messages envoyés.");
		System.out.println("5- Messages reçus.");
		System.out.println("6- Supprimer un message.");
		System.out.println("7- Ajouter un ami.");
		System.out.println("8- Afficher le nom des amis.");
		System.out.println("9- Déconnexion.");
		if (userList.get(userId) instanceof Moderator) {
			System.out.println("\nA- Supprimer un message.");
			if (userList.get(userId).getModeratingLevel() > 1) {
				System.out.println("B- Supprimer un utilisateur.");
			}
		}
		choices = sc.nextLine().toUpperCase();
		choice = choices.charAt(0);

		while (!choices.matches(regex) && choice != 'A' && choice != 'B') {
			System.out.println("\nVeuillez taper une entrée valide.");
			choices = sc.nextLine();
		}

		switch (choice) {
		case '1':
			System.out.println("\nMon profile : ");

			ShowProfile();

			this.Return();

			break;
		case '2':

			this.Change();

			ShowMenu();

			break;
		case '3':
			System.out.println("\nEnvie d'envoyer un message ?");

			this.NewMsg();

			ShowMenu();

			break;
		case '4':
			System.out.println("Messages envoyés :");

			ShowMsg();

			this.Return();

			break;
		case '5':
			System.out.println("Messages reçus :");

			recievedMsg();

			this.Return();
			
			break;
		case '6':
			System.out.println("Quel message voulez-vous supprimer ?");
			
			deleteMsg();

			break;
		case '7':
			System.out.println("Ajouter un ami :");

			if (userList.size() > 1 && userList.size() > (userList.get(userId).getFriendsIndexSize() - 1)) {
				AddFriend();
			}

			this.Return();

			break;
		case '8':
			System.out.println("Mes amis :");

			ShowFriends();

			//Return();

			break;
		case '9':
			firstConnection = false;
			back = false;
			System.out.println("A bientot :)");
			connexion();
			break;
		}

		if (userList.get(userId).getModeratingLevel() > 0) {
			switch (choice) {
			case 'A':
				System.out.println("Quel message voulez vous supprimer ?");
				ShowMenu();

				break;
			}
			if (userList.get(userId).getModeratingLevel() > 1) {
				switch (choice) {
				case 'B':
					System.out.println("Quel utilisateur voulez vous supprimer ?");
					ShowMenu();

					break;
				}
			}
		}
	}

	private void test() {
		try {
			friendChoice = sc.nextInt();
		} catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println("Veuillez entrer un nombre valide :");
			test();
		}
	}

	public void welcomeMessage() {

//		for (int i = 0; i < userList.size(); i++) {
//			System.out.println(userList.get(i).getPrenom());
//		}

		if (back == true) {
			if (firstConnection == true) {
				System.out.println("\nBonjour " + userList.get(userId).getPrenom() + " " + userList.get(userId).getNom()
						+ ", que voulez vous faire maintenant ?");
				firstConnection = false;
			} else {
				System.out.println("\nEt maintenant, on fait quoi ?");
			}
		}
	}
}
