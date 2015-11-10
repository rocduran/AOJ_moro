package ad.uda.moro.ejb.session;

import java.util.ArrayList;

import javax.ejb.Remote;

import ad.uda.moro.MoroException;
import ad.uda.moro.ejb.entity.ActivitatDossier;

@Remote
public interface EnquestesServiceRemote {
	
	/**
	 * Testing
	 * @return an string with a "Hello world!" String.
	 */
	public String helloWorld();

	/*
	 *  CRUD ActivitatDossier
	 */
	
	//TODO UPDATE JavaDoc
	
	/**
	 * Retorna una instancia d'<code>ActivitatDossier</code> amb l'id especificat.
	 * @param id {Integer} L'identificador únic d'activitatDossier. Ha de ser un identificador valid.
	 * @return L'<code>ActivitatDossier</code> amb l'id especificat o <b>null</b> si l'ActivitatDossier no s'ha trobat.
	 * @throws MoroException Si hi ha un error a la capa de persistencia.
	 */
	public ActivitatDossier getActivitatDossier(int id) throws MoroException;
	
	/**
	 * Afegeix una nova instancia d'<code>ActivitatDossier</code> a la capa de persistencia.
	 * @param activitatDossier {ActivitatDossier} La instancia a afegir. Ha de ser valid i amb totes les dades completes.
	 * @throws MoroException Si la instancia donada es invalida, <code>null</code>, ja existeix o si hi ha un error de la capa de persistencia.
	 */
	public void addActivitatDossier(ActivitatDossier activitatDossier) throws MoroException;
	
	/**
	 * Actualitza una instancia d'<code>ActivitatDossier</code> a la capa de persistència.
	 * @param activitatDossier {ActivitatDossier} La instancia d'<code>ActivitatDossier</code> a actualitzar. L'identificador (id) de la instancia
	 * es farà servir per trobar l'ActivitatDossier a actualitzar
	 * @throws MoroException Si l'ActivitatDossier conte informacio invalida o no existeix. També llança una Exception
	 * si hi ha un error de persistència.
	 */
	public void updateActivitatDossier(ActivitatDossier activitatDossier) throws MoroException;
	
	/**
	 * Borra una instancia d' <code>ActivitatDossier</code> de la capa de persistencia. 
	 * @param id {Integer} L'identificador d'<code>ActivitatDossier</code> a borrar.
	 * @throws MoroException Si un establiment amb l'identificador especificat no existeix o o si hi ha un error de la capa de persistencia.
	 */
	public void deleteActivitatDossier(int id) throws MoroException;
	
	/*
	 * Llistats dels entities
	 */
	
	//TODO Llistats de Servei_Dossier, Valoracio_Servei, Valoracio_Parametre
	
	/**
	 * Retorna totes les intancies d'<code>ActivitatDossier</code> de la capa de persitencia, ordenat per l'identificador del <code>Dossier</code>.
	 * @return {ActivitatDossier[]} Un array d'instancies d'<code>ActivitatDossier</code> o <b>null</b> si no hi ha cap <code>ActivitatDossier</code> 
	 * a la capa de persistencia.
	 * @throws MoroException Si hi ha un error de la capa de persistencia.
	 */
	public ActivitatDossier[] getActivitatDossierList() throws MoroException;
	
	//TODO Altres (crud de tots perque som els putos amos).
}
