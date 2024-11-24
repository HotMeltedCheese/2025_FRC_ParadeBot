// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.TeleopTankDrive;
import frc.robot.subsystems.TankDrive;

public class RobotContainer {
  private final TankDrive s_Drive = new TankDrive();
  private final CommandXboxController x_driver0 = new CommandXboxController(0);
  private final TeleopTankDrive c_Drive = new TeleopTankDrive(s_Drive, x_driver0::getLeftY , x_driver0::getRightY);

  public RobotContainer() {
    s_Drive.setDefaultCommand(c_Drive);
    configureBindings();
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
