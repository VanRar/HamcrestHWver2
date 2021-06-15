import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneContacts {
    private Map<String, List<Contact>> contacts;

    //Добавим для теста
    public Map<String, List<Contact>> getContacts() {
        return contacts;
    }

    public PhoneContacts() {
        this.contacts = new HashMap<>();
    }

    //создаем группу с безразмерным массивом для хранения данных
    public void addGroup(String groupName) {
        if (!contacts.containsKey(groupName)) {
            contacts.put(groupName, new ArrayList<>());
        }
    }

    public void addContact(String group, Contact contact) {
        if (!contacts.containsKey(group)) {
            addGroup(group);
        }
        contacts.get(group).add(contact);
    }

    //для вывода переопределяем toString, проще через StringBuilder
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Контакты:\n");
        for (Map.Entry<String, List<Contact>> entry : contacts.entrySet()) {
            stringBuilder.append(entry.getKey()).append("\n");
            for (Contact contact : entry.getValue()) {
                stringBuilder
                        .append("\t")
                        .append(contact.getName())
                        .append(" ")
                        .append(contact.getNumber())
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }
}