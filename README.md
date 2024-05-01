# Gestion_d_un_systeme_bancaire

Ce projet vise à développer une API RESTful pour la gestion d'un système bancaire, en utilisant Spring Boot pour le développement et une base de données relationnelle pour le stockage des données.

## Contrat de service

Le contrat de service définissant les entrées et les sorties des web services est disponible [ici](https://drive.google.com/file/d/1PfAOxt1XIg5A__Z-7y5zqDD9DAqacJEZ/view?usp=share_li nk).

## Schéma de la base de données

Le schéma de la base de données a été conçu en tenant compte des besoins du projet et des spécifications du contrat de service. Les schémas ont été élaborés en amont pour garantir une implémentation efficace.

## Entités

1. **Carte** : Représente une carte bancaire associée à un compte, avec un numéro de carte, un mot de passe et une date d'expiration.
2. **Client** : Représente un client du système bancaire, avec des informations telles que le nom, le prénom, l'âge, les coordonnées, etc.
3. **Compte** : Représente un compte bancaire, avec un solde, un IBAN (International Bank Account Number) et éventuellement des cartes associées.
4. **Transaction** : Représente une transaction effectuée sur un compte, avec une date, un montant et les comptes impliqués.
5. **Virement** : Représente un virement entre deux comptes, avec une date d'exécution, un montant et les comptes émetteur et bénéficiaire.

## Repositories

1. **CarteRepository** : Interface repository pour les opérations de persistance des cartes.
2. **ClientRepository** : Interface repository pour les opérations de persistance des clients.
3. **CompteRepository** : Interface repository pour les opérations de persistance des comptes.
4. **TransactionRepository** : Interface repository pour les opérations de persistance des transactions.
5. **VirementRepository** : Interface repository pour les opérations de persistance des virements.

## Contrôleurs

1. **ClientController** : Contrôleur exposant les endpoints relatifs aux opérations sur les clients.
2. **CompteController** : Contrôleur exposant les endpoints relatifs aux opérations sur les comptes.
3. **VirementController** : Contrôleur exposant les endpoints relatifs aux opérations de virement.

## Services

1. **CarteService** : Service contenant la logique métier pour les opérations liées aux cartes bancaires.
2. **ClientService** : Service contenant la logique métier pour les opérations liées aux clients.
3. **CompteService** : Service contenant la logique métier pour les opérations liées aux comptes bancaires.
4. **VirementService** : Service contenant la logique métier pour les opérations de virement entre comptes.

## Etapes de réalisation

1. **Création du projet Spring Boot** : Utilisation de [Spring Initializr](https://start.spring.io/) avec les dépendances mentionnées dans le contrat de service.
2. **Conception du schéma de la base de données** : Schématisation des tables et des relations en fonction des besoins du projet et du contrat de service.
3. **Connexion avec la base de données** : Configuration de la connexion avec la base de données pour permettre la persistance des données.
4. **Implémentation des entités, des repositories, des contrôleurs et des services** : Développement des composants de l'application en suivant les spécifications du contrat de service.
5. **Tests avec Postman** : Utilisation de Postman pour tester régulièrement l'API et s'assurer du bon fonctionnement des endpoints.


