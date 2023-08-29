public class User {
    String username;
    String passwordSaltHash;
    int clearance;

    User(String username, String passwordSaltHash, int clearance) {
        this.username = username;
        this.passwordSaltHash = passwordSaltHash;
        this.clearance = clearance;
    }
}