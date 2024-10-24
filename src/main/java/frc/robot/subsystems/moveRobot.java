// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class moveRobot extends SubsystemBase {
  // These are placeholder motors
  // Back Left
  public static CANSparkMax backLeftMotor= new CANSparkMax(5, CANSparkMax.MotorType.kBrushless);
  // Front Right
  public static CANSparkMax frontRightMotor = new CANSparkMax(3, CANSparkMax.MotorType.kBrushless);
  // Front Left
  public static CANSparkMax frontLeftMotor = new CANSparkMax(1, CANSparkMax.MotorType.kBrushless);
  // Back Right
  public static CANSparkMax backRightMotor = new CANSparkMax(7, CANSparkMax.MotorType.kBrushless);

  /** Creates a new moveRobot. */
  public moveRobot() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void move(double speed) {
    frontLeftMotor.set(speed);
    frontRightMotor.set(speed);
    backLeftMotor.set(speed);
    backRightMotor.set(speed);
  }

  public void turn(double speed) {
    frontLeftMotor.set(-speed);
    frontRightMotor.set(speed);
    backLeftMotor.set(-speed);
    backRightMotor.set(speed);
  }
}
