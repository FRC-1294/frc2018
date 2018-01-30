package org.team1294.firstpowerup.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1294.firstpowerup.robot.Robot;

import java.util.function.Consumer;

public class AutoForwardPIDCommand extends PIDCommand {
    private final Consumer<Double> outputConsumer;
    private boolean hasRunPIDOnce = false;

    public AutoForwardPIDCommand(final Consumer<Double> outputConsumer, final double distance, final double maxVelocity) {
        super(1.0, 0.1, 0.0);

        this.outputConsumer = outputConsumer;

        double p = SmartDashboard.getNumber("AutoForwardPIDCommand.p", 1.0);
        double i = SmartDashboard.getNumber("AutoForwardPIDCommand.i", 0.1);
        double d = SmartDashboard.getNumber("AutoForwardPIDCommand.d", 0.0);
        double tolerance = SmartDashboard
            .getNumber("AutoForwardPIDCommand.tolerance", 0.01);

        getPIDController().setP(p);
        getPIDController().setI(i);
        getPIDController().setD(d);
        getPIDController().setAbsoluteTolerance(tolerance);
        getPIDController().setOutputRange(-maxVelocity, maxVelocity);
        getPIDController().setSetpoint(distance);
    }

    @Override
    protected double returnPIDInput() {
        hasRunPIDOnce = true;
        return Robot.driveSubsystem.getEncoderPositionAverage();
    }

    @Override
    protected void usePIDOutput(double output) {
        outputConsumer.accept(output);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    public boolean onTarget() {
        return hasRunPIDOnce && getPIDController().onTarget();
    }
}
