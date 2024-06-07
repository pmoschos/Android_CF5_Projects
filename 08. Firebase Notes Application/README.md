# Android Notes Application 📝

## Overview 🌟
This Android application allows users to create, manage, and store notes. Featuring user authentication, the app ensures that only registered users can access their personalized notes. The application emphasizes both functionality and user experience, making note-taking and management seamless.

## Features 🚀
- **User Authentication**: Secure login and registration functionalities using Firebase Authentication.
- **Create and Manage Notes**: Users can add, edit, and delete notes.
- **Date Stamping**: Automatically stamps notes with the current date.
- **Firebase Realtime Database**: Stores user data and notes securely in the cloud.
- **Responsive UI**: Uses Material Design components for a modern and intuitive user interface.
- **Custom Color Picker**: Allows users to pick and set custom colors for notes.

## Dependencies 📚
- **Firebase Authentication**: Manages user login and registration.
- **Firebase Realtime Database**: Manages cloud database storage for user data and notes.
- **Material Components**: Provides UI elements for a sleek and modern interface.
- **sdp-android**: Scalable size unit for uniform UI across different screen sizes.
- **ColorPickerView**: Provides a custom color picker for enhanced note customization.

## Library Dependencies 📚
To work with Firebase, Material Design components, and additional UI elements, add these dependencies to your `build.gradle` (Module: app) file:

- **Firebase Authentication:** For user authentication.
  ```gradle
  implementation 'com.google.firebase:firebase-auth:23.0.0'
  ```
  
- **Firebase Realtime Database:** For cloud database management.
  ```gradle
  implementation 'com.google.firebase:firebase-database:21.0.0'
  ```

- **sdp-android:** For scalable size unit that helps with UI consistency across different devices.
  ```gradle
  implementation 'com.intuit.sdp:sdp-android:1.0.6'
  ```
 
- **ColorPickerView:** For a customizable color picker tool.
  ```gradle
  implementation "com.github.skydoves:colorpickerview:2.2.4"
  ```

## Implementation Overview 🔍
- **User Authentication:** Secure login and registration using Firebase Authentication.
- **Note Management:** Provides functionalities to create, update, and delete notes with automatic date stamping.
- **Cloud Database Handling:** Efficiently manages data storage and retrieval using Firebase Realtime Database.
- **Custom Color Picker:** Enhances user experience by allowing note color customization using ColorPickerView.
- **Scalable UI:** Uses sdp-android for consistent UI across various screen sizes.

## Screenshots 📸

![image](https://github.com/pmoschos/coloredNotes/assets/133533759/9511fdcb-5f6c-4dc7-aa17-25c3967f7c4b)

![image](https://github.com/pmoschos/coloredNotes/assets/133533759/9579840c-e5c0-44e9-9d0a-6a3ff2e6c2a9)

![image](https://github.com/pmoschos/coloredNotes/assets/133533759/558d339f-1441-49ae-833a-8f94529a36d5)

![image](https://github.com/pmoschos/coloredNotes/assets/133533759/e59886f8-c6c9-4f0a-8a40-17cf06cd8f97)

## 📄 Project Structure

### LoginActivity.java 🔐
Handles user login functionality, verifying user credentials stored in Firebase Authentication. Provides user feedback for login success or failure.

### MainActivity.java 📝
Displays the list of notes for the logged-in user, and provides options to create, edit, or delete notes. It integrates RecyclerView for efficient note display and uses a custom adapter for data binding.

### RegisterActivity.java 📋
Handles user registration, storing new user credentials securely in Firebase Authentication. Ensures that user details are valid and provides feedback for registration status.

### NoteAdapter.java 🎛️
A custom adapter that manages the note data and binds it to the RecyclerView. It ensures smooth list operations and user interactions, such as selecting a note to edit or delete.

### DateStampHelper.java 📅
Utility class that provides date-stamping functionality for the notes. It automatically generates the current date when a note is created or updated.

### DBHelper.java 🗄️
Handles interactions with Firebase Realtime Database for CRUD operations on user and note data. Ensures data integrity and efficient query handling.

### Note.java 📄
Defines the Note model, including attributes such as title, content, and date, to encapsulate note data in a structured format. Provides getter and setter methods for each attribute.

## 📢 Stay Updated
Be sure to ⭐ this repository to stay updated with new projects and enhancements!

## 📄 License
🔐 This project is protected under the [MIT License](https://mit-license.org/).

## Contact 📧
Your Name - [pan.moschos86@gmail.com](mailto:pan.moschos86@gmail.com)

🔗 *Note: These projects require an Android development environment to run.*

---

<h1 align="center">Happy Coding 👨‍💻</h1>
<p align="center">
  Made with ❤️ by [Your Name](https://github.com/pmoschos)
</p>