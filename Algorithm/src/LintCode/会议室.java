package LintCode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一系列的会议时间间隔，包括起始和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，确定一个人是否可以参加所有会议。
 *
 * 样例
 * 样例1
 *
 * 输入: intervals = [(0,30),(5,10),(15,20)]
 * 输出: false
 * 解释:
 * (0,30), (5,10) 和 (0,30),(15,20) 这两对会议会冲突
 * 样例2
 *
 * 输入: intervals = [(5,8),(9,15)]
 * 输出: true
 * 解释:
 * 这两个时间段不会冲突
 */
public class 会议室 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,30));
        intervals.add(new Interval(5,10));
        intervals.add(new Interval(15,20));
        System.out.println(canAttendMeetings(intervals));
    }

    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public static boolean canAttendMeetings(List<Interval> intervals) {
        if (null == intervals || 0 >= intervals.size()){
            return true;
        }
        int max = 0;
        Interval maxInterval = intervals.get(0);
        for(Interval interval : intervals){
            int n = interval.end - interval.start;
            if (n > max ){
                max = n;
                maxInterval = interval;
            }
        }
        int s = maxInterval.start;
        int e = maxInterval.end;
        for (Interval interval : intervals){
            if (interval.equals(maxInterval) ){
                continue;
            }
            if (interval.start >= s && interval.start <= e){
                return false;
            }
            if (interval.end >= s && interval.start <= e) {
                return false;
            }
        }
        return true;
    }

    static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
