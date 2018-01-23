package increment.simulator;
/**
 * A gate will transfer data if the transfer input is set to true.
 * 
 * A gate has two inputs:
 * 		* input[width]
 * 		* transfer[1]
 * A gate has one output:
 * 		* output[width]
 * 
 * @author Xu Ke
 *
 */
public class Gate extends Chip {
	public Gate(int width) {
		addInput("input", width);
		addInput("transfer", 1);
		addOutput("output", width);
	}
	
	@Override
	public void evaluate(){
		if (inputs.get("transfer").getBit(0)) {
			outputs.get("output").assign(inputs.get("input"));
		}
	}
}
