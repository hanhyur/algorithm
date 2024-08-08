import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String current = br.readLine();
        String dropTime = br.readLine();
        
        String[] currentArr = current.split(":");
        String[] dropTimeArr = dropTime.split(":");
        
        int currentTotalSecond = changeSecond(currentArr);
        int dropTimeTotalSecond = changeSecond(dropTimeArr);
        
        int needTimeTotalSecond = dropTimeTotalSecond - currentTotalSecond;
        
        if (needTimeTotalSecond <= 0) {
            needTimeTotalSecond += 24 * 3600;
        }
        
        System.out.println(makeTimeFormat(needTimeTotalSecond));
    }
    
    private static String makeTimeFormat(int needTimeTotalSecond) {
        int hours = needTimeTotalSecond / 3600;
        int minutes = needTimeTotalSecond % 3600 / 60;
        int seconds = needTimeTotalSecond % 60;
        
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    private static int changeSecond(String[] timeArr) {
        int hour = Integer.parseInt(timeArr[0]);
        int minute = Integer.parseInt(timeArr[1]);
        int second = Integer.parseInt(timeArr[2]);
        
        return hour * 3600 + minute * 60 + second;
    }
    
}