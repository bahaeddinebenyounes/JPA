package com.baha.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.baha.entities.Vetement;
import com.baha.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class VetementDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

//méthode ajouter d'une entité à la bd
public void ajouter(Vetement c)
{
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(c);

tx.commit();
}

//méthode modifier d'une entité à partir de la bd
	public void modifier(Vetement c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(c);
		tx.commit();
	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Vetement c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		c = entityManager.merge(c); // important
		entityManager.remove(c);
		tx.commit();
	}

//méthode Consulter d'une entité à partir de la bd
	public Vetement consulter(Vetement c, Object id) {
		return entityManager.find(c.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Vetement> listerTous() {
		List<Vetement> vetements = entityManager.createQuery("select c from Vetement c").getResultList();

		return vetements;
	}

//méthode pour lister tous les client dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Vetement> listerParNom(String nom) {
		List<Vetement> vetements = entityManager.createQuery("select c from Vetement c where c.nom like :pnom")
				.setParameter("pnom", "%" + nom + "%").getResultList();

		return vetements;
	}
}