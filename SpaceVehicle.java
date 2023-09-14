
public class SpaceVehicle {
    private int positionX;
    private int positionY;
    private int positionZ;
    private String currentDirection;

    public SpaceVehicle() {
        this.positionX = 0;
        this.positionY = 0;
        this.positionZ = 0;
        this.currentDirection = "N";
    }

    public void moveForward() {
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


    public void turnLeft() {
        if ("N".equals(currentDirection)) {
            currentDirection = "W";
        } else if ("S".equals(currentDirection)) {
            currentDirection = "E";
        } else if ("E".equals(currentDirection)) {
            currentDirection = "N";
        } else if ("W".equals(currentDirection)) {
            currentDirection = "S";
        } else if ("U".equals(currentDirection)) {
            currentDirection = "N";
        } else if ("D".equals(currentDirection)) {
            currentDirection = "S";
        }
    }


    public void processCommands(String[] commands) {
        for (String command : commands) {
            switch (command) {
                case "f":
                    moveForward();
                    break;
               
                case "l":
                    turnLeft();
                    break;
                
            }
        }
    }

    public int[] getCurrentPosition() {
        return new int[]{positionX, positionY, positionZ};
    }

    public String getCurrentDirection() {
        return currentDirection;
    }

    public static void main(String[] args) {
        SpaceVehicle spaceVehicle = new SpaceVehicle();
        String[] commands = {"f", "r", "u", "b", "l"};

        spaceVehicle.processCommands(commands);

        int[] finalPosition = spaceVehicle.getCurrentPosition();
        String finalDirection = spaceVehicle.getCurrentDirection();

        System.out.println("FinalPosition "+finalPosition[0] + ", " + finalPosition[1] + ", " + finalPosition[2]);
        System.out.println("FinalDirection "+finalDirection);
    }
}
