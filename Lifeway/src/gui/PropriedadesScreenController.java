package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.Propriedade;
import negocio.beans.TipoEmpresa;
import negocio.beans.TipoPropriedade;
import negocio.controle.ControladorEmpresa;
import negocio.controle.Fachada;

public class PropriedadesScreenController implements Initializable {
    

    @FXML
    private Button retornar;


    @FXML
    private Button botaoOK;
    @FXML
    private ComboBox<Empresa> empresaCB;
    @FXML 
    private ComboBox<TipoPropriedade> tipoCB;
    @FXML
    private TextArea rua;
    @FXML
    private TextArea numeroCasa;
    @FXML
    private TextArea complemento;
    @FXML
    private TextArea pontoReferencia;

    public void irRetornar(ActionEvent event) throws IOException{
        App n = new App();
        n.trocarCena("Perfil.fxml");

    }

    public void criarPropriedadeAction(ActionEvent event) {
        Propriedade novaPropriedade = new Propriedade(tipoCB.getSelectionModel().getSelectedItem(), new Endereco(rua.getText(), Integer.parseInt(numeroCasa.getText()), complemento.getText(), pontoReferencia.getText()), Fachada.getInstance().getUsuarioLogado(), empresaCB.getSelectionModel().getSelectedItem());
        try {
            Fachada.getInstance().cadastrarPropriedade(novaPropriedade);
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    } 

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<Empresa> empresaList = FXCollections.observableArrayList(ControladorEmpresa.getInstance().listarEmpresas());
        System.out.println(empresaList);
        empresaCB.setItems(empresaList);
        // empresaCB.getItems().addAll(empresaList);
        empresaCB.setCellFactory(new Callback<ListView<Empresa>,ListCell<Empresa>>(){

            @Override
            public ListCell<Empresa> call(ListView<Empresa> arg0) {
                
                final ListCell<Empresa> cell = new ListCell<>() {
                    @Override
                    protected void updateItem(Empresa arg0, boolean arg1) {
                        super.updateItem(arg0, arg1);

                        if(arg0!=null) {
                            setText(arg0.getNome());
                        } else {
                            setText(null);
                        }
                    };
                };

                return cell;
            }
            
        });

        tipoCB.getItems().addAll(TipoPropriedade.values());
        
    }


}
