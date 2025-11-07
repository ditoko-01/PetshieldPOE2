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
https://youtu.be/iwifFyETHAY?si=Xc8bLYCkeh6FjIwM
AI Tools Usage Statement

	Assist with debugging minor Kotlin syntax errors
	All AI outputs were reviewed, customized, and tested manually before inclusion.


To help with formatting, layout design, and structural organization, our team which consisted of Syntiche Ikanga, Syntiche Ditoko, and Harvey used AI technologies in a restricted and supportive capacity during the assignment's completion. In addition to offering advice on space, font consistency, and visual clarity, the assistant also proposed a grid-based structure for Canva and gave samples of how to style resource boxes. These inputs made the initial setup process more efficient and guaranteed a clear and easily readable diagram.
However, our team independently built the main content, which included resource structure, endpoint specification, and attribute selection. We made sure that every resource was technically correct and logically organized by researching RESTful API conventions and applying them to the PetShield environment. The judgments were based on our own knowledge of backend architecture and academic standards; the assistant did not define the relationships or characteristics or produce any code.
In addition to the diagram, we separately finished the entire assignment, which included writing the supporting documentation, establishing the API structure, and creating the layout in Canva. To guarantee readability and professionalism, we selected the background, font sizes, and spacing. Additionally, we made conscious decisions to consider
the PetShield project's accessibility and emotional warming objectives, including the use of color coding and iconography to promote inclusive design.
The written documentation was created by hand and included technical explanations, attribute definitions, and endpoint descriptions. We made sure that every term adhered to RESTful standards and was suitable for academic settings. To satisfy POE requirements, we clarified resource linkages and changed any unclear terminology as needed. Although we examined and improved all final work, the assistant was occasionally engaged to confirm formatting consistency or offer clearer wording.
There was no usage of automated code aid, debugging, or image production. Rather than interfering with the technical or artistic choices, the AI tool acted as a cooperative sounding board, assisting us in improving the diagram's presentation and structure. We made sure that the finished product represented our team's work, academic integrity, and design ideals after reviewing and tailoring all content to the project's particular needs.
In conclusion, we were responsible for the technical content, visual execution, and academic alignment, while AI tools aided in speeding up the formatting process and offering layout recommendations. This strategy gave us the organizational help that AI technologies can provide while preserving complete control over the assessment's technical and creative components. Although the layout and structure directly acknowledged the assistant's contributions, the finished product reflects the efforts and knowledge of our team.

Poe final documantation 
[OPEN SOURCE CODING - part 3.pdf](https://github.com/user-attachments/files/23425539/OPEN.SOURCE.CODING.-.part.3.pdf)
