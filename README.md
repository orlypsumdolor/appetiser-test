# Documentation

## Data Saving

I used Sugar ORM library for data saving. It is intended to simplify the interaction with SQLite database in Android, the data that is being fetched from the API is automatically saved int the DB. If you'll go to the `MainPresenter.java` and check the method `saveDataOnDb()` it is being called after fetching the API data. The saved data is being fetched during the initial load of the app, check `getSearchDb()` under `MainPresenter.java`. If there's no internet connection the list is being initialy populated by the data from the DB.

Also I added image caching using picasso.

## Architecture

In the app I used the MVP Architecture. Following are the reasons why I choose MVP:

- All components in the app can be tested easily and independently
- Modification of app can be done without having to refactor entire app as there is a clear separation of code related to view and app logic.
- Developers can work on building components independently.
