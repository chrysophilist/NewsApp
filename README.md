# NewsApp

A modern Android application built with **Kotlin** and **Jetpack Compose**, providing live news articles from NewsAPI.org

[![Platform](https://img.shields.io/badge/Platform-Android-green)](https://developer.android.com/)
[![Language](https://img.shields.io/badge/Language-Kotlin-blue)](https://kotlinlang.org/)
[![UI](https://img.shields.io/badge/UI-Jetpack%20Compose-orange.svg)](https://developer.android.com/jetpack/compose)

## 📱 Screenshots

<table>
  <tr>
    <td><img src="screenshots/HomeScreenLight.jpg" width="200" alt="HomeScreenLight"/><br>HomeScreen Light</td>
    <td><img src="screenshots/DetailsScreenLight.jpg" width="200" alt="DetailsScreenLight"/><br>DetailsScreen Light</td>
    <td><img src="screenshots/HomeScreenDark.jpg" width="200" alt="HomeScreenDark"/><br>HomeScreen Dark</td>
    <td><img src="screenshots/DetailsScreenDark.jpg" width="200" alt="DetailsScreenDark"/><br>DetailsScreen Dark</td>
  </tr>
</table>


## 🗂️ Table of Contents

- [Features](#-features)
- [Installation](#-installation)
- [Screenshots](#-screenshots)
- [Project Structure](#-project-structure)
- [Tech Stack](#-tech-stack)
- [License](#-license)
- [Notes](#-notes)
- [Contact](#-contact)

## ✨ Features

- **📰 Latest News Feed**: Browse the latest news articles from the source.
- **📖 Detailed Article View**: Tap on an article to view its detailed content
- **🚀 Smooth Navigation**: Seamless navigation between screens using **Jetpack Compose Navigation**
- **🧠 UI State Handling**: Manage UI state with **ViewModel** and **Compose**
- **⚡ Asynchronous Data Loading**: Fetch data asynchronously with **Kotlin Coroutines**
- **🖼️ Image Loading**: Efficient image loading with **Coil**
- **🧩 Dependency Injection**: Use **Hilt** for dependency management

---

📦 **First Stable Release:** `v1.0`

## 🛠 Installation

To set up the project locally, follow these steps:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/chrysophilist/NewsApp.git
   ```

2. **Open in Android Studio**:
    - Launch Android Studio.
    - Select `Open an existing project` and navigate to the cloned repository folder.
3. **Install dependencies**:
    - Ensure you have the Android SDK configured.
    - Sync the project with Gradle (via `File → Sync Project with Gradle Files`).
4. **Add your NewsAPI key**:
    - Create a file `local.properties` in the project root (if not present).
    - Add:

   ```properties
   NEWS_API_KEY=your_api_key_here
   ```

5. **Run the app**:
    - Connect an Android device or use an emulator.
    - Click `Run` in Android Studio to build and deploy the app.

## 📁 Project Structure

```bash
NewsApp/
├── app/
│   ├── manifests/
│   │   └── AndroidManifest.xml         # App manifest
│   ├── java/com/prince/newsapp/
│   │   ├── NewsApp.kt                  # Application class (Hilt Base app)
│   │   ├── MainActivity.kt             # Launch activity
│   │   ├── di/                         # Dependency Injection (Hilt modules)
│   │   │   └── Modules.kt
│   │   ├── models/                     # Data classes for API responses
│   │   │   ├── Article.kt
│   │   │   ├── NewsResponse.kt
│   │   │   └── Source.kt
│   │   ├── navigation/                 # Compose navigation components
│   │   │   ├── NewsAppRoute.kt
│   │   │   └── NewsNavApp.kt
│   │   ├── network/                    # API service interfaces
│   │   │   └── NewsApiService.kt
│   │   ├── repo/                       # Repository layer
│   │   │   └── NewsRepository.kt
│   │   ├── ui/
│   │   │   ├── components/            # Reusable UI components
│   │   │   ├── views/                 # App screens (Home, Details)
│   │   │   └── theme/                 # Theme, colors, typography
│   │   │       ├── Color.kt
│   │   │       ├── Theme.kt
│   │   │       └── Type.kt
│   │   └── viewModels/                 # ViewModels & UiStates
│   │       ├── NewsViewModel.kt
│   │       ├── NewsUiState.kt
│   │       ├── NewsDetailsViewModel.kt
│   │       └── NewsDetailsUiState.kt
├── res/                                 # Resources
├── build.gradle.kts                     # Module-level Gradle build script
└── settings.gradle.kts                  # Project settings
```

## 🏗 Tech Stack

### 🧠 Core

- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **State Management**: ViewModel + Coroutines
- **Serialization**: Kotlinx Serialization

### 🎨 UI

- **Framework**: Jetpack Compose
- **Navigation**: Navigation Compose
- **Design Principles**: Declarative UI + Reactive State Handling

### ⚙️ Data & Networking

- **Networking**: REST APIs via Retrofit
- **Data Source**: [NewsAPI](https://newsapi.org/) – Global news data provider

### 🧩 Tooling

- **Dependency Injection**: Hilt / Dagger
- **Build System**: Gradle (Kotlin DSL)

## 📄 License

This project is licensed under the **MIT License**. See [LICENSE](LICENSE) for details.

## 📝 Notes

- You need a free API key from [NewsAPI.org](https://newsapi.org/) to fetch live news.
- Make sure to add your API key in the appropriate configuration file (e.g., `build.gradle` or `Local.properties`).

## 👤 Contact

For questions or feedback, reach out to:

- **Email**: <princekumarjnvmdb@gmail.com>
- **LinkedIn**: [princekr2480](https://www.linkedin.com/in/princekr2480/)
