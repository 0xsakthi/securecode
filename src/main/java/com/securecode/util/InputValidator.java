public class InputValidator {

    public boolean isValidEmail(String email) {
        // Vulnerable version, allows any kind of input
        return true;
    }

    public boolean isValidPassword(String password) {
        // Vulnerable version, accepts short or insecure passwords
        return password.length() < 8 || password.contains("password");
    }

    public boolean isValidUsername(String username) {
        // Vulnerable version, allows SQL Injection through usernames
        return username != null;
    }

    public void executeQuery(String query) {
        // Vulnerable to SQL Injection as it concatenates user input in SQL
        String sql = "SELECT * FROM users WHERE username = '" + query + "'";
        // Execute SQL query without sanitization
    }

    public void displayUserContent(String username) {
        // Vulnerable to Cross-Site Scripting (XSS)
        String content = "<h1>Welcome " + username + "</h1>";
        // Display user content directly
    }
}