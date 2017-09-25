import java.text.DecimalFormat;

public class capacitorCalculator {

	static DecimalFormat formatter = new DecimalFormat("00.##E0");

	public static void main(String[] args) {
		AppliedVoltage(0.000103, 50000.0, .000001, 0.00000175);
		Voltage(9, 50000, .000001, .00000175);
		Resistance(0.000103, 9, 0.000001, 0.00000175);
		Capacitance(0.000103, 9, 0.000001, 50000);
		Time(0.000103, 9, 0.00000175, 50000);
	}

	private static void Voltage(double Vi, double R, double t, double C) {
		double voltage = 0.0;
		voltage = Vi * (1 - Math.pow(Math.exp(1), -t / (R * C)));
		FormatOutput("The voltage is", voltage, "v");
	}

	private static void AppliedVoltage(double V, double R, double t, double C) {
		double appliedVoltage = 0.0;
		appliedVoltage = V / (1 - Math.pow(Math.exp(1), -t / (R * C)));
		FormatOutput("The applied voltage is", appliedVoltage, "Vi");
	}

	private static void Resistance(double V, double Vi, double t, double C) {
		double resistance = 0.0;
		resistance = -t / (C * Math.log(1 - (V / Vi)));
		FormatOutput("The resistance is", resistance, "ohms");
	}

	private static void Capacitance(double V, double Vi, double t, double R) {
		double capacitance = 0.0;
		capacitance = -t / (R * Math.log(1 - (V / Vi)));
		FormatOutput("The capacitance is", capacitance, "farads");
	}

	private static void Time(double V, double Vi, double C, double R) {
		double time = 0.0;
		time = - R * C * Math.log(1 - (V / Vi));
		FormatOutput("The time is", time, "seconds");
	}

	private static void FormatOutput(String s1, double d, String s2) {
		System.out.println(s1 + " " + d + " or " + formatter.format(d) + " " + s2);
	}
}
