package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
* Class <code><b>Dossier</b></code>.  
* <br>Entity <code><b>Servei</b></code>. 
* <br>Taula persistency <code><b>servei</b></code> 
* @author rduran &amp; mmiret
*/
	
@Entity(name="Dossier")
@Table(name="dossier")
@NamedQueries ( {
	@NamedQuery (
			name = "dossierById",
			query = "FROM Dossier d WHERE d.id = :id"
			),
	@NamedQuery (
			name = "allDossier",
			query = "FROM Dossier d"
			)
})

public class Dossier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) @Column(name ="id", length=11)  private int id;
	@Column(name = "preu", length=11) private int preu;
	@Column(name="descripcio", length=255) private String descripcio;
	
	/**
	 * Constructor method de <blockquote><b>Dossier</b></blockquote> amb parametres:
	 * @param  preu       Preu del dossier
	 * @param  descripcio Nom del dossier
	 */
	public Dossier(int preu, String descripcio) {
		super();
		this.preu = preu;
		this.descripcio = descripcio;
	}
	
	/**
	 * Constructor method de <blockquote><b>Dossier</b></blockquote> sense parametres:
	 */
	public Dossier(){}

	/**
	 * Getter de l'identificador unic de Dossier
	 * @return {Integer} Identificador unic o PrimaryKey del Dossier
	 */
	public int getId() {
		return id;
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
	 * Metode toString del Dossier per a possibles debuggings
	 * @return {String} Representacio textual de l'objecte Dossier
	 */
	@Override
	public String toString() {
		return "Dossier [id=" + id + ", preu=" + preu + ", descripcio=" + descripcio + "]";
	}

	public boolean hasValidInformation() {
		return (this.preu >= 0 && this.descripcio != "");
	}
	
	
	public static boolean isValidIdDossier(int idDossier){
		return (idDossier>=0);
	}
	
	
	
}
	
