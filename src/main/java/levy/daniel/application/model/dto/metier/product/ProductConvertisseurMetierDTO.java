package levy.daniel.application.model.dto.metier.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.product.impl.ProductDTO;
import levy.daniel.application.model.metier.product.IProduct;
import levy.daniel.application.model.metier.product.impl.Product;

/**
 * CLASSE ProductConvertisseurMetierDTO :<br/>
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
 * @since 19 juil. 2019
 *
 */
public class ProductConvertisseurMetierDTO {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ProductConvertisseurMetierDTO.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	private ProductConvertisseurMetierDTO() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * <b>convertit un DTO en OBJET METIER</b>.<br/>
	 * <ul>
	 * <li>retourne null si pDTO == null.</li>
	 * <li>récupère les valeurs String dans le DTO.</li>
	 * <li>convertit les String du DTO en types de l'Objet métier.</li>
	 * <li>injecte les valeurs typées dans un OBJET METIER 
	 * et le retourne.</li>
	 * </ul>
	 *
	 * @param pDTO : IProductDTO.<br/>
	 * 
	 * @return : IProduct : Objet métier.<br/>
	 */
	public static IProduct convertirDTOEnObjetMetier(
			final IProductDTO pDTO) {
		
		synchronized (ProductConvertisseurMetierDTO.class) {
			
			IProduct resultat = null;
			
			if (pDTO != null) {
				
				/* récupère les valeurs String dans le DTO. */
				final String idString = pDTO.getIdString();
				final String nameString = pDTO.getNameString();
				
				/* convertit les String du DTO en types de l'Objet métier. */
				/* id */
				Long id = null;
				
				if (!StringUtils.isBlank(idString)) {
					try {
						id = Long.valueOf(idString);
					} catch (NumberFormatException e) {
						id = null;
					}
				}
				
				/* name */
				final String name = nameString;
				
				/* injecte les valeurs typées dans un OBJET METIER. */
				resultat 
					= new Product(
							id
							, name);
			}
			
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirDTOEnObjetMetier(...).____________________________
	

	
	/**
	 * <b>convertit un OBJET METIER en DTO</b>.<br/>
	 * <ul>
	 * <li>retourne null si pObject == null.</li>
	 * <li>récupère les valeurs typées dans l'objet métier.</li>
	 * <li>convertit les types de l'Objet métier en String du DTO.</li>
	 * <li>injecte les valeurs String dans un DTO 
	 * et le retourne.</li>
	 * </ul>
	 *
	 * @param pObject : IProduct : 
	 * Objet métier.<br/>
	 * 
	 * @return : IProductDTO : DTO.<br/>
	 */
	public static IProductDTO convertirObjetMetierEnDTO(
			final IProduct pObject) {
		
		synchronized (ProductConvertisseurMetierDTO.class) {
			
			IProductDTO resultat = null;
			
			if (pObject != null) {
				
				/* récupère les valeurs typées dans l'objet métier. */
				final Long id = pObject.getId();
				final String name = pObject.getName();
				
				/* convertit les types de l'Objet métier en String du DTO. */
				String idString = null;
				try {
					idString = String.valueOf(id);
				} catch (Exception finalE) {
					idString = null;
				}
				
				final String nameString = name;
				
				/* injecte les valeurs String dans un DTO. */
				resultat 
					= new ProductDTO(
							idString
								, nameString);
				
			}
						
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirObjetMetierEnDTO(...).____________________________
	
	
	
	/**
	 * convertit une liste d'OBJETS METIER en liste 
	 * de DTOs.<br/>
	 * <br/>
	 * - retourne null si pListeObjets == null.<br/>
	 * <br/>
	 *
	 * @param pListeObjets : List&lt;IProduct&gt; : 
	 * Liste d'OBJETS METIER.<br/>
	 * @return : 
	 * List&lt;IProductDTO&gt; : 
	 * Liste de DTOs.<br/>
	 */
	public static List<IProductDTO> convertirListeObjetEnListeDTO(
			final List<IProduct> pListeObjets) {
		
		synchronized (ProductConvertisseurMetierDTO.class) {
			
			/* retourne null si pListeObjets == null. */
			if (pListeObjets == null) {
				return null;
			}
			
			final List<IProductDTO> resultat 
				= new ArrayList<IProductDTO>();
			
			for (final IProduct objet : pListeObjets) {
				
				final IProductDTO dto 
					= convertirObjetMetierEnDTO(objet);
				
				resultat.add(dto);
				
			}
			
			return resultat;
			
		} // Fin de synchronized._______________________________________
		
	} // Fin de convertirListeObjetEnListeDTO(...).________________________
	
	
				
} // FIN DE LA CLASSE ProductConvertisseurMetierDTO.-------------------------
