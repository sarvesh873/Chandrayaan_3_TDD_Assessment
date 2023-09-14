import java.util.Scanner;

public class SpaceVehicle {
    private int positionX;
    private int positionY;
    private int positionZ;
    private String currentDirection;

    // Constructor to initialize the space vehicle's initial position and direction
    public SpaceVehicle() {
        this.positionX = 0;
        this.positionY = 0;
        this.positionZ = 0;
        this.currentDirection = "N";
    }

    // Method to move the space vehicle forward in the current direction
    public void moveForward() {
        // Depending on the current direction, update the position
        if ("N".equals(currentDirection)) {
            positionY++;
        } else if ("S".equals(currentDirection)) {
            positionY--;
        } else if ("E".equals(currentDirection)) {
            positionX++;
        } else if ("W".equals(currentDirection)) {
            positionX--;
        } else if ("U".equals(currentDirection)) {
            positionZ++;
        } else if ("D".equals(currentDirection)) {
            positionZ--;
        }
    }

    // Method to move the space vehicle backward in the current direction
    public void moveBackward() {
        // Depending on the current direction, update the position
        if ("N".equals(currentDirection)) {
            positionY--;
        } else if ("S".equals(currentDirection)) {
            positionY++;
        } else if ("E".equals(currentDirection)) {
            positionX--;
        } else if ("W".equals(currentDirection)) {
            positionX++;
        } else if ("U".equals(currentDirection)) {
            positionZ--;
        } else if ("D".equals(currentDirection)) {
            positionZ++;
        }
    }

    // Method to turn the space vehicle left
    public void turnLeft() {
        // Depending on the current direction, change to the new direction
        if ("N".equals(currentDirection)) {
            currentDirection = "W";
        } else if ("S".equals(currentDirection)) {
            currentDirection = "E";
        } else if ("E".equals(currentDirection)) {
            currentDirection = "N";
        } else if ("W".equals(currentDirection)) {
            currentDirection = "S";
        } else if ("U".equals(currentDirection) || "D".equals(currentDirection)) {
            currentDirection = "N";
        }
    }

    // Method to turn the space vehicle right
    public void turnRight() {
        // Depending on the current direction, change to the new direction
        if ("N".equals(currentDirection)) {
            currentDirection = "E";
        } else if ("S".equals(currentDirection)) {
            currentDirection = "W";
        } else if ("E".equals(currentDirection)) {
            currentDirection = "S";
        } else if ("W".equals(currentDirection)) {
            currentDirection = "N";
        } else if ("U".equals(currentDirection) || "D".equals(currentDirection)) {
            currentDirection = "N";
        }
    }

    // Method to turn the space vehicle upward
    public void turnUp() {
        // Depending on the current direction, change to the new direction
        if ("N".equals(currentDirection)) {
            currentDirection = "U";
        } else if ("S".equals(currentDirection)) {
            currentDirection = "D";
        } else if ("E".equals(currentDirection)) {
            currentDirection = "U";
        } else if ("W".equals(currentDirection)) {
            currentDirection = "D";
        }
    }

    // Method to turn the space vehicle downward
    public void turnDown() {
        // Depending on the current direction, change to the new direction
        if ("N".equals(currentDirection)) {
            currentDirection = "D";
        } else if ("S".equals(currentDirection)) {
            currentDirection = "U";
        } else if ("E".equals(currentDirection)) {
            currentDirection = "D";
        } else if ("W".equals(currentDirection)) {
            currentDirection = "U";
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
        return new int[]{positionX, positionY, positionZ};
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
