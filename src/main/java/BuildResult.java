/**
 * Created by ale on 4/14/17.
 */
public class BuildResult {

    public boolean buildSuccessfull;
    public int hexID;
    public int foundSettlementToPlaceTotoro;



    public BuildResult(boolean successful) {
        this.buildSuccessfull = successful;
        this.hexID = -1;
        this.foundSettlementToPlaceTotoro = -1;
    }

    public BuildResult(boolean successfull, int buildOption, int id){

        if (buildOption == 4){
            this.buildSuccessfull = successfull;
            this.hexID = id;
            this.foundSettlementToPlaceTotoro = -1;
        } else if (buildOption == 3){
            this.buildSuccessfull = successfull;
            this.hexID = -1;
            this.foundSettlementToPlaceTotoro = id;
        }

    }

}
