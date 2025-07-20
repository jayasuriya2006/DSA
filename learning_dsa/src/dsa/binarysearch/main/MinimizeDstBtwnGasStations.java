package dsa.binarysearch.main;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeDstBtwnGasStations {

    public static double getMaxDistanceAfterPlacingKGasStations_Brut(int[] positions, int k) {
        int[] howMany = new int[positions.length - 1];    //sections
        //iteration
        for (int station = 1; station <= k; station++) {
            //find the max length between 2 stations
            double maxDistance = 0;
            int maxSection = 0;
            for (int section = 0; section < positions.length - 1; section++) {
                double initialDis = positions[section + 1] - positions[section];
                int placedStations = howMany[section];
                double updatedSectionDis = initialDis / (placedStations + 1);
                if (updatedSectionDis >= maxDistance) {
                    maxDistance = updatedSectionDis;
                    maxSection = section;
                }
            }
            //place a station at where max section
            howMany[maxSection]++;
        }


        //find the max length between 2 stations
        double maxDistance = 0;
        for (int section = 0; section < positions.length - 1; section++) {
            double initialDis = positions[section + 1] - positions[section];
            int placedStations = howMany[section];
            double updatedSectionDis = initialDis / (placedStations + 1);
            if (updatedSectionDis >= maxDistance) {
                maxDistance = updatedSectionDis;
            }
        }
         return maxDistance;
    }

    public static double getMaxDistanceAfterPlacingKGasStations_Better(int[] positions, int k) {
        int[] howMany = new int[positions.length - 1];
        PriorityQueue<SectionInfo> priorityQueue = new PriorityQueue<>(new SectionInfoComparator());
        //load all the initial distance to pq
        for(int section = 0; section < positions.length - 1; section++){
            priorityQueue.add(new SectionInfo(section, positions[section + 1] - positions[section]));
        }

        for(int station = 1; station <= k; station++){
            SectionInfo maxSection = priorityQueue.poll();
            int sectionNo = maxSection.sectionNo;
            howMany[sectionNo]++;
            double initialDistance = positions[sectionNo + 1] - positions[sectionNo];
            double updatedSectionDis = initialDistance / (howMany[sectionNo] + 1);
            priorityQueue.add(new SectionInfo(sectionNo, updatedSectionDis));
        }
        return priorityQueue.peek().sectionLength;
    }
}

class SectionInfoComparator implements Comparator<SectionInfo>{

    @Override
    public int compare(SectionInfo o1, SectionInfo o2) {
        if(o1.sectionLength > o2.sectionLength){
            return -1;
        } else if(o2.sectionLength > o1.sectionLength){
            return 1;
        } else {
            return 0;
        }
    }
}

class SectionInfo{
    int sectionNo;
    double sectionLength;

    SectionInfo(int sectionNo, double sectionLength){
        this.sectionNo = sectionNo;
        this.sectionLength = sectionLength;
    }
}

