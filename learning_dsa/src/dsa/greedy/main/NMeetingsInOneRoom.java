package dsa.greedy.main;

import java.util.ArrayList;
import java.util.List;

public class NMeetingsInOneRoom {

    //TC - O(NlogN + N)
    //SC - O( 3 * N)
    public static int getMaxMeetingsCanPerform(int[] start, int[] end) {
        int maxMeetings = 0;
        int n = start.length;
        if (n == 0) {
            return maxMeetings;
        }

        //create a collection for meetings and sort based on end time
        List<MeetingInfo> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new MeetingInfo(start[i], end[i], i + 1));
        }
        meetings.sort((a, b) -> a.endTime - b.endTime);

        //perform the meetings which end early
        int freeTime = meetings.get(0).endTime;
        maxMeetings = 1;
        //meeting 0 can perform always so 1 to n -1
        for (int i = 1; i < n; i++) {
            MeetingInfo meeting = meetings.get(i);
            if (meeting.startTime >= freeTime) {
                maxMeetings++;
                freeTime = meeting.endTime;
            }
        }

        return maxMeetings;
    }
}

class MeetingInfo {
    int startTime;
    int endTime;
    int meetingID;

    public MeetingInfo(int startTime, int endTime, int meetingID) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingID = meetingID;
    }
}
