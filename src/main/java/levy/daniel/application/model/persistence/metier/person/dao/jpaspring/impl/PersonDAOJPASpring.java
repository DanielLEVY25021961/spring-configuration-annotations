package levy.daniel.application.model.persistence.metier.person.dao.jpaspring.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.metier.person.IPerson;
import levy.daniel.application.model.persistence.daoexceptions.GestionnaireDaoException;
import levy.daniel.application.model.persistence.metier.person.IPersonDAO;
import levy.daniel.application.model.persistence.metier.person.PersonConvertisseurMetierEntity;
import levy.daniel.application.model.persistence.metier.person.entities.jpa.PersonEntityJPA;

/**
 * CLASSE PersonDAOJPASpring :<br/>
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
 * @author dan Lévy
 * @version 1.0
 * @since 25 juil. 2019
 *
 */
@Repository(value="PersonDAOJPASpring")
public class PersonDAOJPASpring implements IPersonDAO {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * "Classe PersonDAOJPASpring".<br/>
	 */
	public static final String CLASSE_PERSONDAO_JPA_SPRING 
		= "Classe PersonDAOJPASpring";
	
	/**
	 * " - ".
	 */
	public static final String SEPARATEUR_MOINS_AERE 
		= " - ";
	
	/**
	 * saut de ligne de la plateforme.<br/>
	 */
	public static final String SAUT_LIGNE_PLATEFORME 
		= System.getProperty("line.separator");
	
	/**
	 * "this.entityManager est NULL dans le présent DAO".<br/>
	 */
	public static final String MESSAGE_ENTITYMANAGER_NULL 
		= "this.entityManager est NULL dans le présent DAO";

	
	/**
	 * "select person from 
	 * PersonEntityJPA as person ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select person from "
				+ "PersonEntityJPA as person ";
	
	/**
	 * "STOCKAGE IMPOSSIBLE : l'Objet métier à créer est null".
	 */
	public static final String OBJET_NULL 
		= "STOCKAGE IMPOSSIBLE : l'Objet métier à créer est null";
	
	/**
	 * "STOCKAGE IMPOSSIBLE - DOUBLON : 
	 * l'objet existe déjà dans le stockage : ".
	 */
	public static final String DOUBLON 
		= "STOCKAGE IMPOSSIBLE - DOUBLON : l'objet existe déjà dans le stockage : ";
	
	/**
	 * "STOCKAGE IMPOSSIBLE - les champs OBLIGATOIRES (prénom, nom) ne sont pas remplis : ".
	 */
	public static final String CHAMPS_OBLIGATOIRES 
		= "STOCKAGE IMPOSSIBLE - les champs OBLIGATOIRES (prénom, nom) ne sont pas remplis : ";
	
	/**
	 * JPA EntityManager <b>injecté par SPRING</b>.<br/>
	 */
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private transient EntityManager entityManager;
	
	/**
	 * Gestionnaire pour les Exceptions de DAO.<br/>
	 */
	private final transient GestionnaireDaoException gestionnaireException 
		= new GestionnaireDaoException();

	/**
	 * Liste des messages d'erreur à l'intention de l'utilisateur.<br/>
	 * Ne peut jamis être null. <b>tester avec isEmpty()</b>.<br/>
	 */
	private transient List<String> messagesErrorUtilisateurList 
		= new ArrayList<String>(); 
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(PersonDAOJPASpring.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public PersonDAOJPASpring() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * retourne un boolean qui stipule si les champs obligatoires 
	 * de pObject sont bien remplis.<br/>
	 * <br/>
	 * - retourne true si les champs obligatoires sont tous remplis.<br/>
	 * - retourne false si pObject == null.<br/>
	 * <br/>
	 *
	 * @param pObject : IPerson : Objet Métier.
	 * 
	 * @return : boolean : 
	 * true si les champs obligatoires sont tous remplis.<br/>
	 */
	private boolean champsObligatoiresRemplis(
				final IPerson pObject) {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}
		
//		if (StringUtils.isBlank(pObject.getFirstName())) {
//			return false;
//		}
		
		if (StringUtils.isBlank(pObject.getLastName())) {
			return false;
		}
		
		return true;
		
	} // Fin de champsObligatoiresRemplis(...).____________________________


	
	/**
	 * retourne la requete JPQL paramétrée pour la méthode 
	 * <code><b>retrieve(OBJET METIER pObject)</b></code> 
	 * en tenant compte de la getion des paramètres null.<br/>
	 * <br/>
	 *
	 * @param pObject : ITeleversement : OBJET METIER
	 * 
	 * @return javax.persistence.Query
	 * 
	 * @throws Exception
	 */
	private Query fournirRequeteEgaliteMetier(
			final IPerson pObject) throws Exception {
		
		/* REQUETE HQL PARMETREE. */
		String requeteString = null;
		
		Query requete = null;
		
		
		/* REQUETE HQL PARMETREE. */
		requeteString 
			= SELECT_OBJET
				+ "where person.firstName = :pFirstName "
				+ "and person.lastName = :pNom";
		
		/* Construction de la requête HQL. */
		requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pFirstName", pObject.getFirstName());
		requete.setParameter("pNom", pObject.getLastName());
		
		return requete;
				
	} // Fin de fournirRequeteEgaliteMetier(...).__________________________
	
	

	/* CREATE ************/

	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Override
	public IPerson create(
			final IPerson pObject) throws Exception {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* NULL : instancie une nouvelle liste à chaque appel de la méthode. */
		this.messagesErrorUtilisateurList = new ArrayList<String>();
		
		/* NULL : retourne null si pObject == null. */
		if (pObject == null) {
			
			/* ajout d'une explication dans le rapport utilisateur. */
			this.messagesErrorUtilisateurList.add(OBJET_NULL);
			
			return null;
			
		} // Fin de NULL._____________________________________
		
		
		/* CHAMPS OBLIGATOIRES : retourne null si les attributs obligatoires 
		 * de pObject ne sont pas remplis.*/
		if (!this.champsObligatoiresRemplis(pObject)) {
			
			final String message = CHAMPS_OBLIGATOIRES + pObject.toString();
			
			/* ajout d'une explication dans le rapport utilisateur. */
			this.messagesErrorUtilisateurList.add(message);
			
			return null;
			
		} // Fin de CHAMPS OBLIGATOIRES.______________________________
		
		
		/* DOUBLON : retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			
			final String message = DOUBLON + pObject.toString();
			
			/* ajout d'une explication dans le rapport utilisateur. */
			this.messagesErrorUtilisateurList.add(message);
			
			return null;
			
		} // Fin de DOUBLON.___________________________________
		

		IPerson persistentObject = null;

		try {
			
			/* conversion de l'OBJET METIER en ENTITY. */
			final PersonEntityJPA entity 
				= PersonConvertisseurMetierEntity
						.convertirObjetMetierEnEntityJPA(pObject);

			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);

			/* conversion de l'ENTITY en OBJET METIER. */
			persistentObject 
				= PersonConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
							, "méthode create(object)", e);

		}

		/* retourne l'Objet persistant. */
		return persistentObject;

	} // Fin de create(...)._______________________________________________


	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPerson createOrRetrieve(
			final IPerson pEntity) throws Exception {

		/* instancie une nouvelle liste à chaque appel de la méthode. */
		this.messagesErrorUtilisateurList = new ArrayList<String>();
		
		/* retourne null si pObject == null. */
		if (pEntity == null) {
			
			/* ajout d'une explication dans le rapport utilisateur. */
			this.messagesErrorUtilisateurList.add(OBJET_NULL);
			
			return null;
			
		} // Fin de null._____________________________________
		
		
		/* retourne l'objet déjà persisté si pObject est un doublon. */
		if (this.exists(pEntity)) {
			
			return PersonConvertisseurMetierEntity
					.convertirObjetMetierEnEntityJPA(
							this.retrieve(pEntity));
			
		} // Fin de DOUBLON.___________________________________
		
		
		/* retourne null si les attributs obligatoires 
		 * de pObject ne sont pas remplis.*/
		if (!this.champsObligatoiresRemplis(pEntity)) {
			
			final String message = CHAMPS_OBLIGATOIRES + pEntity.toString();
			
			/* ajout d'une explication dans le rapport utilisateur. */
			this.messagesErrorUtilisateurList.add(message);
			
			return null;
			
		} // Fin de CHAMPS OBLIGATOIRES.______________________________
		

		IPerson persistentObject = null;

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* retourne null si pObject est un doublon. */
		if (this.exists(pEntity)) {
			return null;
		}

		try {
			
			PersonEntityJPA entity = null;
			
			/* conversion de l'OBJET METIER en ENTITY. */
			if (!(pEntity instanceof PersonEntityJPA)) {
				entity 
				= PersonConvertisseurMetierEntity
						.convertirObjetMetierEnEntityJPA(pEntity);
			} else {
				entity = (PersonEntityJPA) pEntity;
			}
			

			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);

			/* RETOURNE L'ENTITY. */
			persistentObject = entity;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
							, "méthode create(object)", e);

		}

		/* retourne l'Objet persistant. */
		return persistentObject;

	} // Fin de createOrRetrieve(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void persist(
			final IPerson pObject) throws Exception {
		
		/* ne fait rien si pObject == null. */
		if (pObject == null) {
			return;
		}
		
		/* ne fait rien si pObject est un doublon. */
		if (this.exists(pObject)) {
			return;
		}
		
		if (this.existsId(pObject.getId())) {
			return;
		}
		
		/* ne fait rien si les attributs obligatoires 
		 * de pObject ne sont pas remplis.*/
		if (!this.champsObligatoiresRemplis(pObject)) {
			return;
		}

		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		/* conversion de l'OBJET METIER en ENTITY. */
		final PersonEntityJPA entity = 
				PersonConvertisseurMetierEntity
					.convertirObjetMetierEnEntityJPA(pObject);

		try {
			
			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
							, "méthode persist(object)", e);

		}

	} // Fin de persist(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final IPerson pObject) throws Exception {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}
		
		/* retourne null si les attributs obligatoires 
		 * de pObject ne sont pas remplis.*/
		if (!this.champsObligatoiresRemplis(pObject)) {
			return null;
		}
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
		
		
		/* conversion de l'OBJET METIER en ENTITY. */
		final PersonEntityJPA entity = 
				PersonConvertisseurMetierEntity
					.convertirObjetMetierEnEntityJPA(pObject);
		
		IPerson persistentObject = null;
		
		try {
			
			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);
			
			/* conversion de l'ENTITY en OBJET METIER. */
			persistentObject 
				= PersonConvertisseurMetierEntity
				.convertirEntityJPAEnObjetMetier(entity);

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
							, "méthode createReturnId(object)", e);

		}
		
		/* retourne l'ID de l'Objet persistant. */
		if (persistentObject != null) {
			return persistentObject.getId();
		}
		
		return null;		

	} // Fin de createReturnId(...)._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IPerson> saveIterable(
			final Iterable<IPerson> pList) 
					throws Exception {

		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
		
		/* conversion de le liste de MODEL en liste d'ENTITIES. */
		final List<PersonEntityJPA> listeEntities 
			= PersonConvertisseurMetierEntity
				.convertirListModelEnEntitiesJPA(pList);
		
		final List<IPerson> resultat 
			= new ArrayList<IPerson>();

		final Iterator<PersonEntityJPA> iteS 
			= listeEntities.iterator();

		try {

			while (iteS.hasNext()) {

				final PersonEntityJPA entity = iteS.next();

				/* passe un null dans le lot. */
				if (entity == null) {
					continue;
				}
					
					
				/* Passe les doublons existants en base. */
				if (!this.exists(entity)) {
					
					/* passe si les attributs obligatoires 
					 * de l'objet ne sont pas remplis.*/
					if (this.champsObligatoiresRemplis(entity)) {
						
						IPerson objectPersistant = null;

						try {

							/* ***************** */
							/* PERSISTE en base. */
							this.entityManager.persist(entity);

							/* conversion de l'ENTITY en OBJET METIER. */
							objectPersistant 
								= PersonConvertisseurMetierEntity
								.convertirEntityJPAEnObjetMetier(entity);

						} catch (Exception e) {

							/* LOG. */
							if (LOG.isFatalEnabled()) {
								LOG.fatal(e.getMessage(), e);
							}

							/* Gestion de la DAO Exception. */
							this.gestionnaireException
								.gererException(
										CLASSE_PERSONDAO_JPA_SPRING
											, "Méthode saveIterable(lot)", e);
						}
						
						/* ne sauvegarde pas un doublon 
						 * présent dans le lot. */
						if (objectPersistant != null) {

							/* Ajoute à l'iterable resultat. */
							resultat.add(objectPersistant);								
						}
						
					} // Entity avec attributs obligatoires remplis.
					
				} // Entity persistante._________________
				
			} // Next._____________________________________

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
							, "Méthode saveIterable(lot)", e);

		}

		/* retourne l'iterable resultat. */
		return resultat;

	} // Fin de saveIterable(...)._________________________________________
	
	

	/* READ *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPerson retrieve(
			final IPerson pObject) throws Exception {

		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		IPerson objetResultat = null;		
		PersonEntityJPA entity = null;

		/* récupération de la requête paramétrée. */
		final Query requete = this.fournirRequeteEgaliteMetier(pObject);
		
		try {
			
			/* Execution de la requete HQL. */
			entity 
				= (PersonEntityJPA) requete.getSingleResult();
			
			/* conversion de l'ENTITY en OBJET METIER. */
			objetResultat 
				= PersonConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne null si l'Objet métier n'existe pas 
			 * dans le stockage. */
			return null;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode retrieve(objet)", e);
		}
		
		/* retourne l'objet metier trouvé. */
		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPerson findById(
			final Long pId) throws Exception {
		
		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		IPerson objetTrouve = null;
		PersonEntityJPA entity = null;

		try {
			
			/* ************************* */
			/* récupération de l'ENTITY. */
			entity 
				= this.entityManager.find(
						PersonEntityJPA.class, pId);
			
			/* conversion de l'ENTITY en OBJET METIER. */
			objetTrouve 
				= PersonConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);
			
		}
		catch (Exception e) {
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode findById(ID)", e);
			
		}
		
		/* retourne l'objet metier trouvé. */
		return objetTrouve;
				
	} // Fin de findById(...)._____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long retrieveId(
			final IPerson pObject) throws Exception {
		
		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
		
		IPerson objetResultat = null;		
		PersonEntityJPA entity = null;
		
		/* récupération de la requête paramétrée. */
		final Query requete = this.fournirRequeteEgaliteMetier(pObject);
		
		try {
			
			/* Execution de la requete HQL. */
			entity 
				= (PersonEntityJPA) requete.getSingleResult();
			
			/* conversion de l'ENTITY en OBJET METIER. */
			objetResultat 
				= PersonConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne null si l'Objet métier n'existe pas 
			 * dans le stockage. */
			return null;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode retrieveId(objet)", e);
		}
		
		/* retourne l'ID de l'objet metier trouvé. */
		if (objetResultat != null) {
			return objetResultat.getId();
		}
		
		return null;
		
	} // Fin de retrieveId(...).___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IPerson> rechercherRapide(
			final String pString) throws Exception {
				
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
		
		/* Création de la requête JPQL sous forme de String. */
		final String requeteString 
			= SELECT_OBJET 
			+ "where employee.firstName LIKE :pattern "
					+ "OR employee.lastName LIKE :pattern";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		final String patternRecherche = "%" + pString + "%";
		
		requete.setParameter("pattern", patternRecherche);
		
		List<PersonEntityJPA> resultatEntity = null;
				
		List<IPerson> resultat = null;
		
		try {
			
			/* Execution de la requete HQL. */
			resultatEntity 
				= requete.getResultList();
			
			/* conversion de la liste ENTITY en liste OBJET METIER. */
			resultat 
				= PersonConvertisseurMetierEntity
					.convertirListEntitiesJPAEnModel(resultatEntity);
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne null si l'Objet métier n'existe pas 
			 * dans le stockage. */
			return null;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode rechercherRapide(String %recherche%)", e);
		}
		
		/* retourne la liste d'objets métier. */
		if (resultat != null) {
			return resultat;
		}
		
		return null;
		
	} // Fin de rechercherRapide(...)._____________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IPerson> findAll() throws Exception {
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from PersonEntityJPA";
		
		List<PersonEntityJPA> resultatEntity = null;
		
		List<IPerson> resultat = null;
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* Exécute la javax.persistence.Query. */
			resultatEntity = query.getResultList();
			
			/* convertit la liste d'Entities en OBJETS METIER. */
			resultat = PersonConvertisseurMetierEntity
						.convertirListEntitiesJPAEnModel(
								resultatEntity);

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode findAll()", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAll()._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IPerson> findAllMax(
			final int pStartPosition
				, final int pMaxResult) throws Exception {

		/* retourne null si pId est en dehors des index de stockage. */
		if (pStartPosition > this.count() - 1) {
			return null;
		}
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from PersonEntityJPA";
		
		List<PersonEntityJPA> resultatEntity = null;
		
		List<IPerson> resultat = null;
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString)
					.setFirstResult(pStartPosition)
						.setMaxResults(pMaxResult);
			
			/* Exécute la javax.persistence.Query. */
			resultatEntity = query.getResultList();
						
			/* convertit la liste d'Entities en OBJETS METIER. */
			resultat 
			= PersonConvertisseurMetierEntity
				.convertirListEntitiesJPAEnModel(resultatEntity);

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode findAllMax(int pStartPosition"
								+ ", int pMaxResult)", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAllMax(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IPerson> findAllIterable(
			final Iterable<Long> pIds) throws Exception {
		
		/* retourne null si pIds == null. */
		if (pIds == null) {
			return null;
		}

		final List<IPerson> resultat 
			= new ArrayList<IPerson>();

		for (final Long id : pIds) {
			
			final IPerson objet = this.findById(id);
			
			if (objet != null) {
				resultat.add(objet);
			}
		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAllIterable(...).______________________________________



	/* UPDATE *************/

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPerson update(
			final IPerson pObject) throws Exception {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* retourne pObject si l'objet n'est pas 
		 * déjà persistant en base. */
		if (!this.existsId(pObject.getId())) {
			return pObject;
		}
		
		/* retourne null si pObject créerait un doublon. */
		if (this.exists(pObject)) {
			return null;
		}
		
		/* retourne null si les attributs obligatoires 
		 * de pObject ne sont pas remplis.*/
		if (!this.champsObligatoiresRemplis(pObject)) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
				
		/* conversion de l'OBJET METIER en ENTITY. */
		final PersonEntityJPA entity = 
				PersonConvertisseurMetierEntity
					.convertirObjetMetierEnEntityJPA(pObject);

		IPerson persistentObject = null;
		
		try {
			
			/* MODIFIE en base. */
			this.entityManager.merge(entity);

			/* conversion de l'ENTITY en OBJET METIER. */
			persistentObject 
				= PersonConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);
			
		}
		catch (Exception e) {
		
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode update(objet)", e);
						
		}
				
		/* retourne l'Objet persistant modifié. */
		return persistentObject;
		
	} // Fin de update(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPerson updateById(
			final Long pId, final IPerson pObjectModifie) 
												throws Exception {
		
		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}

		/* retourne null si pId est hors indexes. */
		if (this.findById(pId) == null) {
			return null;
		}
		
		/* retourne null si pObjectModifie == null. */
		if (pObjectModifie == null) {
			return null;
		}
		
		/* retourne null si l'objet modifie pObjectModifie 
		 * créerait un doublon dans le stockage. */
		if (this.exists(pObjectModifie)) {
			return null;
		}
		
		/* retourne null si les attributs obligatoires 
		 * de pObjectModifie ne sont pas remplis.*/
		if (!this.champsObligatoiresRemplis(pObjectModifie)) {
			return null;
		}
		
		/* récupère l'objet à modifier par sons index. */
		final IPerson objetAModifier = this.findById(pId);
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
				
		IPerson persistentObject = null;
		
		try {
			
			/* applique les modifications. */
			objetAModifier.setFirstName(pObjectModifie.getFirstName());
			objetAModifier.setLastName(pObjectModifie.getLastName());
			objetAModifier.setBirthDate(pObjectModifie.getBirthDate());
			
			/* conversion de l'OBJET METIER en ENTITY. */
			final PersonEntityJPA entity = 
					PersonConvertisseurMetierEntity
						.convertirObjetMetierEnEntityJPA(objetAModifier);

			/* MODIFIE en base. */
			this.entityManager.merge(entity);
			
			/* applique les modifications dans le stockage (si nécessaire). */
			this.entityManager.flush();
			
			/* conversion de l'ENTITY en OBJET METIER. */
			persistentObject 
				= PersonConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "méthode updateById(Id, Object)", e);
						
		}
				
		/* retourne l'Objet persistant modifié. */
		return persistentObject;
		
	} // Fin de update(...)._______________________________________________



	/* DELETE *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final IPerson pObject) throws Exception {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}
		
		/* récupère l'instance persistante. */
		final IPerson persistanceInstance 
			= this.retrieve(pObject);
		
		/* retourne false si pObject n'est pas persisté. */
		if (persistanceInstance == null) {
			return false;
		}
				
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}
				
		boolean resultat = false;
			
		try {

			/* récupération de l'ENTITY a détruire. */
			final PersonEntityJPA entity 
				= this.entityManager.find(
						PersonEntityJPA.class
							, persistanceInstance.getId());
						
			/* ************ */
			/* DESTRUCTION. */
			this.entityManager.remove(entity);
			
			resultat = true;
							
		} catch (Exception e) {
		
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode delete(objet)", e);
									
		}
		
		/* retourne le boolean resultat. */
		return resultat;
										
	} // Fin de delete(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(
			final Long pId) throws Exception {
		
		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}
		
		/* ne fait rien si pId est hors indexes. */
		if (this.findById(pId) == null) {
			return;
		}
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}
						
		try {
		
			/* récupération de l'ENTITY a détruire. */
			final PersonEntityJPA entity 
				= this.entityManager.find(
						PersonEntityJPA.class
							, pId);
						
			/* ************ */
			/* DESTRUCTION. */
			this.entityManager.remove(entity);
			
		}
		catch (Exception e) {
		
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode deleteById(ID)", e);
		}
		
	} // Fin de deleteById(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws Exception {
		
		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}
		
		/* retourne false si pId est hors indexes. */
		if (this.findById(pId) == null) {
			return false;
		}
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}
				
		try {
						
			/* récupération de l'ENTITY a détruire. */
			final PersonEntityJPA entity 
				= this.entityManager.find(
						PersonEntityJPA.class
							, pId);
			
			/* ************ */
			/* DESTRUCTION. */
			this.entityManager.remove(entity);
						
			return true;
				
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode deleteByIdBoolean(ID)", e);
		}
		
		return false;
		
	} // Fin de deleteByIdBoolean(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() throws Exception {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from PersonEntityJPA";

		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();
			
		}
		catch (Exception e) {
		
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode deleteAll()", e);
			
		}
		
	} // Fin de deleteAll()._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBoolean() throws Exception {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}

		boolean resultat = false;
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from PersonEntityJPA";
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();
			
			resultat = true;
			
		}
		catch (Exception e) {
					
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode deleteAllBoolean()", e);
			
		}
		
		/* retourne le boolean resultat. */
		return resultat;
		
	} // Fin de deleteAll()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteIterable(
			final Iterable<IPerson> pList) throws Exception {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}
		
		final Iterator<IPerson> ite = pList.iterator();
		
		try {
			
			while (ite.hasNext()) {
				
				final IPerson objet = ite.next();
				final IPerson objetPersistant = this.retrieve(objet);
				
				if (objetPersistant == null) {
					continue;
				}
								
				/* récupération de l'ENTITY a détruire. */
				final PersonEntityJPA entity 
					= this.entityManager.find(
							PersonEntityJPA.class
								, objetPersistant.getId());
				
				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);
				
			}
			
		}
		catch (Exception e) {
					
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_PERSONDAO_JPA_SPRING
					, "Méthode deleteIterable(Iterable)", e);
			
		}
				
	} // Fin de deleteIterable(...)._______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteIterableBoolean(
			final Iterable<IPerson> pList) throws Exception {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}

		boolean resultat = false;
		
		final Iterator<IPerson> ite = pList.iterator();
		
		try {
			
			while (ite.hasNext()) {
				
				final IPerson objet = ite.next();
				final IPerson objetPersistant = this.retrieve(objet);
				
				if (objetPersistant == null) {
					continue;
				}
				
				/* récupération de l'ENTITY a détruire. */
				final PersonEntityJPA entity 
					= this.entityManager.find(
							PersonEntityJPA.class
								, objetPersistant.getId());
				
				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);
				
			}
			
			resultat = true;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_PERSONDAO_JPA_SPRING
					, "Méthode deleteIterableBoolean(Iterable)", e);
			
		}
		
		/* retourne le boolean resultat. */
		return resultat;
				
	} // Fin de deleteIterableBoolean(...).________________________________



	/* TOOLS *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final IPerson pObject) throws Exception {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}

		boolean resultat = false;		
		IPerson objetResultat = null;
		
		/* récupération de la requête paramétrée. */
		final Query requete = this.fournirRequeteEgaliteMetier(pObject);
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (IPerson) requete.getSingleResult();
			
			/* retourne true si l'objet existe en base. */
			if (objetResultat != null) {
				resultat = true;
			}
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne false si l'Objet métier n'existe pas en base. */
			return false;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_PERSONDAO_JPA_SPRING
						, "Méthode exists(objet)", e);
		}
		
		/* retourne le boolean resultat. */
		return resultat;
		
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsId(
			final Long pId) throws Exception {
		
		/* retourne false si pId == null . */
		if (pId == null) {
			return false;
		}
		
		/* retourne true si l'objet métier existe en base. */
		if (this.findById(pId) != null) {
			return true;
		}
		
		return false;
		
	} // Fin de existsId(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() throws Exception {
		
		/* Récupère la liste d'Objets métier de Type paramétré T. */
		final List<IPerson> listObjects = this.findAll();
		
		if (listObjects != null) {
			
			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}
		
		return null;
		
	} // Fin de count().___________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireStockageDansConsole() throws Exception {
		
		final List<IPerson> stockageList = this.findAll();
		
		/* ne fait rien si this.findAll() retourne null. */
		if (stockageList == null) {
			return;
		}
		
		System.out.println(this.afficherListeObjetsMetier(stockageList));
		
	} // Fin de ecrireStockageDansConsole()._______________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListeObjetsMetier(
			final List<IPerson> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final IPerson employee : pList) {
			
			stb.append(employee.toString());
			stb.append(SAUT_LIGNE_PLATEFORME);
			
		}
		
		return stb.toString();
		
	} // Fin de afficherListeObjetsMetier(...).____________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getMessagesErrorUtilisateurList() {
		return this.messagesErrorUtilisateurList;
	} // Fin de getMessagesErrorUtilisateurList()._________________________


	
} // FIN DE LA CLASSE PersonDAOJPASpring.------------------------------------
