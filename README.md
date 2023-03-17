# SchedulerApp

* The application manages the schedule of a user. it allows a user to create an event and it displays the list of events.
* Built with Kotlin

# Architecture
The application was built with MVVM (Model, View, View-Model) architecture and it followed the single activity and multiple fragment pattern


# Major Dependencies
* **View Binding**: The app uses view binding to bind views and layouts to reduce boilerplate code
* **Navigation Component**: The app uses a navigation component to connect between fragments
* **Kotlin flows and coroutine**: The app uses flow to respond/observe changes and to handle data asynchronously
* **Unit test**: The app uses the default Junit for unit-test implementation.

# Project Structure

The app has the following structure
* data: This package contains the model and  repository
* ui: This package contains files that are responsible for the UI/View logic and implementation
* utils: This package is responsible for classes that are used across the application
* Gradle Scripts
    * These scripts are responsible for dependencies and plugins necessary for the project


# How to start the application

1. Download Android Studio

2. Clone or fork the repository by running the command below on your terminal

```
git clone https://github.com/Gabrielhephzibah/SchedulerApp.git

```
3. You can also open the zip file of the project

4. Import or open the project on Android Studio

5. Open build.gradle in Android Studio and sync

6. Run the app on an emulator or directly on an Android device.


# Test
* The app contains basic unit-test cases in the test package.

# Completed Stories
* Story 1: On the right tab, you should have a simple component with the list of clients
* Story 2: Every client should lead to a client details page where 
* Story 3: you can schedule events by providing the day of the week, start time, and end time
* Story 4: On the left tab, the user should find the simple table with upcoming events
* Story 5: Every event should lead to the event details page where you can find following
   information about the event:
- Client details
- Start and end time of the event
- Notes for the event


# Copyright
* Copyright (c) 2023 Gabriel Hephzibah