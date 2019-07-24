package levy.daniel.application.model.metier.person;

import java.time.LocalDate;

/**
 * INTERFACE IPerson :<br/>
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
public interface IPerson {

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	String toString();

	
	
	/**
	 * getter de l' ID en base.<br/>
	 *
	 * @return : this.id : Long<br/>
	 */
	Long getId();


	
	/**
	 * setter de l' ID en base.<br/>
	 *
	 * @param pId : Long : valeur à passer à this.id.<br/>
	 */
	void setId(Long pId);


	
	/**
	 * getter de firstname.<br/>
	 *
	 * @return : String : this.firstname.<br/>
	 */
	String getFirstName();

	

	/**
	 * setter de firstname.<br/>
	 *
	 * @param pFirstName : String : 
	 * valeur à passer à this.firstName.<br/>
	 */
	void setFirstName(String pFirstName);


	
	/**
	 * getter de lastName.<br/>
	 *
	 * @return : this.lastName : String.<br/>
	 */
	String getLastName();

	

	/**
	 * setter de lastName.<br/>
	 *
	 * @param pLastName : String : 
	 * valeur à passer à this.lastname.<br/>
	 */
	void setLastName(String pLastName);


	
	/**
	 * Getter de birthDate.
	 *
	 * @return this.birthDate : LocalDate.<br/>
	 */
	LocalDate getBirthDate();


	
	/**
	* Setter de birthDate.
	*
	* @param pBirthDate : LocalDate : 
	* valeur à passer à this.birthDate.<br/>
	*/
	void setBirthDate(LocalDate pBirthDate);
	
	
	
} // FIN DE L'INTERFACE IPerson.---------------------------------------------
