import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationService notif = new NotificationService(List.of(
                new EmailNotifier(),
                new SMSNotifier(),
                new WhatsAppNotifier()
        ));

        System.out.println("=== Kirim per channel ===");
        notif.notify(new EmailNotifier(), "Halo, ini email test!");
        notif.notify(new SMSNotifier(), "Ini SMS test!");
        notif.notify(new WhatsAppNotifier(), "Ini pesan WhatsApp test!");

        notif.addNotifier(new TelegramNotifier());
        notif.addNotifier(new PushNotifier());

        System.out.println("\n=== Broadcast ke semua channel ===");
        notif.broadcast("Pengumpulan tugas ditutup malam ini!");
    }
}
