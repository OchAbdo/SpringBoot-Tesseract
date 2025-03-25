# API de Conversion d'Image en Texte avec Tesseract-OCR

#### Description

Ce projet est une API REST développée avec Spring Boot permettant d'extraire du texte à partir d'une image en utilisant la bibliothèque Tesseract-OCR.

## Technologies utilisées

Spring Boot (Java)

Tesseract-OCR

Maven

HTML, CSS, JavaScript (Frontend)

## Installation et Configuration

#### Prérequis

Java 17+

Maven

Tesseract-OCR installé sur votre système

### Installation de Tesseract-OCR

#### Sur Ubuntu :

- sudo apt update

- sudo apt install tesseract-ocr libtesseract-dev

- sudo apt install tesseract-ocr-fra

**Pour plus d'informations, visitez l'installateur officiel depuis GitHub : [ici](https://github.com/UB-Mannheim/tesseract/wiki)**


## Interface Frontend

Une interface simple en HTML, CSS et JavaScript est fournie pour tester l'API.

#### Emplacement du fichier

Le fichier index.html est situé dans le dossier **src/main/resources/frontend** du projet Spring Boot.

#### Fonctionnalités

Permet de sélectionner une image et de l'envoyer à l'API

Affiche le texte extrait en réponse
