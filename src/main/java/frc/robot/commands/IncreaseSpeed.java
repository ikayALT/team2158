// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;

//import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.SpinMotorSub;
import frc.robot.subsystems.moveRobot;

public class IncreaseSpeed extends Command {
  SpinMotorSub spinMotorSub;
  moveRobot moveRobotSub;
  public static final Joystick kJoystick = new Joystick(0);

  double speed;
  double rotateSpeed;

  /** Creates a new increaseSpeed. */
  public IncreaseSpeed(SpinMotorSub spinMotorSub, moveRobot moveRobotSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.spinMotorSub = spinMotorSub;
    this.moveRobotSub = moveRobotSub;
    addRequirements(this.spinMotorSub, this.moveRobotSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (Constants.m_motor11.get() != 0.0) {
      System.out.println("Motor already running. please wait for it to stop!");
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    speed = kJoystick.getRawAxis(1); 
    rotateSpeed = kJoystick.getRawAxis(0);
    System.out.println(speed);            
    System.out.println(rotateSpeed);            
    
    // speed = speed of motor 

    //if (m_motor11.get() < 0.1) {
    //  spinMotorSub.setMotorSpeed(speed);
    //}
    
    //spinMotorSub.setMotorSpeed(speed);
    
    moveRobotSub.move(speed);
    if(speed < 0.1 && speed > -0.1)
    {
      moveRobotSub.turn(rotateSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    spinMotorSub.setMotorSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
