// Developer List Widget
$.widget("custom.developerList", {
    options: {
        developers: [], // The developer data array
        displayedDevelopers: [], // Track displayed developers
    },

    _create: function () {
        // When the widget is created, add the "developer-list" class to the element
        this.element.addClass("developer-list");

        // Call the "_displayRandomDevelopers" and "_startAutoUpdate" functions to initialize the widget
        this._displayRandomDevelopers();
        this._startAutoUpdate();
    },

    _displayRandomDevelopers: function () {
        // Get the list of remaining undevelopers that haven't been displayed
        const remainingDevelopers = this._getRemainingDevelopers();

        // Get a random selection of developers (6 in this case) from the remaining list
        const randomDevelopers = this._getRandomDevelopers(6, remainingDevelopers);

        // Clear the existing displayed developers in the widget
        this.element.empty();

        // Display the new random developers by calling "_displayDeveloperItem" for each
        randomDevelopers.forEach(this._displayDeveloperItem.bind(this));

        // Set the displayed developers to the new random developers
        this.options.displayedDevelopers = randomDevelopers;
    },

    _getRemainingDevelopers: function () {
        // Filter the full list of developers to find those that haven't been displayed yet
        return this.options.developers.filter(developer =>
            !this.options.displayedDevelopers.includes(developer)
        );
    },

    _getRandomDevelopers: function (n, source) {
        // Shuffle the list of remaining developers and select the first "n" developers
        const shuffledDevelopers = source.sort(() => 0.5 - Math.random());
        const selectedDevelopers = shuffledDevelopers.slice(0, n);

        // Add the selected developers to the displayed list
        this.options.displayedDevelopers = this.options.displayedDevelopers.concat(selectedDevelopers);

        return selectedDevelopers;
    },

    _displayDeveloperItem: function (developer) {
        // Create a developer item element and a developer info container
        const $developerItem = $("<div>").addClass("developer-item");
        const $developerInfo = $("<div>").addClass("developer-info");

        // Avatar
        const avatarSrc = developer.avatar ? developer.avatar : "Null";
        const $avatarInfo = $("<div>").addClass("info").html(`<div class="img-container"><img src="${avatarSrc}" alt="${developer.username}'s Avatar"></div>`);

        // Username
        const $usernameInfo = $("<div>").addClass("info username").text(developer.username);

        // Homepage
        const homepageURL = developer.homepageURL ? developer.homepageURL : "Null";
        const $homepageLabel = $("<div>").addClass("label").text("Homepage");
        const $homepageInfo = $("<div>").addClass("info link").html(`<a href="${homepageURL}" target="_blank">${homepageURL}</a>`);

        // Location
        const location = developer.location ? developer.location : "Null";
        const $locationLabel = $("<div>").addClass("label").text("Location");
        const $locationInfo = $("<div>").addClass("info").text(location);

        // Admin status
        const $adminLabel = $("<div>").addClass("label").text("Admin Status");
        const adminStatusText = developer.isAdmin ? "Site Admin" : "Not an Admin";
        const $adminInfo = $("<div>")
            .addClass("info")
            .addClass(developer.isAdmin ? "admin" : "not-admin")
            .text(adminStatusText);

        // Append label and info elements to developer info container
        $developerInfo.append($avatarInfo, $usernameInfo, $homepageLabel, $homepageInfo, $locationLabel, $locationInfo, $adminLabel, $adminInfo);

        // Append developer info container to the developer item
        $developerItem.append($developerInfo);

        // Append the developer item to the widget element
        this.element.append($developerItem);

        // Add a click event to show developer information in a popup when the item is clicked
        $developerItem.click(() => this._openDeveloperPopup(developer));
    },

    _openDeveloperPopup: function (developer) {
        // Get avatar source, homepage URL, location, and admin status
        const avatarSrc = developer.avatar ? developer.avatar : "Null";
        const homepageURL = developer.homepageURL ? developer.homepageURL : "Null";
        const location = developer.location ? developer.location : "Null";
        const adminStatusText = developer.isAdmin ? "Site Admin" : "Not an Admin";

        // Define the content of the popup window using HTML
        const popupContent = `
        <link rel="stylesheet" href="styles.css">
        <div class="popup-window">
            <div class="developer-info">
                <div class="info"><div class="img-container"><img src="${avatarSrc}" alt="${developer.username}'s Avatar"></div></div>
                <div class="info username">${developer.username}</div>
                <div class="label">Homepage</div>
                <div class="info"><a class="link" href="${homepageURL}" target="_blank">${homepageURL}</a></div>
                <div class="label">Location</div>
                <div class="info">${location}</div>
                <div class="label">Admin Status</div>
                <div class="info ${developer.isAdmin ? 'admin' : 'not-admin'}">${adminStatusText}</div>
                <div class="label">Followers</div>
                <div class="info">${developer.followers}</div>
                <div class="label">Public Repos</div>
                <div class="info">${developer.publicRepos}</div>
                <div class="label">Bio</div>
                <div class="info">${developer.bio || 'Null'}</div>
            </div>
        </div>
    `;

        // Use a unique window name based on the developer's username
        const windowName = developer.username;

        // Open the popup window with the defined content and set its dimensions
        const popupWindow = window.open("", windowName, "width=600,height=600");
        popupWindow.document.close();
        popupWindow.document.open();
        popupWindow.document.write(popupContent);
        popupWindow.focus();
    },

    _startAutoUpdate: function () {
        // Set an interval to periodically call "_displayRandomDevelopers" every 20 seconds
        setInterval(this._displayRandomDevelopers.bind(this), 20000);
    },

    // Public method to set the developer data
    setDevelopers: function (developers) {
        // Set the developer data array in the widget's options
        this.options.developers = developers;
        this.options.displayedDevelopers = []; // Reset displayed developers
        this._displayRandomDevelopers(); // Display random developers when data is set
    }
});



// Search Widget
$.widget("custom.searchWidget", {
    options: {
        developers: [], // The developer data array
    },

    _create: function () {
        // When the widget is created, add the "search-container" class to the element
        this.element.addClass("search-container");

        // Call the "_setupSearchInput" function to create and set up the search input field
        this._setupSearchInput();
    },

    _setupSearchInput: function () {
        // Create a search input field element
        const $searchInput = $("<input>")
            .attr("type", "text")
            .attr("id", "search-input")
            .attr("placeholder", "Search for a developer...");

        // Create a search button element
        const $searchButton = $("<button>")
            .attr("id", "search-button")
            .text("Search"); // Set the button text

        // Append both the search input and search button to the search container
        this.element.append($searchInput, $searchButton);

        // Connect a click event handler to the search button, calling the "_handleSearch" method when clicked
        $searchButton.on("click", () => this._handleSearch($searchInput.val().trim().toLowerCase()));
    },

    _handleSearch: function (searchTerm) {
        // Convert the search term to lowercase for case-insensitive comparison
        searchTerm = searchTerm.toLowerCase();

        // Find a developer in the developers array whose username matches the search term
        const developer = this.options.developers.find(d =>
            d.username.toLowerCase() === searchTerm
        );

        if (developer) {
            // If a matching developer is found, open a popup window with their information
            const avatarSrc = developer.avatar ? developer.avatar : "Null";
            const homepageURL = developer.homepageURL ? developer.homepageURL : "Null";
            const location = developer.location ? developer.location : "Null";
            const adminStatusText = developer.isAdmin ? "Site Admin" : "Not an Admin";

            // Define the content of the popup window using HTML
            const popupContent = `
            <link rel="stylesheet" href="styles.css">
            <div class="popup-window">
                <div class="developer-info">
                    <div class="info"><div class="img-container"><img src="${avatarSrc}" alt="${developer.username}'s Avatar"></div></div>
                    <div class="info username">${developer.username}</div>
                    <div class="label">Homepage</div>
                    <div class="info"><a class="link" href="${homepageURL}" target="_blank">${homepageURL}</a></div>
                    <div class="label">Location</div>
                    <div class="info">${location}</div>
                    <div class="label">Admin Status</div>
                    <div class="info ${developer.isAdmin ? 'admin' : 'not-admin'}">${adminStatusText}</div>
                    <div class="label">Followers</div>
                    <div class="info">${developer.followers}</div>
                    <div class="label">Public Repos</div>
                    <div class="info">${developer.publicRepos}</div>
                    <div class="label">Bio</div>
                    <div class="info">${developer.bio || 'Null'}</div>
                </div>
            </div>
        `;

            // Use a unique window name based on the developer's username
            const windowName = developer.username;

            // Open a popup window with content
            const popupWindow = window.open("", windowName, "width=600,height=600");
            popupWindow.document.close();
            popupWindow.document.open();
            popupWindow.document.write(popupContent);
            popupWindow.focus();
        } else {
            // If no matching developer is found, display an alert
            alert("Developer not found");
        }
    },

    // Public method to set the developer data in the widget's options
    setDevelopers: function (developers) {
        this.options.developers = developers;
    }
});


$(document).ready(function () {
    // This function is responsible for fetching developer data from the GitHub API
    function fetchDeveloperData() {
        // Send a GET request to the GitHub API to fetch a list of users
        fetch("https://api.github.com/users")
            .then(response => response.json()) // Parse the response as JSON
            .then(data => {
                // Process the fetched data and create an array of promises for each user
                const userPromises = data.map(item => {
                    // Fetch additional details for each user using their login username
                    return fetch(`https://api.github.com/users/${item.login}`)
                        .then(response => {
                            if (!response.ok) {
                                // If the response is not okay, throw an error with details
                                throw new Error(`GitHub API Error: ${response.status} ${response.statusText}`);
                            }
                            return response.json(); // Parse the response as JSON
                        })
                        .then(userDetails => ({
                            // Extract specific user details from the response and return them
                            username: userDetails.login,
                            avatar: userDetails.avatar_url,
                            homepageURL: userDetails.html_url,
                            location: userDetails.location,
                            isAdmin: userDetails.site_admin,

                            // Other details
                            followers: userDetails.followers,
                            publicRepos: userDetails.public_repos,
                            bio: userDetails.bio
                        }))
                        .catch(error => {
                            // Handle any errors that occur during the fetch
                            console.error(`Error fetching details for ${item.login}:`, error);
                            return null; // Return null for failed requests
                        });
                });

                // Wait for all promises to resolve using Promise.all
                return Promise.all(userPromises);
            })
            .then(developers => {
                // Filter out null values (failed requests) from the developers array
                const filteredDevelopers = developers.filter(developer => developer !== null);

                // Initialize the developer list widget by selecting the element with the id "developer-list"
                $("#developer-list").developerList();

                // Set the developer data using the public method "setDevelopers" of the developer list widget
                $("#developer-list").developerList("setDevelopers", filteredDevelopers);

                // Initialize the search widget by selecting the element with the id "search-container"
                $("#search-container").searchWidget();

                // Set the search data using the public method "setDevelopers" of the search widget
                $("#search-container").searchWidget("setDevelopers", filteredDevelopers);

                // Log the filtered developers to the console
                console.log(filteredDevelopers);
            })
            .catch(error => {
                // Handle errors that occur during the fetch process
                console.error("Error fetching developer data:", error);
            });
    }

    // Call the fetchDeveloperData function to initiate the data fetching process
    fetchDeveloperData();
});
