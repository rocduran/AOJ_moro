package ad.uda.moro.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="ActivitatDossier")
@Table(name="activitatdossier")

public class ActivitatDossier implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Class <code><b>ActivitatDossier</b></code> 
	 * @author rduran & mmiret
	 *
	 */
	
	@Id @Column(name ="id", length=11) private int id;
	@Column(name = "idDossier", length=11) private int idDossier;
	@Column(name="idServei", length=11) private int idServei;
	
	public ActivitatDossier(int id, int idDossier, int idServei) {
		super();
		this.id = id;
		this.idDossier = idDossier;
		this.idServei = idServei;
	}
	
	public ActivitatDossier(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	public int getIdServei() {
		return idServei;
	}

	public void setIdServei(int idServei) {
		this.idServei = idServei;
	}

	@Override
	public String toString() {
		return "ActivitatDossier [id=" + id + ", idDossier=" + idDossier + ", idServei=" + idServei + "]";
	}
		
	
}
	
