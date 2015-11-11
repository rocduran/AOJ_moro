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
		return "Today is: " + today.toString();
	}

	@Override
	public ActivitatDossier getActivitatDossier(int id) throws MoroException {
		// Verify parameter:
		if (id < 0)
			throw new MoroException("The parameter is negative !");

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
		if (this.getActivitatDossier(activitatDossier.getId()) != null) 
																		
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
		// Check parameter:
    	if (activitatDossier == null)
    		throw new MoroException("The specified activitatDossier parameter is null");
    	if (!activitatDossier.hasValidInformation())
    		throw new MoroException("The information in the specified activitatDossier parameter with id [" + activitatDossier.getId() + "] is invalid");
    	if (this.getActivitatDossier(activitatDossier.getId()) == null)
    		throw new MoroException("The specified activitat code [" + activitatDossier.getId() + "] does not represent an existent ActivitatDossier instance");
    	
    	// Update the Establishment instance:
    	try {
    		em.merge(activitatDossier);
    	} catch (Exception ex) {
    		throw new MoroException("Persistence error. Details: " + ex.getMessage());
    	}

	}

	@Override
	public void deleteActivitatDossier(int id) throws MoroException {
		// Verify parameter:
		if (id < 0)
			throw new MoroException("The specified id parameter is null");
		if (!ActivitatDossier.isValidActivitatDossierId(id))
			throw new MoroException("The specified code parameter [" + id + "] is not a valid code");
		ActivitatDossier a = this.getActivitatDossier(id);

		if (a == null)
			throw new MoroException("An ActivitatDossier with code [" + id + "] does not exist");

		try {
			em.remove(a);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public ActivitatDossier[] getActivitatDossierList() throws MoroException {
		Query query = em.createNamedQuery("allActivitatDossier"); 
		List<ActivitatDossier> actDos = null;
		try {
			actDos = (List<ActivitatDossier>) query.getResultList(); 
			if (actDos == null)
				return null; 
			if (actDos.size() == 0)
				return null;
			return actDos.toArray(new ActivitatDossier[actDos.size()]); 
		} catch (NoResultException ex) { 
			return null;
		} catch (Exception ex) { 
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}
}
