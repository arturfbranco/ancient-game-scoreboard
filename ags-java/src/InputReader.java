import Util.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {

    private final String path;

    public InputReader(String path) {
        this.path = path;
    }

    public int[][][] processFile() throws IOException {

        int[][][] inputData = new int[400][][];

        Logger.log("Reading file with path: " + this.path);
        FileReader fileReader = new FileReader(this.path);
        BufferedReader br = new BufferedReader(fileReader);
        boolean hasNext = true;
        int index = 0;
        while (hasNext){
            int scoreboardsSize = Integer.parseInt(br.readLine());
            if(scoreboardsSize > 0){
                int[][] scoreboards = new int[scoreboardsSize][2];
                for(int i = 0; i < scoreboardsSize; i++){
                    String[] scoreboard = br.readLine().split(" ");
                    scoreboards[i][0] = Integer.parseInt(scoreboard[0]);
                    scoreboards[i][1] = Integer.parseInt(scoreboard[1]);
                }
                inputData[index] = scoreboards;
                index++;
            } else {
                hasNext = false;
            }
        }
        Logger.log("Number os scoreboards: " + inputData.length);
        return inputData;
    }
}
