package com.gestion.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;


@Entity
@Table
public class Ville {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomVille;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", nullable = false)
    private Region regionid;

    @OneToMany(mappedBy = "villeId")
    private Set<Projet> projet;

    @OneToMany(mappedBy = "villId")
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(final String nomVille) {
        this.nomVille = nomVille;
    }

    public Region getRegionid() {
        return regionid;
    }

    public void setRegionid(final Region regionid) {
        this.regionid = regionid;
    }
    
    

    public Set<Projet> getProjetId() {
		return projet;
	}

	public void setProjetId(Set<Projet> projetId) {
		this.projet = projetId;
	}

	public Set<User> getUsers() {
        return users;
    }

    public void setUsers(final Set<User> users) {
        this.users = users;
    }

}
