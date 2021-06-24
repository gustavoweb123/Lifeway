package gui;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import negocio.beans.Cliente;
import negocio.beans.ValidaCPF;
import negocio.controle.ControladorUsuario;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import excecoes.CPFInvalidoException;
import excecoes.ElementoJaExisteException;
import excecoes.UsuarioJaCadastradoException;

public class SignUp {

    @FXML
    private Button botaoLogar;

    @FXML
    private Button botaoCriarConta;

    @FXML
    private TextField cpf;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField nome;

    @FXML
    private DatePicker dataNascimento;

    public void voltar(ActionEvent event) throws IOException {
       
       App voltarp = new App();
       voltarp.trocarCena("Login.fxml");
    }


    public void criarConta() throws ElementoJaExisteException, IOException, NoSuchAlgorithmException, UsuarioJaCadastradoException, CPFInvalidoException {
        //ControladorUsuario.getInstance().criarNovoUsuario(new Cliente(nome.getText(), cpf.getText(), senha.getText(), dataNascimento.getValue()));;

        try {
            ControladorUsuario.getInstance().cadastrarUsuario(new Cliente(nome.getText(), cpf.getText(), senha.getText(), dataNascimento.getValue()));
        } catch (CPFInvalidoException e) {
            System.out.println("Exception caught: CPF inválido.");  
        } finally {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("CPF inválido");
            //alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("O CPF inserido é inválido. Tente novamente.");
            
            alert.showAndWait();  
        }

        System.out.println(ControladorUsuario.getInstance().listarUsuarios());
        
        botaoCriarConta.setFont(Font.font(14));
        botaoCriarConta.setText("Conta criada!\nFaça seu login.");
        botaoCriarConta.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                App voltarp = new App();
                try {
                    voltarp.trocarCena("Login.fxml");
                } catch (Exception e) {
                    //TODO: handle exception
                }
                
            };
        });
    }

   
       
        
    
}