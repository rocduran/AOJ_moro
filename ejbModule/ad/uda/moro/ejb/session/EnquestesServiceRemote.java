package ad.uda.moro.ejb.session;

import javax.ejb.Remote;

import ad.uda.moro.MoroException;
import ad.uda.moro.ejb.entity.ActivitatDossier;
import ad.uda.moro.ejb.entity.Dossier;
import ad.uda.moro.ejb.entity.Parametre;
import ad.uda.moro.ejb.entity.Servei;
import ad.uda.moro.ejb.entity.Valoracio;

@Remote
public interface EnquestesServiceRemote {

	/*
	 * CRUD ActivitatDossier
	 */

	// TODO UPDATE JavaDoc

	/**
	 * Afegeix una nova instancia d'<code>ActivitatDossier</code> a la capa de
	 * persistencia.
	 * 
	 * @param activitatDossier
	 *            {ActivitatDossier} La instancia a afegir. Ha de ser valid i
	 *            amb totes les dades complertes.
	 * @throws MoroException
	 *             Si la instancia donada es invalida, <code>null</code>, ja
	 *             existeix o si hi ha un error de la capa de persistencia.
	 */
	public void addActivitatDossier(ActivitatDossier activitatDossier) throws MoroException;

	/**
	 * Afegeix una nova instancia de <code>Dossier</code> a la capa de
	 * persistencia.
	 * 
	 * @param dossier
	 *            {Dossier} La instancia a afegir. Ha de ser valid i amb totes
	 *            les dades completes.
	 * @throws MoroException
	 *             Si la instancia donada es invalida, <code>null</code>, ja
	 *             existeix o si hi ha un error de la capa de persistencia.
	 */
	public void addDossier(Dossier dossier) throws MoroException;

	/**
	 * Afegeix una nova instancia de <code>Parametre</code> a la capa de
	 * persistencia.
	 * 
	 * @param parametre
	 *            {Parametre} La instancia a afegir. Ha de ser valid i amb totes
	 *            les dades completes.
	 * @throws MoroException
	 *             Si la instancia donada es invalida, <code>null</code>, ja
	 *             existeix o si hi ha un error de la capa de persistencia.
	 */
	public void addParametre(Parametre parametre) throws MoroException;

	/**
	 * Afegeix una nova instancia de <code>Servei</code> a la capa de
	 * persistencia.
	 * 
	 * @param servei
	 *            {servei} La instancia a afegir. Ha de ser valid i amb totes
	 *            les dades completes.
	 * @throws MoroException
	 *             Si la instancia donada es invalida, <code>null</code>, ja
	 *             existeix o si hi ha un error de la capa de persistencia.
	 */
	public void addServei(Servei servei) throws MoroException;

	/*
	 * Llistats dels entities
	 */

	/**
	 * Afegeix una nova instancia de <code>Valoracio</code> a la capa de
	 * persistencia.
	 * 
	 * @param valoracio
	 *            {Valoracio} La instancia a afegir. Ha de ser valid i amb totes
	 *            les dades completes.
	 * @throws MoroException
	 *             Si la instancia donada es invalida, <code>null</code>, ja
	 *             existeix o si hi ha un error de la capa de persistencia.
	 */
	public void addValoracio(Valoracio valoracio) throws MoroException;

	/**
	 * Borra una instancia d' <code>ActivitatDossier</code> de la capa de
	 * persistencia.
	 * 
	 * @param id
	 *            {Integer} L'identificador d'<code>ActivitatDossier</code> a
	 *            borrar.
	 * @throws MoroException
	 *             Si un ActivitatDossier amb l'identificador especificat no existeix
	 *             o si hi ha un error de la capa de persistencia.
	 */
	public void deleteActivitatDossier(int id) throws MoroException;

	/*
	 * Altres
	 */
	
	//TODO CRUD Valoracio i servei

	/**
	 * Borra una instancia de <code>Dossier</code> de la capa de
	 * persistencia.
	 * 
	 * @param id
	 *            {Integer} L'identificador d'<code>Dossier</code> a
	 *            borrar.
	 * @throws MoroException
	 *             Si un Dossier amb l'identificador especificat no existeix
	 *             o o si hi ha un error de la capa de persistencia.
	 */
	public void deleteDossier(int id) throws MoroException;

	/**
	 * Borra una instancia de <code>Parametre</code> de la capa de
	 * persistencia.
	 * 
	 * @param id
	 *            {Integer} L'identificador d'<code>Parametre</code> a
	 *            borrar.
	 * @throws MoroException
	 *             Si un Parametre amb l'identificador especificat no existeix
	 *             o o si hi ha un error de la capa de persistencia.
	 */
	public void deleteParametre(int id) throws MoroException;

	/**
	 * Borra una instancia de <code>Servei</code> de la capa de
	 * persistencia.
	 * 
	 * @param id
	 *            {Integer} L'identificador d'<code>Servei</code> a
	 *            borrar.
	 * @throws MoroException
	 *             Si un Servei amb l'identificador especificat no existeix
	 *             o o si hi ha un error de la capa de persistencia.
	 */
	public void deleteServei(int id) throws MoroException;
	
	/**
	 * Borra una instancia de <code>Valoracio</code> de la capa de
	 * persistencia.
	 * 
	 * @param id
	 *            {Integer} L'identificador de la<code>Valoracio</code> a
	 *            borrar.
	 * @throws MoroException
	 *             Si una Valoracio amb l'identificador especificat no existeix
	 *             o o si hi ha un error de la capa de persistencia.
	 */
	public void deleteValoracio(int id) throws MoroException;

	/**
	 * Retorna una instancia d'<code>ActivitatDossier</code> amb l'identificador
	 * especificat.
	 * 
	 * @param id
	 *            {Integer} L'identificador únic d'activitatDossier. Ha de ser
	 *            un identificador valid.
	 * @return L'<code>ActivitatDossier</code> amb l'identificador especificat o
	 *         <b>null</b> si l'ActivitatDossier no s'ha trobat.
	 * @throws MoroException
	 *             Si hi ha un error a la capa de persistencia.
	 */
	public ActivitatDossier getActivitatDossierById(int id) throws MoroException;

	/**
	 * Retorna totes les intancies d'<code>ActivitatDossier</code> de la capa de
	 * persitencia, ordenat per l'identificador del <code>Dossier</code>.
	 * 
	 * @return {ActivitatDossier[]} Un array d'instancies d'
	 *         <code>ActivitatDossier</code> o <b>null</b> si no hi ha cap
	 *         <code>ActivitatDossier</code> a la capa de persistencia.
	 * @throws MoroException
	 *             Si hi ha un error de la capa de persistencia.
	 */
	public ActivitatDossier[] getActivitatDossierList() throws MoroException;

	/**
	 * Retorna una entitat de <code>Dossier</code> a partir de un id donat
	 * 
	 * @param idDossier
	 *            PK del dossier que busquem
	 * @return Entitat de Dossier buscada
	 * @throws MoroException Llança MoroException
	 */
	public Dossier getDossierById(int idDossier) throws MoroException;

	/**
	 * Retorna totes les intancies de <code>Dossier</code> de la capa de
	 * persitencia,
	 * 
	 * @return {Dossiers[]} Un array d'instancies de <code>Dossier</code> o
	 *         <b>null</b> si no hi ha cap <code>Dossier</code> a la capa de
	 *         persistencia.
	 * @throws MoroException
	 *             Si hi ha un error de la capa de persistencia.
	 */
	public Dossier[] getDossierList() throws MoroException;

	/**
	 * Retorna una entitat de <code>Parametre</code> a partir de un id donat
	 * 
	 * @param idParam
	 *            PK del servei que busquem
	 * @return Entitat de Parametre buscada
	 * @throws MoroException Llança MoroException
	 */
	public Parametre getParametreById(int idParam) throws MoroException;

	/**
	 * Retorna totes les intancies de <code>Parametre</code> de la capa de
	 * persitencia,
	 * 
	 * @return {Parametre[]} Un array d'instancies de <code>Parametre</code> o
	 *         <b>null</b> si no hi ha cap <code>Parametre</code> a la capa de
	 *         persistencia.
	 * @throws MoroException
	 *             Si hi ha un error de la capa de persistencia.
	 */
	public Parametre[] getParametreList() throws MoroException;

	/**
	 * Retorna una entitat de <code>Servei</code> a partir de un id donat
	 * 
	 * @param idServei
	 *            PK del servei que busquem
	 * @return Entitat de Servei buscada
	 * @throws MoroException Llança MoroException
	 */
	public Servei getServeiById(int idServei) throws MoroException;

	/**
	 * Retorna totes les intancies de <code>Servei</code> de la capa de
	 * persitencia,
	 * 
	 * @return {Servei[]} Un array d'instancies de <code>Servei</code> o
	 *         <b>null</b> si no hi ha cap <code>Servei</code> a la capa de
	 *         persistencia.
	 * @throws MoroException
	 *             Si hi ha un error de la capa de persistencia.
	 */
	public Servei[] getServeiList() throws MoroException;

	/**
	 * Retorna totes les instancies de <code>Servei</code> d'un dossier amb
	 * idDossier = id
	 * @param idDossier {Integer} Identificador del dossier
	 * 
	 * @return {Servei[]} un array d'instances de <code>Servei</code> o
	 *         <b>null</b> si no en hi cap o no existeix el Dossier amb
	 *         idDossier = dossier
	 * @throws MoroException Llança MoroException
	 */
	public ActivitatDossier[] getServeisDossierList(int idDossier) throws MoroException;
	
	/**
	 * Retorna una entitat de <code>Valoracio</code> a partir de un id donat
	 * 
	 * @param idValoracio
	 *            PK de la valoracio que busquem
	 * @return Entitat de Valoracio buscada
	 * @throws MoroException Llança MoroException
	 */
	public Valoracio getValoracioById(int idValoracio) throws MoroException;
	
	/**
	 * Retorna totes les intancies de <code>Valoracio</code> de la capa de
	 * persitencia,
	 * 
	 * @return {Valoracio[]} Un array d'instancies de <code>Valoracio</code> o
	 *         <b>null</b> si no hi ha cap <code>Valoracio</code> a la capa de
	 *         persistencia.
	 * @throws MoroException
	 *             Si hi ha un error de la capa de persistencia.
	 */
	public Valoracio[] getValoracioList() throws MoroException;

	/**
	 * Retorna totes les intancies de <code>Valoracio</code> del parametre amb
	 * <code>idParam</code>
	 * 
	 * @param idParam {int}
	 *            identificador del parametre
	 * 
	 * @return {Valoracio[]} Un array d'instancies de <code>Valoracio</code> o
	 *         <b>null</b> si no hi ha cap <code>Valoracio</code> a la capa de
	 *         persistencia.
	 * @throws MoroException
	 *             Si hi ha un error de la capa de persistencia.
	 */
	public Valoracio[] getValoracioParametre(int idParam) throws MoroException;

	/**
	 * Retorna una llista de <code>Valoracio</code> del servei amb
	 * <code>idServei</code>
	 * 
	 * @param idServei
	 *            {int} identificador del servei
	 * @return {Valoracio[]} Un array d'instancies de <code>Valoracio</code> o
	 *         <b>null</b> si no hi ha cap <code>Valoracio</code> a la capa de
	 *         persistencia.
	 * @throws MoroException
	 *             Si hi ha un error de la capa de persistencia.
	 */
	public Valoracio[] getValoracioServei(int idServei) throws MoroException;
	
	/**
	 * Actualitza una instancia d'<code>ActivitatDossier</code> a la capa de
	 * persistència.
	 * 
	 * @param activitatDossier
	 *            {ActivitatDossier} La instancia d'
	 *            <code>ActivitatDossier</code> a actualitzar. 
	 * @throws MoroException
	 *             Si l'ActivitatDossier conte informacio invalida o no
	 *             existeix. Tambe llança una Exception si hi ha un error de
	 *             persistència.
	 */
	public void updateActivitatDossier(ActivitatDossier activitatDossier) throws MoroException;

	/**
	 * Actualitza una instancia de <code>Dossier</code> a la capa de
	 * persistència.
	 * 
	 * @param dossier
	 *            {Dossier} La instancia de 
	 *            <code>Dossier</code> a actualitzar.
	 * @throws MoroException
	 *             Si el Dossier conte informacio invalida o no
	 *             existeix. També llança una Exception si hi ha un error de
	 *             persistència.
	 */
	public void updateDossier(Dossier dossier) throws MoroException;

	/**
	 * Actualitza una instancia de <code>Parametre</code> a la capa de
	 * persistència.
	 * 
	 * @param parametre
	 *            {Parametre} La instancia de 
	 *            <code>Parametre</code> a actualitzar.
	 * @throws MoroException
	 *             Si el Parametre conte informacio invalida o no
	 *             existeix. També llança una Exception si hi ha un error de
	 *             persistència.
	 */
	public void updateParametre(Parametre parametre) throws MoroException;

	/**
	 * Actualitza una instancia de <code>Dossier</code> a la capa de
	 * persistència.
	 * 
	 * @param servei
	 *            {Servei} La instancia de 
	 *            <code>Servei</code> a actualitzar.
	 * @throws MoroException
	 *             Si el Servei conte informacio invalida o no
	 *             existeix. També llança una Exception si hi ha un error de
	 *             persistència.
	 */
	public void updateServei(Servei servei) throws MoroException;
	
	/**
	 * Actualitza una instancia de <code>Valoracio</code> a la capa de
	 * persistència.
	 * 
	 * @param valoracio
	 *            {Valoracio} La instancia de 
	 *            <code>Valoracio</code> a actualitzar.
	 * @throws MoroException
	 *             Si la Valoracio conte informacio invalida o no
	 *             existeix. També llança una Exception si hi ha un error de
	 *             persistència.
	 */
	public void updateValoracio(Valoracio valoracio) throws MoroException;

}
