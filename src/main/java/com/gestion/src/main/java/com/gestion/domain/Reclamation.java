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
public class Reclamation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String mode;

    @Column(nullable = false, columnDefinition = "longtext")
    private String commentaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_id", nullable = false)
    private Etat etatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "canal_id", nullable = false)
    private Canal canalId;

    @OneToMany(mappedBy = "reclamationId")
    private Set<UserReclamation> userReclamations;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(final String mode) {
        this.mode = mode;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(final String commentaire) {
        this.commentaire = commentaire;
    }

    public Etat getEtatId() {
        return etatId;
    }

    public void setEtatId(final Etat etatId) {
        this.etatId = etatId;
    }

    public Canal getCanalId() {
        return canalId;
    }

    public void setCanalId(final Canal canalId) {
        this.canalId = canalId;
    }

    public Set<UserReclamation> getUserReclamations() {
        return userReclamations;
    }

    public void setUserReclamations(final Set<UserReclamation> userReclamations) {
        this.userReclamations = userReclamations;
    }

}
