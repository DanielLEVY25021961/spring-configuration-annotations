package levy.daniel.application.model.dto.metier.societe.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.developpeur.IDeveloppeurDTO;
import levy.daniel.application.model.dto.metier.developpeur.impl.DeveloppeurDTO;
import levy.daniel.application.model.dto.metier.societe.ISocieteDTO;
import levy.daniel.application.model.metier.societe.ISociete;


/**
 * CLASSE SocieteDTO :<br/>
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
public class SocieteDTO implements ISocieteDTO {

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
	 * identifiant en base sous forme de String.
	 */
	private String idString;
	
	/**
	 * .<br/>
	 */
	private String nomSocieteString;
	
	/**
	 * .<br/>
	 */
	private IDeveloppeurDTO chefDeveloppeurDTO;
	
	/**
	 * .<br/>
	 */
	private IDeveloppeurDTO developpeurDTO;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(SocieteDTO.class);

	// *************************METHODES************************************/
	
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public SocieteDTO() {
		this(null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pIdString
	 * @param pNomSocieteString
	 * @param pChefDeveloppeurDTO
	 * @param pDeveloppeurDTO
	 */
	public SocieteDTO(
			final String pIdString
				, final String pNomSocieteString
					, final IDeveloppeurDTO pChefDeveloppeurDTO
						, final IDeveloppeurDTO pDeveloppeurDTO) {
		
		super();
		
		this.idString = pIdString;
		this.nomSocieteString = pNomSocieteString;
		this.chefDeveloppeurDTO = pChefDeveloppeurDTO;
		this.developpeurDTO = pDeveloppeurDTO;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * <b>instancie un DTO (VUE) à partir d'un Objet Metier</b>.<br/>
	 *
	 * @param pObject : ISociete.<br/>
	 */
	public SocieteDTO(
			final ISociete pObject) {
		
		super();
		
		if (pObject != null) {
			
			String idStringLocal = null;
			IDeveloppeurDTO chefDTO = null;
			IDeveloppeurDTO devDTO = null;
			
			
			if (pObject.getId() != null) {
				idStringLocal = String.valueOf(pObject.getId());
			}
			
			if (pObject.getChefDeveloppeur() != null) {
				chefDTO = new DeveloppeurDTO(pObject.getChefDeveloppeur());
			}
			
			if (pObject.getDeveloppeur() != null) {
				devDTO = new DeveloppeurDTO(pObject.getDeveloppeur());
			}

			this.setIdString(idStringLocal);
			this.setNomSocieteString(pObject.getNomSociete());
			this.setChefDeveloppeurDTO(chefDTO);
			this.setDeveloppeurDTO(devDTO);
		}
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR._______________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("SocieteDTO [");
		
		builder.append("idString=");
		if (this.idString != null) {			
			builder.append(this.idString);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("nomSocieteString=");
		if (this.nomSocieteString != null) {			
			builder.append(this.nomSocieteString);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("chefDeveloppeurDTO=");
		if (this.chefDeveloppeurDTO != null) {			
			builder.append(this.chefDeveloppeurDTO);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("developpeurDTO=");
		if (this.developpeurDTO != null) {			
			builder.append(this.developpeurDTO);
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
	public String getNomSocieteString() {
		return this.nomSocieteString;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNomSocieteString(
			final String pNomSocieteString) {
		this.nomSocieteString = pNomSocieteString;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IDeveloppeurDTO getChefDeveloppeurDTO() {
		return this.chefDeveloppeurDTO;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setChefDeveloppeurDTO(
			final IDeveloppeurDTO pChefDeveloppeurDTO) {
		this.chefDeveloppeurDTO = pChefDeveloppeurDTO;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IDeveloppeurDTO getDeveloppeurDTO() {
		return this.developpeurDTO;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDeveloppeurDTO(
			final IDeveloppeurDTO pDeveloppeurDTO) {
		this.developpeurDTO = pDeveloppeurDTO;
	}



} // FIN DE LA CLASSE SocieteDTO.--------------------------------------------
