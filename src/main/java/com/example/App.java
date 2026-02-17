package com.example;

import com.example.model.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hibernate-demo");

        ajouterProduits(entityManagerFactory);
        afficherProduits(entityManagerFactory);

        entityManagerFactory.close();
    }

    private static void ajouterProduits(EntityManagerFactory entityManagerFactory) {

        EntityManager entityManager =
                entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Produit laptop = new Produit("Laptop", new BigDecimal("999.99"));
            Produit smartphone = new Produit("Smartphone", new BigDecimal("499.99"));
            Produit tablette = new Produit("Tablette", new BigDecimal("299.99"));

            entityManager.persist(laptop);
            entityManager.persist(smartphone);
            entityManager.persist(tablette);

            entityManager.getTransaction().commit();
            System.out.println("Produits insérés avec succès !");

        } catch (Exception exception) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            exception.printStackTrace();

        } finally {
            entityManager.close();
        }
    }

    private static void afficherProduits(EntityManagerFactory entityManagerFactory) {

        EntityManager entityManager =
                entityManagerFactory.createEntityManager();

        try {

            List<Produit> listeProduits =
                    entityManager.createQuery("SELECT p FROM Produit p", Produit.class)
                            .getResultList();

            System.out.println("\nListe des produits :");

            for (Produit item : listeProduits) {
                System.out.println(item);
            }

            System.out.println("\nRecherche du produit avec ID = 2 :");

            Produit produitTrouve =
                    entityManager.find(Produit.class, 2L);

            if (produitTrouve != null) {
                System.out.println(produitTrouve);
            } else {
                System.out.println("Produit non trouvé");
            }

        } finally {
            entityManager.close();
        }
    }
}
