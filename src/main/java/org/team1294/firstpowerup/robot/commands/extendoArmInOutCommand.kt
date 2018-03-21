package org.team1294.firstpowerup.robot.commands
import edu.wpi.first.wpilibj.command.Command
import org.team1294.firstpowerup.robot.Robot

class extendoArmInOutCommand(val goingIn : Boolean) : Command("Extendo arm out command") {
    private val max : Double = 500.0;
    private val min : Double = 0.0;
    private var target : Double = 0.0;
    init {
        if(goingIn)
        {
            Robot.armSubsystem.setExtendMotionMagic(min);
            target = min;
        }
        else
        {
            Robot.armSubsystem.setExtendMotionMagic(max);
            target = max
        }
    }
    override fun isFinished(): Boolean {
        return Robot.armSubsystem.extensionSensorValue == target;
    }
}