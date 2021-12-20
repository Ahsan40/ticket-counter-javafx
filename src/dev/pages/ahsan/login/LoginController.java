package dev.pages.ahsan.login;

import dev.pages.ahsan.main.Config;
import dev.pages.ahsan.main.Main;
import dev.pages.ahsan.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button btnClose;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnSignIn;

    @FXML
    private CheckBox chboxRemember;

    @FXML
    private TextField tfPass;

    @FXML
    private TextField tfUserName;

    @FXML
    private ToggleButton tglTheme;

    @FXML
    private Text txtTitle;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtTitle = new Text();
        txtTitle.setText(Config.title);
        tglTheme = new ToggleButton();
        tglTheme.setOnAction(this::tglThemeOnClick);

    }

    public void tglThemeOnClick(ActionEvent e) {
        if (!tglTheme.isSelected())
            selectDarkTheme();
        else
        selectLightTheme();
        Main.root.getStylesheets().add(Objects.requireNonNull(getClass().getResource(Config.CSS)).toExternalForm());
    }

    private void selectLightTheme() {
        tglTheme.setSelected(false);
        tglTheme.setText("Dark Theme");
        Utils.changeCSS(Main.root, Config.lightCSS);
    }

    private void selectDarkTheme() {
        tglTheme.setText("Light Theme");
        tglTheme.setSelected(true);
        Utils.changeCSS(Main.root, Config.darkCSS);
    }
}
