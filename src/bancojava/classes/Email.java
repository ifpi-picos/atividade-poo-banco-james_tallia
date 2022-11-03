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
    public void enviarNotificacao(String comando1, double valor, LocalDate data, LocalTime hora) {
                JOptionPane.showMessageDialog(null, ""+comando1+" realizado(a) no valor de "+valor+" na data: "+data.format(dataFormatada)+" na hora: "+hora.format(horaFormatada), "Email",JOptionPane.ERROR_MESSAGE);
    }
}
