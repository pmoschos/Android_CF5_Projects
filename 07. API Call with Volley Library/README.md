# Movie Search - Anroid Application 🎥

## Overview 🌟
This Android application allows users to search for movies. Utilizing the IMDb API, it fetches and displays information about movies. Users can enter a movie title in the search field, and the app presents a list of relevant movies, complete with details like title, description, and image.

## Features 🚀
- **Search Functionality**: Users can enter a movie title to retrieve and display matching results.
- **RecyclerView**: Efficient display of movie listings.
- **Picasso Library**: Enables image loading and rendering.
- **Volley Library**: Manages network requests for movie data retrieval.

## Dependencies 📚
- **Volley**: Handles network requests.
- **Picasso**: Manages image loading.
- **Material Components**: Provides UI elements.

## Library Dependencies 📚
To work with network data and images, the application depends on two key libraries: Volley and Picasso. Add these dependencies to your `build.gradle` (Module: app) file:

- **Volley Library:** For network requests and data retrieval.
  ```gradle
  implementation 'com.android.volley:volley:1.2.1'
   ```
- **Picasso Library:** For image loading and caching.
  ```gradle
  implementation 'com.squareup.picasso:picasso:2.71828'
   ```

## Implementation Overview 🔍
- **ListView with Network Data:** Demonstrates how to populate a `ListView` with data fetched using Volley. This is essential for applications that require dynamic data retrieval from a server or an API.
- **Image Handling:** Showcases the use of Picasso to efficiently load and display images within the application. Picasso simplifies the process of image loading, caching, and display, making it a valuable tool for apps that handle a lot of images.

## Screenshots 📸
![image](https://github.com/pmoschos/ImdbMovieSearch2023a/assets/133533759/5e9a4d3f-b565-43cc-8454-f510a3a67f06)

## 📄 Project Structure

### MainActivity.java 📝
Handles the main activities and initializes the RecyclerView with a list of movies. It also implements swipe-to-delete functionality and manages the undo feature for accidental deletions.

### MovieAdapter.java 🎛️
A custom adapter that manages the movie data and binds it to the RecyclerView, ensuring smooth list operations and user interactions.

### Movie.java 🎬
Defines the Movie model, including attributes such as title, category, and image, to encapsulate movie data in a structured format.

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
