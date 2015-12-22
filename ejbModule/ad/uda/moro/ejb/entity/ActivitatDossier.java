package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;



/**
* Class <code><b>ActivitatDossier</b></code>.  
* <br>Entity <code><b>ActivitatDossier</b></code>. 
* <br>Taula persistency <code><b>activitatdossier</b></code> 
* @author rduran &amp; mmiret
*/

@Entity(name="ActivitatDossier")
@Table(name="activitatdossier")
@XmlRootElement(name = "activitatDossier")
@NamedQueries ( {
	@NamedQuery (
			name = "allActivitatDossier",
			query = "FROM ActivitatDossier ad ORDER BY ad.id"
			),
	@NamedQuery (
			name = "dossiersById",
			query = "FROM ActivitatDossier ad WHERE ad.idDossier = :idDossier"
			)
})

public class ActivitatDossier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) @Column(name ="id", length=11)  private int id;
	
	@ManyToOne (optional = true)
	@JoinColumn (name = "idDossier")
	private Dossier idDossier;
	
	@ManyToOne (optional = true)
	@JoinColumn (name = "idServei")
	private Servei idServei;
	
	/**
	 * Constructor method de <blockquote><b>ActivitatDossier</b></blockquote> amb parametres:
	 * @param idDossier	{Integer} Identificador d'un dossier.
	 * @param idServei {Integer} Identificador d'un servei.
	 */
	public ActivitatDossier(Dossier idDossier, Servei idServei) {
		super();
		this.idDossier = idDossier;
		this.idServei = idServei;
	}
	
	/**
	 * Constructor method de <blockquote><b>ActivitatDossier</b></blockquote> sense parametres:
	 */
	public ActivitatDossier(){}

	/**
	 * Getter de l'identificador unic de ActivitatDossier
	 * @return {Integer} Identificador unic o PrimaryKey del ActivitatDossier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter de l'identificador unic d'un Dossier
	 * @return {Integer} Identificador unic o PrimaryKey del Dossier
	 */
	public Dossier getIdDossier() {
		return idDossier;
	}

	/**
	 * Setter de l'identificador unic d'un Dossier
	 * @param idDossier {Integer} Identificador unic o PrimaryKey del Dossier
	 */
	public void setIdDossier(Dossier idDossier) {
		this.idDossier = idDossier;
	}

	/**
	 * Getter de identificador unic d'un Servei:
	 * @return {Integer} El identificador unic d'un servei
	 */
	public Servei getIdServei() {
		return idServei;
	}

	/**
	 * Setter de identificador unic d'un Servei:
	 * @param idServei {Integer} Identificador unic d'un servei
	 */
	public void setIdServei(Servei idServei) {
		this.idServei = idServei;
	}

	/**
	 * Metode toString del ActivitatDossier per a possibles debuggings
	 * @return {String} Representacio textual de l'objecte ActivitatDossier
	 */
	@Override
	public String toString() {
		return "ActivitatDossier [id=" + id + ", idDossier=" + idDossier.getId() + ", idServei=" + idServei.getId() + "]";
	}
	
	public boolean hasValidInformation() {
		return (this.idDossier.hasValidInformation() & this.idServei.hasValidInformation());
	}
	
	public boolean isValidActivitatDossierId() {
		return (this.id >= 0);
	}
		
	
}
	
