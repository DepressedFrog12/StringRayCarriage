package frc.robot.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;

public class IntakeIOTalonSRX {
    private final TalonSRX roller = new TalonSRX(Constants.IntakeConstants.ROLLER_MOTOR_ID);
    private final TalonSRX iRoller = new TalonSRX(Constants.IntakeConstants.IROLLER_MOTOR_ID);   

    
}
