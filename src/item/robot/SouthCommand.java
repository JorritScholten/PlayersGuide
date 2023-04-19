package item.robot;

public class SouthCommand implements RobotCommand {
    public void run(Robot robot) {
        if (robot.isPowered()) {
            robot.setX(robot.getX() - 1);
        }
    }
}
