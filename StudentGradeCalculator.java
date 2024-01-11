import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Student Grade Calculator =====");
        
        // Input grades for different components
        double assignmentsGrade = getValidGrade("Enter your assignments grade: ", scanner);
        double quizzesGrade = getValidGrade("Enter your quizzes grade: ", scanner);
        double midtermExamGrade = getValidGrade("Enter your midterm exam grade: ", scanner);
        double finalExamGrade = getValidGrade("Enter your final exam grade: ", scanner);

        // Define grading scale
        double[] gradeRanges = {90, 80, 70, 60, 0};
        char[] letterGrades = {'A', 'B', 'C', 'D', 'F'};

        // Calculate overall course grade
        double overallGrade = calculateOverallGrade(assignmentsGrade, quizzesGrade, midtermExamGrade, finalExamGrade);

        // Determine letter grade
        char letterGrade = determineLetterGrade(overallGrade, gradeRanges, letterGrades);

        // Display result
        System.out.println("\n===== Result =====");
        System.out.println("Overall Grade: " + overallGrade);
        System.out.println("Letter Grade: " + letterGrade);
    }

    private static double getValidGrade(String prompt, Scanner scanner) {
        double grade;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid numerical grade.");
                scanner.next(); // consume the invalid input
            }
            grade = scanner.nextDouble();

            if (grade < 0 || grade > 100) {
                System.out.println("Invalid input. Grade should be between 0 and 100.");
            }
        } while (grade < 0 || grade > 100);

        return grade;
    }

    private static double calculateOverallGrade(double assignmentsGrade, double quizzesGrade,
                                                double midtermExamGrade, double finalExamGrade) {
        // You can use weighted averages here if needed
        return (assignmentsGrade + quizzesGrade + midtermExamGrade + finalExamGrade) / 4;
    }

    private static char determineLetterGrade(double overallGrade, double[] gradeRanges, char[] letterGrades) {
        for (int i = 0; i < gradeRanges.length; i++) {
            if (overallGrade >= gradeRanges[i]) {
                return letterGrades[i];
            }
        }
        return ' '; // Default case, should not happen if the grading scale is properly defined.
    }
}
