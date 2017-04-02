/**
 * Created by NatalieGoldstein on 4/1/17.
 */
public class EndOfTurn {

    public String isGameDone(Player player1, Player player2, int tileCount){

        int tieBreakNum;
        if(areTwoTypesOfPiecesUsed(player1) == true){
            return "white";
        }else if(areTwoTypesOfPiecesUsed(player2) == true){
            return "black";
        }else if(areThereTilesLeft(tileCount) == false){
            if(player1.getCurrentScore() >player2.getCurrentScore()){
                return "white";
            }else if(player2.getCurrentScore() > player1.getCurrentScore()){
                return "black";
            }else if(player1.getCurrentScore() == player2.getCurrentScore()){
                tieBreakNum =tieBreaker(player1, player2);
                if(tieBreakNum == 1){
                    return "white";
                }else if(tieBreakNum == 2){
                    return "black";
                }else if(tieBreakNum == 0){
                    return "no winner";
                }
            }
        }
        return "none";
    }


    public boolean areTwoTypesOfPiecesUsed(Player player2){
        int MeepCount = player2.getRemainingMeeples();
        int TotoroCount = player2.getRemainingTotoros();
        int TigerCount = player2.getRemainingTigers();
       if(MeepCount == 0 && TotoroCount ==0){
            return true;
       }if(TotoroCount == 0 && TigerCount == 0){
           return true;
        }if(TigerCount==0 && MeepCount == 0){
           return true;
        }
        return false;
    }


    public boolean areThereTilesLeft(int tileCount){
        if(tileCount == 48){
            return false;
        }
        return true;
    }


    public int tieBreaker(Player player1, Player player2){
        if(player1.getRemainingTotoros() > player2.getRemainingTotoros()){
            return 2;
        }else if(player2.getRemainingTotoros() > player1.getRemainingTotoros()){
            return 1;
        }else if(player1.getRemainingTotoros() == player2.getRemainingTotoros()){
            if(player1.getRemainingTigers()> player2.getRemainingTigers()){
                return 2;
            }else if(player2.getRemainingTigers()>player1.getRemainingTigers()){
                return 1;
            }else if(player1.getRemainingTigers() == player2.getRemainingTigers()){
                    if(player1.getRemainingMeeples() > player2.getRemainingMeeples()){
                        return 2;
                    }else if(player2.getRemainingMeeples()> player1.getRemainingMeeples()){
                        return 1;}
            }
        }
        return 0;
    }



}
