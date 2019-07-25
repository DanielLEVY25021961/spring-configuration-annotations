package levy.daniel.application.model.persistence.metier.employee.entities.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.employee.IEmployeeDTO;
import levy.daniel.application.model.metier.employee.IEmployee;


/**
 * CLASSE EmployeeEntityJPA :<br/>
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
@Entity(name="EmployeeEntityJPA")
@Table(name="EMPLOYEES", schema="PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_PRENOM_NOM"
, columnNames={"PRENOM", "NOM"})
, indexes={@Index(name="INDEX_NOM_PRENOM", columnList="NOM, PRENOM")})
public class EmployeeEntityJPA implements IEmployee {

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
     * prenom de l'EmployeeEntityJPA.<br/>
     */
    private String firstName;
   
    /**
     * nom de l'EmployeeEntityJPA.<br/>
     */
    private String lastName;
   
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(EmployeeEntityJPA.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public EmployeeEntityJPA() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pFirstName
	 * @param pLastName
	 */
	public EmployeeEntityJPA(
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
	public EmployeeEntityJPA(
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
	public EmployeeEntityJPA(
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
	public final String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("EmployeeEntityJPA [");
		
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
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
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
	@Column(name="PRENOM"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
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
	@Column(name="NOM"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
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

	
	
} // FIN DE LA CLASSE EmployeeEntityJPA.----------------------------------------------
