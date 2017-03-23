/**
 * Created by alecasanas on 3/22/17.
 */
public class Tiger {

    private String status;
    private String color;
    private int score;

    public Tiger(String color) {
        this.color = color;
        status = "Not played";
    }

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }

    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }

    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }
}
