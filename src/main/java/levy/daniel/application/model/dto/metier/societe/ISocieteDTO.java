package levy.daniel.application.model.dto.metier.societe;

import java.io.Serializable;

import levy.daniel.application.model.dto.metier.developpeur.IDeveloppeurDTO;

/**
 * INTERFACE ISocieteDTO :<br/>
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
 * @since 14 nov. 2018
 *
 */
public interface ISocieteDTO extends Serializable {

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	String toString();

	
	
	/**
	 * Getter de l'ID en base sous forme de String.<br/>
	 *
	 * @return this.idString : String.<br/>
	 */
	String getIdString();


	
	/**
	* Setter de l'ID en base sous forme de String.<br/>
	*
	* @param pIdString : String : 
	* valeur à passer à this.idString.<br/>
	*/
	void setIdString(String pIdString);

	

	/**
	 * Getter du nomSocieteString.<br/>
	 *
	 * @return this.nomSocieteString : String.<br/>
	 */
	String getNomSocieteString();
	
	
	
	/**
	 * Setter du nomSocieteString.<br/>
	 *
	 * @param pNomSocieteString : String : 
	 * valeur à passer à this.nomSocieteString.<br/>
	 */
	void setNomSocieteString(String pNomSocieteString);
	
	
	
	/**
	 * Getter du chefDeveloppeurDTO.<br/>
	 *
	 * @return this.chefDeveloppeurDTO : IDeveloppeurDTO.<br/>
	 */
	IDeveloppeurDTO getChefDeveloppeurDTO();


	
	/**
	* Setter du chefDeveloppeurDTO.<br/>
	*
	* @param pChefDeveloppeurDTO : IDeveloppeurDTO : 
	* valeur à passer à this.chefDeveloppeurDTO.<br/>
	*/
	void setChefDeveloppeurDTO(
			IDeveloppeurDTO pChefDeveloppeurDTO);


	
	/**
	 * Getter du developpeurDTO.<br/>
	 *
	 * @return this.developpeurDTO : IDeveloppeurDTO.<br/>
	 */
	IDeveloppeurDTO getDeveloppeurDTO();


	
	/**
	* Setter du developpeurDTO..<br/>
	*
	* @param pDeveloppeurDTO : IDeveloppeurDTO : 
	* valeur à passer à this.developpeurDTO.<br/>
	*/
	void setDeveloppeurDTO(
			IDeveloppeurDTO pDeveloppeurDTO);



} // FIN DE L'INTERFACE ISocieteDTO.-----------------------------------------
