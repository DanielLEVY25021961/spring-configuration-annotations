package levy.daniel.application.model.metier.product;


/**
 * INTERFACE IProduct :<br/>
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
public interface IProduct {
	
	

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
	 * Getter du name du Product.<br/>
	 *
	 * @return name : String.<br/>
	 */
	String getName();


	
	/**
	* Setter du name du Product.<br/>
	*
	* @param pName : String : 
	* valeur à passer à this.name.<br/>
	*/
	void setName(String pName);

	
	
} // FIN DE L'INTERFACE IProduct.--------------------------------------------
