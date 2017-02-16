package jpa; /**
 * Created by nikorobidoux on 2/2/2017.
 */
import jpa.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {

    private AddressBookRepository repo;
    private boolean init = false;

    @Autowired
    public void repoInit(AddressBookRepository r){
        repo = r;
    }
    /*
    @RequestMapping("/createAddressBook")
    public String createAddressBook(Model model) {
        //model.addAttribute("addressBook", addressBook);
        AddressBook addressBook = new AddressBook();
        model.addAttribute("addressBook", addressBook);
        repo.save(addressBook);
        return "addaddressbook";
    }
    */

    @RequestMapping("/display")
    public String displayAddressBook(Model model){
        AddressBook a = repo.findAll().iterator().next();
        model.addAttribute("addressBook",a);
        return "addNewBuddy";
    }

    /*
    @PostMapping("/display")
    public String newBuddySubmit(@ModelAttribute AddressBook addressBook){
        AddressBook a = repo.findAll().iterator().next();
        a.addBuddy(new BuddyInfo("joeski", "123454"));
        repo.save(a);
        return "showAllBuddies";
    }
    */

    @GetMapping("/createAddressBook")
    public String createAddressBook(Model model) {

        AddressBook addressBook = new AddressBook();
        model.addAttribute("addressBook", addressBook);
        repo.save(addressBook);
        init = true;


        return "addNewBuddy";
    }

    @RequestMapping("/addBuddy")
    public String addBuddy(@RequestParam(value = "name") String name, @RequestParam(value = "pnum") String pnum, Model model){
        BuddyInfo b = new BuddyInfo(name,pnum);
        AddressBook a = repo.findAll().iterator().next();
        a.addBuddy(b);
        model.addAttribute("addressBook",a);
        repo.save(a);
        return "showAllBuddies";
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
