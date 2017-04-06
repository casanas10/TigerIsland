/**
 * Created by Val on 4/2/2017.
 */
public class RotationConverter {
    public int serverToOurs(int rotation){
        switch(rotation){
            case 1:
                return 180;
            case 2:
                return 120;
            case 3:
                return 60;
            case 4:
                return 0;
            case 5:
                return 300;
            case 6:
                return 240;
        }
        return -1;
    }

    public int oursToServer(int degrees){
        switch (degrees){
            case 0:
                return 4;
            case 60:
                return 3;
            case 120:
                return 2;
            case 180:
                return 1;
            case 240:
                return 6;
            case 300:
                return 5;
        }
        return -1;
    }

}