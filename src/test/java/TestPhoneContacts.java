import org.hamcrest.MatcherAssert;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class TestPhoneContacts {
    @org.junit.jupiter.api.Test
    public void testCreateGroup() {
        // given:
        //создадим группы для теста
        String[] groups = {"Группа 1", "Группа 2", "Группа 3", "Группа 4", "Группа 5"};

        PhoneContacts phoneContacts = new PhoneContacts();

        // when:
        //заполним телефонную книгу группами
        for (String group : groups) {
            phoneContacts.addGroup(group);
        }

        // then:
        for (String group : groups) {
            //  ну тут прям вообще удобно:
            MatcherAssert.assertThat(phoneContacts.getContacts(), hasKey(group));
        }
    }

    @org.junit.jupiter.api.Test
    public void testAddContact() {
        // given:
        //создадим группы и контакты для теста
        String[] groups = {"Группа 1", "Группа 2", "Группа 3", "Группа 4", "Группа 5"};
        Contact[] contacts = new Contact[10];
        for (int i = 0; i < 10; i++) {
            contacts[i] = (new Contact(("Контакт " + i), ("999999999" + i)));
        }

        PhoneContacts phoneContacts = new PhoneContacts();

        // when:
        //заполним телефонную книгу группами и контактами
        for (String group : groups) {
            for (Contact contact : contacts) {
                phoneContacts.addContact(group, contact);
            }
        }

        // then:
        //проведем проверку
        int i = 0; //нарна так делать не стоит, но мне показалось что такой вариант самый простой, проходимся по мапе и по нашим массивам
        for (Map.Entry<String, List<Contact>> entry : phoneContacts.getContacts().entrySet()) {
            //по сути такая проверка была выше, для разнообразия сделаем проверку по стрингу
            //    Assertions.assertEquals(entry.getKey(), groups[i++]);

            MatcherAssert.assertThat(entry.getKey(), hasToString(groups[i++]));
            int j = 0;
            for (Contact contact : entry.getValue()) {
                //пробежимся по контактам в группе
                MatcherAssert.assertThat(contact.toString(), hasToString(contacts[j++].toString()));
            }
        }
    }
}