package item.robot;

public class OffCommand extends RobotCommand {
    public void run(Robot robot) {
        robot.setPowered(false);
    }
}
