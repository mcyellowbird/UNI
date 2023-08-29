import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class FileSystem {
    private Map<String, User> users = new HashMap<>();
    private List<File> files = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private void loadSaltAndShadowFiles() {
        try {
            BufferedReader saltReader = new BufferedReader(new FileReader("salt.txt"));
            BufferedReader shadowReader = new BufferedReader(new FileReader("shadow.txt"));

            String saltLine, shadowLine;
            while ((saltLine = saltReader.readLine()) != null && (shadowLine = shadowReader.readLine()) != null) {
                String[] saltParts = saltLine.split(":");
                String[] shadowParts = shadowLine.split(":");

                String username = saltParts[0].trim();
                String passSaltHash = shadowParts[1].trim();
                int clearance = Integer.parseInt(shadowParts[2].trim());

                User user = new User(username, passSaltHash, clearance);
                users.put(username, user);
            }

            saltReader.close();
            shadowReader.close();
            System.out.println("User data loaded from salt.txt and shadow.txt\n");
        } catch (IOException e) {
            System.out.println("Error while loading user data from salt.txt and shadow.txt\n");
        }
    }

    public void createUser() {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists\n");
            return;
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (!isPasswordValid(password)) {
            System.out.println("Password requirements not met\n");
            return;
        }

        System.out.print("Confirm Password: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match\n");
            return;
        }

        int clearance;
        do {
            System.out.print("User clearance (0-3): ");
            clearance = Integer.parseInt(scanner.nextLine());
        } while (clearance < 0 || clearance > 3);

        String salt = generateRandomSalt();
        String passSaltHash = getMD5Hash(password + salt);

        users.put(username, new User(username, passSaltHash, clearance));
        System.out.println("User created successfully\n");

        updateSaltAndShadowFiles(username, salt, passSaltHash, clearance);
    }

    private boolean isPasswordValid(String password) {
        // Check for minimum length, uppercase, lowercase, digits, symbols
        // Return true if password meets requirements
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$");
    }

    private String generateRandomSalt() {
        Random random = new Random();
        StringBuilder salt = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            salt.append(random.nextInt(10));
        }
        return salt.toString();
    }

    private void updateSaltAndShadowFiles(String username, String salt, String passSaltHash, int clearance) {
        try {
            FileWriter saltFileWriter = new FileWriter("salt.txt", true);
            saltFileWriter.write(username + ":" + salt + "\n");
            saltFileWriter.flush();
            saltFileWriter.close();
            System.out.println("Updated salt.txt successfully\n");
        
            FileWriter shadowFileWriter = new FileWriter("shadow.txt", true);
            shadowFileWriter.write(username + ":" + passSaltHash + ":" + clearance + "\n");
            shadowFileWriter.flush();
            shadowFileWriter.close();
            System.out.println("Updated shadow.txt successfully\n");
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to files\n");
        }
    }

    public void loginUser() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        User user = users.get(username);
    
        if (user == null) {
            System.out.println("User not found\n");
            return;
        }
    
        String salt = getSaltFromFile(username);
        if (salt == null) {
            System.out.println("Salt not found for the user\n");
            return;
        }
    
        System.out.println(username + " found in salt.txt");
        System.out.println("salt retrieved: " + salt);
        
        System.out.println("hashing ...\n");
        System.out.print("Enter Password: ");
        String enteredPassword = scanner.nextLine(); // Prompt for password
        String enteredPassSaltHash = getMD5Hash(enteredPassword + salt);
        System.out.println("hash value: " + enteredPassSaltHash);
    
        if (user.passwordSaltHash.equals(enteredPassSaltHash)) {
            System.out.println("Authentication successful\n");
            System.out.println("User clearance: " + user.clearance);
            loggedInMenu(user);
        } else {
            System.out.println("Authentication failed\n");
        }
    }

    private String getSaltFromFile(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("salt.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(username)) {
                    return parts[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void loggedInMenu(User user) {
        while (true) {
            System.out.println("Options: (C)reate, (A)ppend, (R)ead, (W)rite, (L)ist, (S)ave or (E)xit.");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
    
            switch (choice.toLowerCase()) {
                case "c":
                    createFile(user);
                    break;
                case "a":
                    appendToFile(user);
                    break;
                case "r":
                    readFile(user);
                    break;
                case "w":
                    writeFile(user);
                    break;
                case "l":
                    listFiles();
                    break;
                case "s":
                    saveToFile();
                    break;
                case "e":
                    System.out.print("Shut down the FileSystem? (Y)es or (N)o: ");
                    String shutdownChoice = scanner.nextLine();
                    if (shutdownChoice.equalsIgnoreCase("y")) {
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
    
    public void appendToFile(User user) {
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();
    
        File file = getFile(filename);
        if (file == null) {
            System.out.println("File not found\n");
            return;
        }
    
        if (user.clearance >= file.classification) {
            // Perform append operation
            System.out.println("Append operation successful\n");
        } else {
            System.out.println("Access denied\n");
        }
    }
    
    public void readFile(User user) {
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();
    
        File file = getFile(filename);
        if (file == null) {
            System.out.println("File not found\n");
            return;
        }
    
        if (user.clearance >= file.classification) {
            // Perform read operation
            System.out.println("Read operation successful\n");
        } else {
            System.out.println("Access denied\n");
        }
    }
    
    public void writeFile(User user) {
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();
    
        File file = getFile(filename);
        if (file == null) {
            System.out.println("File not found\n");
            return;
        }
    
        if (user.clearance >= file.classification) {
            // Perform write operation
            System.out.println("Write operation successful\n");
        } else {
            System.out.println("Access denied.");
        }
    }
    
    public File getFile(String filename) {
        for (File file : files) {
            if (file.filename.equals(filename)) {
                return file;
            }
        }
        return null;
    }

    public void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("Files.store"));

            for (File file : files) {
                writer.println("Filename: " + file.filename + ", Classification: " + file.classification);
            }

            writer.close();
            System.out.println("Data saved to Files.store\n");
        } catch (IOException e) {
            System.out.println("Error while saving data to Files.store\n");
        }
    }

    public void createFile(User user) {
        System.out.print("Filename: ");
        String filename = scanner.nextLine();

        if (fileExists(filename)) {
            System.out.println("File already exists\n");
            return;
        }

        files.add(new File(filename, user.clearance));
        System.out.println("File created successfully\n");
    }

    public boolean fileExists(String filename) {
        for (File file : files) {
            if (file.filename.equals(filename)) {
                return true;
            }
        }
        return false;
    }

    public void listFiles() {
        System.out.println("Files in the FileSystem:");
        for (File file : files) {
            System.out.println("Filename: " + file.filename + ", Classification: " + file.classification);
        }
        System.out.println();
    }

    public void loadFromFile() {
        try {
            java.io.File file = new java.io.File("Files.store");
            if (!file.exists()) {
                System.out.println("Files.store not found. Skipping loading\n");
                return;
            }
    
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String filename = parts[0].trim().replace("Filename: ", "");
                    int classification = Integer.parseInt(parts[1].trim().replace("Classification: ", ""));
                    files.add(new File(filename, classification));
                }
            }
            reader.close();
            System.out.println("Data loaded from Files.store\n");
        } catch (IOException e) {
            System.out.println("Error while loading data from Files.store\n");
        }
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        Scanner scanner = new Scanner(System.in);
    
        // Report MD5 test output
        String testInput = "This is a test";
        String md5TestOutput = fs.getMD5Hash(testInput);
        System.out.println("MD5 (\"" + testInput + "\") = " + md5TestOutput + "\n");
    
        // Load data from Files.store if available
        fs.loadFromFile();
        fs.loadSaltAndShadowFiles();
    
        if (args.length == 0) {
            while (true) {
                System.out.println("1. Create User");
                System.out.println("2. Login User");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
    
                switch (choice) {
                    case 1:
                        fs.createUser();
                        break;
                    case 2:
                        fs.loginUser();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.\n");
                }
            }
        } else if (args.length == 1 && args[0].equals("-i")) {        
            fs.loginUser();
        }
    }
}