package myProj.localMemory;

import java.util.Arrays;
import java.util.List;

public interface Const {

    public List<String> CITIES = Arrays.asList("Минск", "Витебск", "Могилев", "Гродно", "Гомель", "Брест");

    public List<String> STATES_ORDER = Arrays.asList("Отменён", "Выполняется", "Ожидание", "Исполнен");

    String STATUS_BAN = "BAN";
    String STATUS_OK = "OK";

}
