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
    double liftSpeedCoef = 1.0;
    double liftInput = -Robot.controller1.getRawAxis(1);

    //System.out.println(Robot.lift.getEncoder());

    //if(Math.abs(liftInput) > 0.05) {
      /*if(Robot.lift.getEncoder() < 10000 && liftInput < 0) {
        liftSpeedCoef = 0.2;
      }
  
      if(Robot.lift.getEncoder() < 1000 && liftInput < 0) {
        liftSpeedCoef = 0.0;
      }*/
  
      //Robot.lift.liftMotor.set(ControlMode.PercentOutput, liftInput * liftSpeedCoef);
      Robot.lift.liftMotor.set(-liftInput * liftSpeedCoef);
    /*} else {
      Robot.lift.enable();
    }*/
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
