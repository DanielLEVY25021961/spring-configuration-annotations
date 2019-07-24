package levy.daniel.application.model.metier.societe;

import levy.daniel.application.model.metier.developpeur.IDeveloppeur;


/**
 * INTERFACE ISociete :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author adminLocal Lévy
 * @version 1.0
 * @since 12 nov. 2018
 *
 */
public interface ISociete {

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	String toString();


	
	/**
	 * Getter de l'ID en base.<br/>
	 *
	 * @return this.id : Long.<br/>
	 */
	Long getId();


	
	/**
	* Setter de l'ID en base.<br/>
	*
	* @param pId : Long : 
	* valeur à passer à this.id.<br/>
	*/
	void setId(Long pId);


	/**
	 * Getter .<br/>
	 *
	 * @return nomSociete : String.<br/>
	 */
	String getNomSociete();


	/**
	* .<br/>
	*
	* @param pNomSociete : String : 
	* valeur à passer à this.nomSociete.<br/>
	*/
	void setNomSociete(String pNomSociete);


	/**
	 * Getter .<br/>
	 *
	 * @return chefDeveloppeur : IDeveloppeur.<br/>
	 */
	IDeveloppeur getChefDeveloppeur();


	/**
	* .<br/>
	*
	* @param pChefDeveloppeur : IDeveloppeur : 
	* valeur à passer à this.chefDeveloppeur.<br/>
	*/
	void setChefDeveloppeur(IDeveloppeur pChefDeveloppeur);


	/**
	 * Getter .<br/>
	 *
	 * @return developpeur : IDeveloppeur.<br/>
	 */
	IDeveloppeur getDeveloppeur();


	/**
	* .<br/>
	*
	* @param pDeveloppeur : IDeveloppeur : 
	* valeur à passer à this.developpeur.<br/>
	*/
	void setDeveloppeur(IDeveloppeur pDeveloppeur);
	
	

} // FIN DE L'INTERFACE ISociete.------------------------------------------
