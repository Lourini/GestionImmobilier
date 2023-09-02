package com.gestion.domain;


import java.time.LocalDate;
import java.util.Set;

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




@Entity
@Table
public class Bien {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(
            nullable = false,
            name = "\"description\"",
            columnDefinition = "longtext"
    )
    private String description;

    @Column(nullable = false)
    private Double prix;

    @Column(nullable = false)
    private String numTitle;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programme_id" ,nullable = false)
    private Programme programmeId;

    @OneToMany(mappedBy = "bienId")
    private Set<AchatLocation> achatLocations;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(final Double prix) {
        this.prix = prix;
    }

    public String getNumTitle() {
        return numTitle;
    }

    public void setNumTitle(final String numTitle) {
        this.numTitle = numTitle;
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

    public Programme getProgrammeId() {
		return programmeId;
	}

	public void setProgrammeId(Programme programmeId) {
		this.programmeId = programmeId;
	}

	public Set<AchatLocation> getAchatLocations() {
        return achatLocations;
    }

    public void setAchatLocations(final Set<AchatLocation> achatLocations) {
        this.achatLocations = achatLocations;
    }

}
