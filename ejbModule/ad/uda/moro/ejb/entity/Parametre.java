package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="Parametre")
@Table(name="parametres")

public class Parametre implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Class <code><b>Parametre</b></code> 
	 * @author rduran & mmiret
	 *
	 */
	
	@Id @Column(name ="id", length=11) private int id;
	@Column(name = "idTipus", length=11) private int idTipus;
	@Column(name="descripcio", length=255) private String descripcio;
	
	public Parametre(int id, int idTipus, String descripcio) {
		super();
		this.id = id;
		this.idTipus = idTipus;
		this.descripcio = descripcio;
	}
	
	public Parametre(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTipus() {
		return idTipus;
	}

	public void setIdTipus(int idTipus) {
		this.idTipus = idTipus;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	@Override
	public String toString() {
		return "Parametres [id=" + id + ", idTipus=" + idTipus + ", descripcio=" + descripcio + "]";
	}
	
	
	
}
	
