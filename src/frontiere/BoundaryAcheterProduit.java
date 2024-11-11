package frontiere;

import java.util.Iterator;
import java.util.Scanner;
import frontiere.Clavier;
import personnages.Gaulois;
import controleur.ControlAcheterProduit;
import villagegaulois.Etal;


public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée Bonemine mais il faut être"
					+ " un habitant de notre village pour commercer ici.");
		}
		else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			Gaulois[] vendeurs = controlAcheterProduit.trouverVendeurs(produit);
			if (vendeurs.length == 0) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
			else {
				System.out.println("Chez quel commerçant voulez-vous acheter des "+produit+" ?");
				for (int i = 0; i < vendeurs.length; i++) {
					System.out.println((i+1)+" - "+vendeurs[i].getNom());
				}
				int choixVendeur = Clavier.entrerEntier("");
				String nomVendeur = vendeurs[choixVendeur-1].getNom();
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur "
				+ nomVendeur);
				Etal etal = controlAcheterProduit.trouverEtal(nomVendeur);
				int nbProduit = Clavier.entrerEntier("Combien de fleurs voulez-vous acheter ?");
				int nbStock = controlAcheterProduit.quantiteEtal(etal);
				if (nbStock == 0) {
					System.out.println(nomAcheteur+" veut acheter "+nbProduit+" "+produit+
							", malheureusement il n’y en a plus !");
				}else if (nbStock < nbProduit) {
					System.out.println(nomAcheteur+" veut acheter "+nbProduit+" "+produit+
							", malheureusement "+nomVendeur+" n’en a plus que "+nbStock+
							" "+nomAcheteur+" achète tout le stock de Bonemine.");
					controlAcheterProduit.acheterProduit(etal, nbStock);
				}else {
					System.out.println(nomAcheteur+" achète "+nbProduit+" "+produit+" a "+nomVendeur);
					controlAcheterProduit.acheterProduit(etal, nbProduit);
				}
				
			}
		}
	}
}
