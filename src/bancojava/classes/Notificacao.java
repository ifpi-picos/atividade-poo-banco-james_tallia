package bancojava.classes;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Notificacao{
    public void enviarNotificacao(int comandoInteiro, double valor, LocalDate data, LocalTime hora);
}
