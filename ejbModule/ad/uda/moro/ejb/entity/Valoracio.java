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
	
	@Id @Column(name ="id", length=11) private int id;
	@Column(name = "idDossier", length=11) private int idDossier;
	@Column(name="idServei", length=11) private int idServei;
	@Column(name="idParam", length=11) private int idParam;
	@Column(name="valor", length=11) private int valor;
	
	/**
	 * Constructor method de <blockquote><b>Valoració</b></blockquote> amb paràmetres:
	 * @param  id        {Integer} Identificador únic d'una valoració
	 * @param  idDossier {Integer} Identificador únic d'un dossier
	 * @param  idServei  {Integer} Identificador únic d'un servei
	 * @param  idParam   {Integer} Identificador únic d'un parametre
	 * @param  valor     {Integer} Puntuació donada al parametre d'un servei d'un dossier. Valor enter entre 0 i 5.
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
	 * Getter de l'identificador únic de la Valoració.
	 * @return {Integer} Identificador únic de la Valoració.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter de l'identificador únic de la Valoració.
	 * @param id {Integer} Identificador únic de la Valoració.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter de l'identificador únic de Dossier
	 * @return {Integer} Identificador únic o PrimaryKey del Dossier
	 */
	public int getIdDossier() {
		return idDossier;
	}
	/**
	 * Setter de l'identificador únic de Dossier
	 * @param idDossier {Integer} Identificador únic o PrimaryKey del Dossier
	 */
	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	/**
	 * Getter de identificador únic del Servei:
	 * @return {Integer} El identificador únic del servei
	 */
	public int getIdServei() {
		return idServei;
	}

	/**
	 * Setter de identificador únic del Servei:
	 * @param idServei {Integer} Identificador únic del servei
	 */
	public void setIdServei(int idServei) {
		this.idServei = idServei;
	}

	/**
	 * Getter de l'identificador únic del Parametre:
	 * @return {Integer} L'identificador únic del parametre
	 */
	public int getIdParam() {
		return idParam;
	}

	/**
	 * Setter de l'identificador únic del Parametre:
	 * @param idParam {Integer} Identificador únic del parametre
	 */
	public void setIdParam(int idParam) {
		this.idParam = idParam;
	}

	/**
	 * Getter del valor de Valoració
	 * @return {Integer} {Integer} Puntuació donada al parametre d'un servei d'un dossier. Valor enter entre 0 i 5.
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Setter del valor de la Valoració
	 * @param valor {Integer} Puntuació donada al parametre d'un servei d'un dossier. Valor enter entre 0 i 5.
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * Mètode toString del Parametre per a possibles debuggings
	 * @return {String} Representació textual de l'objecte Parametre
	 */
	@Override
	public String toString() {
		return "Valoracio [id=" + id + ", idDossier=" + idDossier + ", idServei=" + idServei + ", idParam=" + idParam
				+ ", valor=" + valor + "]";
	}
		
	
}
	
