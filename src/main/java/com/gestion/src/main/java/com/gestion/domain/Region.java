package com.gestion.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;


@Entity
@Table
public class Region {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nomRegion;

    @OneToMany(mappedBy = "regionid")
    private Set<Ville> villeid;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(final String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public Set<Ville> getVilleid() {
        return villeid;
    }

    public void setVilleid(final Set<Ville> villeid) {
        this.villeid = villeid;
    }

}
