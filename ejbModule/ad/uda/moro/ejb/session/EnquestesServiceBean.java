package ad.uda.moro.ejb.session;

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
import ad.uda.moro.ejb.entity.Parametre;
import ad.uda.moro.ejb.entity.Servei;
import ad.uda.moro.ejb.entity.Valoracio;

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
	public ActivitatDossier getActivitatDossierById(int id) throws MoroException {
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

		// Update the ActivitatDossier instance:
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
		ActivitatDossier a = this.getActivitatDossierById(id);
		if (!a.isValidActivitatDossierId())
			throw new MoroException("The specified code parameter [" + id + "] is not a valid code");

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

	@SuppressWarnings("unchecked")
	@Override
	public ActivitatDossier[] getServeisDossierList(int idDossier) throws MoroException {
		Dossier dossier = null;
		try {
			dossier = this.getDossierById(idDossier);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}

		Query query = em.createNamedQuery("dossiersById");
		query.setParameter("idDossier", dossier);
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

	@Override
	public void addDossier(Dossier dossier) throws MoroException {
		// Verify parameter:
		if (dossier == null)
			throw new MoroException("The specified dossier parameter is null");
		if (!dossier.hasValidInformation())
			throw new MoroException("The specified dossier parameter contains invalid information");

		// Add the instance:
		try {
			em.persist(dossier);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public Dossier getDossierById(int idDossier) throws MoroException {
		// Verify parameter:
		if (idDossier < 0)
			throw new MoroException("The parameter is negative !");
		try {
			return em.find(Dossier.class, idDossier);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public void addServei(Servei servei) throws MoroException {
		// Verify parameter:
		if (servei == null)
			throw new MoroException("The specified servei parameter is null");
		if (!servei.hasValidInformation())
			throw new MoroException("The specified servei parameter contains invalid information");

		// Add the instance:
		try {
			em.persist(servei);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public Servei getServeiById(int idServei) throws MoroException {
		// Verify parameter:
		if (idServei < 0)
			throw new MoroException("The parameter is negative !");
		try {
			return em.find(Servei.class, idServei);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public void addParametre(Parametre parametre) throws MoroException {
		// Verify parameter:
		if (parametre == null)
			throw new MoroException("The specified parametre parameter is null");
		if (!parametre.hasValidInformation())
			throw new MoroException("The specified parametre parameter contains invalid information");

		// Add the instance:
		try {
			em.persist(parametre);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public void addValoracio(Valoracio valoracio) throws MoroException {
		// Verify parameter:
		if (valoracio == null)
			throw new MoroException("The specified parametre parameter is null");
		if (!valoracio.hasValidInformation())
			throw new MoroException("The specified parametre parameter contains invalid information");

		// Add the instance:
		try {
			em.persist(valoracio);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public Parametre getParametreById(int idParam) throws MoroException {
		// Verify parameter:
		if (idParam < 0)
			throw new MoroException("The parameter is negative !");
		try {
			return em.find(Parametre.class, idParam);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Dossier[] getDossierList() throws MoroException {
		Query query = em.createNamedQuery("allDossier");
		List<Dossier> dossiers = null;
		try {
			dossiers = (List<Dossier>) query.getResultList();
			if (dossiers == null)
				return null;
			if (dossiers.size() == 0)
				return null;
			return dossiers.toArray(new Dossier[dossiers.size()]);
		} catch (NoResultException ex) {
			return null;
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Servei[] getServeiList() throws MoroException {
		Query query = em.createNamedQuery("allServei");
		List<Servei> serveis = null;
		try {
			serveis = (List<Servei>) query.getResultList();
			if (serveis == null)
				return null;
			if (serveis.size() == 0)
				return null;
			return serveis.toArray(new Servei[serveis.size()]);
		} catch (NoResultException ex) {
			return null;
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Parametre[] getParametreList() throws MoroException {
		Query query = em.createNamedQuery("allParametre");
		List<Parametre> parametres = null;
		try {
			parametres = (List<Parametre>) query.getResultList();
			if (parametres == null)
				return null;
			if (parametres.size() == 0)
				return null;
			return parametres.toArray(new Parametre[parametres.size()]);
		} catch (NoResultException ex) {
			return null;
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Valoracio[] getValoracioServei(int idServei) throws MoroException {
		Servei servei = null;
		try {
			servei = this.getServeiById(idServei);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}

		Query query = em.createNamedQuery("valoracioByIdServei");
		query.setParameter("idServei", servei);
		List<Valoracio> valoracions = null;
		try {
			valoracions = (List<Valoracio>) query.getResultList();
			if (valoracions == null)
				return null;
			if (valoracions.size() == 0)
				return null;
			return valoracions.toArray(new Valoracio[valoracions.size()]);
		} catch (NoResultException ex) {
			return null;
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Valoracio[] getValoracioParametre(int idParam) throws MoroException {
		Parametre parametre = null;
		try {
			parametre = this.getParametreById(idParam);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}

		Query query = em.createNamedQuery("valoracioByIdParametre");
		query.setParameter("idParam", parametre);
		List<Valoracio> valoracions = null;
		try {
			valoracions = (List<Valoracio>) query.getResultList();
			if (valoracions == null)
				return null;
			if (valoracions.size() == 0)
				return null;
			return valoracions.toArray(new Valoracio[valoracions.size()]);
		} catch (NoResultException ex) {
			return null;
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public void deleteDossier(int id) throws MoroException {
		// Verify parameter:
		if (id < 0)
			throw new MoroException("The specified id parameter is null");
		Dossier dossier = this.getDossierById(id);

		try {
			em.remove(dossier);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public void updateDossier(Dossier dossier) throws MoroException {
		// Check parameter:
		if (dossier == null)
			throw new MoroException("The specified Dossier parameter is null");
		if (!dossier.hasValidInformation())
			throw new MoroException(
					"The information in the specified Dossier parameter with id [" + dossier.getId() + "] is invalid");

		// Update the Dossier instance:
		try {
			em.merge(dossier);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public void deleteServei(int id) throws MoroException {
		// TODO mirar xq cony pete ! xD
		// Verify parameter:
		if (id < 0)
			throw new MoroException("The specified id parameter is null");
		Servei servei = this.getServeiById(id);

		try {
			em.remove(servei);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}
	}

	@Override
	public void updateServei(Servei servei) throws MoroException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteParametre(int id) throws MoroException {
		if (id < 0)
			throw new MoroException("The specified id parameter is null");
		Parametre parametre = this.getParametreById(id);

		try {
			em.remove(parametre);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}

	}

	@Override
	public void updateParametre(Parametre parametre) throws MoroException {
		// Check parameter:
		if (parametre == null)
			throw new MoroException("The specified Parametre parameter is null");
		if (!parametre.hasValidInformation())
			throw new MoroException(
					"The information in the specified Parametre parameter with id [" + parametre.getId() + "] is invalid");

		// Update the Dossier instance:
		try {
			em.merge(parametre);
		} catch (Exception ex) {
			throw new MoroException("Persistence error. Details: " + ex.getMessage());
		}

	}
}
