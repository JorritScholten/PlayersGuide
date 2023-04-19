package item.robot;

public class WestCommand implements RobotCommand {
    public void run(Robot robot) {
        if (robot.isPowered()) {
            robot.setY(robot.getY() - 1);
        }
    }
}
