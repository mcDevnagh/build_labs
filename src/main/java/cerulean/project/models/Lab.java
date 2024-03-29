package cerulean.project.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document
public class Lab {

    @Id
    private String _id;

    private String name;

    private String labCreator_Id;

    private List<Part> partsList;
    private List<String> assignedTo_Ids;
    private List<Step> steps;
    private Boolean ispublished;

    public Lab(String name,String labCreator_Id,String _id,List<Part> partsList,List<String> assignedTo_Ids,List<Step> steps){
        this.name = name;
        this.labCreator_Id = labCreator_Id;
        this._id = _id;
        this.partsList = partsList;
        this.assignedTo_Ids = assignedTo_Ids;
        this.steps = steps;
        this.ispublished = false;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){this.name = name;}

    public List<Part> getPartsList() {
        return partsList;
    }

    public void setPartsList(List<Part> partLists){this.partsList = partLists;}

    public List<String> getAssignedTo_Ids() {
        return assignedTo_Ids;
    }

    public void setAssignedTo_Ids(List<String> assignedTo_Ids) {
        this.assignedTo_Ids = assignedTo_Ids;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public Boolean getIspublished(){return this.ispublished;}

    public void setIspublished(Boolean ispublished){this.ispublished = ispublished;}

    public String getLabCreator_Id(){return this.labCreator_Id;}

    private void set_id(String id){this._id = id;}


    public Lab cloneLab(){
        String id = UUID.randomUUID().toString();
        this.set_id(id);
        this.setName(this.getName()+" Copy");
        this.setIspublished(false);
        this.setAssignedTo_Ids(null);
        return this;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Lab cloned = (Lab)super.clone();
//        return cloned;
//    }


}
