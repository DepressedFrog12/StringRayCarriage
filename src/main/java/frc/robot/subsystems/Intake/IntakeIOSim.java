package frc.robot.subsystems.Intake;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import frc.robot.Constants;

public class IntakeIOSim implements IntakeIO{
	private DCMotorSim intakeMotorSim;
	private DCMotorSim iIntakeMotorSim;

	public IntakeIOSim() {
		intakeMotorSim = new DCMotorSim(LinearSystemId.createDCMotorSystem(Constants.IntakeConstants.kVSim, Constants.IntakeConstants.kASim), DCMotor.getNEO(1));
		iIntakeMotorSim = new DCMotorSim(LinearSystemId.createDCMotorSystem(Constants.IntakeConstants.kVSim, Constants.IntakeConstants.kASim), DCMotor.getNEO(1));

	}

	@Override
	public void processInputs(IntakeIOInputsAutoLogged inputs) {
		intakeMotorSim.update(0.02);
		iIntakeMotorSim.update(0.02);

		inputs.rollerRPM = intakeMotorSim.getAngularVelocityRPM();
		inputs.iRollerRPM = iIntakeMotorSim.getAngularVelocityRPM();
		inputs.rollersVolts = intakeMotorSim.getInputVoltage();
	}

	@Override
	public void setRollerVolts(double volts) {
		intakeMotorSim.setInputVoltage(volts);
		iIntakeMotorSim.setInputVoltage(volts);
	}

	@Override
	public void setRollerRPM(AngularVelocity rpm) {
		System.out.println(rpm.in(RadiansPerSecond));
		intakeMotorSim.setAngularVelocity(rpm.in(RadiansPerSecond));
		iIntakeMotorSim.setAngularVelocity(-rpm.in(RadiansPerSecond));
	}

	@Override
	public void setRollerPID(double kP, double kI, double kD) {
		// TODO Auto-generated method stub
	}

	@Override
	public void settoZero() {
		intakeMotorSim.setAngularVelocity(0);
		iIntakeMotorSim.setAngularVelocity(0);
	}
}
