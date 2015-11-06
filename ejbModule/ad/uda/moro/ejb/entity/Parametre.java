package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
* Class <code><b>Parametre</b></code>.  
* <br>Entity <code><b>Parametre</b></code>. 
* <br>Taula persistency <code><b>parametres</b></code> 
* @author rduran &amp; mmiret
*/

@Entity(name="Parametre")
@Table(name="parametres")

public class Parametre implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @Column(name ="id", length=11) private int id;
	@Column(name = "idTipus", length=11) private int idTipus;
	@Column(name="descripcio", length=255) private String descripcio;
	
	/**
	 * Constructor method de <blockquote><b>Parametre</b></blockquote> amb paràmetres:
	 * @param id 	{Integer} Identificador únic de la relació
	 * @param idTipus	{Integer} Identificador del tipus de servei. Per exemple: <blockquote><b>1 = Guia, 2 = Hotel, etc...</b></blockquote>.
	 * @param Descripcio {String} Descriu que es el parametre en un String.
	 */
	public Parametre(int id, int idTipus, String descripcio) {
		super();
		this.id = id;
		this.idTipus = idTipus;
		this.descripcio = descripcio;
	}
	
	/**
	 * Constructor method <blockquote><b>Parametre</b></blockquote>  sense parametres.
	 */
	public Parametre(){}

	/**
	 * Getter de l'identificador únic del Parametre:
	 * @return {Integer} L'identificador únic del parametre
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter de l'identificador únic del Parametre:
	 * @param id {Integer} Identificador únic del parametre
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter de idTipus de Parametre:
	 * @return {Integer} L'identificador del tipus de servei.
	 */
	public int getIdTipus() {
		return idTipus;
	}

	/**
	 * Setter de idTipus de Parametre:
	 * @param idTipus {Integer} Identificador del tipus de servei
	 */
	public void setIdTipus(int idTipus) {
		this.idTipus = idTipus;
	}

	/**
	 * Getter de la descripcio de Parametre:
	 * @return {String} La descripcio del Parametre, per exemple: "<code><b>Amabilitat</b></code>"
	 */
	public String getDescripcio() {
		return descripcio;
	}

	/**
	 * Setter de la descripció de Parametre:
	 * @param descripcio {String} La descripcio del Parametre, per exemple: "<code><b>Amabilitat</b></code>"
	 */
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	/**
	 * Mètode toString del Parametre per a possibles debuggings
	 * @return {String} Representació textual de l'objecte Parametre
	 */
	@Override
	public String toString() {
		return "Parametres [id=" + id + ", idTipus=" + idTipus + ", descripcio=" + descripcio + "]";
	}
	
	
	
}
	
