package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	public Gaulois[] trouverVendeurs(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	public Etal trouverEtal(String vendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
	}
	public int quantiteEtal(Etal etal) {
		return etal.getQuantite();
	}
	public void acheterProduit(Etal etal, int quantite) {
		etal.acheterProduit(quantite);
	}
}
