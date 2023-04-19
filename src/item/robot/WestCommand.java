package item.robot;

public class WestCommand extends RobotCommand {
    @Override
    public void run(Robot robot) {
        if (robot.isPowered()) {
            robot.setY(robot.getY() - 1);
        }
    }
}
