package levy.daniel.application.model.metier.student.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.student.IStudent;


/**
 * CLASSE Student :<br/>
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
public class Student implements IStudent {
	
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
	 * name du Student.<br/>
	 */
	private String name;
	
	/**
	 * age du Student.<br/>
	 */
	private Integer age;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Student.class);


	// *************************METHODES************************************/

	
	
	 /**
	 * .<br/>
	 *
	 */
	public Student() {
		this(null, null, null);
	}
	
	
	
	 /**
	 * .<br/>
	 *
	 * @param pName
	 * @param pAge
	 */
	public Student(
			final String pName
					, final Integer pAge) {
		this(null, pName, pAge);
	}
	
	
	
	 /**
	 * .<br/>
	 *
	 * @param pId
	 * @param pName
	 * @param pAge
	 */
	public Student(
			final Long pId
				, final String pName
					, final Integer pAge) {
		
		super();
		
		this.id = pId;
		this.name = pName;
		this.age = pAge;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Student [");
		
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("name=");
		if (this.name != null) {			
			builder.append(this.name);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("age=");
		if (this.age != null) {			
			builder.append(this.age);
		} else {
			builder.append(NULL);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	}



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() {
		return this.id;
	}



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {
		this.id = pId;
	}



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.name;
	}



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName(
			final String pName) {
		this.name = pName;
	}



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getAge() {
		return this.age;
	}



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAge(
			final Integer pAge) {
		this.age = pAge;
	}
	
	
	
	
	

}
