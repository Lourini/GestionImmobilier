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
public class Canal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @OneToMany(mappedBy = "canalId")
    private Set<Reclamation> reclamations;

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

    public Set<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(final Set<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

}
