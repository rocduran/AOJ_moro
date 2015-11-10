package ad.uda.moro.ejb.session;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ad.uda.moro.MoroException;
import ad.uda.moro.ejb.entity.ActivitatDossier;

/**
 * Session Bean implementation class EnquestesServiceBean
 */
@Stateless
@Remote(EnquestesServiceRemote.class)
@LocalBean
public class EnquestesServiceBean implements EnquestesServiceRemote {
	
	@PersistenceContext(unitName = "MoroPU")
    private EntityManager em;
	
	@Override
	public String helloWorld() {
		Date today = new Date();
		return "Today is: "+today.toString();
	}

	@Override
	public ActivitatDossier getActivitatDossier(int id) throws MoroException {
		// Verify parameter:
				if (id < 0)
					throw new MoroException("The parameter is negative !");
				System.out.println("HOLA");
				// Get the Language instance:
				try {
					return em.find(ActivitatDossier.class, id);
				} catch (Exception ex) {
					throw new MoroException("Persistence error. Details: " + ex.getMessage());
				}
	}

	@Override
	public void addActivitatDossier(ActivitatDossier activitatDossier) throws MoroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateActivitatDossier(ActivitatDossier activitatDossier) throws MoroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteActivitatDossier(int id) throws MoroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActivitatDossier[] getEstablishmentListOrderedByName() throws MoroException {
		// TODO Auto-generated method stub
		return null;
	}

}
