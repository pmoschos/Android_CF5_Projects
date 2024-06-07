# My First Project

## Project Overview 🌟
Welcome to MyFirstProject2024a, an Android application designed to demonstrate basic navigation between activities. This README focuses on the `MainActivity`, `Second2Activity`, and `FavoriteActivity` classes, which manage user interactions and navigation.

## Technologies & Tools 🛠️

![Android](https://img.shields.io/badge/-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/-Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Android Studio](https://img.shields.io/badge/-Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)

## Installation 🚀
To set up this project:
1. Clone the repository to your local machine:
   ```sh
   git clone https://github.com/pmoschos/Android_CF5_Projects/tree/main/01.%20First%20Project
   ```
2. Open the project in Android Studio or your preferred IDE.
3. Build the project to resolve any dependencies:
   - Go to Build > Rebuild Project in the menu bar.
4. Run the app on an emulator or physical device.

## Usage 🏃‍♂️
Launch the app on your emulator or device.  
Click on the buttons to navigate between different activities.  

## Code Explanation 📝

### MainActivity.java
`MainActivity` extends `AppCompatActivity` and is responsible for handling user interactions and navigation to other activities.

#### UI Components:
- `Button` for navigating to `Second2Activity` (`button1`).
- `Button` for navigating to `FavoriteActivity` (`button2`).

#### Key Methods:
- `onCreate(Bundle savedInstanceState)`: Sets up the UI layout and initializes the UI components.
- `button1.setOnClickListener`: Defines the behavior for the first button, navigating to `Second2Activity`.
- `button2.setOnClickListener`: Defines the behavior for the second button, navigating to `FavoriteActivity`.

### Second2Activity.java
`Second2Activity` extends `AppCompatActivity` and represents a secondary screen in the app.

#### UI Components:
- `TextView` for displaying a message (`messageTV`).
- `Button` for submitting an action (`submitBtn`).

#### Key Methods:
- `onCreate(Bundle savedInstanceState)`: Sets up the UI layout and initializes the UI components. The `submitBtn` is set with an `OnClickListener` that starts `FavoriteActivity` and finishes the current activity.

#### Lifecycle Methods:
- `onStart()`: Logs when the activity becomes visible to the user.
- `onResume()`: Logs when the activity starts interacting with the user.
- `onPause()`: Logs when the system is about to start resuming another activity.
- `onStop()`: Logs when the activity is no longer visible to the user.
- `onRestart()`: Logs when the activity is restarting after stopping.
- `onDestroy()`: Logs when the activity is about to be destroyed.

### FavoriteActivity.java
`FavoriteActivity` extends `AppCompatActivity` and represents another screen in the app.

#### Key Methods:
- `onCreate(Bundle savedInstanceState)`: Sets up the UI layout for the favorite activity.

## Features 🌟
- Basic navigation between activities using buttons.
- Simple UI setup for demonstrating activity transitions.

## Screenshots 📸

### Main Screen
![Main Screen](https://github.com/pmoschos/MyFirstProject2024a/assets/133533759/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx)

### Second Screen
![Second Screen](https://github.com/pmoschos/MyFirstProject2024a/assets/133533759/yyyyyyyy-yyyy-yyyy-yyyy-yyyyyyyyyyyy)

### Favorite Screen
![Favorite Screen](https://github.com/pmoschos/MyFirstProject2024a/assets/133533759/zzzzzzzz-zzzz-zzzz-zzzz-zzzzzzzzzzzz)

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