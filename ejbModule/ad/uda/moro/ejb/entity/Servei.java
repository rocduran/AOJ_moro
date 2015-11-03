package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="Servei")
@Table(name="servei")

public class Servei implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Class <code><b>Servei</b></code> 
	 * @author rduran & mmiret
	 *
	 */
	
	@Id @Column(name ="id", length=11) private int id;
	@Column(name = "idTipus", length=11) private int idTipus;
	@Column(name="descripcio", length=255) private String descripcio;
	
	public Servei(int id, int idTipus, String descripcio) {
		super();
		this.id = id;
		this.idTipus = idTipus;
		this.descripcio = descripcio;
	}
	
	public Servei(){}

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
		return "Servei [id=" + id + ", idTipus=" + idTipus + ", descripcio=" + descripcio + "]";
	}
	
	
	
}
	
