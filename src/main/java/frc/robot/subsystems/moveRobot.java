// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class moveRobot extends SubsystemBase {
  // These are placeholder motors
  // Top Right
  CANSparkMax m_motor11 = Constants.m_motor11;
  // Bottom Right
  CANSparkMax m_motor12 = Constants.m_motor11;
  // Top Left
  CANSparkMax m_motor13 = Constants.m_motor11;
  // Bottom Left
  CANSparkMax m_motor14 = Constants.m_motor11;

  /** Creates a new moveRobot. */
  public moveRobot() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void move(double speed) {
    m_motor11.set(speed);
    m_motor12.set(speed);
    m_motor13.set(speed);
    m_motor14.set(speed);
  }

  public void turnLeft(double speed) {
     
  }

  public void turnRight(double speed) {

  }
}
