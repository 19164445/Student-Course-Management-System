package Code;

public class SimulatedTimeSystem {
    private boolean isPaused;/*用于停止时间*/
    private double rate;/*设定时间的流逝速率*/
    private Time elapsedTime;/*当前时间是第×周 周× ×点*/
    AlarmQueue alarmQueue;/*储存闹钟的队列*/

    /*构造方法*/
    public SimulatedTimeSystem() {
        isPaused = false;
        rate = 1.0;
        elapsedTime = new Time();
        alarmQueue=new AlarmQueue();
    }

    /*开始计时*/
    public void start() {
        while (!isPaused) {
            try {
                Thread.sleep(10000 / (long) rate);
                elapsedTime.addHour();
                System.out.println(elapsedTime.toString());
                if (!alarmQueue.isEmpty() && elapsedTime.compareTo(alarmQueue.nextAlarm().getTime())==0) {/*闹钟队列不空&&当前时间和闹钟队列的下一个时间相等*/
                    System.out.println(alarmQueue.nextAlarm().toString());/*输出闹钟信息*/
                    alarmQueue.removeNextAlarm();/*移除队列中的第一个闹钟*/
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*暂停*/
    public void setPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    /*设定速率*/
    public void setRate(double rate) {
        this.rate = rate;
    }

}
