package com.gestion.domain;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table
public class Etat {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @OneToMany(mappedBy = "etatId")
    private Set<Reclamation> relamations;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public Set<Reclamation> getRelamations() {
        return relamations;
    }

    public void setRelamations(final Set<Reclamation> relamations) {
        this.relamations = relamations;
    }

}
