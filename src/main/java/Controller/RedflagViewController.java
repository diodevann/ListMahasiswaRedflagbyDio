
package Controller;

import Model.MahasiswaRedflag;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class RedflagViewController implements Initializable {
    
    @FXML private TextField inputNIM;
    @FXML private TextField inputNama;
    @FXML private DatePicker inputTanggal; 
    @FXML private ComboBox<String> inputZodiak;
    
    @FXML private TableView<MahasiswaRedflag> tabelData;
    @FXML private TableColumn<MahasiswaRedflag, String> kolomNIM;
    @FXML private TableColumn<MahasiswaRedflag, String> kolomNama;
    @FXML private TableColumn<MahasiswaRedflag, String> kolomZodiak;
    @FXML private TableColumn<MahasiswaRedflag, LocalDate> kolomTanggal;

    private ObservableList<MahasiswaRedflag> daftarData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        daftarData = FXCollections.observableArrayList(
            new MahasiswaRedflag("123001", "Dioy", "Gemini", LocalDate.of(2025, 11, 10)),
            new MahasiswaRedflag("123002", "I Gede", "Leo", LocalDate.of(2025, 11, 11))
        );

        
        kolomNIM.setCellValueFactory(new PropertyValueFactory<>("nim"));
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolomZodiak.setCellValueFactory(new PropertyValueFactory<>("zodiak"));
        kolomTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggalEntri"));

       
        inputZodiak.setItems(FXCollections.observableArrayList(
            "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", 
            "Libra", "Scorpio", "Sagitarius", "Capricorn", "Aquarius", "Pisces"));

      
        tabelData.setItems(daftarData);

        
        tabelData.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    inputNIM.setText(newSelection.getNim());
                    inputNama.setText(newSelection.getNama());
                    inputZodiak.setValue(newSelection.getZodiak());
                    inputTanggal.setValue(newSelection.getTanggalEntri());
                }
            });
    }
    

    @FXML
    private void handleAdd() {
        try {
            MahasiswaRedflag baru = new MahasiswaRedflag(
                inputNIM.getText(),
                inputNama.getText(),
                inputZodiak.getValue(),
                inputTanggal.getValue()
            );
            daftarData.add(baru);
            clearInputFields();
        } catch (Exception e) {
            System.err.println("Error saat menambahkan: " + e.getMessage());
        }
    }

    @FXML
    private void handleEdit() { 
        MahasiswaRedflag dipilih = tabelData.getSelectionModel().getSelectedItem();
        if (dipilih != null) {
            
            dipilih.setNim(inputNIM.getText());
            dipilih.setNama(inputNama.getText());
            dipilih.setZodiak(inputZodiak.getValue());
            dipilih.setTanggalEntri(inputTanggal.getValue());
            
           
            tabelData.refresh(); 
            clearInputFields();
        }
    }

    @FXML
    private void handleDelete() { 
        MahasiswaRedflag dipilih = tabelData.getSelectionModel().getSelectedItem();
        if (dipilih != null) {
            daftarData.remove(dipilih);
            clearInputFields();
        }
    }
    
    private void clearInputFields() {
        inputNIM.clear();
        inputNama.clear();
        inputZodiak.setValue(null);
        inputTanggal.setValue(null);
    }
}