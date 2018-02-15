package org.team1294.firstpowerup.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1294.firstpowerup.robot.RobotMap;

/**
 * @author Austin Jenchi (timtim17)
 */
public class IntakeSubsystem extends Subsystem {
    private TalonSRX leftTalon;
    private TalonSRX rightTalon;

    public IntakeSubsystem() {
        super("Intake Subsystem");
        leftTalon = new TalonSRX(RobotMap.TALON_INTAKE_LEFT);
        rightTalon = new TalonSRX(RobotMap.TALON_INTAKE_RIGHT);

        rightTalon.follow(leftTalon);

        leftTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, RobotMap.CTRE_TIMEOUT_INIT);
        rightTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, RobotMap.CTRE_TIMEOUT_INIT);
    }

    public void driveIntake(double output) {
        leftTalon.set(ControlMode.PercentOutput, output);
//        leftTalon.set(ControlMode.Velocity, output);
    }

    public void stop() {
        driveIntake(0);
    }

    public double getLeftEncoder() {
        return leftTalon.getSelectedSensorPosition(0);
    }

    public double getRightEncoder() {
        return rightTalon.getSelectedSensorPosition(0);
    }

    public void resetEncoders() {
        leftTalon.setSelectedSensorPosition(0, 0, RobotMap.CTRE_TIMEOUT_PERIODIC);
        rightTalon.setSelectedSensorPosition(0, 0, RobotMap.CTRE_TIMEOUT_PERIODIC);
    }

    @Override
    protected void initDefaultCommand() {
//        setDefaultCommand();
    }
}
