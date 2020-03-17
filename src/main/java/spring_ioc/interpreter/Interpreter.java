package spring_ioc.interpreter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_ioc.reader.ReaderBean;
import spring_ioc.repository.UserEntryRepository;



import java.util.Arrays;

@Component
public class Interpreter {

    private ReaderBean readerBean = new ReaderBean();
    private Environment env = new Environment();

    private UserEntryRepository repository;

    @Autowired
    public void setRepository(UserEntryRepository repository) {
        this.repository = repository;
        this.env.addAttribute("nameStorage", this.repository);
    }

    public void handle(String input) {
        String[] temp = input.split(" ");
        String curCommand = null;
        String[] args = new String[0];
        if (temp.length == 1) {
            curCommand = temp[0];
        } else if (temp.length > 1) {
            curCommand = temp[0];
            args = Arrays.copyOfRange(temp, 1, temp.length);
        }
        if (curCommand == null)
            throw new IllegalArgumentException("command is null");
        switch (curCommand) {
            case ("add"):
                readerBean.add(env, args);
                break;
            case ("out"):
                readerBean.out(env, args);
                break;
        }
    }
}