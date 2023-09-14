import java.util.Scanner;

public class SpaceVehicle {
    
    private int xPos; // Current X position
    private int yPos; // Current Y position
    private int zPos; // Current Z position
    private String currentDirection; // Current direction ("N", "S", "E", "W", "U", "D")

    // Constructor to initialize the space vehicle's initial position and direction
    public SpaceVehicle() {
        this.xPos = 0;
        this.yPos = 0;
        this.zPos = 0;
        this.currentDirection = "N";
    }

    // Method to move the space vehicle forward in the current direction
    public void moveForward() {
        switch (currentDirection) {
            case "N":
                yPos++;
                break;
            case "S":
                yPos--;
                break;
            case "E":
                xPos++;
                break;
            case "W":
                xPos--;
                break;
            case "U":
                zPos++;
                break;
            case "D":
                zPos--;
                break;
        }
    }

    // Method to move the space vehicle backward in the current direction
    public void moveBackward() {
        switch (currentDirection) {
            case "N":
                yPos--;
                break;
            case "S":
                yPos++;
                break;
            case "E":
                xPos--;
                break;
            case "W":
                xPos++;
                break;
            case "U":
                zPos--;
                break;
            case "D":
                zPos++;
                break;
        }
    }

    // Method to turn the space vehicle left
    public void turnLeft() {
        switch (currentDirection) {
            case "N":
                currentDirection = "W";
                break;
            case "S":
                currentDirection = "E";
                break;
            case "E":
                currentDirection = "N";
                break;
            case "W":
                currentDirection = "S";
                break;
            case "U":
                currentDirection = "N";
                break;
            case "D":
                currentDirection = "S";
                break;
        }
    }

    // Method to turn the space vehicle right
    public void turnRight() {
        switch (currentDirection) {
            case "N":
                currentDirection = "E";
                break;
            case "S":
                currentDirection = "W";
                break;
            case "E":
                currentDirection = "S";
                break;
            case "W":
                currentDirection = "N";
                break;
            case "U":
                currentDirection = "N";
                break;
            case "D":
                currentDirection = "S";
                break;
        }
    }

    // Method to turn the space vehicle upward
    public void turnUp() {
        switch (currentDirection) {
            case "N":
                currentDirection = "U";
                break;
            case "S":
                currentDirection = "D";
                break;
            case "E":
                currentDirection = "U";
                break;
            case "W":
                currentDirection = "D";
                break;
        }
    }

    // Method to turn the space vehicle downward
    public void turnDown() {
        switch (currentDirection) {
            case "N":
                currentDirection = "D";
                break;
            case "S":
                currentDirection = "U";
                break;
            case "E":
                currentDirection = "D";
                break;
            case "W":
                currentDirection = "U";
                break;
        }
    }

    // Method to process a sequence of commands (e.g., "f", "r", "u", "b", "l")
    public void processCommands(String[] commands) {
        for (String command : commands) {
            switch (command) {
                case "f":
                    moveForward();
                    break;
                case "b":
                    moveBackward();
                    break;
                case "l":
                    turnLeft();
                    break;
                case "r":
                    turnRight();
                    break;
                case "u":
                    turnUp();
                    break;
                case "d":
                    turnDown();
                    break;
                default:
                    System.out.println("Invalid Command: " + command);
                    break;
            }
        }
    }

    // Method to get the current position as an array of integers [x, y, z]
    public int[] getCurrentPosition() {
        return new int[]{xPos, yPos, zPos};
    }

    // Method to get the current direction ("N", "S", "E", "W", "U", or "D")
    public String getCurrentDirection() {
        return currentDirection;
    }

    public static void main(String[] args) {
        SpaceVehicle spaceVehicle = new SpaceVehicle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sequence of commands (e.g., f, r, u, b, l):");
        String input = scanner.nextLine();
        String[] commands = input.split(",\\s*"); // Split commands by commas

        spaceVehicle.processCommands(commands);

        int[] finalPosition = spaceVehicle.getCurrentPosition();
        String finalDirection = spaceVehicle.getCurrentDirection();

        System.out.println("Final Position: " + finalPosition[0] + ", " + finalPosition[1] + ", " + finalPosition[2]);
        System.out.println("Final Direction: " + finalDirection);
    }
}
