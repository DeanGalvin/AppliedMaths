import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ShannonTheory {

	public static void main(String[] args) {
		channelCapacity(22, 4);
	}

	private static void channelCapacity(double snr, double bandwidth) {
		double channelCap = 0.0;

		double sOverN = Math.pow(10, snr/10);
		channelCap = (bandwidth * Math.pow(10, 3)) * (Math.log(1 + 158.49) / Math.log(2));
		System.out.println("The channel cap is " + channelCap);
		NumberFormat formatter = new DecimalFormat("00.###E0");
		System.out.println("Channel capacity = " + formatter.format(channelCap));
	}
}
