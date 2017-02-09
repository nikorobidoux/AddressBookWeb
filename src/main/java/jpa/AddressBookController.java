package jpa; /**
 * Created by nikorobidoux on 2/2/2017.
 */
import jpa.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class AddressBookController {

    private AddressBookRepository repo;

    @Autowired
    public void repoInit(AddressBookRepository r){
        repo = r;
    }

    @RequestMapping("/createAddressBook")
    public String createAddressBook(Model model) {//TODO make the parameter an addressbook?
        //model.addAttribute("addressBook", addressBook);
        AddressBook addressBook = new AddressBook();
        model.addAttribute("addressBook", addressBook);
        repo.save(addressBook);
        return "addaddressbook";
    }

    @RequestMapping("/addBuddy")
    public String addBuddy(@RequestParam(value = "name") String name, @RequestParam(value = "pnum") String pnum, Model model){
        BuddyInfo b = new BuddyInfo(name,pnum);
        AddressBook a = repo.findAll().iterator().next();
        a.addBuddy(b);
        model.addAttribute("addressBook",a);
        repo.save(a);
        return "addaddressbook";
    }


    @RequestMapping("/removeBuddy")
    public String removeBuddy(@RequestParam(value = "name") String name, @RequestParam(value = "pnum") String pnum, Model model){
        BuddyInfo b = new BuddyInfo(name,pnum);
        AddressBook a = repo.findAll().iterator().next();
        a.removeBuddy(b);

        model.addAttribute("addressBook",a);
        repo.save(a);

        return "addaddressbook";
    }
}
