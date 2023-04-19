package item.robot;

public class EastCommand extends RobotCommand {
    @Override
    public void run(Robot robot) {
        if (robot.isPowered()) {
            robot.setY(robot.getY() + 1);
        }
    }
}
