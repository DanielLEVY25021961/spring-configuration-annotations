package levy.daniel.application.model.dto.metier.product;

import java.io.Serializable;

/**
 * INTERFACE IProductDTO :<br/>
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
public interface IProductDTO extends Serializable {
	
	

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
	 * Getter du name du Product.<br/>
	 *
	 * @return name : String.<br/>
	 */
	String getNameString();


	
	/**
	* Setter du name du Product.<br/>
	*
	* @param pNameString : String : 
	* valeur à passer à this.nameString.<br/>
	*/
	void setNameString(String pNameString);

	
	
} // FIN DE L'INTERFACE IProductDTO.-----------------------------------------
