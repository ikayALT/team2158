// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SpinMotorSub;

public class IncreaseSpeed extends Command {
  SpinMotorSub spinMotorSub;

  double speed;

  /** Creates a new increaseSpeed. */
  public IncreaseSpeed(SpinMotorSub spinMotorSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.spinMotorSub = spinMotorSub;
    addRequirements(this.spinMotorSub);
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
    speed = RobotContainer.kJoystick.getY() / 127; // Get Y Value of Joystick (-127 - +127)
                                                   // Divide by 127 to get out of (-1 - +1) to set Speed
    if (Constants.m_motor11.get() == 0.0) {
      spinMotorSub.setMotorSpeed(speed);
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
