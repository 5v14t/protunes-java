package com._5v14t.protunes.ui.components;

import com._5v14t.protunes.be.Song;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class SectionView extends StackPane {
    @FXML private Label             lblSectionTitle;
    @FXML private Label             lblItemsInSection;
    @FXML private ListView<Song>    lstSection;
    @FXML private Button            btnAdd;

    public SectionView() {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("SectionView.fxml")
        );

        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initialize() {
        lstSection.setCellFactory(listView -> new SongCell());
    }

    public void setTitle(String title) {
        lblSectionTitle.setText(title);
    }

    public String getTitle() {
        return lblSectionTitle.getText();
    }

    public void setItemAmount(int amount) {
        lblItemsInSection.setText(String.valueOf(amount));
    }

    public int getItemAmount() {
        return Integer.parseInt(lblItemsInSection.getText());
    }

    public void setShowButton(boolean visibility) {
        btnAdd.setVisible(visibility);
    }

    public boolean getShowButton() {
        return btnAdd.isVisible();
    }

    public ListView<Song> getListView () {
        return lstSection;
    }

    public void setButtonText(String text) {
        btnAdd.setText(text);
    }

    public String getButtonText() {
        return btnAdd.getText();
    }

    public void setAddAction(EventHandler<ActionEvent> action) {
        btnAdd.setOnAction(action);
    }
}
