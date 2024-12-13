[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/QGf4F8_h)

# Projet "Dice" - Gestion de lancés de dés avec Spring Boot

## Explication des étapes réalisées

### 1. Création du projet Spring Boot
- Utilisation de Spring Initializr pour générer un projet Maven avec les dépendances : Spring Web, Spring Data JPA, H2 Database.
- Configuration du port à 8081 dans `application.properties`.

---

### 2. Création de la classe `Dice`
- Classe permettant de simuler un lancé de dé.

---

### 3. Modélisation de l'entité `DiceRollLog`
- Entité JPA avec les champs :
  - **Nombre de dés** : Nombre de dés lancés.
  - **Résultats** : Liste des valeurs obtenues.
  - **Horodatage** : Moment du lancé.

---

### 4. Implémentation du Repository `DiceRollLogRepository`
- Interface héritant de `JpaRepository` pour gérer les enregistrements en base de données.

---

### 5. Création du service `DiceService`
- Logique métier pour :
  - Lancer des dés.
  - Enregistrer les résultats dans l'historique.

---

### 6. Création des contrôleurs REST

#### Contrôleur pour les lancés de dés (`DiceController`)
- **`GET /api/rollDice`** : Lancer un seul dé.
- **`GET /api/rollDices/{X}`** : Lancer X dés (remplacez `{X}` par un nombre).

#### Contrôleur pour l'historique (`HistoryController`)
- **`GET /api/diceLogs`** : Consulter l'historique des lancés.

---

## Bonus

### 7. Swagger - Documentation interactive des API
- Ajout de la dépendance `springdoc-openapi-starter-webmvc-ui` pour intégrer Swagger.
- Tous les endpoints sont documentés automatiquement.
- Accès à la documentation Swagger via l'interface web à l'URL :  
  **[http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)**

---

### 8. Lombok - Simplification du code
- Ajout de la dépendance Lombok pour réduire le code boilerplate.
- Utilisation des annotations suivantes :
  - **`@Data`** : Génère automatiquement les getters, setters, `toString`, et autres méthodes utiles.
  - **`@NoArgsConstructor`** et **`@AllArgsConstructor`** : Génèrent des constructeurs sans et avec arguments.
- Exemple d'optimisation avec Lombok sur l'entité `DiceRollLog` :
  ```java
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Entity
  public class DiceRollLog {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private int diceCount;

      @ElementCollection
      private List<Integer> results;

      private LocalDateTime timestamp;
  }
  ```

---

## URLs à utiliser

- **Lancer un dé** : `http://localhost:8081/api/rollDice`
- **Lancer plusieurs dés** : `http://localhost:8081/api/rollDices/{X}` (remplacez `{X}` par un nombre).
- **Consulter l'historique** : `http://localhost:8081/api/diceLogs`
- **Documentation Swagger** : `http://localhost:8081/swagger-ui.html`

---



# ---------------------------------------------------------------------------------------------------------------------

## Description
Le projet "Dice" est une application construite avec Spring Boot permettant de simuler des lancés de dés et de gérer un historique des résultats en base de données. Ce projet met en œuvre les concepts fondamentaux de Spring Boot, notamment l'injection de dépendances, les services RESTful, les entités JPA et les repositories.


## Étapes de réalisation

### 1. Création du projet Spring Boot
- Utilisez [Spring Initializr](https://start.spring.io/) pour créer le projet.
- Choisissez la dernière version de Spring Boot disponible (LTS).
- Optez pour **Maven** ou **Gradle** comme outil de gestion de dépendances.
- Ajoutez les dépendances nécessaires : **Spring Web**, **Spring Data JPA**, **H2 Database** .

### 2. Configuration du projet
- Configurez l'application pour qu'elle utilise le port **8081**.
- Donnez un nom (**dice**) au projet dans le fichier de configuration :
  - Utilisez **`application.properties`** ou **`application.yml`** selon votre préférence.

### 3. Création de la classe `Dice`
- Implémentez une classe représentant un dé avec les méthodes nécessaires pour effectuer un lancé.
- Marquez cette classe avec l'annotation `@Component` pour pouvoir l'injecter au besoin.

### 4. Création de l'entité `DiceRollLog`
- Modélisez une entité JPA `DiceRollLog` comprenant les champs suivants :
  - **`id`** : Identifiant unique.
  - **`diceCount`** : Nombre de dés lancés.
  - **`results`** : Liste ou chaîne des valeurs obtenues. Il existe de nombreuses façons de stocker des valeurs simples (simple String), certaines sont plus élégantes (@ElementCollection) que d'autres, vous pouvez choisir la solution qui vous conviendra.
  - **`timestamp`** : Horodatage du lancé.
- Utilisez des annotations JPA comme `@Entity`, `@Id`, `@GeneratedValue`, etc.

### 5. Création du `Repository`
- Implémentez une interface héritant de `JpaRepository<DiceRollLog, Long>` pour gérer les interactions avec la base de données.

### 6. Création du contrôleur REST pour lancer les dés
- Implémentez un contrôleur REST annoté avec `@RestController`.
- Ajoutez les endpoints suivants :
  - **`GET /rollDice`** : Lancer un seul dé.
  - **`GET /rollDices/{X}`** : Lancer X dés (X étant un paramètre dynamique).

### 7. Création du `Service`
- Créez un service marqué avec `@Service` contenant une méthode :
  - Prend en paramètre le nombre de dés à lancer.
  - Retourne les résultats des lancés au contrôleur.
  - Enregistre l’historique des lancés dans la base via le `Repository`.

### 8. Contrôleur pour afficher les historiques
- Ajoutez un autre contrôleur REST permettant d'afficher l'historique des lancés :
  - **`GET /diceLogs`** : Retourne tous les enregistrements de `DiceRollLog` au format JSON.

### 9. Tests et validation
- Démarrez l'application et testez les endpoints.
- Vérifiez les résultats dans la base de données et les réponses JSON.

### 10. (Bonus) Ajout de fonctionnalités avancées
- **Swagger** :
  - Ajoutez la dépendance Swagger/OpenAPI.
  - Configurez Swagger pour documenter vos endpoints.
  - Accédez à la documentation sur **`http://localhost:8081/swagger-ui.html`**.
- **Lombok** :
  - Utilisez Lombok pour simplifier les getters, setters et constructeurs de vos entités.

---

## Livrables
- Le code complet du projet, accessible via un dépôt GitHub.
- Un fichier `README.md` décrivant les étapes réalisées

## Technologies
- **Framework principal** : Spring Boot
- **Base de données** : H2 
- **Documentation API** : Swagger (bonus)
- **Simplification de code** : Lombok (bonus)
