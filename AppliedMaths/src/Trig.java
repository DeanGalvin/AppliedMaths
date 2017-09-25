import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;


public class Trig {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("#.##");
		String choice = "y";
		System.out.println("Welcome to the object height calculator!\n");
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter distance from the object: ");
			double distance = sc.nextDouble();
			System.out.print("Enter angle of elevation(in degrees): ");
			double elevation = sc.nextDouble();
			System.out.println("The height of the object is: " + formatter.format(calculateObjectHeight(distance, elevation)));
			System.out.println();
			System.out.print("Continue? (Y / N): ");
			choice = sc.next();
		}
	}

	public static double calculateObjectHeight(double distanceFromObject, double angleOfElevation) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		double tanAngle = Math.tan(Math.toRadians(angleOfElevation));
		return distanceFromObject * tanAngle;
	}
}
