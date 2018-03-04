package org.team1294.firstpowerup.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Austin Jenchi (timtim17)
 */
public class AutoShortSideDeliverSimple extends CommandGroup {
    private final char side;

    public AutoShortSideDeliverSimple(char side) {
        super("SBBL deliver cube to " + side);
        this.side = side;
        addSequential(new AutoDriveCommand(1.4));
        addSequential(new AutoDriveCommand(0, 90, 0.5, 0.75));
        addSequential(new SetArmHeightCommand(500));
        addSequential(new AutoDeliverCrateCommand());
    }

    public boolean shouldDeliverCube() {
        return DriverStation.getInstance().getGameSpecificMessage().charAt(0) == side;
    }
}
