package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
* Class <code><b>Dossier</b></code>.  
* </br>Entity <code><b>Servei</b></code>. 
* </br>Taula persistency <code><b>servei</b></code> 
* @author rduran & mmiret
*/
	
@Entity(name="Dossier")
@Table(name="dossier")

public class Dossier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @Column(name ="id", length=11) private int id;
	@Column(name = "preu", length=11) private int preu;
	@Column(name="descripcio", length=255) private String descripcio;
	
	/**
	 * Constructor method de <blockquote><b>Dossier</b></blockquote> amb paràmetres:
	 * @param  id         Identificador únic del dossier
	 * @param  preu       Preu del dossier
	 * @param  descripcio Nom del dossier
	 * @return            Instància de Dossier amb els paràmetres especificats
	 */
	public Dossier(int id, int preu, String descripcio) {
		super();
		this.id = id;
		this.preu = preu;
		this.descripcio = descripcio;
	}
	
	/**
	 * Constructor method de <blockquote><b>Dosier</b></blockquote> sense paràmetres:
	 */
	public Dossier(){}

	/**
	 * Getter de l'identificador únic de Dossier
	 * @return {Integer} Identificador únic o PrimaryKey del Dossier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter de l'identificador únic de Dossier
	 * @param id {Integer} Identificador únic o PrimaryKey del Dossier
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter del preu del dossier
	 * @return {Integer} Preu del dossier
	 */
	public int getPreu() {
		return preu;
	}

	/**
	 * Setter del Preu del dossier
	 * @param preu {Integer} Preu del dossier
	 */
	public void setPreu(int preu) {
		this.preu = preu;
	}

	/**
	 * Getter del nom del Dossier
	 * @return {String} Nom del dossier
	 */
	public String getDescripcio() {
		return descripcio;
	}

	/**
	 * Setter del nom del Dossier
	 * @param descripcio {String} Nom del dossier
	 */
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	/**
	 * Mètode toString del Dossier per a possibles debuggings
	 * @return {String} Representació textual del objecte Dossier
	 */
	@Override
	public String toString() {
		return "Dossier [id=" + id + ", preu=" + preu + ", descripcio=" + descripcio + "]";
	}
	
	
	
	
}
	
