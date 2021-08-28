# SecureServices-SpringSecurity-Keycloak
Java + Spring boot [ keycloak, security, data-rest, data-jpa, web, thymeleaf, hateoas, devtools ] + Maven + Bootstrap + MySQL + Eclipse


Dans cette démo, on montre comment gérer la sécurité d’une application web rendu côté serveur avec l’adaptateur Keycloak.
Cette application se compose :

• Une application Front-end Web Spring MVC côté serveur basée sur thymeleaf, qui permet de gérer des livres et des gestionnaires. 
  Les livres sont stockés dans une base de données MySQL et les gestionnaires sont accessible à distance via un micro service : Bookmanager-Service.

• Microservice Book-Service, pour gérer les livres et les auteurs.

• Microservice Bookmanager-Service, pour gérer les Gestionnaires de livres.

• La gestion des livres et des gestionnaires, dans l’application Front-end, est sécurisée via un système d’authentification SSO basé sur Keycloak Server.
  
Via la console admin de keycloak : 

  •	On peut ajouter l’interface d’enregistrement des utilisateurs, authentification avec email, 
    rappeler moi, mot de passe oublié, …, en cochant les options dédiées.
    
  •	Créer un Realm : un demaine où on va sécuriser plusieurs applications (clients). 
  
  •	Ajouter les utilisateurs qui utilisent ces applications et leur attribuer des rôles : ‘USER’, ‘MANAGER’, ‘ADMIN’.

Objectif : Sécuriser l’accès au service ‘bookmanager-service’ avec Keycloak. Pour interroger ce service, il faut s’authentifier en tant qu’utilisateur avec le rôle ‘MANAGER’.
