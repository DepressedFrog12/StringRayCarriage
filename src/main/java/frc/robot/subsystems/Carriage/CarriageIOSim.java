package frc.robot.subsystems.Carriage;


import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import frc.robot.Constants;
import frc.robot.subsystems.Carriage.CarriageIOInputsAutoLogged;

public class CarriageIOSim implements CarriageIO{
	private DCMotorSim carriageMotorSim;

	public CarriageIOSim() {
		carriageMotorSim = new DCMotorSim(LinearSystemId.createDCMotorSystem(Constants.CarriageConstants.kVSim, Constants.CarriageConstants.kASim), DCMotor.getNEO(1));

	}

	@Override
	public void processInputs(CarriageIOInputsAutoLogged inputs) {
		carriageMotorSim.update(0.02);

		inputs.carriageRPM = carriageMotorSim.getAngularVelocityRPM();
		inputs.carriagesVolts = carriageMotorSim.getInputVoltage();
	}

	@Override
	public void setCarriageVolts(double volts) {
		carriageMotorSim.setInputVoltage(volts);
	}

	@Override
	public void setCarriageRPM(double rpm) {
		System.out.println(rpm);
		carriageMotorSim.setInput(rpm);
	}

	@Override
	public void setCarriagePID(double kP, double kI, double kD) {
		
	}

	@Override
	public void settoZero() {
		carriageMotorSim.setAngularVelocity(0);
		carriageMotorSim.setInput(0);
	}
}
