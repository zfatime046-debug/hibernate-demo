package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity  // Indique à JPA que cette classe est une entité persistante
public class Produit {

    @Id  // Clé primaire de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // La valeur de l'id sera générée automatiquement par la base de données
    private Long id;

    // Nom du produit
    private String nom;

    // Prix du produit (BigDecimal recommandé pour les valeurs monétaires)
    private BigDecimal prix;

    // Constructeur par défaut requis par JPA
    // JPA utilise ce constructeur pour créer les objets via réflexion
    public Produit() {
    }

    // Constructeur personnalisé pour créer facilement un produit
    public Produit(String nom, BigDecimal prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // ===== Getters et Setters =====

    // Retourne l'identifiant du produit
    public Long getId() {
        return id;
    }

    // Définit l'identifiant du produit
    public void setId(Long id) {
        this.id = id;
    }

    // Retourne le nom du produit
    public String getNom() {
        return nom;
    }

    // Modifie le nom du produit
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Retourne le prix du produit
    public BigDecimal getPrix() {
        return prix;
    }

    // Modifie le prix du produit
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    // Méthode utilisée pour afficher l'objet de manière lisible
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
