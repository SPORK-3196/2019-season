/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunArm extends Command {
  public RunArm() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.arm.armMotor.set(0);
    Robot.arm.armPID.setP(0.05);
    Robot.arm.armPID.setI(0);
    Robot.arm.armPID.setD(0);
    Robot.arm.armPID.setOutputRange(-0.4, 0.4);

    Robot.arm.wristMotor.set(0);
    Robot.arm.wristPID.setP(0.1);
    Robot.arm.wristPID.setI(0);
    Robot.arm.wristPID.setD(0);
    Robot.arm.wristPID.setOutputRange(-0.4, 0.4);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //double armSpeed = -0.4*Robot.controller1.getRawAxis(1);
    //double wristSpeed = 0.4*Robot.controller1.getRawAxis(5);
    //double wristSpeed = Robot.controller1.getAButton() ? 0.4 : Robot.controller1.getBButton() ? -0.4 : 0;

    //Robot.arm.armMotor.set(armSpeed);
    //Robot.arm.wristMotor.set(wristSpeed);

    double armOffset = 3.0;
    double wristOffset = 4.0;

    Robot.arm.armEncoder = Robot.arm.armMotor.getEncoder().getPosition();
    Robot.arm.wristEncoder = Robot.arm.wristMotor.getEncoder().getPosition();

    if(Robot.controller1.getYButtonPressed()) {
      Robot.arm.armOut = !Robot.arm.armOut;
    }

    if(Robot.arm.armOut) {
      Robot.arm.armPID.setOutputRange(-0.15, 0.15);
      Robot.arm.wristPID.setOutputRange(-0.25, 0.25);

      if(Robot.controller1.getAButton()) {
          Robot.arm.armPID.setReference((((Robot.lift.getEncoder() / 30000.0) - 1.0) * 16.9), ControlType.kPosition);
          Robot.arm.wristPID.setReference((((Robot.arm.armEncoder + 16.9) * (7.6/16.9)) - 7.6), ControlType.kPosition);
      } else if(Robot.controller1.getBumper(Hand.kLeft)) {
        Robot.arm.armPID.setReference((((Robot.lift.getEncoder() / 30000.0) - 1.0) * 16.9) + armOffset, ControlType.kPosition);
        Robot.arm.wristPID.setReference((((Robot.arm.armEncoder + 16.9) * (10.6/16.9)) - 10.6) + wristOffset, ControlType.kPosition);
      } else {
        Robot.arm.armPID.setReference((((Robot.lift.getEncoder() / 30000.0) - 1.0) * 16.9), ControlType.kPosition);
        Robot.arm.wristPID.setReference((((Robot.arm.armEncoder + 16.9) * (10.6/16.9)) - 10.6), ControlType.kPosition);
      }
    } else {
      Robot.arm.armPID.setOutputRange(-0.4, 0.4);
      Robot.arm.wristPID.setOutputRange(-0.4, 0.4);

      if(Robot.lift.getEncoder() < 15000) {
        Robot.arm.armPID.setReference(0, ControlType.kPosition); 
        Robot.arm.wristPID.setReference(0, ControlType.kPosition);
      } else {
        Robot.arm.armPID.setReference(-1.69, ControlType.kPosition); 
        Robot.arm.wristPID.setReference(-1.06, ControlType.kPosition);
      }
    }

    //Robot.arm.armPID.setReference(-15, ControlType.kPosition);

    /*System.out.print(Robot.arm.armEncoder);
    System.out.print("\t\t\t");
    System.out.println(Robot.arm.wristEncoder);*/

    //System.out.println(((Robot.arm.armEncoder + 15.0) * (9.0/15.0)) - 9f);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //System.out.println("Finished using manual PID arm control...");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
