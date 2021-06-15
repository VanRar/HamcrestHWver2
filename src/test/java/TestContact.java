import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestContact {
    //тут уже для дополнительных методов, а то с такими темпами придётся ещё какое-нибудь ДЗ тестировать

    @org.junit.jupiter.api.Test
    public void testGetName() {
        //создаем контакт
        Contact contact = new Contact("Ivan", "999999");
        Contact contact1 = new Contact("Ivan", "999999");

        //можем проверить свойства
        assertThat(contact, hasProperty("number"));
        //можем проверить номер
        assertThat(contact, hasProperty("number", equalTo("999999")));
        //созданы ли два объекта с одинаковыми значениями:
        assertThat(contact, samePropertyValuesAs(contact1));
    }
}
