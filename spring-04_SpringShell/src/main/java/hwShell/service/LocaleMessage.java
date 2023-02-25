package hwShell.service;

import hwShell.config.ApplicationProps;
import hwShell.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;


@Component
public class LocaleMessage {

    private final MessageSource messageSource;
    private final ApplicationProps applicationProps;

    @Autowired
    public LocaleMessage(QuestionDao dao, MessageSource messageSource, ApplicationProps applicationProps) {
        this.messageSource = messageSource;
        this.applicationProps=applicationProps;
    }

    public String showMessage (String str){
       return messageSource.getMessage(str, null, applicationProps.getLocale());
    }

    public String showMessage (String str, String s){
        return  messageSource.getMessage("inputNumber.user", new String[]{s},applicationProps.getLocale());
    }
    public String showMessage (String str, Integer integer){
        return  messageSource.getMessage("scoreTest.user", new Integer[]{integer}, applicationProps.getLocale());
    }
}
