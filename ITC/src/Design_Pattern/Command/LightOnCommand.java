package Design_Pattern.Command;




/*      Допустим, вы хотите реализовать команду для включения света.
        Обратившись к описаниям классов устройств, мы видим, что класс
        Light содержит два метода: оп() и off(). Реализация команды выгля-
        дит примерно так:*/


public class LightOnCommand implements Command { // Класс команды должен реализовать интерфейс Command .

    Light light;
    public LightOnCommand(Light light) { // 13 переменной light конструктору передается конкретный объект, которым будет
      //  управлять команда (допустим, освещение в гостиной).При вызове execute получателем запроса будет объект light

        this.light = light;
    }


        @Override
    public void execute() {
            light.on();
        }
}
