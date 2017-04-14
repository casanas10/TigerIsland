/**
 * Created by ale on 4/14/17.
 */
public class BuildResult {

    public boolean buildSuccessfull;
    public int level3hex;


    public BuildResult(boolean successful) {
        this.buildSuccessfull = successful;
        this.level3hex = -1;
    }

    public BuildResult(boolean successfull, int level3hex){
        this.buildSuccessfull = successfull;
        this.level3hex = level3hex;
    }
}
