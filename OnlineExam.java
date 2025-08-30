import java.util.*;
class OnlineExam {
    static Scanner sc = new Scanner(System.in);
    static String username = "student";
    static String password = "1234";
    static String profileName = "Student User";
    public static void main(String[] args) {
        if (login()) {
            int choice;
            do {
                System.out.println("\n===== ONLINE EXAMINATION SYSTEM =====");
                System.out.println("1. Update Profile/Password");
                System.out.println("2. Take Exam (MCQ)");
                System.out.println("3. Logout");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1: updateProfile(); break;
                    case 2: takeExam(); break;
                    case 3: System.out.println("Logging out... Goodbye!"); break;
                    default: System.out.println("Invalid choice!");
                }
            } while (choice != 3);
        }
    }
    static boolean login() {
        System.out.println("===== LOGIN =====");
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter username: ");
            String u = sc.next();
            System.out.print("Enter password: ");
            String p = sc.next();
            if (u.equals(username) && p.equals(password)) {
                System.out.println("Login successful! Welcome " + profileName);
                return true;
            } else {
                attempts--;
                System.out.println("Invalid credentials. Attempts left: " + attempts);
            }
        }
        System.out.println("Too many failed attempts. Exiting...");
        return false;
    }
    static void updateProfile() {
        System.out.println("===== UPDATE PROFILE =====");
        System.out.print("Enter new name: ");
        sc.nextLine(); // clear buffer
        profileName = sc.nextLine();
        System.out.print("Enter new password: ");
        password = sc.next();
        System.out.println("Profile updated successfully!");
    }
    static void takeExam() {
        System.out.println("===== ONLINE EXAM =====");
        String[] questions = {
            "Q1. Java is a ____ ?\n1. Programming Language\n2. Operating System\n3. Database\n4. Game Engine",
            "Q2. Which keyword is used to inherit a class in Java?\n1. this\n2. super\n3. extends\n4. implements",
            "Q3. Which of these is not a primitive type?\n1. int\n2. String\n3. float\n4. char"
        };
        int[] answers = {1, 3, 2};  // correct answers
        int score = 0;
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 30 * 1000; // 30 seconds
        for (int i = 0; i < questions.length; i++) {
            long currentTime = System.currentTimeMillis();
            if (currentTime > endTime) {
                System.out.println("\nTime is up! Auto-submitting exam...");
                break;
            }
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            int ans = sc.nextInt();
            if (ans == answers[i]) {
                score++;
            }
        }
        System.out.println("Exam Finished! Your Score: " + score + "/" + questions.length);
    }
}
