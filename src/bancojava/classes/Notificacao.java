package bancojava.classes;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Notificacao{
    void enviarNotificacao(String comando1, double valor, LocalDate data, LocalTime hora);
}
