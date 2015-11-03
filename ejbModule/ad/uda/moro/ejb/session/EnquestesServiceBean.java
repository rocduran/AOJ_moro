package ad.uda.moro.ejb.session;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EnquestesServiceBean
 */
@Stateless
@Remote(EnquestesServiceRemote.class)
@LocalBean
public class EnquestesServiceBean implements EnquestesServiceRemote {

    /**
     * Default constructor. 
     */
    public EnquestesServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String helloWorld() {
		Date today = new Date();
		return "Today is: "+today.toString();
	}

}
