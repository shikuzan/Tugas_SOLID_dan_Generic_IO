import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final List<Notifier> notifiers = new ArrayList<>();

    public NotificationService(List<Notifier> notifiers) {
        this.notifiers.addAll(notifiers);
    }

    public void addNotifier(Notifier notifier) {
        notifiers.add(notifier);
    }

    public void notify(Notifier notifier, String message) {
        notifier.send(message);
    }

    public void broadcast(String message) {
        for (Notifier n : notifiers) {
            n.send(message);
        }
    }
}
