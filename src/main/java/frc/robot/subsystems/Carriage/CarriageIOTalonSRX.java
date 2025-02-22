package frc.robot.subsystems.Carriage;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.RobotController;
import frc.robot.Constants;

public class CarriageIOTalonSRX implements CarriageIO {
    private TalonSRX carriage;

    public CarriageIOTalonSRX(int motorId) {
        carriage = new TalonSRX(motorId);
        carriage.configFactoryDefault();

        carriage.setInverted(true);
    }

    @Override
    public void processInputs(CarriageIOInputsAutoLogged inputs) {

        inputs.carriageRPM = carriage.getSelectedSensorVelocity();
        inputs.carriageTemp = carriage.getTemperature();

    }

    @Override
    public void setCarriagePercent(double maxPercent) {
        carriage.set(ControlMode.PercentOutput, MathUtil.clamp(maxPercent, -1, 1));
    }

    @Override
    public void setToZero() {
        carriage.set(ControlMode.PercentOutput, 0);
    }

}
