# Gestion_d_un_systeme_bancaire
Ce projet vise à développer une API RESTful pour la gestion d'un système bancaire, en utilisant Spring Boot pour le développement et une base de données relationnelle pour le stockage des données.

Contrat de service
Le contrat de service définissant les entrées et les sorties des web services est disponible [ici](https://drive.google.com/file/d/1PfAOxt1XIg5A__Z-7y5zqDD9DAqacJEZ/view?usp=share_li nk).

Schéma de la base de données
Le schéma de la base de données a été conçu en tenant compte des besoins du projet et des spécifications du contrat de service. Les schémas ont été élaborés en amont pour garantir une implémentation efficace.

Entités
Carte : Représente une carte bancaire associée à un compte, avec un numéro de carte, un mot de passe et une date d'expiration.
Client : Représente un client du système bancaire, avec des informations telles que le nom, le prénom, l'âge, les coordonnées, etc.
Compte : Représente un compte bancaire, avec un solde, un IBAN (International Bank Account Number) et éventuellement des cartes associées.
Transaction : Représente une transaction effectuée sur un compte, avec une date, un montant et les comptes impliqués.
Virement : Représente un virement entre deux comptes, avec une date d'exécution, un montant et les comptes émetteur et bénéficiaire.

Repositories
CarteRepository : Interface repository pour les opérations de persistance des cartes.
ClientRepository : Interface repository pour les opérations de persistance des clients.
CompteRepository : Interface repository pour les opérations de persistance des comptes.
TransactionRepository : Interface repository pour les opérations de persistance des transactions.
VirementRepository : Interface repository pour les opérations de persistance des virements.

Contrôleurs
ClientController : Contrôleur exposant les endpoints relatifs aux opérations sur les clients.
CompteController : Contrôleur exposant les endpoints relatifs aux opérations sur les comptes.
VirementController : Contrôleur exposant les endpoints relatifs aux opérations de virement.

Services
CarteService : Service contenant la logique métier pour les opérations liées aux cartes bancaires.
ClientService : Service contenant la logique métier pour les opérations liées aux clients.
CompteService : Service contenant la logique métier pour les opérations liées aux comptes bancaires.
VirementService : Service contenant la logique métier pour les opérations de virement entre comptes.

Etapes de réalisation
Création du projet Spring Boot : Utilisation de Spring Initializr avec les dépendances mentionnées dans le contrat de service.
Conception du schéma de la base de données : Schématisation des tables et des relations en fonction des besoins du projet et du contrat de service.
Connexion avec la base de données : Configuration de la connexion avec la base de données pour permettre la persistance des données.
Implémentation des entités, des repositories, des contrôleurs et des services : Développement des composants de l'application en suivant les spécifications du contrat de service.
Tests avec Postman : Utilisation de Postman pour tester régulièrement l'API et s'assurer du bon fonctionnement des endpoints.
