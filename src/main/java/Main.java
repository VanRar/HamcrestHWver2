import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PhoneContacts phoneContacts = new PhoneContacts();

        createGroup(phoneContacts);
        setContact(phoneContacts);

        System.out.println(phoneContacts);
    }

    public static void createGroup(PhoneContacts phoneContacts) {
        while (true) {
            System.out.println("Введите название группы или нет для выхода:");
            String nameGroup = scanner.nextLine();
            if ("нет".equals(nameGroup)) break;
            phoneContacts.addGroup(nameGroup);
        }
    }

    public static void setContact(PhoneContacts phoneContacts) {
        while (true) {
            System.out.println("Создать контакт (введите имя и его номер или введите нет)?");
            String nameContact = scanner.nextLine();
            if ("нет".equals(nameContact)) break;
            String[] constrContact = nameContact.split(" ");
            Contact contactClass = new Contact(constrContact[0], constrContact[1]);
            System.out.println("Укажите группы контакта через запятую");
            String[] group = scanner.nextLine().split(",");
            for (String g : group) {
                phoneContacts.addContact(g.trim(), contactClass);
            }
        }
    }
}