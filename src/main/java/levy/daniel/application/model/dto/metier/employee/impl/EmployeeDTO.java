package levy.daniel.application.model.dto.metier.employee.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.employee.IEmployeeDTO;
import levy.daniel.application.model.metier.employee.IEmployee;


/**
 * CLASSE EmployeeDTO :<br/>
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
public class EmployeeDTO implements IEmployeeDTO {

	// ************************ATTRIBUTS************************************/

	/**
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * "Classe EmployeeDTO".<br/>
	 */
	public static final String CLASSE_EMPLOYEE_DTO 
		= "Classe EmployeeDTO";
	
	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
		
	/**
	 * VIRGULE_ESPACE : String :<br/>
	 * ", ".<br/>
	 */
	public static final String VIRGULE_ESPACE = ", ";
		
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	public static final String NULL = "null";
		
	/**
	 * ID en base sous forme de String.
	 */
	private String idString;
	
	/**
	 * firstName sous forme de String.
	 */
	private String firstNameString;
	
	/**
	 * lastName sous forme de String.
	 */
	private String lastNameString;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(EmployeeDTO.class);
	

	// *************************METHODES************************************/

	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public EmployeeDTO() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pFirstNameString : String : firstName sous forme de String.
	 * @param pLastNameString : String : lastName sous forme de String. 
	 */
	public EmployeeDTO(
			final String pFirstNameString
					, final String pLastNameString) {
		this(null, pFirstNameString, pLastNameString);
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pIdString : String : ID en base sous forme de String.
	 * @param pFirstNameString : String : firstName sous forme de String.
	 * @param pLastNameString : String : lastName sous forme de String. 
	 */
	public EmployeeDTO(
			final String pIdString
				, final String pFirstNameString
					, final String pLastNameString) {
		
		super();
		
		this.idString = pIdString;
		this.firstNameString = pFirstNameString;
		this.lastNameString = pLastNameString;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * <b>transforme un Objet Metier en DTO (VUE)</b>.
	 *
	 * @param pObject : IEmployee.
	 */
	public EmployeeDTO(
			final IEmployee pObject) {
		
		super();
		
		if (pObject != null) {
			
			String idStringLocal = null;
			
			if (pObject.getId() != null) {
				idStringLocal = String.valueOf(pObject.getId());
			}
			
			this.setIdString(idStringLocal);
			this.setFirstNameString(pObject.getFirstName());
			this.setLastNameString(pObject.getLastName());
		}
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR._______________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("EmployeeDTO [");
		
		builder.append("idString=");
		if (this.getIdString() != null) {			
			builder.append(this.getIdString());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);

		builder.append("firstNameString=");
		if (this.getFirstNameString() != null) {			
			builder.append(this.getFirstNameString());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);

		builder.append("lastNameString=");
		if (this.getLastNameString() != null) {			
			builder.append(this.getLastNameString());
		} else {
			builder.append(NULL);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getIdString() {
		return this.idString;
	} // Fin de getIdString()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setIdString(
			final String pIdString) {
		this.idString = pIdString;		
	} // Fin de setIdString(...).__________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFirstNameString() {
		return this.firstNameString;
	} // Fin de getFirstNameString().______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFirstNameString(
			final String pFirstNameString) {
		this.firstNameString = pFirstNameString;		
	} // Fin de setFirstNameString(...).___________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLastNameString() {
		return this.lastNameString;
	} // Fin de getLastNameString()._______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLastNameString(
			final String pLastNameString) {
		this.lastNameString = pLastNameString;		
	} // Fin de setLastNameString(...).____________________________________



} // FIN DE LA CLASSE EmployeeDTO.-------------------------------------------
