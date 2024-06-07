# Coding Factory Android Layout 📱

![Total Views](https://views.whatilearened.today/views/github/pmoschos/android-projects.svg) ![Java](https://img.shields.io/badge/language-Java-orange.svg) ![GitHub last commit](https://img.shields.io/github/last-commit/pmoschos/Android_CF5_Projects) ![License](https://img.shields.io/badge/license-MIT-green.svg)

## Overview 🌟
Welcome to the Coding Factory Android Layout repository, a simple yet effective layout designed for an Android application. This layout provides buttons for different programming languages and technologies, aimed at enhancing the user interface for coding enthusiasts.

## About the Repository 📖
This repository contains a single XML layout file that can be used as a template for Android applications focusing on various programming languages. It is a great starting point for creating educational apps or projects.

## Repository Contents 📂
- XML Layout for a vertical linear layout containing:
  - A `TextView` displaying "Coding Factory"
  - Multiple `LinearLayout` elements, each containing buttons for different programming languages

## 📸 Screenshot
![image](https://github.com/pmoschos/NestedLinearLayouts/assets/133533759/101471a2-4d93-45ff-9032-9abc90eef128)

## XML Layout Preview 📄

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:weightSum="13"
    android:background="@color/gray"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:text="Coding Factory"
        android:gravity="center"
        android:textSize="40sp"
        android:textStyle="bold"
        android:layout_weight="4" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="2"
        android:orientation="horizontal"
        android:weightSum="2">

        <Button
            android:id="@+id/javaBtn"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:layout_margin="18dp"
            android:textSize="22sp"
            android:text="Java" />

        <Button
            android:id="@+id/cBtn"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:layout_margin="18dp"
            android:textSize="22sp"
            android:text="C#" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="2"
        android:orientation="horizontal"
        android:weightSum="2">

        <Button
            android:id="@+id/pythonBtn"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:layout_margin="18dp"
            android:textSize="22sp"
            android:text="Python" />

        <Button
            android:id="@+id/phpBtn"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:layout_margin="18dp"
            android:textSize="22sp"
            android:text="Php" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="2"
        android:orientation="horizontal"
        android:weightSum="2">

        <Button
            android:id="@+id/javascriptBtn"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:layout_margin="18dp"
            android:textSize="22sp"
            android:text="Javascript" />

        <Button
            android:id="@+id/angularBtn"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:layout_margin="18dp"
            android:textSize="22sp"
            android:text="Angular" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="2"
        android:orientation="horizontal"
        android:weightSum="2">

        <Button
            android:id="@+id/sqlBtn"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:layout_margin="18dp"
            android:textSize="22sp"
            android:text="SQL" />

        <Button
            android:id="@+id/mongodbBtn"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:layout_margin="18dp"
            android:textSize="22sp"
            android:text="MONGODB" />
    </LinearLayout>

    <TextView
        android:id="@+id/bottomTV"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:textSize="20sp"
        android:textStyle="bold"
        android:gravity="center"
        android:text="Android Development" />
</LinearLayout>
```

## Getting Started 🚀
To get started with this layout:

1. Ensure Android Studio is installed on your machine.
2. Clone the repository:
   ```sh
   git clone https://github.com/pmoschos/Android_CF5_Projects
   ```
3. Open the project in Android Studio.
4. Add the provided XML layout to your project's `res/layout` directory.
5. Customize and extend the layout as needed for your application.

## 📢 Stay Updated
Be sure to ⭐ this repository to stay updated with new projects and enhancements!

## 📄 License
🔐 This project is protected under the [MIT License](https://mit-license.org/).

## Contact 📧
Your Name - pan.moschos86@gmail.com

🔗 *Note: These projects require an Android development environment to run.*

---
<h1 align=center>Happy Coding 👨‍💻 </h1>

<p align="center">
  Made with ❤️ by Your Name (https://github.com/pmoschos)
</p>
