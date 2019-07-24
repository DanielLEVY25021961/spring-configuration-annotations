package levy.daniel.application.model.metier.student;


/**
 * INTERFACE IStudent :<br/>
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
public interface IStudent {

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
	 * Getter du name du Student.<br/>
	 *
	 * @return this.name : String.<br/>
	 */
	String getName();


	/**
	* Setter du name du Student.<br/>
	*
	* @param pName : String : 
	* valeur à passer à this.name.<br/>
	*/
	void setName(String pName);


	/**
	 * Getter de l'age du Student.<br/>
	 *
	 * @return this.age : Integer.<br/>
	 */
	Integer getAge();


	/**
	* Getter de l'age du Student.<br/>
	*
	* @param pAge : Integer : 
	* valeur à passer à this.age.<br/>
	*/
	void setAge(Integer pAge);

	
	
} // FIN DE L'INTERFACE IStudent.------------------------------------------
