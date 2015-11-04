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
	 * Constructor method amb paràmetres:
	 * @param id Identificador del servei (PrimaryKey del Entity)
	 * @param idTipus Identificador del tipus de servei. Per exemple: <blockquote><b>1 = Guia, 2 = Hotel, etc...</b></blockquote>
	 * @param descripcio Descriu que es el servei en un String.
	 * @see CommonUtilities
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
	 * Getter de identificador únic del servei:
	 * @return El identificador únic del servei
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Setter de identificador únic del servei:
	 * @param Identificador únic del servei
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter de idTipus de servei:
	 * @return L'identificador del tipus de servei.
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
	
