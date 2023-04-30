package Code;

import java.util.PriorityQueue;

public class AlarmQueue {
    /*内部类Alarm*/
    class Alarm {
        private Time time;/*要设定的闹钟的时间*/
        private String AlarmDescribe;/*闹钟描述*/

        /*构造方法*/
        public Alarm(Time time, String alarmDescribe) {
            this.time = time;
            AlarmDescribe = alarmDescribe;
        }

        public Time getTime() {
            return time;
        }

        /*打印闹钟信息*/
        @Override
        public String toString() {
            return "当前时间为" + time.toString() + AlarmDescribe;
        }
    }




    /*类成员*/
    private PriorityQueue<Alarm> queue;

    /*构造方法*/
    public AlarmQueue() {
        queue = new PriorityQueue<>((a1, a2) -> a1.getTime().compareTo(a2.getTime()));
    }

    /*添加闹钟*/
    public void addAlarm(Time time, String alarmDescribe) {
        Alarm a = new Alarm(time, alarmDescribe);/*创建新的闹钟*/
        queue.offer(a);
    }

    public Alarm nextAlarm() {
        return queue.peek();
    }

    public void removeNextAlarm() {
        queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
