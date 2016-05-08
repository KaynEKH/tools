package net.kurse.ts2c.ihm;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import net.kurse.ts2c.core.CharSheetSaver;
import net.kurse.ts2c.dao.RefDataDao;
import net.kurse.ts2c.domain.Caracteristique;

public class MainFrameController {

	@FXML private Text outputtext;
	@FXML private Button button;
	
	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
		RefDataDao.test();
		Caracteristique carac = new Caracteristique(3, 2, 5, 4, 2, 4);
		try {
			CharSheetSaver.save(carac);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		outputtext.setText("Test OK");
		
	}
}
