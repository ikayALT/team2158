// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpinMotorSub extends SubsystemBase {
  CANSparkMax m_motor11 = Constants.m_motor11;
  //CANSparkMax m_motor14 = Constants.m_motor14;

  /** Creates a new SpinMotorSub. */
  //int randInt;
  public SpinMotorSub() {}

  @Override
  public void periodic() {
    //randInt = ((int) (Math.random() * 10) + 1);
  }

  public void setMotorSpeed(double speed) {
    m_motor11.set(speed);
    //m_motor14.set(speed);
  }

  

  public boolean startMotor() {
    return true;
  }
}
