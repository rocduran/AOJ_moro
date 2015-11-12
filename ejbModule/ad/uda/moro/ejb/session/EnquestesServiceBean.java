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
import ad.uda.moro.ejb.entity.Dossier;
import ad.uda.moro.ejb.entity.Servei;

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
			throw new MoroException("The information in the specified activitatDossier parameter with id ["
					+ activitatDossier.getId() + "] is invalid");
		if (this.getActivitatDossier(activitatDossier.getId()) == null)
			throw new MoroException("The specified activitat code [" + activitatDossier.getId()
					+ "] does not represent an existent ActivitatDossier instance");

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
		Dossier dossier = getDossierById(id);
		if (!ActivitatDossier.isValidActivitatDossierId(dossier))
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

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public Servei[] getServeisDossierList(int idDossier) throws MoroException {
		return null;
//		// Verifiquem que el dossier amb id = idDossier existeixi
//		if (idDossier < 0)
//			throw new MoroException("The specified id parameter is null");
//		if (!ActivitatDossier.isValidActivitatDossierId(idDossier))
//			throw new MoroException("The specified code parameter [" + idDossier + "] is not a valid code");
//		if (this.getActivitatDossier(idDossier) == null)
//			throw new MoroException("The specified activitat code [" + idDossier
//					+ "] does not represent an existent ActivitatDossier instance");
//
//		// Si existeix el dossier, selecionem tots els idServei que tingui
//		// associats amb el seu idDossier
//		Query queryIdServeis = em.createNamedQuery("allServeisIdByDossierId");
//		queryIdServeis.setParameter("idDossier", idDossier);
//		List<Integer> idServeis = null;
//		try {
//			idServeis = (List<Integer>) queryIdServeis.getResultList();
//			if (idServeis == null)
//				return null;
//			if (idServeis.size() == 0)
//				return null;
//			idServeis.toArray(new Integer[idServeis.size()]);
//		} catch (NoResultException ex) {
//			return null;
//		} catch (Exception ex) {
//			throw new MoroException("Persistence error. Details: " + ex.getMessage());
//		}
//
//		// Selecionem tots el serveis que tinguin el seu id dins la taula
//		// idServeis
//		System.out.println(idServeis.size());
//		List<Servei> serveis = null;
//		try {
//			for (int i = 0; i < idServeis.size(); i++) {
//				Query query = em.createNamedQuery("serveiById");
//				query.setParameter("id", idServeis.get(i));
//				serveis.add(serveis.size(), (Servei) query.getSingleResult());
//			}
//			if (serveis.size() == 0)
//				return null;
//			return serveis.toArray(new Servei[serveis.size()]);
//		} catch (NoResultException ex) {
//			return null;
//		} catch (Exception ex) {
//			throw new MoroException("Persistence error. Details: " + ex.getMessage());
//		}

	}

	@Override
	public Dossier getDossierById(int idDossier) throws MoroException {
		Dossier dossier = null;
		try {
				Query query = em.createNamedQuery("dossierById");
				query.setParameter("id", idDossier);
				dossier = (Dossier) query.getSingleResult();
			return dossier;
		} catch (NoResultException ex) {
			return null;
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public Servei getServeiById(int idServei) throws MoroException {
		Servei servei = null;
		try {
				Query query = em.createNamedQuery("serveiById");
				query.setParameter("id", idServei);
				servei = (Servei) query.getSingleResult();
			return servei;
		} catch (NoResultException ex) {
			return null;
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}
}
