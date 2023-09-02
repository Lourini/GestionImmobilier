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

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table
public class Programme {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nomProgramme;
    
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

    @OneToMany(mappedBy = "programmeId")
    private Set<Bien> bienId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projet_id", nullable = false)
    private Projet projetId;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNomProgramme() {
        return nomProgramme;
    }

    public void setNomProgramme(final String nomProgramme) {
        this.nomProgramme = nomProgramme;
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
    
    

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUpdatedDate(final LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Projet getProjetId() {
        return projetId;
    }

    public void setProjetId(final Projet projetId) {
        this.projetId = projetId;
    }
    
	public Set<Bien> getBienId() {
        return bienId;
    }

    public void setBienId(final Set<Bien> bienId) {
        this.bienId = bienId;
    }

}
