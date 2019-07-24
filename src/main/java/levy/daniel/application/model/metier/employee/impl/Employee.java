package levy.daniel.application.model.metier.employee.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.employee.IEmployeeDTO;
import levy.daniel.application.model.metier.employee.IEmployee;


/**
 * CLASSE Employee :<br/>
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
public class Employee implements IEmployee {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
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
     * prenom de l'Employee.<br/>
     */
    private String firstName;
   
    /**
     * nom de l'Employee.<br/>
     */
    private String lastName;
   
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Employee.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public Employee() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pFirstName
	 * @param pLastName
	 */
	public Employee(
			final String pFirstName
					, final String pLastName) {
		this(null, pFirstName, pLastName);
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pId
	 * @param pFirstName
	 * @param pLastName
	 */
	public Employee(
			final Long pId
				, final String pFirstName
					, final String pLastName) {
		
		super();
		
		this.id = pId;
		this.firstName = pFirstName;
		this.lastName = pLastName;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * <b>instancie un Objet Metier à partir d'une VUE (DTO)</b>.<br/>
	 *
	 * @param pDTO : IEmployeeDTO.<br/>
	 */
	public Employee(
			final IEmployeeDTO pDTO) {
		
		super();
		
		if (pDTO != null) {
			
			Long idLocal = null;
			
			if (pDTO.getIdString() != null) {
				
				try {
					idLocal = Long.valueOf(pDTO.getIdString());
				} catch (Exception e) {
					this.id = null;
				}
			}
			
			this.setId(idLocal);
			this.setFirstName(pDTO.getFirstNameString());
			this.setLastName(pDTO.getLastNameString());
		}
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR._______________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Employee [");
		
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("firstName=");
		if (this.firstName != null) {			
			builder.append(this.firstName);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("lastName=");
		if (this.lastName != null) {			
			builder.append(this.lastName);
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

	
	
} // FIN DE LA CLASSE Employee.----------------------------------------------
