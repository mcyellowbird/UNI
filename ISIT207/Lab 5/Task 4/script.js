// Initialize IndexedDB database
let dbPromise;
const dbName = 'developersDB';
const dbVersion = 1;

function initDatabase() {
    return new Promise((resolve, reject) => {
        const request = indexedDB.open(dbName, dbVersion);

        // Database upgrade logic
        request.onupgradeneeded = function (event) {
            const db = event.target.result;
            const objectStore = db.createObjectStore('developers', {
                keyPath: 'developerID',
                autoIncrement: true
            });

            // Create indexes for efficient querying
            objectStore.createIndex('homepageURL', 'homepageURL', {
                unique: false
            });
            objectStore.createIndex('location', 'location', {
                unique: false
            });
        };

        // Database successfully opened
        request.onsuccess = function (event) {
            dbPromise = event.target.result;
            resolve();
        };

        // Database opening error
        request.onerror = function (event) {
            reject(event.target.error);
        };
    });
}

// Add a new developer to the database
function addDeveloper() {
    const developerID = $('#developerID').val();
    const homepageURL = $('#homepageURL').val();
    const location = $('#location').val();

    // Validate inputs
    if (!developerID || !/^[a-zA-Z0-9]+$/.test(developerID)) {
        showError('Invalid Developer ID. It should contain only letters and numbers.');
        return;
    }

    if (!homepageURL || !/^https?:\/\/.*/i.test(homepageURL)) {
        showError('Invalid Home Page URL. It should start with "http://" or "https://".');
        return;
    }

    if (!location) {
        showError('Location cannot be empty.');
        return;
    }

    // Check if Developer ID already exists
    const transaction = dbPromise.transaction(['developers'], 'readonly');
    const objectStore = transaction.objectStore('developers');
    const request = objectStore.get(developerID);

    request.onsuccess = function (event) {
        const existingDeveloper = event.target.result;

        if (existingDeveloper) {
            showError('Developer ID already exists. Choose a different ID.');
        } else {
            // If ID is unique, proceed with adding the developer
            const addTransaction = dbPromise.transaction(['developers'], 'readwrite');
            const addObjectStore = addTransaction.objectStore('developers');

            const addRequest = addObjectStore.add({
                developerID,
                homepageURL,
                location
            });

            addRequest.onsuccess = function () {
                displayDevelopers();
            };

            addRequest.onerror = function (event) {
                console.error('Error adding developer:', event.target.error);
            };
        }
    };

    request.onerror = function (event) {
        console.error('Error checking existing developer ID:', event.target.error);
    };
}

// Display an error message to the user
function showError(message) {
    const errorElement = $('<div>', {
        class: 'error'
    }).text(message);
    $('#developerList').prepend(errorElement);
    setTimeout(() => errorElement.remove(), 5000); // Remove error message after 5 seconds
}

// Delete the last entry in the database
function deleteLastEntry() {
    const transaction = dbPromise.transaction(['developers'], 'readwrite');
    const objectStore = transaction.objectStore('developers');
    const request = objectStore.openCursor(null, 'prev');

    request.onsuccess = function (event) {
        const cursor = event.target.result;
        if (cursor) {
            cursor.delete();
            displayDevelopers();
        }
    };

    request.onerror = function (event) {
        console.error('Error deleting last entry:', event.target.error);
    };
}

// Delete all data in the database
function deleteAllData() {
    const transaction = dbPromise.transaction(['developers'], 'readwrite');
    const objectStore = transaction.objectStore('developers');
    const request = objectStore.clear();

    request.onsuccess = function () {
        displayDevelopers();
    };

    request.onerror = function (event) {
        console.error('Error deleting all data:', event.target.error);
    };
}

// Delete a developer by ID from the database
function deleteDeveloperByID() {
    const deleteByID = $('#deleteByID').val();
    const transaction = dbPromise.transaction(['developers'], 'readwrite');
    const objectStore = transaction.objectStore('developers');
    const request = objectStore.delete(deleteByID);

    request.onsuccess = function () {
        displayDevelopers();
    };

    request.onerror = function (event) {
        console.error('Error deleting developer by ID:', event.target.error);
    };
}

// Display all developers in the user interface
function displayDevelopers() {
    const developerList = $('#developerList');
    developerList.empty();

    const transaction = dbPromise.transaction(['developers'], 'readonly');
    const objectStore = transaction.objectStore('developers');

    const cursorRequest = objectStore.openCursor();

    cursorRequest.onsuccess = function (event) {
        const cursor = event.target.result;
        if (cursor) {
            showDeveloperFromDB(cursor);
            cursor.continue();
        }
    };

    cursorRequest.onerror = function (event) {
        console.error('Error opening cursor:', event.target.error);
    };
}

// Display a single developer in the user interface
function showDeveloperFromDB(cursor) {
    const developerList = $('#developerList');
    const developer = cursor.value;

    const table = $('<table>', {
        class: 'developer-table'
    });

    const addRow = (label, data) => {
        const row = $('<tr>');
        const labelCell = $('<td>', {
            class: 'developer-label'
        }).text(label);
        const dataCell = $('<td>', {
            class: 'dev-data'
        }).text(data);
        row.append(labelCell, dataCell);
        table.append(row);
    };

    addRow('ID', developer.developerID);
    addRow('URL', developer.homepageURL);
    addRow('Location', developer.location);

    const listItem = $('<li>', {
        class: 'developer-item'
    }).append(table);
    developerList.append(listItem);
}

// Initialize the database and display developers on document ready
$(document).ready(function () {
    initDatabase()
        .then(() => {
            displayDevelopers();
        })
        .catch((error) => {
            console.error('Error initializing database:', error);
        });
});