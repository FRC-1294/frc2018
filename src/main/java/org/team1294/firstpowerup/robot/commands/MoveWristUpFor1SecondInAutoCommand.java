package org.team1294.firstpowerup.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1294.firstpowerup.robot.Robot;

/**
 * @author Austin Jenchi (timtim17)
 */
public class MoveWristUpFor1SecondInAutoCommand extends Command {
    public MoveWristUpFor1SecondInAutoCommand() {
        super("Move wrist down for 1 second (for switch auto)");
        setTimeout(1);
        requires(Robot.armSubsystem);
    }

    @Override
    protected void initialize() {
        Robot.armSubsystem.driveWristPercentOut(0.25);
    }

    @Override
    protected void end() {
        Robot.armSubsystem.driveWristPercentOut(0);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
