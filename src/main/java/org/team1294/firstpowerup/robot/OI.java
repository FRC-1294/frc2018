package org.team1294.firstpowerup.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The class representing the OI, or operator's interface. This class contains
 * references to all of the {@link edu.wpi.first.wpilibj.Joystick Joysticks}
 * used at the DS. You can also use the joystick instances to access the
 * individual {@link JoystickButton JoystickButtons}, and you can link
 * {@link edu.wpi.first.wpilibj.command.Command Commands} to run when they
 * are pressed.
 */
public class OI {
    private XboxController driveJoystick;

//    private Button exampleButton;

    public OI() {
        driveJoystick = new XboxController(RobotMap.JOYSTICK_DRIVE);

//        exampleButton = new JoystickButton(driveJoystick,
//                RobotMap.EXAMPLE_BUTTON);
//        exampleButton.toggleWhenPressed(new ExampleCommand());
    }

    public double getDriveLeftX() {
        return driveJoystick.getX(GenericHID.Hand.kLeft);
    }

    public double getDriveLeftY() {
        return -driveJoystick.getY(GenericHID.Hand.kLeft);
    }
}
