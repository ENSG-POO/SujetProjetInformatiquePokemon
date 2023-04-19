package jeu.eu.ensg;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jeu.eu.ensg.gui.BoutonCombat;
import jeu.eu.ensg.gui.CartePanel;
import jeu.eu.ensg.gui.ImageCombat;
import jeu.eu.ensg.gui.ListePok;

public class Combat {
	
	private Pokemon PJ;
	private Pokemon PS;
	private boolean isOver;

	public Combat(Pokemon pJ, Pokemon pS, boolean isOver) {
		super();
		PJ = pJ;
		PS = pS;
		this.isOver = isOver;
	}
	

	public Pokemon getPJ() {
		return PJ;
	}
	public void setPJ(Pokemon pJ) {
		PJ = pJ;
	}
	public Pokemon getPS() {
		return PS;
	}
	public void setPS(Pokemon pS) {
		PS = pS;
	}
	public boolean isOver() {
		return isOver;
	}
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	
	public void swap(Pokemon n) {
		setPJ(n);
	}
	
	public static double testEfficacite(Attaque att,Pokemon def) {
		Type deft = def.getType();
		Type attt = att.getType();
		Double Coeff = Double.parseDouble(attt.getdata(deft));
		return Coeff;
	}
	
	
	public void assault(Attaque atkPerso, Attaque atkOrdi, Pokemon pokPerso,Pokemon pokSauv) {
		int puissance = atkPerso.getPuissance();
		boolean spe = atkPerso.isSpe();
		double deg = 0.0;
		
		int puissance2 = atkOrdi.getPuissance();
		boolean spe2 = atkOrdi.isSpe();
		double deg2 = 0.0;
		
		// attaque du joueur
		if (spe == false) {
			deg = ((((0.4*pokPerso.getStats().getLvl() + 2)* pokPerso.getStats().getAttack()*puissance)/(50*pokSauv.getStats().getDefense())) + 2 ); // *CE
			//deg = ((((2*att.getStats().getLvl())/5)+2*puissance*att.getStats().getAttack()/def.getStats().getDefense())/50)+2;
		}
		else {
			deg = ((((0.4*pokPerso.getStats().getLvl() + 2)* pokPerso.getStats().getSpAtk()*puissance)/(50*pokSauv.getStats().getSpDef())) + 2 ); // *CE
			//deg = ((((2*att.getStats().getLvl())/5)+2*puissance*att.getStats().getSpAtk()/def.getStats().getSpDef())/50)+2;
		}
		double Coeff = testEfficacite(atkPerso,pokSauv);
		deg = deg * Coeff;
		if (pokPerso.getType()==atkPerso.getType()) {
			deg = deg*1.5;
		}
		int degat = (int)deg;
		pokSauv.setHP(pokSauv.getHP()-degat);
		System.out.println("Vous infligez " + Integer.toString(degat));
		
		//attaque de l'ordi
		if (pokSauv.getHP()> 0) {
			if (spe2 == false) {
				deg2 = ((((0.4*pokSauv.getStats().getLvl() + 2)* pokSauv.getStats().getAttack()*puissance2)/(50*pokPerso.getStats().getDefense())) + 2 )*10; // *CE
				//deg2 = ((((2*att.getStats().getLvl())/5)+2*puissance2*att.getStats().getAttack()/def.getStats().getDefense())/50)+2;
			}
			else {
				deg2 = ((((0.4*pokSauv.getStats().getLvl() + 2)* pokSauv.getStats().getSpAtk()*puissance2)/(50*pokPerso.getStats().getSpDef())) + 2 )*10; // *CE
				//deg2 = ((((2*att.getStats().getLvl())/5)+2*puissance2*att.getStats().getSpAtk()/def.getStats().getSpDef())/50)+2;
			}
			double Coeff2 = testEfficacite(atkOrdi,pokPerso);
			deg2 = deg2 * Coeff2;
			if (pokSauv.getType()==atkOrdi.getType()) {
				deg = deg*1.5;
			}
			int degat2 = (int)deg2;
			pokPerso.setHP(pokPerso.getHP()-degat2);
			System.out.println("Vous recevez " + Integer.toString(degat2));
		}
	}
	

	public void changer(ArrayList <Pokemon> L) {
		int[][] nb = new int[5][10];
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Vos autres pokémons sont: " + L + "\n" + nb + " \n Taper le NOMBRE correspondant à la position de votre nouveau pokémon " );
		int nbr = sc2.nextInt(); // récupération de la position du nouveau pokémon dans la liste de pokémon du joueur
		Pokemon p = L.get(nbr);
		L.removeIf(element -> element.equals(p));
		L.add(this.getPJ());
		this.setPJ(p);
	}
	
	ArrayList <Pokemon> L = new ArrayList<Pokemon>();
	
	public void jouer(ArrayList<Pokemon> L) {
		
		JFrame fen = new JFrame();
		fen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fen.setSize(1200,800);

		fen.setLayout(new BorderLayout());
		
		fen.add(BorderLayout.CENTER, new ImageCombat());

		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setTitle("fenetre de combat");
		
		// BOUTTON DE BASE / FUITE ATTAQUE CHANGE
		JButton fuite = new JButton("Fuir");
		fuite.setBounds(50, 50, 20, 100);
		
		JButton attaque = new JButton("Attaque STAB");
		attaque.setBounds(50, 50, 20, 100);
		
		JButton attaque1 = new JButton("Attaque de base");
		attaque1.setBounds(50, 50, 20, 100);
		
		JButton change = new JButton("Changer de pokémon");
		change.setBounds(50, 50, 20, 100);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(new GridLayout(3,1));
		
		JPanel Main = new JPanel();
		Main.setLayout(new GridLayout(1,4));
		Main.add(fuite);
		Main.add(attaque);
		Main.add(attaque1);
		Main.add(change);
		
		
		JButton Yes = new JButton("Yes");
		change.setBounds(50, 50, 20, 100);
		
		JButton No = new JButton("No");
		change.setBounds(50, 50, 20, 100);
		
		JPanel yn = new JPanel();
		yn.setLayout(new GridLayout(1,2));
		yn.add(Yes);
		yn.add(No);
		
		
		List<Integer> nbr = new ArrayList<Integer>();
		for (int i=0;i<L.size();i++) {
			if (nbr.size()!=0) {
				nbr.set(i, i);
		}}
		JComboBox<Integer> ch = new JComboBox<Integer>(nbr.toArray(new Integer[nbr.size()]));
		
		JPanel selec = new JPanel();
		selec.setLayout(new GridLayout(1,1));
		selec.add(ch);
		
		ActionListener Fuite = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				fen.dispose();
			}
		};
		
		ActionListener Attaque = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				
			}
		};
		
		ActionListener Attaque_Spe = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				System.out.println("ATTAQUE_SPE");
			}
		};
		
		ActionListener Changer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				if (L.isEmpty()) {
					System.out.println("Impossible");
				}
				else {
					Combat.this.changer(L);
				}
			}
		};
			
		
		
		
		fuite.addActionListener(Fuite);
		attaque.addActionListener(Attaque);
		attaque1.addActionListener(Attaque_Spe);
		change.addActionListener(Changer);
		
		ButtonPanel.add(Main);
		ButtonPanel.add(yn);
		ButtonPanel.add(selec);
		fen.add(ButtonPanel, BorderLayout.SOUTH);
		ButtonPanel.setEnabled(false);
		fen.setVisible(true); 
		
		
		while (!(isOver) || !(L.isEmpty()) || this.getPS().getHP()>0 ||this.getPJ().getHP()>0) {
			// pour le pokémon sauvage
			List<Attaque> listeAttSauv = this.getPS().getListAtck();
			Random rand = new Random(); 
			int choixAtt = rand.nextInt(2);
			
			//pour le pokémon du dresseur			
			List<Attaque> listeAttPok = this.getPJ().getListAtck();
			String attaqueUn = listeAttPok.get(0).getNom();
			String attaqueDeux = listeAttPok.get(1).getNom();
			
			// Affiche l'etat des deux pokemons
			System.out.println("Votre Pokemon");
			System.out.println(this.getPJ().toStringC()+ ", Niveau = " + this.getPJ().getStats().getLvl().toString());
			System.out.println(this.getPJ().getStats().getAttack().toString());
			System.out.println("Pokemon Adverse");
			System.out.println(this.getPS().toStringC()+ ", Niveau = " + this.getPS().getStats().getLvl().toString());
			System.out.println(this.getPS().getStats().getDefense().toString());
			
			if (L.isEmpty()) {
				System.out.println("Attention , votre sac est vide, vous ne pouvez pas changer");
			}
			
			//demande au joueur le mouvement désiré
			
			System.out.println("Veuillez choisir entre attaquer, changer de pokémon ou fuir \n Taper 'FUIR' pour fuir 'ATTAQUER' por attaquer et 'CHANGER' pour changer de pokémon");
			Main.setEnabled(true);
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			
			
			if (str.equals("FUIR")) {
				fuir();
				break;
			}
			else if (str.equals("CHANGER")) {
				if (L.isEmpty()) {
					System.out.println("Impossible");
				}
				else {
					this.changer(L);
				}
			}	
			// commande pour attaquer
			else if (str.equals("ATTAQUER")) {
			
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Veuillez choisir une attaque entre" + attaqueUn + " et " + attaqueDeux + ". Taper le nom de l'attaque ");
				String str1 = sc.nextLine();
				System.out.println("Vous avez saisi : " + str1);
				
				//action durant le tour
				if (str1.equals(attaqueUn)) {
					assault(listeAttPok.get(0), listeAttSauv.get(choixAtt), this.getPJ(), this.getPS());
				}
				else {
					assault(listeAttPok.get(1), listeAttSauv.get(choixAtt), this.getPJ(), this.getPS());
				}
				System.out.println("L'adversaire à utilisé " + this.getPS().getListAtck().get(choixAtt).getNom());
			}
			else {
				System.out.println("erreur");
				break;
			}
			if (this.getPS().getHP()<=0) {
				System.out.println("Bravo, vous avez capturé un nouveau pokémon");
				
				L.add(this.getPS());
				break;
			}
			if (this.getPJ().getHP()<=0) {
				System.out.println("Votre Pokemon est KO");
				if (!(L.isEmpty())) {
					System.out.println("Vous avez encore des Pokemon, voulez vous changez ?");
					System.out.println("Yes ou NO" );
					Scanner sc3 = new Scanner(System.in);
					String str3 = sc3.nextLine();
					if (str3.equals("YES")) {
						this.setPJ(L.get(0));
					}
					else {
						System.out.println("Vous avez fui, votre pokemon est perdu");
						break;
					}
				}
				else {
					System.out.println("Vous n'avez plus de pokemon en etat de combatre,Defaite");
					break;
				}
			}
		}
	}
		

	public void fuir() {
		setOver(true);
	}
}
