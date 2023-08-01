import java.util.Scanner; import java.util.ArrayList;

class MyPlaylist{

	// Globally accessible variable to reference this class to call its methods
	private static MyPlaylist playlist = new MyPlaylist();

	// Globally accessible variable used to store and retrieve each 'song' object
	private static ArrayList<Song> songs = new ArrayList<Song>();

	public static void main(String[] args){
		// Create Scanner object
		Scanner input = new Scanner(System.in);

		// Create variable to store user's input
		int inputValue = 0;

		System.out.println("\nWelcome to my playlist!");
		do{ // Repeat loop while the user's choice does not equal the choice to quit the program
			// Display welcome message
			playlist.displayWelcome();

			// Get user input
			System.out.print("Enter your choice: ");
			inputValue = input.nextInt();

			if (inputValue == 1){
				playlist.createSong();
			}

			if (inputValue == 2){
				playlist.listSongs();
			}

			if (inputValue == 3){
				playlist.removeSong();
			}

			if (inputValue == 4){
				playlist.searchSong();
			}

			if (inputValue == 5){
				playlist.displayPlaytime();
			}

		} while (inputValue != 6);
		System.out.println("\nThank you. Bye!");
		System.out.println("\n~~~~~~~~~~~~~~~~~~~");
	}

	// Display the welcome message
	public void displayWelcome(){
		System.out.println("\n~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n1 - Add a new song");
		System.out.println("2 - List all songs");
		System.out.println("3 - Remove an existing song");
		System.out.println("4 - Search for a song");
		System.out.println("5 - Display total playtime");
		System.out.println("6 - Exit");
	}

	// Method to create a song
	public void createSong(){
		// Create Scanner object
		Scanner songDetails = new Scanner(System.in);

		System.out.println("\n~~~~~~~~~~~~~~~~~~~");

		// Get user inputs
		System.out.print("\nTitle of the song: ");
		String songName = songDetails.nextLine();

		System.out.print("Name of the artist: ");
		String songArtist = songDetails.nextLine();

		System.out.print("Genre of the song: ");
		String songGenre = songDetails.nextLine();

		System.out.print("Duration (Seconds): ");
		int songDuration = songDetails.nextInt();

		// Create a new song based off user input
		Song newSong = new Song(songName, songArtist, songGenre, songDuration);

		// Add the newly created song object to the songs List
		songs.add(newSong);
	}

	// Method to list all songs
	public void listSongs(){
		System.out.println("\n~~~~~~~~~~~~~~~~~~~");

		// Loop through each song and display its details
		for (int i = 0; i < songs.size(); i++){
			// Declare temporary variable to store each song
			Song tempSong = songs.get(i);
			System.out.println("\nTrack " + (i+1));
			System.out.println("Title: " + tempSong.getTitle());
			System.out.println("Artist: " + tempSong.getArtist());
			System.out.println("Genre: " + tempSong.getGenre());
			System.out.println("Duration (Seconds): " + tempSong.getDuration());
		}

		// If there are no songs in the List, then display this message
		if (songs.isEmpty()){
			System.out.println("\nThere are no songs in your playlist");
		}
	}

	// Method to remove a song
	public void removeSong(){
		// Create Scanner object
		Scanner remove = new Scanner(System.in);
		System.out.println("\n~~~~~~~~~~~~~~~~~~~");

		// Check if the songs List is not empty (This is is a different way to write same FOR loop and IF statement in the listSongs() method)
		if (!songs.isEmpty()){
			// Print total amount of songs in the songs List
			System.out.printf("\nThere are %d song(s) in your playlist:", songs.size());

			// Loop through each song and print its number in the songs List and its title 
			for (int i = 0; i < songs.size(); i++){
				// Declare temporary variable to store each song
				Song tempSong = songs.get(i);
				System.out.printf("\n%d: %s", (i+1), tempSong.getTitle());
			}

			// Prompt user for input
			System.out.print("\n\nSelect a song to remove (Input the index): ");

			int removeVal = remove.nextInt();

			// Print the removed song (removeVal-1 is needed because the index is 1 less than the input value)
			System.out.printf("\n%s is removed from your playlist\n", songs.get((removeVal-1)).getTitle());

			// Remove the song from the List
			songs.remove((removeVal-1));
		}

		// If the songs list is empty, display this message
		else {System.out.println("\nThere are no songs in your playlist");}
	}

	// Method to search for a song
	public void searchSong(){
		// Create Scanner object
		Scanner search = new Scanner(System.in);
		System.out.println("\n~~~~~~~~~~~~~~~~~~~");

		// Prompt user for input
		System.out.printf("\nEnter the title of the song: ");
		String title = search.nextLine();

		// Loop through each song and display its details if the song title matches the user's input ONLY if there are songs in the List
		if (songs.size() > 0){
			for (int i = 0; i < songs.size(); i++){
				Song tempSong = songs.get(i);
				if (title.equals(tempSong.getTitle())){
					System.out.println("\nSong found, here are its details:\n");
					System.out.println("Track " + (i+1));
					System.out.println("Title: " + tempSong.getTitle());
					System.out.println("Artist: " + tempSong.getArtist());
					System.out.println("Genre: " + tempSong.getGenre());
					System.out.println("Duration (Seconds): " + tempSong.getDuration());
					break;
				}
				// This message will display if the counter equals the size of the songs List (ie. the last song in the List)
				if ((i+1) == songs.size()){
					System.out.println("\nSong not found in your playlist");
				}
			}
		}
		else System.out.println("\nSong not found in your playlist");
	}

	// Method to display total playtime for the playlist
	public void displayPlaytime(){
		System.out.println("\n~~~~~~~~~~~~~~~~~~~");

		// Variable to store total playtime
		int totalPlaytime = 0;
		// Variable to store the titles for each song in one line
		String songTitles = "";

		// Loop through each song
		for (int i = 0; i < songs.size(); i++){
			Song tempSong = songs.get(i);

			// Add the current song's duration to the variable for the playlist's total playtime
			totalPlaytime += tempSong.getDuration();
			// If there is only one song in the list, set the songTitles variable to that song's title
			if (songs.size() == 1){
				songTitles = tempSong.getTitle();
			}

			// Otherwise, if there are more than one song in the list, add the current song's title to the songTitles variable along with a comma
			else if ((i+1) < songs.size()){
				songTitles += tempSong.getTitle() + ", ";
			}

			// Otherwise, if the current song is the last song in the list, add the current song's title to the songTitles variable
			else if ((i+1) == songs.size()){
				songTitles += tempSong.getTitle();
			}
		}

		// Calculation to display hours, minutes and seconds
		int hours, minutes, seconds;
		hours = totalPlaytime / 3600;
		minutes = (totalPlaytime % 3600) / 60;
		seconds = totalPlaytime % 60;

		// If the amount of hours is greater than 0, display this message
		if (hours > 0){
			System.out.printf("\nThe total playtime for %d songs (%s) is %d hours %d minutes and %d seconds\n", songs.size(), songTitles, hours, minutes, seconds);
		}

		// Otherwise, display this message
		else{
			System.out.printf("\nThe total playtime for %d songs (%s) is %d minutes and %d seconds\n", songs.size(), songTitles, minutes, seconds);
		}
	}
}

class Song{
	private String title;
	private String artist;
	private String genre;
	private int duration;

	// Constructor
	public Song(String t, String a, String g, int d){
		this.title = t;
		this.artist = a;
		this.genre = g;
		this.duration = d;
	}

	// Method to return the song's title
	public String getTitle(){
		return title;
	}

	// Method to return the song's artist
	public String getArtist(){
		return artist;
	}

	// Method to return the song's genre
	public String getGenre(){
		return genre;
	}

	// Method to return the song's duration
	public int getDuration(){
		return duration;
	}
}