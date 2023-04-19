package item.robot;

public class SouthCommand extends RobotCommand {
    @Override
    public void run(Robot robot) {
        if (robot.isPowered()) {
            robot.setX(robot.getX() - 1);
        }
    }
}
