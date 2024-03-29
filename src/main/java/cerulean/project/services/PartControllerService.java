package cerulean.project.services;

import cerulean.project.database.PartRepository;
import cerulean.project.models.Account;
import cerulean.project.models.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PartControllerService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PartRepository partRepository;

    public Part getPart(String partId) {
        return partRepository.findById(partId).orElse(null);
    }
    public void updatePart(String parId,Part part){
        partRepository.save(part);
    }

    public void publishPart(String partID){


        Part part = getPart(partID);
        part.setIspublished(true);
        partRepository.save(part);
        //return part.get_id();
    }
    public void deletePart(String partID){
        if(partRepository.existsById(partID)) {
            Part part = getPart(partID);
            partRepository.delete(part);
        }
        else
            throw new RuntimeException("Part Does Not Exist");

    }

    public String addNewPart(String creatorUsername, Part newPart) {
        Account creator = accountService.getAccount(creatorUsername);
        return addNewPart(creator, newPart);
    }

    private String addNewPart(Account creator, Part newPart) {
        if (partRepository.existsById(newPart.get_id())) {
            // If part is already in the DB don't do anything
            throw new RuntimeException("Part with that ID already exists");
        } else {
            creator.getCreatedParts_ids().add(newPart.get_id());
            accountService.save(creator);
            partRepository.save(newPart);
        }
        return newPart.get_id().toString();
    }

    public List<Part> getPartsCreatedByUser(Account user) {
        List<Part> result = new ArrayList<>();
        partRepository.findAllById(user.getCreatedParts_ids()).forEach(result::add);
        return result;
    }

    public List<Part> getAllParts(){
        List<Part> result = new ArrayList<>();
        partRepository.findAll().forEach(result::add);
        return result;
    }

}
