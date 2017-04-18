import java.util.ArrayList;

/**
 * Created by alecasanas on 4/13/17.
 */
public class NukeResult {

    public boolean nukingSuccessfull;
    public int hexID;
    public int orientation;


    public NukeResult(boolean successful) {
        this.nukingSuccessfull = successful;
        this.hexID = -1;
        this.orientation = -1;
    }

    public NukeResult(boolean successfull, int hexID, int orientation){
        this.nukingSuccessfull = successfull;
        this.hexID = hexID;
        this.orientation = orientation;
    }
}
