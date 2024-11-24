package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class TankDrive extends SubsystemBase{
    private final CANSparkMax m_front_right_motor;
    private final CANSparkMax m_back_right_motor;
    private final CANSparkMax m_front_left_motor;
    private final CANSparkMax m_back_left_motor;

    public TankDrive() {
        m_front_right_motor = new CANSparkMax(Constants.TankDriveConstants.FRONT_RIGHT_MOTOR_ID, MotorType.kBrushless); 
        m_back_right_motor = new CANSparkMax(Constants.TankDriveConstants.BACK_RIGHT_MOTOR_ID, MotorType.kBrushless); 
        m_front_left_motor = new CANSparkMax(Constants.TankDriveConstants.FRONT_LEFT_MOTOR_ID, MotorType.kBrushless); 
        m_back_left_motor = new CANSparkMax(Constants.TankDriveConstants.BACK_LEFT_MOTOR_ID, MotorType.kBrushless);
        configureMotors();
    }

    public void drive(double left_input, double right_input) {
        setMotorValues(left_input * Constants.TankDriveConstants.maxSpeed, right_input * Constants.TankDriveConstants.maxSpeed);
    }

    private void setMotorValues(double left_speed, double right_speed) {
        m_front_left_motor.set(left_speed);
        m_front_right_motor.set(right_speed);
    }

    private void configureMotors() {
        m_front_right_motor.setInverted(Constants.TankDriveConstants.FRONT_RIGHT_MOTOR_INVERT); 
        m_back_right_motor.setInverted(Constants.TankDriveConstants.BACK_RIGHT_MOTOR_INVERT); 
        m_front_left_motor.setInverted(Constants.TankDriveConstants.FRONT_LEFT_MOTOR_INVERT);
        m_back_left_motor.setInverted(Constants.TankDriveConstants.BACK_LEFT_MOTOR_INVERT); 

        m_back_right_motor.follow(m_front_right_motor);
        m_back_left_motor.follow(m_front_left_motor);

        m_front_right_motor.setIdleMode(CANSparkMax.IdleMode.kBrake); 
        m_back_right_motor.setIdleMode(CANSparkMax.IdleMode.kBrake); 
        m_front_left_motor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        m_back_left_motor.setIdleMode(CANSparkMax.IdleMode.kBrake); 

        m_front_right_motor.setSmartCurrentLimit(40); 
        m_back_right_motor.setSmartCurrentLimit(40); 
        m_front_left_motor.setSmartCurrentLimit(40); 
        m_back_left_motor.setSmartCurrentLimit(40);
    }
}
