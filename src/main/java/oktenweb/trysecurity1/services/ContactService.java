package oktenweb.trysecurity1.services;

import oktenweb.trysecurity1.dao.ContactDAO;
import oktenweb.trysecurity1.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactDAO contactDAO;

    public ContactService(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public void save(Contact contact){
        if(contact!=null){
            contactDAO.save(contact);
        }
    }
    public List<Contact> findAll(){
        return contactDAO.findAll();
    }

    public Contact getOne(int id){

        return contactDAO.getOne(id);
    }
}
