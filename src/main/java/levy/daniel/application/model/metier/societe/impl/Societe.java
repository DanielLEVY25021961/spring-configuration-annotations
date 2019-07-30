package levy.daniel.application.model.metier.societe.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import levy.daniel.application.model.dto.metier.societe.ISocieteDTO;
import levy.daniel.application.model.metier.developpeur.IDeveloppeur;
import levy.daniel.application.model.metier.developpeur.impl.Developpeur;
import levy.daniel.application.model.metier.societe.ISociete;


/**
 * CLASSE Societe :<br/>
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
 * @since 12 nov. 2018
 *
 */
public class Societe implements ISociete {

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
	 * .<br/>
	 */
	private String nomSociete;
	
	/**
	 * .<br/>
	 */
	@Autowired
	@Qualifier("Developpeur")
	private IDeveloppeur chefDeveloppeur;
	
	/**
	 * .<br/>
	 */
	@Autowired
	@Qualifier("Developpeur")
	private IDeveloppeur developpeur;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Societe.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public Societe() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pNomSociete
	 * @param pChefDeveloppeur
	 * @param pDeveloppeur
	 */
	public Societe(
			final String pNomSociete
				, final IDeveloppeur pChefDeveloppeur
					, final IDeveloppeur pDeveloppeur) {		
		this(null, pNomSociete, pChefDeveloppeur, pDeveloppeur);
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________


	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pId
	 * @param pNomSociete
	 * @param pChefDeveloppeur
	 * @param pDeveloppeur
	 */
	public Societe(
			final Long pId
				, final String pNomSociete
					, final IDeveloppeur pChefDeveloppeur
						, final IDeveloppeur pDeveloppeur) {
		
		super();
		
		this.id = pId;
		this.nomSociete = pNomSociete;
		this.chefDeveloppeur = pChefDeveloppeur;
		this.developpeur = pDeveloppeur;
		
	} // Fin du CONSTRUCTEUR COMPLET BASE._________________________________


	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * <b>transforme une VUE (DTO) en Objet Metier</b>.<br/>
	 *
	 * @param pDTO : ISocieteDTO.<br/>
	 */
	public Societe(
			final ISocieteDTO pDTO) {
		
		super();
		
		if (pDTO != null) {
			
			Long idLocal = null;
			IDeveloppeur chefLocal = null;
			IDeveloppeur devLocal = null;
			
			if (pDTO.getIdString() != null) {
				try {
					idLocal = Long.valueOf(pDTO.getIdString());
				} catch (Exception e) {
					this.id = null;
				}				
			}
			
			if (pDTO.getChefDeveloppeurDTO() != null) {
				chefLocal 
				= new Developpeur(pDTO.getChefDeveloppeurDTO());
			}
			
			if (pDTO.getDeveloppeurDTO() != null) {
				devLocal 
				= new Developpeur(pDTO.getDeveloppeurDTO());
			}
			
			this.setId(idLocal);
			this.nomSociete = pDTO.getNomSocieteString();
			this.chefDeveloppeur = chefLocal;
			this.developpeur = devLocal;
			
		}
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR._______________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Societe [");
		
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("nomSociete=");
		if (this.nomSociete != null) {			
			builder.append(this.nomSociete);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("chefDeveloppeur=");
		if (this.chefDeveloppeur != null) {
			builder.append(this.chefDeveloppeur.toString());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		

		if (this.developpeur != null) {
			builder.append("developpeur=");
			builder.append(this.developpeur.toString());
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
	public String getNomSociete() {
		return this.nomSociete;
	}



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNomSociete(
			final String pNomSociete) {
		this.nomSociete = pNomSociete;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IDeveloppeur getChefDeveloppeur() {
		return this.chefDeveloppeur;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setChefDeveloppeur(
			final IDeveloppeur pChefDeveloppeur) {
		this.chefDeveloppeur = pChefDeveloppeur;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IDeveloppeur getDeveloppeur() {
		return this.developpeur;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDeveloppeur(
			final IDeveloppeur pDeveloppeur) {
		this.developpeur = pDeveloppeur;
	}



}
