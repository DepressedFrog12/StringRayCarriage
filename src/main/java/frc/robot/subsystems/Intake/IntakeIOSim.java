package frc.robot.subsystems.Intake;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import frc.robot.Constants;

public class IntakeIOSim implements IntakeIO{
	private DCMotorSim intakeMotorSim;

	public IntakeIOSim() {
		intakeMotorSim = new DCMotorSim(LinearSystemId.createDCMotorSystem(Constants.IntakeConstants.kVSim, Constants.IntakeConstants.kASim), DCMotor.getNEO(1));

	}

	@Override
	public void processInputs(IntakeIOInputsAutoLogged inputs) {
		intakeMotorSim.update(0.02);

		inputs.rollerRPM = intakeMotorSim.getAngularVelocityRPM();
		inputs.rollersVolts = intakeMotorSim.getInputVoltage();
	}

	@Override
	public void setRollerVolts(double volts) {
		intakeMotorSim.setInputVoltage(volts);
	}

	@Override
	public void setRollerRPM(double rpm) {
		System.out.println(rpm);
		intakeMotorSim.setInput(rpm);
	}

	@Override
	public void setRollerPID(double kP, double kI, double kD) {
		// TODO Auto-generated method stub
	}

	@Override
	public void settoZero() {
		intakeMotorSim.setAngularVelocity(0);
		intakeMotorSim.setInput(0);
	}
}
