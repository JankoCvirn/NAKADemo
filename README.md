# **NAKA Test app**

_Mobile Developer Expertise Test._
Task 1:
Create a simple mobile app (Android or iOS) that performs basic user management tasks, with
the following features:
1. User List: Display a list of users, showing their first name, last name, gender, and age.
2. CRUD Functionality: Implement the ability to add, edit, and remove users.
3. Data Persistence: Ensure the user data is cached so it persists between app sessions.
4. Statistics View: Include a “Statistics” button, which presents a view displaying:
   ○ Average Age of all users
   ○ Gender Distribution: Display the percentage of male and female users
   Task 2:
   Extend the app with a second tab that integrates with an external API:
1. User Data Fetching: Create a screen that fetches a list of users from JSONPlaceholder
   (https://jsonplaceholder.typicode.com/).
2. User Details: When a user is selected, navigate to a screen displaying that user’s posts
   (also fetched from JSONPlaceholder).
3. Create Post: Add a button to create a post. Display the server response upon
   submission.
4. Error Handling: If data fetches fail, show a snackbar with an appropriate error message.
---

## **Table of Contents**

- [Features](#features)
- [Architecture](#architecture)
- [Setup and Installation](#setup-and-installation)
- [Technologies Used](#technologies-used)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

---

## **Features**

- ✨ **Feature 1**: *Step 1.*
- ✨ **Feature 2**: *Step 2.*

---

## **Architecture**

The project follows the **[MVVM]** for scalability, maintainability, and separation of concerns.

### Key Components:
- **ViewModel**: Manages UI-related data and business logic.
- **StateFlow**: Enables reactive data updates.
- **Repository**: Provides a single source of truth for data.
- **Use Cases**: Encapsulate business rules.

---

## **Setup and Installation**

### **Prerequisites**
- **Android Studio**: [Download Android Studio](https://developer.android.com/studio)
- **JDK 11 or higher**: [Install JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Gradle**: Bundled with Android Studio.

### **Steps**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/your-repo.git