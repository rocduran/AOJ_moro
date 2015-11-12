package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Class <code><b>Valoracio</b></code>. <br>
 * Entity <code><b>Valoracio</b></code>. <br>
 * Taula persistency <code><b>parametres</b></code>
 * 
 * @author rduran &amp; mmiret
 */

@Entity(name = "Valoracio")
@Table(name = "valoracio")
@NamedQueries ( {
	@NamedQuery (
		name = "valoracioByIdServei",
		query = "FROM Valoracio v WHERE v.idServei = :idServei"
		),
	@NamedQuery (
			name = "valoracioByIdParametre",
			query = "FROM Valoracio v WHERE v.idParam = :idParam"
			)
})

public class Valoracio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private int id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idDossier")
	private Dossier idDossier;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idServei")
	private Servei idServei;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idParam")
	private Parametre idParam;

	@Column(name = "valor", length = 11)
	private int valor;

	/**
	 * Constructor method de <blockquote><b>Valoració</b></blockquote> amb
	 * parametres:
	 * 
	 * @param id
	 *            {Integer} Identificador unic d'una valoració
	 * @param idDossier
	 *            {Integer} Identificador unic d'un dossier
	 * @param idServei
	 *            {Integer} Identificador unic d'un servei
	 * @param idParam
	 *            {Integer} Identificador unic d'un parametre
	 * @param valor
	 *            {Integer} Puntuacio donada al parametre d'un servei d'un
	 *            dossier. Valor enter entre 0 i 5.
	 */
	public Valoracio(Dossier idDossier, Servei idServei, Parametre idParam, int valor) {
		super();
		this.idDossier = idDossier;
		this.idServei = idServei;
		this.idParam = idParam;
		this.valor = valor;
	}

	/**
	 * Constructor method <blockquote><b>Valoracio</b></blockquote> sense
	 * parametres.
	 */
	public Valoracio() {
	}

	/**
	 * Getter de l'identificador unic de la Valoracio.
	 * 
	 * @return {Integer} Identificador unic de la Valoracio.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter de l'identificador unic de Dossier
	 * 
	 * @return {Integer} Identificador unic o PrimaryKey del Dossier
	 */
	public Dossier getIdDossier() {
		return idDossier;
	}

	/**
	 * Setter de l'identificador unic de Dossier
	 * 
	 * @param idDossier
	 *            {Integer} Identificador unic o PrimaryKey del Dossier
	 */
	public void setIdDossier(Dossier idDossier) {
		this.idDossier = idDossier;
	}

	/**
	 * Getter de identificador unic del Servei:
	 * 
	 * @return {Integer} El identificador unic del servei
	 */
	public Servei getIdServei() {
		return idServei;
	}

	/**
	 * Setter de identificador unic del Servei:
	 * 
	 * @param idServei
	 *            {Integer} Identificador unic del servei
	 */
	public void setIdServei(Servei idServei) {
		this.idServei = idServei;
	}

	/**
	 * Getter de l'identificador unic del Parametre:
	 * 
	 * @return {Integer} L'identificador unic del parametre
	 */
	public Parametre getIdParam() {
		return idParam;
	}

	/**
	 * Setter de l'identificador unic del Parametre:
	 * 
	 * @param idParam
	 *            {Integer} Identificador unic del parametre
	 */
	public void setIdParam(Parametre idParam) {
		this.idParam = idParam;
	}

	/**
	 * Getter del valor de Valoracio
	 * 
	 * @return {Integer} {Integer} Puntuacio donada al parametre d'un servei
	 *         d'un dossier. Valor enter entre 0 i 5.
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Setter del valor de la Valoracio
	 * 
	 * @param valor
	 *            {Integer} Puntuacio donada al parametre d'un servei d'un
	 *            dossier. Valor enter entre 0 i 5.
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * Metode toString del Parametre per a possibles debuggings
	 * 
	 * @return {String} Representacio textual de l'objecte Parametre
	 */
	@Override
	public String toString() {
		return "Valoracio [id=" + id + ", idDossier=" + idDossier.getId() + ", idServei=" + idServei.getId() + ", idParam=" + idParam.getId()
				+ ", valor=" + valor + "]";
	}

	public boolean hasValidInformation() {
		return (this.idDossier.hasValidInformation() && this.idServei.hasValidInformation()
				&& this.idParam.hasValidInformation() && 0 < this.valor && this.valor <= 5);
	}

}
