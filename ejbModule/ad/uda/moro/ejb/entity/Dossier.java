package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="Dossier")
@Table(name="dossier")

public class Dossier implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Class <code><b>Dossier</b></code> 
	 * @author rduran & mmiret
	 *
	 */
	
	@Id @Column(name ="id", length=11) private int id;
	@Column(name = "preu", length=11) private int preu;
	@Column(name="descripcio", length=255) private String descripcio;
	
	public Dossier(int id, int preu, String descripcio) {
		super();
		this.id = id;
		this.preu = preu;
		this.descripcio = descripcio;
	}
	
	public Dossier(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPreu() {
		return preu;
	}

	public void setPreu(int preu) {
		this.preu = preu;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	@Override
	public String toString() {
		return "Dossier [id=" + id + ", preu=" + preu + ", descripcio=" + descripcio + "]";
	}
	
	
	
	
}
	
