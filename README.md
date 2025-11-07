#Title PetShield – Android App (Final POE)

#Project Overview

PetShield is an Android mobile application designed to help pet owners manage their pets’ health and safety. The app allows users to register pets, track vaccinations, report lost pets, and connect with nearby shelters and veterinarians.
It integrates:
Firebase Authentication (for secure login and registration), Firebase Firestore Database (to store pet and user data), Cloud Storage / API services (for pet images and reports).
The app was developed with a focus on user experience, data security, and stability, handling all invalid inputs gracefully without crashing.
#Objectives and Design Considerations
Goal	Design Choice
Provide a simple and safe platform for pet management     	Minimalist UI and intuitive navigation
Ensure data security and reliability	                      Firebase Auth + Firestore
Handle invalid inputs safely	                               Input validation with inline error messages
Allow quick reporting of lost pets	Fast                      cloud sync and easy form submission
Support multiple devices                                    	Responsive layouts and real-time sync


Features
	User Authentication (Login / Register / Password reset via Firebase)
	Pet Registration and Profile Management
	Lost Pet Reporting System
	Cloud Database Integration (Firestore)
	Error Handling & Input Validation
	Automated Testing (JUnit )
	GitHub Actions CI/CD Build
| Login Screen | Pet Profile | Lost Pet Report | 
screens.pdf


#Installation and Setup

To build and run PetShield locally:
Clone the repository:
https://github.com/ditoko-01/PetshieldPOE2.git
Open the project in Android Studio. Connect Firebase: Add your google-services.json file in /app. Build and run the app:
./gradlew assembleDebug
Automated Testing and CI/CD
The app uses GitHub Actions to automate builds and run tests on each commit to the main branch.
Tests performed:
•	Unit Tests: Verify pet registration logic, validation, and database sync.
•	UI Tests: Espresso tests ensure all screens respond correctly.
•	Build Test: Confirms successful Gradle build and artifact creation.

Data Storage (What’s Stored Online)

Firebase Authentication:

•	Stores user UID, email, and registration time (no passwords in plaintext).
Firestore Database:
•	Users collection (user info)
•	Pets collection (pet name, breed, vaccination data)
•	LostReports collection (pet details, last location, contact info)
Storage:
•	Pet images and report photos are stored in Firebase Storage and linked to document IDs.

 Release Notes
 
Version 1.0 – Final 

New Features Added:

•	Firebase Authentication (Login, Register, Reset Password)
•	Pet registration and management with Firestore
•	Lost Pet reporting feature with image upload
•	Input validation for all forms
•	Integrated GitHub Actions for automated builds
Improvements Since Prototype:
•	UI redesigned for clarity and consistency
•	Error handling and crash prevention implemented
•	Optimized Firestore reads/writes

Innovative Features:

•	Real-time lost pet updates for community users
•	Automatic data sync with cloud database
•	Notification feature for nearby lost pets (in development)

Video Demonstration

Watch the full demonstration with voice-over

AI Tools Usage Statement

	Assist with debugging minor Kotlin syntax errors
	All AI outputs were reviewed, customized, and tested manually before inclusion.

