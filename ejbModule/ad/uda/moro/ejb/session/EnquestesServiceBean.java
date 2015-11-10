package ad.uda.moro.ejb.session;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import ad.uda.moro.MoroException;
import ad.uda.moro.ejb.entity.ActivitatDossier;

/**
 * Session Bean implementation class EnquestesServiceBean
 */
@Stateless
@Remote(EnquestesServiceRemote.class)
@LocalBean
public class EnquestesServiceBean implements EnquestesServiceRemote {

	@Override
	public String helloWorld() {
		Date today = new Date();
		return "Today is: "+today.toString();
	}

	@Override
	public ActivitatDossier getActivitatDossier(int id) throws MoroException {
		// TODO Auto-generated method stub
		return null;
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
