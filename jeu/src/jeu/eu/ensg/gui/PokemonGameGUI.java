package jeu.eu.ensg.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PokemonGameGUI extends JFrame implements ActionListener {
	private JButton buttonatt1;
	private JButton buttonatt2;
	private JButton buttonatt3;
	private JButton buttonatt4;
	private JLabel labelSelectedPokemon;
	private JLabel labelComputerPokemon;
	private JLabel labelUserScore;
	private JLabel labelComputerScore;
	private int userScore;
	private int computerScore;
	private Random random;

	public PokemonGameGUI() {
		super("Pokemon Game");

		// Création des boutons pour les Pokemon
		buttonatt1 = new JButton("Attaque 1");
		buttonatt1.addActionListener(this);
		buttonatt2 = new JButton("Attaque 2");
		buttonatt2.addActionListener(this);
		buttonatt3 = new JButton("Attaque 3");
		buttonatt3.addActionListener(this);
		buttonatt4 = new JButton("Attaque 4");
		buttonatt4.addActionListener(this);

		// Création d'un panneau pour les boutons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));
		buttonPanel.add(buttonatt1);
		buttonPanel.add(buttonatt2);
		buttonPanel.add(buttonatt3);
		buttonPanel.add(buttonatt4);

		// Création d'un label pour le Pokemon sélectionné par l'utilisateur
		labelSelectedPokemon = new JLabel("Aucun Pokemon sélectionné");
		labelSelectedPokemon.setFont(new Font("Arial", Font.BOLD, 16));
		labelSelectedPokemon.setHorizontalAlignment(SwingConstants.CENTER);

		// Création d'un label pour le Pokemon sélectionné par l'ordinateur
		labelComputerPokemon = new JLabel();
		labelComputerPokemon.setHorizontalAlignment(SwingConstants.CENTER);

		// Création d'un panneau pour les labels de Pokemon
		JPanel pokemonPanel = new JPanel();
		pokemonPanel.setLayout(new GridLayout(2, 1));
		pokemonPanel.add(labelSelectedPokemon);
		pokemonPanel.add(labelComputerPokemon);

		// Création de labels pour les scores
		labelUserScore = new JLabel("0");
		labelUserScore.setFont(new Font("Arial", Font.BOLD, 32));
		labelUserScore.setHorizontalAlignment(SwingConstants.CENTER);
		labelComputerScore = new JLabel("0");
		labelComputerScore.setFont(new Font("Arial", Font.BOLD, 32));
		labelComputerScore.setHorizontalAlignment(SwingConstants.CENTER);

		// Création d'un panneau pour les scores
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(1, 2));
		scorePanel.add(labelUserScore);
		scorePanel.add(labelComputerScore);

		// Ajout des panneaux à la fenêtre principale
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(buttonPanel, BorderLayout.CENTER);
		getContentPane().add(pokemonPanel, BorderLayout.NORTH);
		getContentPane().add(scorePanel, BorderLayout.SOUTH);

		// Configuration de la fenêtre principale
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);

		// Initialisation des scores et du générateur de nombres aléatoires
		userScore = 0;
		computerScore = 0;
		random = new Random();
	}

	public static void main(String[] args) {
		new PokemonGameGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// L'utilisateur a sélectionné une attaque
		if (e.getSource() == buttonatt1 || e.getSource() == buttonatt2|| e.getSource() == buttonatt3|| e.getSource() == buttonatt4) {
			// Afficher l'attaque sélectionné
			JButton selectedButton = (JButton) e.getSource();
			labelSelectedPokemon.setText(selectedButton.getText());
			labelSelectedPokemon.setIcon(selectedButton.getIcon());

			// Sélectionner un Pokemon au hasard pour l'ordinateur
			String[] pokemonNames = { "Pikachu", "Charmander", "Squirtle" };
			int computerIndex = random.nextInt(pokemonNames.length);
			String computerPokemon = pokemonNames[computerIndex];
			labelComputerPokemon.setText(computerPokemon);
			labelComputerPokemon.setIcon(new ImageIcon("images/" + computerPokemon.toLowerCase() + ".png"));

			// Comparer les Pokemon sélectionnés
			String userPokemon = selectedButton.getText();
			int result = comparePokemon(userPokemon, computerPokemon);

			// Mettre à jour les scores et les afficher
			if (result == 1) {
				userScore++;
				labelUserScore.setText(Integer.toString(userScore));
			} else if (result == -1) {
				computerScore++;
				labelComputerScore.setText(Integer.toString(computerScore));
			}

			// Vérifier si un joueur a atteint le score maximum et afficher un message de
			// fin de jeu
			if (userScore == 10 || computerScore == 10) {
				String message;
				if (userScore == 10) {
					message = "Bravo, vous avez gagné !";
				} else {
					message = "Dommage, vous avez perdu !";
				}
				JOptionPane.showMessageDialog(this, message, "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
				// Réinitialiser le jeu
				userScore = 0;
				computerScore = 0;
				labelSelectedPokemon.setText("Aucun Pokemon sélectionné");
				labelSelectedPokemon.setIcon(null);
				labelComputerPokemon.setText("");
				labelComputerPokemon.setIcon(null);
				labelUserScore.setText("0");
				labelComputerScore.setText("0");
			}
		}
	}

	private int comparePokemon(String userPokemon, String computerPokemon) {
		if (userPokemon.equals(computerPokemon)) {
			return 0;
		} else if (userPokemon.equals("Pikachu")) {
			if (computerPokemon.equals("Charmander")) {
				return 1;
			} else {
				return -1;
			}
		} else if (userPokemon.equals("Charmander")) {
			if (computerPokemon.equals("Squirtle")) {
				return 1;
			} else {
				return -1;
			}
		} else {
			if (computerPokemon.equals("Pikachu")) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}
