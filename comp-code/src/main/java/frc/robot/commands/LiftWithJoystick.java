/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftWithJoystick extends Command {
  public LiftWithJoystick() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.lift.liftMotor.set(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double liftInput = -Robot.controller1.getRawAxis(1);
    double liftSpeedCoef = -1.0;

    //System.out.println(Robot.lift.getEncoder());
    if(Robot.controller1.getXButtonPressed()) {
      Robot.lift.setSetpoint(10000);
      Robot.lift.enable();
    }

    if(Math.abs(liftInput) > 0.08) {
      Robot.lift.disable();
      if(liftInput < 0.0) {
        if(Robot.lift.getEncoder() < 10000) {
          liftSpeedCoef = -0.4;
        }
        if(Robot.lift.getEncoder() < 1000) {
          liftSpeedCoef = -0.0;
        }
      }

      Robot.lift.liftMotor.set(liftInput * liftSpeedCoef);
      //Robot.lift.setSetpoint(Robot.lift.getEncoder());
    }

    
    System.out.println(Robot.lift.getPIDController().getError());
  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
