package com.campusnum.reseausocial;

/**
 * 
 * @author Utilisateur
 *
 */
public class Message {

	private String text, sender, recipient;

	/**
	 * Constructeur sans param�tres
	 */
	public Message() {
		this.setText("Texte");
		this.setSender("Expediteur");
		this.setRecipient("Destinataire");
	}

	/**
	 * 
	 * @param pText
	 * @param pSender
	 * @param pRecipient
	 */
	public Message(String pText, String pSender, String pRecipient) {
		this.setText(pText);
		this.setSender(pSender);
		this.setRecipient(pRecipient);
	}

	/**
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @param pText
	 */
	public Message(String pText) {
		text = pText;
	}

	/**
	 * retourne l'exp�diteur
	 * 
	 * @return
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Impl�mente l'expediteur
	 * 
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * retourne le destinataire
	 * 
	 * @return
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * Impl�mente le destinataire
	 * 
	 * @param recipient
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

}
