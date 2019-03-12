/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.LiftWithJoystick;

/**
 * Add your docs here.
 */
public class OldLift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  /*public int offset = 0;

  public WPI_TalonSRX liftMotor = new WPI_TalonSRX(10);

  public int getEncoder() {
    return liftMotor.getSelectedSensorPosition() - offset;
  }

  public void resetEncoder() {
    offset = liftMotor.getSelectedSensorPosition();
  }

  public void resetEncoderTo(int val) {
    offset = liftMotor.getSelectedSensorPosition() - val;
  }*/

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new LiftWithJoystick());
  }
}
