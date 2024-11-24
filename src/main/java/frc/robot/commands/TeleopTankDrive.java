package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.TankDrive;;

public class TeleopTankDrive extends Command{
    private final TankDrive s_TankDrive;
    private final DoubleSupplier left_joystick_input;
    private final DoubleSupplier right_joystick_input;

    public TeleopTankDrive(TankDrive drive, DoubleSupplier left, DoubleSupplier right) {
        this.s_TankDrive = drive;
        this.left_joystick_input = left;
        this.right_joystick_input = right;
        addRequirements(s_TankDrive);
    }

    @Override
    public void execute() {
        s_TankDrive.drive(left_joystick_input.getAsDouble(), right_joystick_input.getAsDouble());
    }
}
