package levy.daniel.application.model.dto.metier.employee;

import java.io.Serializable;

/**
 * INTERFACE IEmployeeDTO :<br/>
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
public interface IEmployeeDTO extends Serializable {
	
	

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
	
	

} // FIN DE L'INTERFACE IEmployeeDTO.----------------------------------------
