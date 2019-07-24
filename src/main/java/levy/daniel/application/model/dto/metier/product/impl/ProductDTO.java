package levy.daniel.application.model.dto.metier.product.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.product.IProductDTO;
import levy.daniel.application.model.metier.product.IProduct;


/**
 * CLASSE ProductDTO :<br/>
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
public class ProductDTO implements IProductDTO {

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
	 * ID en base sous forme de String.<br/>
	 */
	private String idString;
	
	/**
	 * nameString du Product sous forme de String.<br/>
	 */
	private String nameString;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ProductDTO.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public ProductDTO() {
		this(null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pIdString : Long : ID en base.
	 * @param pNameString : String : nameString du ProductDTO.
	 */
	public ProductDTO(
			final String pIdString
				, final String pNameString) {
		
		super();
		
		this.idString = pIdString;
		this.nameString = pNameString;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


	
	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * <b>transforme un Objet Metier en VUE (DTO)</b>.<br/>
	 *
	 * @param pObject : IProduct.<br/>
	 */
	public ProductDTO(
			final IProduct pObject) {
		
		super();
		
		if (pObject != null) {
			
			String idStringLocal = null;
			
			if (pObject.getId() != null) {
				idStringLocal = String.valueOf(pObject.getId());
			}
			
			this.setIdString(idStringLocal);
			this.setNameString(pObject.getName());
		}
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR._______________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("ProductDTO [");
		
		builder.append("idString=");
		if (this.idString != null) {			
			builder.append(this.idString);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("nameString=");
		if (this.nameString != null) {			
			builder.append(this.nameString);
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
	public String getIdString() {
		return this.idString;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setIdString(
			final String pIdString) {
		this.idString = pIdString;
	}



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNameString() {
		return this.nameString;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNameString(
			final String pNameString) {
		this.nameString = pNameString;
	}

	

} // FIN DE LA CLASSE ProductDTO.--------------------------------------------
