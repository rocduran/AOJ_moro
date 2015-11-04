package ad.uda.moro;

/**
 * Class <code><b>CommonUtilities</b></code> is a tool box for developers who use the PlaygroundEJB
 * module. It contains useful methods to locate Session interfaces, using RMI and to perform
 * basic operations, like formatting and transforming information.
 * <p>
 * The methods in this <b>final</b> class can be called directly from the Class. Instantiating
 * is not necessary.
 * @author Alexander Beening Jansen - PA3CLV / C33AB
 */
public class CommonUtilities {

	/**
	 * Returns the complete name to use to look up a remote EJB session bean from a remote client.
	 * @param beanName The name of the bean implementation. Example: "<code><b>SomeServiceBean</b></code>"
	 * @param interfaceName The full classified name of the session interface.
	 * Example: "<code><b>ad.playground.ejb.session.SomeService</b></code>". This name can be obtained by
	 * using the expression:
	 * <blockquote>
	 *     <font color="navy" size="3"><code><b>
	 *     ClassName.class.getName(); -- <font color="black">Example: </font><font color="maroon">SomeServiceRemote.class.getname();
	 *     </font></b></code></font>
	 * </blockquote>
	 * @return The name as it can be used to perform a remote lookup.<br/>
	 * Example: <blockquote><font color="maroon" size="3">
	 * <code><b>ejb:/PlayGroundEJB//SomeServiceBean!ad.playground.ejb.session.SomeServiceRemote</b></code>
	 * </font></blockquote>
	 * Returns <b>null</b> if invalid parameters have been specified or if the EJB could not be located.
	 */
	
	//TODO Afegir 3 final statics amb el tipus de servei. Per exemple: 1 = Guia, 2 = Hotel,etc... 
	
	public static String getLookupEJBName(String beanName, String interfaceName) {
    	
        String appName = ""; // There is no EAR name
        String distinctName = ""; // No distinct name specified

        // Create a look up string name and return it:
        StringBuilder nameBuilder = new StringBuilder("ejb:");
        nameBuilder.append(appName);
        nameBuilder.append('/');
        nameBuilder.append("Moro");
        nameBuilder.append('/');
        nameBuilder.append(distinctName);
        nameBuilder.append('/');
        nameBuilder.append(beanName);
        nameBuilder.append('!');
        nameBuilder.append(interfaceName);
        
        return nameBuilder.toString();
    }
	

}
