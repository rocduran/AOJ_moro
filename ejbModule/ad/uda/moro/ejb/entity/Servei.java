package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Class <code><b>Servei</b></code>. 
 * <br>Entity <code><b>Servei</b></code>. 
 * <br>Taula persistency <code><b>servei</b></code>
 * @author rduran &amp; mmiret
 *
 */

@Entity(name="Servei")
@Table(name="servei")
@NamedQueries ( {
	@NamedQuery (
			name = "serveiById",
			query = "FROM Servei s WHERE s.id = :id"
			)
})

public class Servei implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) @Column(name ="id", length=11) private int id;
	@Column(name = "idTipus", length=11) private int idTipus;
	@Column(name="descripcio", length=255) private String descripcio;
	
	/**
	 * Constructor method <blockquote><b>Servei</b></blockquote>  amb parametres:
	 * @param id 		{Integer} Identificador del servei (PrimaryKey del Entity)
	 * @param idTipus 	{Integer} Identificador del tipus de servei. Per exemple: <blockquote><b>1 = Guia, 2 = Hotel, etc...</b></blockquote>
	 * @param descripcio {String} Descriu que es el servei en un String.
	 * @see ad.uda.moro.CommonUtilities
	 */
	public Servei(int idTipus, String descripcio) {
		this.idTipus = idTipus;
		this.descripcio = descripcio;
	}
	
	/**
	 * Constructor method <blockquote><b>Servei</b></blockquote>  sense parametres.
	 */
	public Servei(){}

	/**
	 * Getter de identificador unic del Servei:
	 * @return {Integer} El identificador unic del servei
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter de idTipus de servei:
	 * @return {Integer} L'identificador del tipus de servei.
	 */
	public int getIdTipus() {
		return idTipus;
	}

	/**
	 * Setter de idTipus de servei:
	 * @param idTipus {Integer} Identificador del tipus de servei
	 */
	public void setIdTipus(int idTipus) {
		this.idTipus = idTipus;
	}

	/**
	 * Getter de la descripcio de servei:
	 * @return {String} La descripcio del servei, per exemple: "<code><b>Guia Paku</b></code>"
	 */
	public String getDescripcio() {
		return descripcio;
	}
	/**
	 * Setter de la descripcio de servei:
	 * @param descripcio {String} La descripcio del servei, per exemple: "<code><b>Guia Paku</b></code>"
	 */
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	/**
	 * Metode toString del Servei per a possibles debuggings
	 * @return {String} Representacio textual de l'objecte Servei
	 */
	@Override
	public String toString() {
		return "Servei [id=" + id + ", idTipus=" + idTipus + ", descripcio=" + descripcio + "]";
	}

	public boolean hasValidInformation() {
		return (0 < this.idTipus & this.idTipus <= 3 & this.descripcio != "");
	}
	
	
	
}
	
