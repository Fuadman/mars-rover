public class Rover {

    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    Integer x = 0;
    Integer y = 0;
    // Default facing to North
    Integer facing = N;

    public Rover() {
    }

    public void setPosition(Integer x, Integer y, Integer facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public void printPosition() {
        char dir = 'N';
        switch (facing) {
            case 1:
                dir = 'N';
                break;
            case 2:
                dir = 'E';
                break;
            case 3:
                dir = 'S';
                break;
            case 4:
                dir = 'W';
                break;
            default:
                dir = 'N';
        }
        System.out.println(x + " " + y + " " + dir);
    }

    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++) {
            process(commands.charAt(idx));
        }
    }

    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException(
                    "Unrecognized Command.");
        }
    }

    private void move() {
        if (facing.equals(N)) {
            this.y++;
        } else if (facing.equals(E)) {
            this.x++;
        } else if (facing.equals(S)) {
            this.y--;
        } else if (facing.equals(W)) {
            this.x--;
        }
    }

    private void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
    }

    private void turnRight() {
        facing = (facing + 1) > W ? N : facing + 1;
    }

    public static void main(String args[]) {
        Rover rover = new Rover();
        rover.setPosition(1, 2, N);
        rover.process("LMLMLMLMM");
        rover.printPosition();
        rover.setPosition(3, 3, E);
        rover.process("MMRMMRMRRM");
        rover.printPosition();
    }
}
