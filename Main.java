import java.util.Scanner;// 0 - 1 - 3
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //creates a new RAM with 1024 bytes (1 KB) of memory
        RAM ram = new RAM(1024);

        //reads data from user input and writes it to RAM data structure
        System.out.print("Enter data to write to RAM: ");
        String input = scanner.nextLine();
        for (int i = 0; i < input.length() && i < ram.getSize(); i++) {
            ram.write(i, (byte) input.charAt(i));
        }

        //reads data from the RAM (Input by the user previously) and prints it to console
        System.out.print("Data in RAM: ");
        for (int i = 0; i < ram.getSize(); i++) {
            System.out.print((char) ram.read(i));
        }
        System.out.println();

        System.out.println("Now adding 'ABC' using refresh");
        //adds data "ABC" to ram using refresh
        byte[] testData = new byte[] {
                (byte) 0x41,
                (byte) 0x42,
                (byte) 0x43,
        };
        ram.refresh(testData);
        System.out.print("Updated Data in RAM: ");
        for (int i = 0; i < ram.getSize(); i++) {
            System.out.print((char) ram.read(i));
        }
        System.out.println();

        //reads program parameters from the user and load the program from the RAM data structure
        System.out.print("Enter program start address: ");
        int startAddres = scanner.nextInt();
        System.out.print("Enter program length: ");
        int length = scanner.nextInt();
        byte[] program = ram.loadProgram(startAddres, length);

        //print the program to the console
        System.out.print("Program loaded from RAM: ");
        for (byte b : program) {
            System.out.print((char) b);
        }
        System.out.println();


    }
}
