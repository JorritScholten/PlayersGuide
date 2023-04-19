package item.robot;

public class Robot {
    private int x;

    private int y;

    private boolean isPowered;

    private RobotCommand[] commands = new RobotCommand[3];

    public void setCommands(RobotCommand command1, RobotCommand command2, RobotCommand command3) {
        commands[0] = command1;
        commands[1] = command2;
        commands[2] = command3;
    }

    public void run() {
        System.out.printf("[%d %d %b]\n", x, y, isPowered);
        for (RobotCommand command : commands) {
            command.run(this);
            System.out.printf("[%d %d %b]\n", x, y, isPowered);
        }
    }

    public int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    public boolean isPowered() {
        return isPowered;
    }

    protected void setPowered(boolean isPowered) {
        this.isPowered = isPowered;
    }
}
