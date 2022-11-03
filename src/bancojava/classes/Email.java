package bancojava.classes;



import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Email implements Notificacao {
    LocalDate data = LocalDate.now();
    DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("E, dd/MM/yyy");
    LocalTime hora = LocalTime.now();
    DateTimeFormatter horaFormatada = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Email() {

    }
    @Override
    public void enviarNotificacao(int comandoInteiro, double valor, LocalDate data, LocalTime hora) {


            if (comandoInteiro == 2){

                JOptionPane.showMessageDialog(null, "Depósito realizado", "Email",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Depósito realizado no valor de "+valor+" na data: "+data.format(dataFormatada)+" na hora: "+hora.format(horaFormatada), "Email",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Email enviado com sucesso!", "Email",JOptionPane.ERROR_MESSAGE);
            } else if (comandoInteiro == 3) {
                JOptionPane.showMessageDialog(null, "Transferência realizada", "Email",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Transferência realizada no valor de "+valor+" na data: "+data.format(dataFormatada)+" na hora: "+hora.format(horaFormatada), "Email",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Email enviado com sucesso!", "Email",JOptionPane.ERROR_MESSAGE);
            } else if (comandoInteiro == 4) {

                JOptionPane.showMessageDialog(null, "Saque realizado", "Email",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Saque realizado no valor de "+valor+" na data: "+data.format(dataFormatada)+" na hora: "+hora.format(horaFormatada), "Email",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Email enviado com sucesso!", "Email",JOptionPane.ERROR_MESSAGE);
            }

    }
}
