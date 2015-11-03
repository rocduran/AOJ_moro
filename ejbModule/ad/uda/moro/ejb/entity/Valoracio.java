package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="Valoracio")
@Table(name="valoracio")

public class Valoracio implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Class <code><b>Valoracio</b></code> 
	 * @author rduran & mmiret
	 *
	 */
	
	@Id @Column(name ="id", length=11) private int id;
	@Column(name = "idDossier", length=11) private int idDossier;
	@Column(name="idServei", length=11) private int idServei;
	@Column(name="idParam", length=11) private int idParam;
	@Column(name="valor", length=11) private int valor;
	
	
	public Valoracio(int id, int idDossier, int idServei, int idParam, int valor) {
		super();
		this.id = id;
		this.idDossier = idDossier;
		this.idServei = idServei;
		this.idParam = idParam;
		this.valor = valor;
	}
	
	public Valoracio(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	public int getIdServei() {
		return idServei;
	}

	public void setIdServei(int idServei) {
		this.idServei = idServei;
	}

	public int getIdParam() {
		return idParam;
	}

	public void setIdParam(int idParam) {
		this.idParam = idParam;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Valoracio [id=" + id + ", idDossier=" + idDossier + ", idServei=" + idServei + ", idParam=" + idParam
				+ ", valor=" + valor + "]";
	}
		
	
}
	
