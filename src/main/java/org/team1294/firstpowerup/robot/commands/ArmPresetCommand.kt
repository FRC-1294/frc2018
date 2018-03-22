package org.team1294.firstpowerup.robot.commands

import edu.wpi.first.wpilibj.command.CommandGroup
import org.team1294.firstpowerup.robot.Robot

class ArmPresetCommand(type : Int)  : CommandGroup("Arm Preset Command"){
    private val high: Double = 87.0;
    private val low : Double = 763.0;
    private val mid : Double = 350.0
    private val switch : Double = 618.0
    init
    {
        if(type == 1)
        {
            if(Robot.armSubsystem.armHeight == high)
            //    addSequential(ToggleArmWristDeployCommand())
            else
            {
                //if (!Robot.armSubsystem.isWristIn)
                //    addSequential(ToggleArmWristDeployCommand())
                addParallel(SetArmHeightCommand(mid));
                addSequential(extendoArmInOutCommand(true))
                addParallel(SetArmHeightCommand(high))
                addSequential(extendoArmInOutCommand(false))
            }

        }
        else if(type == 2)
        {
            if(Robot.armSubsystem.armHeight == high) {
               // if (!Robot.armSubsystem.isWristIn)
                 //   addSequential(ToggleArmWristDeployCommand())
                addParallel(SetArmHeightCommand(mid));
                addSequential(extendoArmInOutCommand(true))
                addParallel(SetArmHeightCommand(switch))
                addSequential(extendoArmInOutCommand(false))
            }
            else
            {
                addSequential(SetArmHeightCommand(switch))
            }
        }
        else if(type == 3)
        {
            if(Robot.armSubsystem.armHeight == low) {}
            else if(Robot.armSubsystem.armHeight == switch) {
                addSequential(SetArmHeightCommand(low))
                addParallel(extendoArmInOutCommand(false))
            }
            else {
                //if (!Robot.armSubsystem.isWristIn)
                //  addSequential(ToggleArmWristDeployCommand())
                addParallel(SetArmHeightCommand(mid));
                addSequential(extendoArmInOutCommand(true))
                addParallel(SetArmHeightCommand(low))
                addSequential(extendoArmInOutCommand(false))
            }
        }
    }
}