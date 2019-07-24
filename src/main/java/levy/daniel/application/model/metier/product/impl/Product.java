package levy.daniel.application.model.metier.product.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.product.IProductDTO;
import levy.daniel.application.model.metier.product.IProduct;


/**
 * CLASSE Product :<br/>
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
public class Product implements IProduct {

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
	 * name du Product.<br/>
	 */
	private String name;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Product.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public Product() {
		this(null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pName : String : name du Product.
	 */
	public Product(
			final String pName) {		
		this(null, pName);		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pId : Long : ID en base.
	 * @param pName : String : name du Product.
	 */
	public Product(
			final Long pId, final String pName) {
		
		super();
		
		this.id = pId;
		this.name = pName;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * <b>instancie un Objet Metier à partir d'une VUE (DTO)</b>.<br/>
	 *
	 * @param pDTO : IProductDTO.<br/>
	 */
	public Product(
			final IProductDTO pDTO) {
		
		super();
		
		if (pDTO != null) {
			
			Long idLocal = null;
			
			if (pDTO.getIdString() != null) {
				try {
					idLocal = Long.valueOf(pDTO.getIdString());
				} catch (Exception e) {
					this.setId(null);
				}
			}
			
			this.setId(idLocal);
			this.setName(pDTO.getNameString());
			
		}
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR._______________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Product [");
		
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
		
		builder.append("]");
		
		return builder.toString();
		
	} // Fin de toString().______________________________________________


	
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

	

} // FIN DE LA CLASSE Product.-----------------------------------------------
