package frc.robot.subsystems.Intake;

import static edu.wpi.first.units.Units.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.units.measure.AngularVelocity;
import frc.robot.Constants;

public class IntakeIOTalonSRX implements IntakeIO {
    private final TalonSRX roller = new TalonSRX(Constants.IntakeConstants.ROLLER_MOTOR_ID);

    public IntakeIOTalonSRX() {
        roller.configFactoryDefault();

        roller.setInverted(true);
    }

    @Override
    public void processInputs(IntakeIOInputsAutoLogged inputs) {

        inputs.rollerRPM = roller.getSelectedSensorVelocity();
        inputs.rollersVolts = roller.getMotorOutputVoltage();
        inputs.rollerAmps = roller.getSupplyCurrent();
        inputs.rollerTemp = roller.getTemperature();

    }

    @Override
    public void setRollerVolts(double volts) {
        roller.set(ControlMode.PercentOutput, volts);
    }

    @Override
    public void setRollerRPM(double rPM) {
        roller.set(ControlMode.PercentOutput, rPM);
    }

    @Override
    public void settoZero() {
        roller.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void setRollerPID(double kP, double kI, double kD) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRollerPID'");
    }
}
