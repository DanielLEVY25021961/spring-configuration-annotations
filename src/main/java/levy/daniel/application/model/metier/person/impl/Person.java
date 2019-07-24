package levy.daniel.application.model.metier.person.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.person.IPerson;

/**
 * CLASSE Person :<br/>
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
public class Person implements IPerson {

	// ************************ATTRIBUTS************************************/
	

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
	 * ID en base.<br/>
	 */
	private Long id;
	
	 
    /**
     * prenom.<br/>
     */
    private String firstName;

    
    /**
     * nom.<br/>
     */
    private String lastName;
    
    /**
     * date de naissance.<br/>
     */
    private LocalDate birthDate;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(Person.class);

	// *************************METHODES************************************/


	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public Person() {
		this(null, null, null, null);
	} // Fin de Person().__________________________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pFirstName
	 * @param pLastName
	 * @param pBirthDate
	 */
	public Person(
			final String pFirstName, final String pLastName
				, final LocalDate pBirthDate) {
		
		this(null, pFirstName, pLastName, pBirthDate);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pId : Long : ID en base.
	 * @param pFirstName : String : prénom.
	 * @param pLastName : String : nom.
	 * @param pBirthDate : java.time.LocalDate : date de naissance.
	 */
	public Person(
			final Long pId
				, final String pFirstName, final String pLastName
				, final LocalDate pBirthDate) {
		
		super();
		
		this.id = pId;
		this.firstName = pFirstName;
		this.lastName = pLastName;
		this.birthDate = pBirthDate;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
	/**
	 * retourne une String de la forme 
	 * <code>[annee-mois-jour]</code> 
	 * à partir d'une java.time.LocalDate pDate.<br/>
	 * Par exemple, retourne <b>"2019-06-13"</b> 
	 * pour le 13 juin 2019.<br/>
	 * <br/>
	 * - retourne null si pDate == null.<br/>
	 * <br/>
	 *
	 * @param pDate : LocalDate : date à formater.
	 * 
	 * @return : String : affichage de la date formatée.<br/>
	 */
	private String formaterLocalDateEnString(
			final LocalDate pDate) {
		
		/* retourne null si pDate == null. */
		if (pDate == null) {
			return null;
		}
		
		/* formateur de type 2019-06-13 
		 * (13 juin 2019)*/
		final DateTimeFormatter formatter 
			= DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
		final String resultat = pDate.format(formatter);
				
		return resultat;
		
	} // Fin de formaterLocalDateEnString(...).____________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Person [");
		
		
		builder.append("id=");
		if (this.getId() != null) {			
			builder.append(this.getId());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("firstName=");
		if (this.getFirstName() != null) {			
			builder.append(this.getFirstName());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("lastName=");
		if (this.getLastName() != null) {			
			builder.append(this.getLastName());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("birthDate=");
		if (this.getBirthDate() != null) {
			builder.append(
					this.formaterLocalDateEnString(this.getBirthDate()));
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
	public Long getId() {
		return this.id;
	} // Fin de getId().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {
		this.id = pId;		
	} // Fin de setId(...).________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFirstName() {
		return this.firstName;
	} // Fin de getFirstName().____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFirstName(
			final String pFirstName) {
		this.firstName = pFirstName;
	} // Fin de setFirstName(...)._________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLastName() {
		return this.lastName;
	} // Fin de getLastName()._____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLastName(
			final String pLastName) {
		this.lastName = pLastName;
	} // Fin de setLastName(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocalDate getBirthDate() {
		return this.birthDate;
	} // Fin de getBirthDate().____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBirthDate(
			final LocalDate pBirthDate) {
		this.birthDate = pBirthDate;
	} // Fin de setBirthDate(...)._________________________________________

	
	
} // FIN DE LA CLASSE Person.------------------------------------------------
