package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
* Class <code><b>ActivitatDossier</b></code>.  
* <br>Entity <code><b>ActivitatDossier</b></code>. 
* <br>Taula persistency <code><b>activitatdossier</b></code> 
* @author rduran &amp; mmiret
*/

@Entity(name="ActivitatDossier")
@Table(name="activitatdossier")

public class ActivitatDossier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @Column(name ="id", length=11) private int id;
	@Column(name = "idDossier", length=11) private int idDossier;
	@Column(name="idServei", length=11) private int idServei;
	
	/**
	 * Constructor method de <blockquote><b>ActivitatDossier</b></blockquote> amb paràmetres:
	 * @param id 	{Integer} Identificador únic de la relació
	 * @param idDossier	{Integer} Identificador d'un dossier.
	 * @param idServei {Integer} Identificador d'un servei.
	 */
	public ActivitatDossier(int id, int idDossier, int idServei) {
		super();
		this.id = id;
		this.idDossier = idDossier;
		this.idServei = idServei;
	}
	
	/**
	 * Constructor method de <blockquote><b>ActivitatDossier</b></blockquote> sense paràmetres:
	 */
	public ActivitatDossier(){}

	/**
	 * Getter de l'identificador únic de ActivitatDossier
	 * @return {Integer} Identificador únic o PrimaryKey del ActivitatDossier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter de l'identificador únic de ActivitatDossier
	 * @param id {Integer} Identificador únic o PrimaryKey del ActivitatDossier
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter de l'identificador únic d'un Dossier
	 * @return {Integer} Identificador únic o PrimaryKey del Dossier
	 */
	public int getIdDossier() {
		return idDossier;
	}

	/**
	 * Setter de l'identificador únic d'un Dossier
	 * @param idDossier {Integer} Identificador únic o PrimaryKey del Dossier
	 */
	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	/**
	 * Getter de identificador únic d'un Servei:
	 * @return {Integer} El identificador únic d'un servei
	 */
	public int getIdServei() {
		return idServei;
	}

	/**
	 * Setter de identificador únic d'un Servei:
	 * @param idServei {Integer} Identificador únic d'un servei
	 */
	public void setIdServei(int idServei) {
		this.idServei = idServei;
	}

	/**
	 * Mètode toString del ActivitatDossier per a possibles debuggings
	 * @return {String} Representació textual de l'objecte ActivitatDossier
	 */
	@Override
	public String toString() {
		return "ActivitatDossier [id=" + id + ", idDossier=" + idDossier + ", idServei=" + idServei + "]";
	}
		
	
}
	
