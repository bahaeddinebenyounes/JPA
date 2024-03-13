package com.baha.test;

import com.baha.dao.VetementDao;
import com.baha.entities.Vetement;

public class VetementTest {
	public static void main(String[] args) {
//créer un objet client
		Vetement c = new Vetement();
		c.setNom("chaussure");
		c.setPrix(200.3);
//ajouter l'objet client à la BD
		VetementDao cltDao = new VetementDao();
		cltDao.ajouter(c);
		System.out.println("Appel de la méthode listerTous");
		for (Vetement cl : cltDao.listerTous())
			System.out.println(cl.getCode() + " " + cl.getNom());
		System.out.println("Appel de la méthode listerParNom");
		for (Vetement cl : cltDao.listerParNom("chau"))

			System.out.println(cl.getCode() + " " + cl.getNom());
		 VetementDao vetementDao = new VetementDao();
	        Vetement vetementAUpdate = vetementDao.consulter(new Vetement(), 4);
	        vetementAUpdate.setNom("chaussette");
	        vetementDao.modifier(vetementAUpdate);

	        // Supprimer un vetement existant
	        Vetement vetementASupprimer = vetementDao.consulter(new Vetement(), 5); 
	        vetementDao.supprimer(vetementASupprimer);
	        System.out.println("Vêtement supprimé: " + vetementASupprimer.getCode() + " " + vetementASupprimer.getNom());


	        // Consulter un vetement par son identifiant
	        Vetement vetementConsulte = vetementDao.consulter(new Vetement(), 4); 
	        System.out.println("Vetement consulté: " + vetementConsulte.getCode() + " " + vetementConsulte.getNom());
 }
}
