package item.robot;

public class NorthCommand implements RobotCommand {
    public void run(Robot robot) {
        if (robot.isPowered()) {
            robot.setX(robot.getX() + 1);
        }
    }
}
