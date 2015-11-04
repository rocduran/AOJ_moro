package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Class <code><b>Servei</b></code>. Entity <code><b>Servei</b></code>. Taula persistency <code><b>servei</b></code>
 * @author rduran & mmiret
 *
 */

@Entity(name="Servei")
@Table(name="servei")

public class Servei implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @Column(name ="id", length=11) private int id;
	@Column(name = "idTipus", length=11) private int idTipus;
	@Column(name="descripcio", length=255) private String descripcio;
	
	/**
	 * Constructor method amb parametres:
	 * @param id Identificador del servei (PK)
	 * @param idTipus Identificador del tipus de servei.
	 * @param descripcio Descriu que es el servei en un String.
	 */
	public Servei(int id, int idTipus, String descripcio) {
		super();
		this.id = id;
		this.idTipus = idTipus;
		this.descripcio = descripcio;
	}
	
	/**
	 * Constructor method sense parametres.
	 */
	public Servei(){}

	/**
	 * Getter de id unic del servei:
	 * @return El id unic del servei
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Setter de id unic del servei:
	 * @param identificador unic del servei
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter de idTipus de servei:
	 * @return El id unic del servei
	 */
	public int getIdTipus() {
		return idTipus;
	}

	/**
	 * Setter de idTipus de servei:
	 * @param identificador del tipus de servei
	 */
	public void setIdTipus(int idTipus) {
		this.idTipus = idTipus;
	}

	/**
	 * Getter de la descripcio de servei:
	 * @return La descripcio del servei, per exemple: "<code><b>Guia Paku</b></code>"
	 */
	public String getDescripcio() {
		return descripcio;
	}
	/**
	 * Setter de idTipus de servei:
	 * @param identificador del tipus de servei
	 */
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	/**
	 * Mètode toString de Servei per possibles debuggings.
	 */
	@Override
	public String toString() {
		return "Servei [id=" + id + ", idTipus=" + idTipus + ", descripcio=" + descripcio + "]";
	}
	
	
	
}
	
