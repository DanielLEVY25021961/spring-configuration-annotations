package levy.daniel.application.model.dto.metier.person;

/**
 * INTERFACE IPersonDTO :<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 23 juil. 2019
 *
 */
public interface IPersonDTO {
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	String toString();


		
	/**
	 * getter de l'idString en base sous forme de String.<br/>
	 *
	 * @return : this.idString : Long<br/>
	 */
	String getIdString();

	

	/**
	 * setter de l'idString en base.<br/>
	 *
	 * @param pIdString : Long : 
	 * valeur à passer à this.idString.<br/>
	 */
	void setIdString(String pIdString);


	
	/**
	 * getter de firstNameString.<br/>
	 *
	 * @return : String : this.firstNameString.<br/>
	 */
	String getFirstNameString();


	
	/**
	 * setter de firstNameString.<br/>
	 *
	 * @param pFirstNameString : String : 
	 * valeur à passer à this.firstNameString.<br/>
	 */
	void setFirstNameString(String pFirstNameString);

	

	/**
	 * getter de lastNameString.<br/>
	 *
	 * @return : this.lastNameString : String.<br/>
	 */
	String getLastNameString();


	
	/**
	 * setter de lastNameString.<br/>
	 *
	 * @param pLastNameString : String : 
	 * valeur à passer à this.lastname.<br/>
	 */
	void setLastNameString(String pLastNameString);


	
	/**
	 * Getter de birthDateString.
	 *
	 * @return this.birthDateString : String.<br/>
	 */
	String getBirthDateString();


	
	/**
	* Setter de birthDateString.
	*
	* @param pBirthDateString : String : 
	* valeur à passer à this.birthDateString.<br/>
	*/
	void setBirthDateString(String pBirthDateString);
	
	
		
} // FIN DE L'INTERFACE IPersonDTO.------------------------------------------
