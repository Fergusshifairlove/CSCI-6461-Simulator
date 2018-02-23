package increment.simulator.userInterface;

import increment.simulator.ui.MachineWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;



public class MainPanelController {
	public void setMachine(MachineWrapper machine) {

		Text_Tick_Text.textProperty().bind(machine.getTickProperty().asString());
        Text_PC_Text.textProperty().bind(machine.getProgramCounterProperty());
		Text_BUS_Text.textProperty().bind(machine.getBusProperty());
		Text_MAR_Text.textProperty().bind(machine.getMemoryAddressRegisterProperty());
		Text_MBR_Text.textProperty().bind(machine.getMemoryBufferRegisterProperty());
		Text_IR_Text.textProperty().bind(machine.getInstructionRegisterProperty());
		Text_GPRF_Text.textProperty().bind(machine.getGeneralPurposeRegisterFileProperty());
		Text_IRF_Text.textProperty().bind(machine.getIndexRegisterFileProperty());
		Text_CU_Text.textProperty().bind(machine.getControlUnitProperty());
		Text_Memory_Text.textProperty().bind(machine.getMemoryProperty());

	}

    @FXML private  Text Text_Tick_Text;
    @FXML private  Text Text_PC_Text;
    @FXML private  Text Text_BUS_Text;
    @FXML private  Text Text_MAR_Text;
    @FXML private  Text Text_MBR_Text;
    @FXML private  Text Text_IR_Text;
    @FXML private  Text Text_GPRF_Text;
    @FXML private  Text Text_IRF_Text;
    @FXML private  Text Text_CU_Text;
    @FXML private  Text Text_Memory_Text;

    public void handleTickButtonAction(ActionEvent actionEvent) {

    }

    public void handleAutoTickButtonAction(ActionEvent actionEvent) {
    }

    public void handleShowMagicButtonAction (ActionEvent actionEvent) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/res/fxml/ControlPanel.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }


}
