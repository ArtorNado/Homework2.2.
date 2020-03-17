package spring_ioc.reader;


import org.springframework.stereotype.Component;
import spring_ioc.interpreter.Environment;
import spring_ioc.model.UserEntry;
import spring_ioc.repository.UserEntryRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReaderBean {

    public void add(Environment env, String[] args) {
        String name = args[0];
        UserEntryRepository nameStorage = env.getAttribute("nameStorage", UserEntryRepository.class);
        UserEntry nameEntry = new UserEntry(name);
        nameStorage.save(nameEntry);
    }

    public void out(Environment env, String[] args) {
        UserEntryRepository nameStorage = env.getAttribute("nameStorage", UserEntryRepository.class);
        List<UserEntry> userEntryList = new ArrayList<>();
        nameStorage.findAll().forEach(userEntryList::add);
        System.out.println(userEntryList);
    }

}
