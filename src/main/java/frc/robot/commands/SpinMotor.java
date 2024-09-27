// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.SpinMotorSub;

public class SpinMotor extends Command {
  SpinMotorSub spinMotor_Sub;

  double intakeSpeed = Constants.intakeSpeed;
  double shootSpeed = Constants.shootSpeed;
  double stopSpeed = Constants.stopSpeed;

  public static boolean shootReady = false;
  boolean botFirstAction = false; 

  /** Creates a new SpinMotor. */
  public SpinMotor(SpinMotorSub spinMotor_Sub) {
    this.spinMotor_Sub = spinMotor_Sub;
    addRequirements(this.spinMotor_Sub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    if (shootReady == false) {
      if (botFirstAction == false) {
        System.out.println("intake ready!");
        System.out.println("!! This is the bots first action since start up !!");
        botFirstAction = true;
        shootReady = false;
      }
      else {
        System.out.println("shoot ready!");
        shootReady = true;
      }
    }
    else {
      System.out.println("intake ready!");
      shootReady = false;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (shootReady == true) {
      spinMotor_Sub.setMotorSpeed(shootSpeed);
    }
    else {
      spinMotor_Sub.setMotorSpeed(intakeSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    spinMotor_Sub.setMotorSpeed(stopSpeed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
