package ad.uda.moro.ejb.session;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
				// Get the Language instance:
				try {
					return em.find(ActivitatDossier.class, id);
				} catch (Exception ex) {
					throw new MoroException("Persistence error. Details: " + ex.getMessage());
				}
	}

	@Override
	public void addActivitatDossier(ActivitatDossier activitatDossier) throws MoroException {
		// Verify parameter:
		if (activitatDossier == null)
			throw new MoroException("The specified activitatDossier parameter is null");
		if (!activitatDossier.hasValidInformation())
			throw new MoroException("The specified activitatDossier parameter contains invalid information");
		if (this.getActivitatDossier(activitatDossier.getId()) != null) // Language exists
			throw new MoroException("An actvitatDossier with code [" + activitatDossier.getId() + "] already exists");
				
		// Add the instance:
		try {
					em.persist(activitatDossier);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
		
	}

	@Override
	public void updateActivitatDossier(ActivitatDossier activitatDossier) throws MoroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteActivitatDossier(int id) throws MoroException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ActivitatDossier[] getActivitatDossierList() throws MoroException {
		// Create a named query to obtain the collection of languages:
				Query query = em.createNamedQuery("allActivitatDossier"); // The query to use and specified in Entity "Language"
				List<ActivitatDossier> actDos = null; // Will contain the query result
				try {
					actDos = (List<ActivitatDossier>)query.getResultList(); // Get the List
					if (actDos == null) return null; // Result could be null
					if (actDos.size() == 0) return null; // Result could be empty
					return actDos.toArray(new ActivitatDossier[actDos.size()]); // return the collection as an array
				} catch (NoResultException ex) { // In case this exception is thrown...
					return null;
				} catch (Exception ex) { // Any other error
					throw new MoroException("Persistence error. Details: " + ex.getMessage());
				}
	}

}
