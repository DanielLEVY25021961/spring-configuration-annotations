package levy.daniel.application.model.dto.metier.person.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.person.IPersonDTO;

/**
 * CLASSE PersonDTO :<br/>
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
public class PersonDTO implements IPersonDTO {

	// ************************ATTRIBUTS************************************/

	/**
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * "Classe PersonDTO".<br/>
	 */
	public static final String CLASSE_PERSON_DTO 
		= "Classe PersonDTO";
	
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
	 * identifiant en base sous forme de String.
	 */
	private String idString;
	
	/**
	 * firstName sous forme de String.<br/>
	 */
	private String firstNameString;
	
	/**
	 * lastName sous forme de String.<br/>
	 */
	private String lastNameString;
	
	/**
	 * birthDate sous forme de String.<br/>
	 */
	private String birthDateString;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(PersonDTO.class);

	// *************************METHODES************************************/


	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public PersonDTO() {
		this(null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.
	 *
	 * @param pFirstNameString : String : firstName sous forme de String.
	 * @param pLastNameString : String : lastName sous forme de String.
	 * @param pBirthDateString : String : birthDate sous forme de String.
	 */
	public PersonDTO(
			final String pFirstNameString
					, final String pLastNameString
						, final String pBirthDateString) {
		
		this(null, pFirstNameString, pLastNameString, pBirthDateString);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.
	 *
	 * @param pIdString : String : ID en base sous forme de String.
	 * @param pFirstNameString : String : firstName sous forme de String.
	 * @param pLastNameString : String : lastName sous forme de String.
	 * @param pBirthDateString : String : birthDate sous forme de String.
	 */
	public PersonDTO(
			final String pIdString
				, final String pFirstNameString
					, final String pLastNameString
						, final String pBirthDateString) {
		
		super();
		
		this.idString = pIdString;
		this.firstNameString = pFirstNameString;
		this.lastNameString = pLastNameString;
		this.birthDateString = pBirthDateString;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("PersonDTO [");
			
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
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("birthDateString=");
		if (this.getBirthDateString() != null) {
			builder.append(this.getBirthDateString());
		} else {
			builder.append(NULL);
		}
		
		builder.append("]");
		
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

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBirthDateString() {
		return this.birthDateString;
	} // Fin de getBirthDateString().______________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBirthDateString(
			final String pBirthDateString) {
		this.birthDateString = pBirthDateString;
	} // Fin de setBirthDateString(...).___________________________________


	
} // FIN DE LA CLASSE PersonDTO.---------------------------------------------
