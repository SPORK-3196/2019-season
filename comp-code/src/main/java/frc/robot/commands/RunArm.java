/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunArm extends Command {
  public RunArm() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.arm);
  }

  double map(double x, double in_min, double in_max, double out_min, double out_max) {
    return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.arm.armMotor.set(0);
    Robot.arm.armPID.setP(0.1);
    Robot.arm.armPID.setI(0);
    Robot.arm.armPID.setD(0);
    Robot.arm.armPID.setOutputRange(-0.5, 0.5);

    Robot.arm.wristMotor.set(0);
    Robot.arm.wristPID.setP(0.1);
    Robot.arm.wristPID.setI(0);
    Robot.arm.wristPID.setD(0);
    Robot.arm.wristPID.setOutputRange(-0.4, 0.4);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //double armSpeed = 0.8*Robot.controller1.getRawAxis(5);
    //double wristSpeed = Robot.controller1.getAButton() ? 0.4 : Robot.controller1.getBButton() ? -0.4 : 0;

    //Robot.arm.armMotor.set(armSpeed);
    //Robot.arm.wristMotor.set(wristSpeed);

    Robot.arm.armPID.setReference((Robot.lift.getEncoder() / 2000) - 15, ControlType.kPosition);
    //Robot.arm.armPID.setReference(0, ControlType.kPosition);

    Robot.arm.armEncoder = Robot.arm.armMotor.getEncoder().getPosition();
    Robot.arm.wristEncoder = Robot.arm.wristMotor.getEncoder().getPosition();

    System.out.println(Robot.arm.armEncoder);
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
