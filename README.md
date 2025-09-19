# 🏦 Application Console Java - Gestion des Comptes Bancaires

## 📌 Description du projet
Cette application console, développée en **Java 8**, permet de gérer les comptes bancaires et leurs opérations.  
Elle a été conçue dans le cadre d’un brief pédagogique afin de mettre en pratique la programmation orientée objet, la gestion des exceptions, et la structuration d’un projet logiciel.

Fonctionnalités principales :
- Création d’un compte **courant** ou **épargne** (avec génération automatique de code `CPT-XXXXX`).
- Gestion des **versements**, **retraits** et **virements** entre comptes.
- Consultation du **solde** et de la **liste des opérations**.
- Application automatique d’**intérêts périodiques** pour les comptes épargne (thread dédié).
- Gestion d’un **menu interactif** dans la console.

---

## 🛠️ Technologies utilisées
- **Java 8** (OOP, Threads, Exceptions)
- **Collections** : `HashMap`, `ArrayList`
- **UUID** pour les identifiants d’opérations
- **Random** pour la génération de codes de comptes

---

## 📂 Structure du projet
```
│── controller/
│ └── CompteController.java # Gestion des menus et logique de contrôle
│
│── models/
│ ├── Compte.java # Classe abstraite de base
│ ├── CompteCourant.java # Hérite de Compte, avec découvert
│ ├── CompteEpargne.java # Hérite de Compte, avec taux d'intérêt
│ ├── Operation.java # Classe abstraite pour les opérations
│ ├── Versement.java # Opération de versement
│ └── Retrait.java # Opération de retrait
│
│── Main.java # Point d'entrée de l'application
```


---

## ⚙️ Prérequis
- **Java JDK 8** ou supérieur installé
- **IDE** recommandé : IntelliJ IDEA, Eclipse, ou VS Code
- Connaissance de base de l’exécution de projets Java avec packages

---

## ▶️ Exécution
1. Cloner le projet :
   ```bash
   git clone https://github.com/KhawlaBoukniter/Banck_Project
   cd Banck_Project
2. Compiler les fichiers Java (en respectant les packages) :
    ```bash
    javac Main.java controller/*.java models/*.java
    ```
3. Lancer l’application :
    ```bash
    java Main
    ```