package it.cnr.si.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Multa.
 */
@Entity
@Table(name = "multa")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Multa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "data_multa", nullable = false)
    private LocalDate dataMulta;

    
    @Lob
    @Column(name = "multa_pdf", nullable = false)
    private byte[] multaPdf;

    @Column(name = "multa_pdf_content_type", nullable = false)
    private String multaPdfContentType;

    @Column(name = "visionato_multa")
    private ZonedDateTime visionatoMulta;

    @NotNull
    @Column(name = "pagato_multa", nullable = false)
    private Boolean pagatoMulta;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private Veicolo veicolo;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataMulta() {
        return dataMulta;
    }

    public Multa dataMulta(LocalDate dataMulta) {
        this.dataMulta = dataMulta;
        return this;
    }

    public void setDataMulta(LocalDate dataMulta) {
        this.dataMulta = dataMulta;
    }

    public byte[] getMultaPdf() {
        return multaPdf;
    }

    public Multa multaPdf(byte[] multaPdf) {
        this.multaPdf = multaPdf;
        return this;
    }

    public void setMultaPdf(byte[] multaPdf) {
        this.multaPdf = multaPdf;
    }

    public String getMultaPdfContentType() {
        return multaPdfContentType;
    }

    public Multa multaPdfContentType(String multaPdfContentType) {
        this.multaPdfContentType = multaPdfContentType;
        return this;
    }

    public void setMultaPdfContentType(String multaPdfContentType) {
        this.multaPdfContentType = multaPdfContentType;
    }

    public ZonedDateTime getVisionatoMulta() {
        return visionatoMulta;
    }

    public Multa visionatoMulta(ZonedDateTime visionatoMulta) {
        this.visionatoMulta = visionatoMulta;
        return this;
    }

    public void setVisionatoMulta(ZonedDateTime visionatoMulta) {
        this.visionatoMulta = visionatoMulta;
    }

    public Boolean isPagatoMulta() {
        return pagatoMulta;
    }

    public Multa pagatoMulta(Boolean pagatoMulta) {
        this.pagatoMulta = pagatoMulta;
        return this;
    }

    public void setPagatoMulta(Boolean pagatoMulta) {
        this.pagatoMulta = pagatoMulta;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public Multa veicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
        return this;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Multa multa = (Multa) o;
        if (multa.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), multa.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Multa{" +
            "id=" + getId() +
            ", dataMulta='" + getDataMulta() + "'" +
            ", multaPdf='" + getMultaPdf() + "'" +
            ", multaPdfContentType='" + getMultaPdfContentType() + "'" +
            ", visionatoMulta='" + getVisionatoMulta() + "'" +
            ", pagatoMulta='" + isPagatoMulta() + "'" +
            "}";
    }
}
