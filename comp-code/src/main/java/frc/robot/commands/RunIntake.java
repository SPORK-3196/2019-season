/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunIntake extends Command {
  public RunIntake() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intake);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.intake.intakeMotor.set(0);
    System.out.println("Intaking");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //double servoPos = (Robot.controller1.getRawAxis(5) + 1.0) / 2.0;
    //Robot.intake.testServo.set(servoPos);

    double intakeSpeed = Robot.controller1.getRawAxis(3) - Robot.controller1.getRawAxis(2);
    Robot.intake.intakeMotor.set(intakeSpeed);
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
