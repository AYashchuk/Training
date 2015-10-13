package Design_Pattern.Command;


/*
Начнем по порядку: все объекты команд реализуют единый интерфейс, который состоит всего
        из одного метода. В примере с кафе мы назвали этот метод orderUp(), но чаще встречается стан-
        дартное имя execute().
        Интерфейс Command выглядит так:
*/


public interface Command {
    public void execute();
}
