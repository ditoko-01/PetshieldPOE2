#Title
PetShield – Android App (Final POE)

#Project Overview

PetShield is an Android mobile application designed to help pet owners manage their pets’ health and safety.
The app allows users to register pets, track vaccinations, report lost pets, and connect with nearby shelters and veterinarians.

It integrates:

Firebase Authentication (for secure login and registration),
Firebase Firestore Database (to store pet and user data),
Cloud Storage / API services (for pet images and reports).

The app was developed with a focus on user experience, data security, and stability, handling all invalid inputs gracefully without crashing.

Objectives and Design Considerations

Goal	                                                          Design Choice
Provide a simple and safe platform for pet management             Minimalist UI and intuitive navigation
Ensure data security and reliability	                          Firebase Auth + Firestore
Handle invalid inputs safely	                                  Input validation with inline error messages
Allow quick reporting of lost pets	                              Fast cloud sync and easy form submission
Support multiple devices	                                      Responsive layouts and real-time sync

Features

User Authentication (Login / Register / Password reset via Firebase)

Pet Registration and Profile Management

Lost Pet Reporting System

Cloud Database Integration (Firestore)

Error Handling & Input Validation

Automated Testing (JUnit / Espresso)

GitHub Actions CI/CD Build


| Login Screen               | Pet Profile                    | Lost Pet Report              | Firebase Data                    |
| -------------------------- | ------------------------------ | ---------------------------- | -------------------------------- |
| ![login](https://github.com/user-attachments/assets/c5b13983-d625-4158-955f-d109cd11dae1)
