package com.jmt.sevenwondersscienceadvisor;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreCalcUtils {

	private static Integer scienceScore(int x, int y, int z) {
		int score = 0;
		for (int c = x, t = y, g = z; c > 0 && t > 0 && g > 0; c--, t--, g--) {
			score += 7;
		}
		score += Math.pow(x, 2);
		score += Math.pow(y, 2);
		score += Math.pow(z, 2);
		return score;
	}

	public static Integer findBestScore(int x, int y, int z, int u) {
		int score = 0;
		ArrayList<Integer> scoreList = new ArrayList<Integer>();		
		if (u == 1) {
			scoreList.add(scienceScore((x+1), y, z));
			scoreList.add(scienceScore(x, (y+1), z));
			scoreList.add(scienceScore(x, y, (z+1)));			
		}
		else if (u==2) {
			scoreList.add(scienceScore((x+2), y, z));
			scoreList.add(scienceScore(x, (y+2), z));
			scoreList.add(scienceScore(x, y, (z+2)));		
			
			scoreList.add(scienceScore((x+1), (y+1), z));
			scoreList.add(scienceScore(x, (y+1), (z+1)));
			scoreList.add(scienceScore((x+1), y, (z+1)));	
		}
		else if (u==3) {
			scoreList.add(scienceScore((x+3), y, z));
			scoreList.add(scienceScore(x, (y+3), z));
			scoreList.add(scienceScore(x, y, (z+3)));	
			
			scoreList.add(scienceScore((x+2), (y+1), z));
			scoreList.add(scienceScore(x, (y+2), (z+1)));
			scoreList.add(scienceScore((x+1), y, (z+2)));	
			
			scoreList.add(scienceScore((x+1), (y+1), (z+1)));			
		}
		else {
			scoreList.add(scienceScore(x, y, z));
		}
		
		Collections.sort(scoreList);
		score = scoreList.get(scoreList.size()-1);
		return score;
	}
}
