package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;



/**
* Class <code><b>Valoracio</b></code>.  
* <br>Entity <code><b>Valoracio</b></code>. 
* <br>Taula persistency <code><b>parametres</b></code> 
* @author rduran &amp; mmiret
*/

@Entity(name="Valoracio")
@Table(name="valoracio")

public class Valoracio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) @Column(name ="id", length=11)  private int id;
	@Column(name = "idDossier", length=11) private int idDossier;
	@Column(name="idServei", length=11) private int idServei;
	@Column(name="idParam", length=11) private int idParam;
	@Column(name="valor", length=11) private int valor;
	
	/**
	 * Constructor method de <blockquote><b>Valoració</b></blockquote> amb parametres:
	 * @param  id        {Integer} Identificador unic d'una valoració
	 * @param  idDossier {Integer} Identificador unic d'un dossier
	 * @param  idServei  {Integer} Identificador unic d'un servei
	 * @param  idParam   {Integer} Identificador unic d'un parametre
	 * @param  valor     {Integer} Puntuacio donada al parametre d'un servei d'un dossier. Valor enter entre 0 i 5.
	 */
	public Valoracio(int id, int idDossier, int idServei, int idParam, int valor) {
		super();
		this.id = id;
		this.idDossier = idDossier;
		this.idServei = idServei;
		this.idParam = idParam;
		this.valor = valor;
	}
	
	/**
	 * Constructor method <blockquote><b>Valoracio</b></blockquote>  sense parametres.
	 */
	public Valoracio(){}


	/**
	 * Getter de l'identificador unic de la Valoracio.
	 * @return {Integer} Identificador unic de la Valoracio.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter de l'identificador unic de la Valoracio.
	 * @param id {Integer} Identificador unic de la Valoracio.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter de l'identificador unic de Dossier
	 * @return {Integer} Identificador unic o PrimaryKey del Dossier
	 */
	public int getIdDossier() {
		return idDossier;
	}
	/**
	 * Setter de l'identificador unic de Dossier
	 * @param idDossier {Integer} Identificador unic o PrimaryKey del Dossier
	 */
	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	/**
	 * Getter de identificador unic del Servei:
	 * @return {Integer} El identificador unic del servei
	 */
	public int getIdServei() {
		return idServei;
	}

	/**
	 * Setter de identificador unic del Servei:
	 * @param idServei {Integer} Identificador unic del servei
	 */
	public void setIdServei(int idServei) {
		this.idServei = idServei;
	}

	/**
	 * Getter de l'identificador unic del Parametre:
	 * @return {Integer} L'identificador unic del parametre
	 */
	public int getIdParam() {
		return idParam;
	}

	/**
	 * Setter de l'identificador unic del Parametre:
	 * @param idParam {Integer} Identificador unic del parametre
	 */
	public void setIdParam(int idParam) {
		this.idParam = idParam;
	}

	/**
	 * Getter del valor de Valoracio
	 * @return {Integer} {Integer} Puntuacio donada al parametre d'un servei d'un dossier. Valor enter entre 0 i 5.
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Setter del valor de la Valoracio
	 * @param valor {Integer} Puntuacio donada al parametre d'un servei d'un dossier. Valor enter entre 0 i 5.
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * Metode toString del Parametre per a possibles debuggings
	 * @return {String} Representacio textual de l'objecte Parametre
	 */
	@Override
	public String toString() {
		return "Valoracio [id=" + id + ", idDossier=" + idDossier + ", idServei=" + idServei + ", idParam=" + idParam
				+ ", valor=" + valor + "]";
	}
		
	
}
	
