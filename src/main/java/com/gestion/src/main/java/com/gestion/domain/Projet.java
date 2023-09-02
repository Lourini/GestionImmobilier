package com.gestion.domain;

import javax.persistence.CascadeType;
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

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table
public class Projet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nomProjet;
    
    @Column(
            nullable = false,
            name = "\"description\"",
            columnDefinition = "longtext"
    )
    private String description;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;

    @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "projetId")
    private Set<Programme> programmes;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ville_id", nullable = false)
    private Ville villeId;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(final String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Programme> getProgrammeId() {
		return programmes;
	}

	public void setProgrammeId(Set<Programme> programmes) {
		this.programmes = programmes;
	}

	public Ville getVilleId() {
		return villeId;
	}

	public void setVilleId(Ville villeId) {
		this.villeId = villeId;
	}

}
