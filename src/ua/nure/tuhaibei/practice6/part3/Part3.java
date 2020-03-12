package ua.nure.tuhaibei.practice6.part3;

public class Part3 {
	private static final int sizeParking = 4;

	public static void main(String[] args) {

		Parking parking = new Parking(sizeParking);

		System.out.println(parking.arrive(2)); // 0010, true
		parking.print();
		System.out.println(parking.arrive(3)); // 0011, true
		parking.print();
		System.out.println(parking.arrive(2)); // 1011, true
		parking.print();
		System.out.println(parking.arrive(2)); // 1111, true
		parking.print();
		System.out.println(parking.arrive(2)); // 1111, false
		parking.print();

		System.out.println(parking.depart(1)); // 1011, true
		parking.print();
		System.out.println(parking.depart(1)); // 1011, false
		parking.print();

	}
}
