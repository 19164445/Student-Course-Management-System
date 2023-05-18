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

    /*按照时间顺序，将闹钟添加至队列中*/
    /*参数为新闹钟的时间和信息描述*/
    public void addAlarm(Time time, String alarmDescribe) {
        Alarm a = new Alarm(time, alarmDescribe);/*创建新的闹钟*/
        queue.offer(a);
    }


    /*获取当前队列中的第一个闹钟*/
    public Alarm nextAlarm() {
        return queue.peek();
    }

    /*移除当前队列中的第一个闹钟*/
    /*注意，每当一个闹钟发挥作用，该队列中的第一个闹钟都应该被移除*/
    public void removeNextAlarm() {
        queue.poll();
    }

    /*检查闹钟队列中是否为空*/
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
