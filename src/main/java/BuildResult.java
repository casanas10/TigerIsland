import java.util.ArrayList;

/**
 * Created by ale on 4/14/17.
 */
public class BuildResult {

    public boolean buildSuccessfull;
    public int hexID;
    public int buildOption;
    public ArrayList<Integer> listHexes;
    public String terrainExtend;

    public BuildResult(boolean successful) {
        this.buildSuccessfull = successful;
        this.hexID = -1;
        this.buildOption = -1;
        this.listHexes = new ArrayList<>();
        this.terrainExtend = "";
    }

    public BuildResult(boolean successfull, int buildOption, int id){
        this.buildSuccessfull = successfull;
        this.hexID = id;
        this.buildOption = buildOption;
        this.listHexes = new ArrayList<>();
        this.terrainExtend = "";

    }

    public BuildResult(boolean buildSuccessfull, ArrayList<Integer> listHexes){
        this.buildSuccessfull = buildSuccessfull;
        this.listHexes = listHexes;
        this.hexID = -1;
        this.buildOption = -1;
        this.terrainExtend = "";
    }

    public BuildResult(boolean successfull, int buildOption, int id, String terrainExtend){
        this.buildSuccessfull = successfull;
        this.buildOption = buildOption;
        this.hexID = id;
        this.terrainExtend = terrainExtend;
        this.listHexes = new ArrayList<>();
    }
}
